package edu.monash.fit5046.healthyrecipehub.data.repository

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.android.gms.tasks.Tasks
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import edu.monash.fit5046.healthyrecipehub.data.local.database.AppDatabase
import edu.monash.fit5046.healthyrecipehub.data.model.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.tasks.await

/**
 * Authentication Repository - Uses Firebase Auth + Firestore
 */
class AuthRepository(
    private val context: Context,
    private val database: AppDatabase
) {
    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val usersCollection = firestore.collection("users")

    companion object {
        private const val PREFS_NAME = "auth_prefs"
        private const val KEY_USER_ID = "user_id"
        private const val KEY_IS_LOGGED_IN = "is_logged_in"
        private const val KEY_LAST_LOGIN = "last_login"

        @Volatile
        private var instance: AuthRepository? = null

        fun getInstance(context: Context): AuthRepository {
            return instance ?: synchronized(this) {
                val database = AppDatabase.getDatabase(context)
                instance = AuthRepository(context, database)
                instance!!
            }
        }
    }

    private val _authState = MutableStateFlow<AuthState>(AuthState.Unauthenticated)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()
    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser.asStateFlow()

    init {
        if (firebaseAuth.currentUser != null) {
            saveSessionId(firebaseAuth.currentUser!!.uid)
            // Set a valid auth state so MainApp doesn't think we're unauthenticated
            _authState.value = AuthState.Authenticated(
                createUserFromFirebaseUser(firebaseAuth.currentUser!!)
            )
        } else {
            clearSession(); _authState.value = AuthState.Unauthenticated
        }
    }

    suspend fun login(email: String, password: String): Result<User> = try {
        val r = firebaseAuth.signInWithEmailAndPassword(email, password).await()
        val fb = r.user ?: throw Exception("Login failed")
        val u = (getUserFromFirestore(fb.uid) ?: createUserFromFirebaseUser(fb)).copy(lastLoginAt = System.currentTimeMillis())
        saveUserToFirestore(u); saveSession(u); database.userDao().insertUser(u)
        logActivity(u.id, ActivityType.LOGIN)
        _currentUser.value = u; _authState.value = AuthState.Authenticated(u)
        Result.Success(u)
    } catch (e: Exception) { Result.Error(e, e.message ?: "Login failed") }

    suspend fun register(email: String, password: String, displayName: String): Result<User> = try {
        val r = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
        val fb = r.user ?: throw Exception("Registration failed")
        fb.updateProfile(UserProfileChangeRequest.Builder().setDisplayName(displayName).build()).await()
        fb.sendEmailVerification().await()
        val u = User(id = fb.uid, email = email, displayName = displayName,
            photoUrl = fb.photoUrl?.toString(), role = UserRole.USER,
            dietaryPreferences = emptyList(), allergies = emptyList(), dailyCalorieGoal = 2000,
            createdAt = System.currentTimeMillis(), lastLoginAt = System.currentTimeMillis(),
            isEmailVerified = false, isBiometricEnabled = false)
        saveUserToFirestore(u); saveSession(u); database.userDao().insertUser(u)
        logActivity(u.id, ActivityType.LOGIN)
        _currentUser.value = u; _authState.value = AuthState.Authenticated(u)
        Result.Success(u)
    } catch (e: Exception) { Result.Error(e, e.message ?: "Registration failed") }

    suspend fun signInWithGoogle(idToken: String): Result<User> = try {
        val r = firebaseAuth.signInWithCredential(GoogleAuthProvider.getCredential(idToken, null)).await()
        val fb = r.user ?: throw Exception("Google Sign-In failed")
        val u = (getUserFromFirestore(fb.uid) ?: createUserFromFirebaseUser(fb)).copy(lastLoginAt = System.currentTimeMillis())
        saveUserToFirestore(u); saveSession(u); database.userDao().insertUser(u)
        logActivity(u.id, ActivityType.LOGIN)
        _currentUser.value = u; _authState.value = AuthState.Authenticated(u)
        Result.Success(u)
    } catch (e: Exception) { Result.Error(e, e.message ?: "Google Sign-In failed") }

    suspend fun logout(): Result<Unit> {
        _currentUser.value?.let { logActivity(it.id, ActivityType.LOGOUT) }
        firebaseAuth.signOut(); clearSession()
        _currentUser.value = null; _authState.value = AuthState.Unauthenticated
        return Result.Success(Unit)
    }

    suspend fun forgotPassword(email: String): Result<Unit> = try {
        firebaseAuth.sendPasswordResetEmail(email).await(); Result.Success(Unit)
    } catch (e: Exception) { Result.Error(e, e.message ?: "Password reset failed") }

    suspend fun changePassword(currentPassword: String, newPassword: String): Result<Unit> = try {
        val u = firebaseAuth.currentUser ?: throw Exception("Not authenticated")
        u.reauthenticate(com.google.firebase.auth.EmailAuthProvider.getCredential(u.email ?: "", currentPassword)).await()
        u.updatePassword(newPassword).await()
        logActivity(u.uid, ActivityType.PASSWORD_CHANGE); Result.Success(Unit)
    } catch (e: Exception) { Result.Error(e, e.message ?: "Password change failed") }

    suspend fun updateProfile(displayName: String? = null, photoUrl: String? = null,
        dietaryPreferences: List<String>? = null, allergies: List<String>? = null,
        dailyCalorieGoal: Int? = null): Result<User> {
        val cu = _currentUser.value ?: return Result.Error(Exception("Not auth"), "Login first")
        return try {
            val updated = cu.copy(displayName = displayName ?: cu.displayName,
                photoUrl = photoUrl ?: cu.photoUrl,
                dietaryPreferences = dietaryPreferences ?: cu.dietaryPreferences,
                allergies = allergies ?: cu.allergies,
                dailyCalorieGoal = dailyCalorieGoal ?: cu.dailyCalorieGoal)
            if (displayName != null) firebaseAuth.currentUser?.updateProfile(
                UserProfileChangeRequest.Builder().setDisplayName(displayName).build())?.await()
            saveUserToFirestore(updated); database.userDao().updateUser(updated)
            _currentUser.value = updated; logActivity(updated.id, ActivityType.PROFILE_UPDATE)
            Result.Success(updated)
        } catch (e: Exception) { Result.Error(e, e.message ?: "Update failed") }
    }

    suspend fun refreshUserData(): Result<User> {
        return try {
            val fb = firebaseAuth.currentUser ?: return Result.Error(Exception("Not auth"), "Login first")
            val u = getUserFromFirestore(fb.uid) ?: createUserFromFirebaseUser(fb)
            _currentUser.value = u; database.userDao().insertUser(u)
            _authState.value = AuthState.Authenticated(u); Result.Success(u)
        } catch (e: Exception) { Result.Error(e, e.message ?: "Refresh failed") }
    }

    private suspend fun saveUserToFirestore(user: User) {
        usersCollection.document(user.id).set(hashMapOf(
            "id" to user.id, "email" to user.email, "displayName" to user.displayName,
            "photoUrl" to user.photoUrl, "role" to user.role.name,
            "dietaryPreferences" to user.dietaryPreferences, "allergies" to user.allergies,
            "dailyCalorieGoal" to user.dailyCalorieGoal, "createdAt" to user.createdAt,
            "lastLoginAt" to user.lastLoginAt, "isEmailVerified" to user.isEmailVerified,
            "isBiometricEnabled" to user.isBiometricEnabled)).await()
    }

    private suspend fun getUserFromFirestore(userId: String): User? = try {
        val d = usersCollection.document(userId).get().await()
        if (d.exists()) User(id = d.getString("id") ?: userId, email = d.getString("email") ?: "",
            displayName = d.getString("displayName") ?: "", photoUrl = d.getString("photoUrl"),
            role = try { UserRole.valueOf(d.getString("role") ?: "USER") } catch (_: Exception) { UserRole.USER },
            dietaryPreferences = (d.get("dietaryPreferences") as? List<String>) ?: emptyList(),
            allergies = (d.get("allergies") as? List<String>) ?: emptyList(),
            dailyCalorieGoal = (d.getLong("dailyCalorieGoal")?.toInt()) ?: 2000,
            createdAt = d.getLong("createdAt") ?: System.currentTimeMillis(),
            lastLoginAt = d.getLong("lastLoginAt") ?: System.currentTimeMillis(),
            isEmailVerified = d.getBoolean("isEmailVerified") ?: false,
            isBiometricEnabled = d.getBoolean("isBiometricEnabled") ?: false) else null
    } catch (_: Exception) { null }

    private fun createUserFromFirebaseUser(fb: com.google.firebase.auth.FirebaseUser) = User(
        id = fb.uid, email = fb.email ?: "",
        displayName = fb.displayName ?: fb.email?.substringBefore("@") ?: "User",
        photoUrl = fb.photoUrl?.toString(), role = UserRole.USER,
        dietaryPreferences = emptyList(), allergies = emptyList(), dailyCalorieGoal = 2000,
        createdAt = System.currentTimeMillis(), lastLoginAt = System.currentTimeMillis(),
        isEmailVerified = fb.isEmailVerified, isBiometricEnabled = false)

    suspend fun sendEmailVerification(): Result<Unit> {
        return try {
            firebaseAuth.currentUser?.sendEmailVerification()?.await()
            Result.Success(Unit)
        } catch (e: Exception) { Result.Error(e, e.message ?: "Failed") }
    }

    fun getToken(): String? {
        return try {
            val t = firebaseAuth.currentUser?.getIdToken(false) ?: return null
            Tasks.await(t).token
        } catch (_: Exception) { null }
    }
    suspend fun getIdToken(): String? = try {
        firebaseAuth.currentUser?.getIdToken(false)?.await()?.token
    } catch (_: Exception) { null }

    private fun saveSessionId(userId: String) { prefs.edit {
        putString(KEY_USER_ID, userId); putBoolean(KEY_IS_LOGGED_IN, true)
        putLong(KEY_LAST_LOGIN, System.currentTimeMillis()) } }
    private fun saveSession(user: User) { saveSessionId(user.id) }
    private fun clearSession() { prefs.edit {
        remove(KEY_USER_ID); putBoolean(KEY_IS_LOGGED_IN, false) } }

    fun getCurrentUserId(): String? = prefs.getString(KEY_USER_ID, null)

    fun isLoggedIn(): Boolean = firebaseAuth.currentUser != null
    fun isAdmin(): Boolean = _currentUser.value?.role == UserRole.ADMIN

    private suspend fun logActivity(userId: String, type: ActivityType, details: String? = null) {
        database.userDao().insertActivityLog(UserActivityLog(userId = userId, activityType = type, details = details))
    }

    fun getCurrentUserLive(): Flow<User?> {
        val uid = getCurrentUserId() ?: return MutableStateFlow(null).asStateFlow()
        return database.userDao().getUserByIdFlow(uid)
    }
}

sealed class AuthState {
    data object Unauthenticated : AuthState()
    data object Loading : AuthState()
    data class Authenticated(val user: User) : AuthState()
    data class EmailVerificationRequired(val email: String) : AuthState()
    data class Error(val message: String) : AuthState()
}
