package edu.monash.fit5046.healthyrecipehub.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import edu.monash.fit5046.healthyrecipehub.data.model.*
import edu.monash.fit5046.healthyrecipehub.data.repository.AuthRepository
import edu.monash.fit5046.healthyrecipehub.data.repository.AuthState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * Authentication ViewModel
 * Manages authentication UI state
 */
class AuthViewModel(application: Application) : AndroidViewModel(application) {

    private val authRepository: AuthRepository = AuthRepository.getInstance(application)

    // StateFlow from repository
    val authState: StateFlow<AuthState> = authRepository.authState
    val currentUser: StateFlow<User?> = authRepository.currentUser

    // LiveData for one-time events
    private val _loginResult = MutableLiveData<Result<User>>()
    val loginResult: LiveData<Result<User>> = _loginResult

    private val _registerResult = MutableLiveData<Result<User>>()
    val registerResult: LiveData<Result<User>> = _registerResult

    private val _passwordResetResult = MutableLiveData<Result<Unit>>()
    val passwordResetResult: LiveData<Result<Unit>> = _passwordResetResult

    private val _changePasswordResult = MutableLiveData<Result<Unit>>()
    val changePasswordResult: LiveData<Result<Unit>> = _changePasswordResult

    private val _profileUpdateResult = MutableLiveData<Result<User>>()
    val profileUpdateResult: LiveData<Result<User>> = _profileUpdateResult

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    /**
     * Login with email and password
     */
    fun login(email: String, password: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            val result = authRepository.login(email, password)
            _loginResult.value = result

            if (result is Result.Error) {
                _errorMessage.value = result.message
            }

            _isLoading.value = false
        }
    }

    /**
     * Register new account
     */
    fun register(email: String, password: String, displayName: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            val result = authRepository.register(email, password, displayName)
            _registerResult.value = result

            if (result is Result.Error) {
                _errorMessage.value = result.message
            }

            _isLoading.value = false
        }
    }

    /**
     * Logout current user
     */
    fun logout() {
        viewModelScope.launch {
            _isLoading.value = true
            authRepository.logout()
            _isLoading.value = false
        }
    }

    /**
     * Send password reset email
     */
    fun forgotPassword(email: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            val result = authRepository.forgotPassword(email)
            _passwordResetResult.value = result

            if (result is Result.Error) {
                _errorMessage.value = result.message
            }

            _isLoading.value = false
        }
    }

    /**
     * Change password
     */
    fun changePassword(currentPassword: String, newPassword: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            val result = authRepository.changePassword(currentPassword, newPassword)
            _changePasswordResult.value = result

            if (result is Result.Error) {
                _errorMessage.value = result.message
            }

            _isLoading.value = false
        }
    }

    /**
     * Update user profile
     */
    fun updateProfile(
        displayName: String? = null,
        photoUrl: String? = null,
        dietaryPreferences: List<String>? = null,
        allergies: List<String>? = null,
        dailyCalorieGoal: Int? = null
    ) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            val result = authRepository.updateProfile(
                displayName = displayName,
                photoUrl = photoUrl,
                dietaryPreferences = dietaryPreferences,
                allergies = allergies,
                dailyCalorieGoal = dailyCalorieGoal
            )
            _profileUpdateResult.value = result

            if (result is Result.Error) {
                _errorMessage.value = result.message
            }

            _isLoading.value = false
        }
    }

    /**
     * Refresh current user data
     */
    fun refreshUserData() {
        viewModelScope.launch {
            _isLoading.value = true
            authRepository.refreshUserData()
            _isLoading.value = false
        }
    }

    /**
     * Check if user is logged in
     */
    fun isLoggedIn(): Boolean = authRepository.isLoggedIn()

    /**
     * Check if current user is admin
     */
    fun isAdmin(): Boolean = authRepository.isAdmin()

    /**
     * Get current user ID
     */
    fun getCurrentUserId(): String? = authRepository.getCurrentUserId()

    /**
     * Clear error message
     */
    fun clearError() {
        _errorMessage.value = null
    }

    /**
     * Clear results
     */
    fun clearResults() {
        _loginResult.value = Result.Idle
        _registerResult.value = Result.Idle
        _passwordResetResult.value = Result.Idle
        _changePasswordResult.value = Result.Idle
        _profileUpdateResult.value = Result.Idle
    }
}
