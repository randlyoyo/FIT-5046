package edu.monash.fit5046.healthyrecipehub.data.repository

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import edu.monash.fit5046.healthyrecipehub.data.local.database.AppDatabase
import edu.monash.fit5046.healthyrecipehub.data.model.*
import edu.monash.fit5046.healthyrecipehub.data.remote.api.AuthApiService
import edu.monash.fit5046.healthyrecipehub.data.remote.api.RetrofitClient
import edu.monash.fit5046.healthyrecipehub.data.remote.api.safeApiCall
import edu.monash.fit5046.healthyrecipehub.data.remote.dto.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Authentication Repository
 * Manages user authentication state and session
 */
class AuthRepository(
    private val context: Context,
    private val apiService: AuthApiService,
    private val database: AppDatabase
) {

    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val PREFS_NAME = "auth_prefs"
        private const val KEY_TOKEN = "auth_token"
        private const val KEY_REFRESH_TOKEN = "refresh_token"
        private const val KEY_USER_ID = "user_id"
        private const val KEY_IS_LOGGED_IN = "is_logged_in"
        private const val KEY_LAST_LOGIN = "last_login"

        // Mock mode for offline testing - set to true for demo without backend
        private const val MOCK_MODE = true

        @Volatile
        private var instance: AuthRepository? = null

        fun getInstance(context: Context): AuthRepository {
            return instance ?: synchronized(this) {
                val database = AppDatabase.getDatabase(context)
                instance = AuthRepository(
                    context,
                    RetrofitClient.authApiService,
                    database
                )
                instance!!
            }
        }
    }

    // StateFlow for authentication state
    private val _authState = MutableStateFlow<AuthState>(AuthState.Unauthenticated)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()

    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser.asStateFlow()

    init {
        // Restore session on initialization
        restoreSession()
    }

    // ====== Authentication Operations ======

    suspend fun login(email: String, password: String): Result<User> {
        // Mock mode: bypass API call for offline testing
        if (MOCK_MODE) {
            // In mock mode, accept any credentials and create/login a mock user
            val mockUser = User(
                id = "mock_${email.hashCode()}",
                email = email,
                displayName = email.substringBefore("@"),
                photoUrl = null,
                role = UserRole.USER,
                dietaryPreferences = emptyList(),
                allergies = emptyList(),
                dailyCalorieGoal = 2000,
                createdAt = System.currentTimeMillis(),
                lastLoginAt = System.currentTimeMillis(),
                isEmailVerified = true,
                isBiometricEnabled = false
            )

            saveAuthData("mock_token_${System.currentTimeMillis()}", mockUser)
            _currentUser.value = mockUser
            _authState.value = AuthState.Authenticated(mockUser)
            database.userDao().insertUser(mockUser)

            return Result.Success(mockUser)
        }

        val request = LoginRequest(email, password)

        return when (val result = safeApiCall { apiService.login(request) }) {
            is Result.Success -> {
                val response = result.data
                if (response.success && response.user != null) {
                    val user = response.user.toUser()

                    // Save auth data
                    saveAuthData(response.token, user)

                    // Update state
                    _currentUser.value = user
                    _authState.value = AuthState.Authenticated(user)

                    // Cache user to local database
                    database.userDao().insertUser(user)

                    // Log activity
                    logActivity(user.id, ActivityType.LOGIN)

                    Result.Success(user)
                } else {
                    Result.Error(
                        Exception("Login failed"),
                        response.message ?: "Invalid credentials"
                    )
                }
            }
            is Result.Error -> result
            is Result.Loading -> Result.Loading
            is Result.Idle -> Result.Idle
        }
    }

    suspend fun register(email: String, password: String, displayName: String): Result<User> {
        // Mock mode: bypass API call for offline testing
        if (MOCK_MODE) {
            val mockUser = User(
                id = "mock_${System.currentTimeMillis()}",
                email = email,
                displayName = displayName,
                photoUrl = null,
                role = UserRole.USER,
                dietaryPreferences = emptyList(),
                allergies = emptyList(),
                dailyCalorieGoal = 2000,
                createdAt = System.currentTimeMillis(),
                lastLoginAt = System.currentTimeMillis(),
                isEmailVerified = true,
                isBiometricEnabled = false
            )

            saveAuthData("mock_token_${System.currentTimeMillis()}", mockUser)
            _currentUser.value = mockUser
            _authState.value = AuthState.Authenticated(mockUser)
            database.userDao().insertUser(mockUser)

            return Result.Success(mockUser)
        }

        val request = RegisterRequest(email, password, displayName)

        return when (val result = safeApiCall { apiService.register(request) }) {
            is Result.Success -> {
                val response = result.data
                if (response.success && response.user != null) {
                    val user = response.user.toUser()

                    if (response.requiresEmailVerification) {
                        _authState.value = AuthState.EmailVerificationRequired(user.email)
                        Result.Success(user)
                    } else {
                        saveAuthData(response.token, user)
                        _currentUser.value = user
                        _authState.value = AuthState.Authenticated(user)
                        database.userDao().insertUser(user)
                        Result.Success(user)
                    }
                } else {
                    Result.Error(
                        Exception("Registration failed"),
                        response.message ?: "Registration failed"
                    )
                }
            }
            is Result.Error -> result
            is Result.Loading -> Result.Loading
            is Result.Idle -> Result.Idle
        }
    }

    suspend fun logout(): Result<Unit> {
        val token = getToken()

        // Log activity before logout
        _currentUser.value?.let {
            logActivity(it.id, ActivityType.LOGOUT)
        }

        // Clear local auth data regardless of API result
        clearAuthData()

        _currentUser.value = null
        _authState.value = AuthState.Unauthenticated

        // Try to notify server
        token?.let {
            safeApiCall { apiService.logout("Bearer $it") }
        }

        return Result.Success(Unit)
    }

    suspend fun forgotPassword(email: String): Result<Unit> {
        val request = PasswordResetRequest(email)
        return when (val result = safeApiCall { apiService.forgotPassword(request) }) {
            is Result.Success -> Result.Success(Unit)
            is Result.Error -> result
            is Result.Loading -> Result.Loading
            is Result.Idle -> Result.Idle
        }
    }

    suspend fun changePassword(currentPassword: String, newPassword: String): Result<Unit> {
        val token = getToken() ?: return Result.Error(
            Exception("Not authenticated"),
            "Please login first"
        )

        val request = ChangePasswordRequest(currentPassword, newPassword)
        return when (val result = safeApiCall {
            apiService.changePassword("Bearer $token", request)
        }) {
            is Result.Success -> {
                _currentUser.value?.let {
                    logActivity(it.id, ActivityType.PASSWORD_CHANGE)
                }
                Result.Success(Unit)
            }
            is Result.Error -> result
            is Result.Loading -> Result.Loading
            is Result.Idle -> Result.Idle
        }
    }

    // ====== Profile Operations ======

    suspend fun updateProfile(
        displayName: String? = null,
        photoUrl: String? = null,
        dietaryPreferences: List<String>? = null,
        allergies: List<String>? = null,
        dailyCalorieGoal: Int? = null
    ): Result<User> {
        val token = getToken() ?: return Result.Error(
            Exception("Not authenticated"),
            "Please login first"
        )

        val request = UpdateProfileRequest(
            displayName = displayName,
            photoUrl = photoUrl,
            dietaryPreferences = dietaryPreferences,
            allergies = allergies,
            dailyCalorieGoal = dailyCalorieGoal
        )

        return when (val result = safeApiCall {
            apiService.updateProfile("Bearer $token", request)
        }) {
            is Result.Success -> {
                val user = result.data.data?.toUser()
                if (user != null) {
                    _currentUser.value = user
                    database.userDao().updateUser(user)
                    logActivity(user.id, ActivityType.PROFILE_UPDATE)
                    Result.Success(user)
                } else {
                    Result.Error(Exception("Update failed"), "Failed to update profile")
                }
            }
            is Result.Error -> result
            is Result.Loading -> Result.Loading
            is Result.Idle -> Result.Idle
        }
    }

    suspend fun refreshUserData(): Result<User> {
        val token = getToken() ?: return Result.Error(
            Exception("Not authenticated"),
            "Please login first"
        )

        return when (val result = safeApiCall {
            apiService.getCurrentUser("Bearer $token")
        }) {
            is Result.Success -> {
                val user = result.data.data?.toUser()
                if (user != null) {
                    _currentUser.value = user
                    database.userDao().updateUser(user)
                    Result.Success(user)
                } else {
                    Result.Error(Exception("User not found"), "User data not available")
                }
            }
            is Result.Error -> result
            is Result.Loading -> Result.Loading
            is Result.Idle -> Result.Idle
        }
    }

    // ====== Session Management ======

    private fun saveAuthData(token: String?, user: User) {
        prefs.edit {
            putString(KEY_TOKEN, token)
            putString(KEY_USER_ID, user.id)
            putBoolean(KEY_IS_LOGGED_IN, true)
            putLong(KEY_LAST_LOGIN, System.currentTimeMillis())
        }
        RetrofitClient.setAuthToken(token)
    }

    private fun clearAuthData() {
        prefs.edit {
            remove(KEY_TOKEN)
            remove(KEY_REFRESH_TOKEN)
            remove(KEY_USER_ID)
            putBoolean(KEY_IS_LOGGED_IN, false)
        }
        RetrofitClient.setAuthToken(null)
    }

    private fun restoreSession() {
        // In MOCK_MODE, do not restore session - always require fresh login
        if (MOCK_MODE) {
            _authState.value = AuthState.Unauthenticated
            return
        }
        val token = prefs.getString(KEY_TOKEN, null)
        val userId = prefs.getString(KEY_USER_ID, null)
        val isLoggedIn = prefs.getBoolean(KEY_IS_LOGGED_IN, false)

        if (isLoggedIn && token != null && userId != null) {
            RetrofitClient.setAuthToken(token)
        }
        _authState.value = AuthState.Unauthenticated
    }

    fun getToken(): String? = prefs.getString(KEY_TOKEN, null)

    fun getCurrentUserId(): String? = prefs.getString(KEY_USER_ID, null)

    fun isLoggedIn(): Boolean {
        if (MOCK_MODE) return false
        return prefs.getBoolean(KEY_IS_LOGGED_IN, false)
    }

    fun isAdmin(): Boolean = _currentUser.value?.role == UserRole.ADMIN

    // ====== Activity Logging ======

    private suspend fun logActivity(userId: String, activityType: ActivityType, details: String? = null) {
        val log = UserActivityLog(
            userId = userId,
            activityType = activityType,
            details = details
        )
        database.userDao().insertActivityLog(log)
    }

    fun getCurrentUserLive(): Flow<User?> {
        val userId = getCurrentUserId() ?: return MutableStateFlow(null).asStateFlow()
        return database.userDao().getUserByIdFlow(userId)
    }
}

/**
 * Authentication State Sealed Class
 */
sealed class AuthState {
    data object Unauthenticated : AuthState()
    data object Loading : AuthState()
    data class Authenticated(val user: User) : AuthState()
    data class EmailVerificationRequired(val email: String) : AuthState()
    data class Error(val message: String) : AuthState()
}
