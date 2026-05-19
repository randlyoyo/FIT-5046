package edu.monash.fit5046.healthyrecipehub.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import edu.monash.fit5046.healthyrecipehub.data.model.*
import edu.monash.fit5046.healthyrecipehub.data.remote.api.*
import edu.monash.fit5046.healthyrecipehub.data.repository.AuthRepository
import kotlinx.coroutines.launch

/**
 * Admin ViewModel
 * Manages admin dashboard functionality
 */
class AdminViewModel(application: Application) : AndroidViewModel(application) {

    private val adminApiService: AdminApiService = RetrofitClient.adminApiService
    private val authRepository: AuthRepository = AuthRepository.getInstance(application)

    // Users
    private val _users = MutableLiveData<Resource<List<User>>>()
    val users: LiveData<Resource<List<User>>> = _users

    // Statistics
    private val _statistics = MutableLiveData<Resource<StatisticsResponse>>()
    val statistics: LiveData<Resource<StatisticsResponse>> = _statistics

    private val _userStats = MutableLiveData<Resource<UserStatisticsDto>>()
    val userStats: LiveData<Resource<UserStatisticsDto>> = _userStats

    private val _recipeStats = MutableLiveData<Resource<RecipeStatisticsDto>>()
    val recipeStats: LiveData<Resource<RecipeStatisticsDto>> = _recipeStats

    // Operations
    private val _operationResult = MutableLiveData<Result<Unit>>()
    val operationResult: LiveData<Result<Unit>> = _operationResult

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    /**
     * Load all users
     */
    fun loadUsers(page: Int = 1, limit: Int = 50) {
        viewModelScope.launch {
            _isLoading.value = true
            _users.value = Resource.loading()

            val token = authRepository.getToken()
            if (token == null) {
                _users.value = Resource.error("Not authenticated")
                _isLoading.value = false
                return@launch
            }

            val result = safeApiCall { adminApiService.getAllUsers("Bearer $token", page, limit) }
            when (result) {
                is Result.Success -> {
                    val users = result.data.data?.map { it.toUser() } ?: emptyList()
                    _users.value = Resource.success(users)
                }
                is Result.Error -> {
                    _users.value = Resource.error(result.message)
                }
                else -> {}
            }

            _isLoading.value = false
        }
    }

    /**
     * Load statistics
     */
    fun loadStatistics() {
        viewModelScope.launch {
            _isLoading.value = true
            val token = authRepository.getToken()

            if (token == null) {
                _isLoading.value = false
                return@launch
            }

            // Load general statistics
            val statsResult = safeApiCall { adminApiService.getStatistics("Bearer $token") }
            when (statsResult) {
                is Result.Success -> {
                    _statistics.value = Resource.success(statsResult.data)
                }
                is Result.Error -> {
                    _statistics.value = Resource.error(statsResult.message)
                }
                else -> {}
            }

            // Load user statistics
            val userStatsResult = safeApiCall {
                adminApiService.getUserStatistics("Bearer $token", 30)
            }
            when (userStatsResult) {
                is Result.Success -> {
                    _userStats.value = Resource.success(userStatsResult.data)
                }
                is Result.Error -> {
                    _userStats.value = Resource.error(userStatsResult.message)
                }
                else -> {}
            }

            // Load recipe statistics
            val recipeStatsResult = safeApiCall {
                adminApiService.getRecipeStatistics("Bearer $token", 30)
            }
            when (recipeStatsResult) {
                is Result.Success -> {
                    _recipeStats.value = Resource.success(recipeStatsResult.data)
                }
                is Result.Error -> {
                    _recipeStats.value = Resource.error(recipeStatsResult.message)
                }
                else -> {}
            }

            _isLoading.value = false
        }
    }

    /**
     * Update user role
     */
    fun updateUserRole(userId: String, role: UserRole) {
        viewModelScope.launch {
            _isLoading.value = true
            val token = authRepository.getToken()

            if (token == null) {
                _operationResult.value = Result.Error(
                    Exception("Not authenticated"),
                    "Please login"
                )
                _isLoading.value = false
                return@launch
            }

            val result = safeApiCall {
                adminApiService.updateUserRole("Bearer $token", userId, role.name)
            }
            _operationResult.value = result.map { }
            _isLoading.value = false
        }
    }

    /**
     * Delete user
     */
    fun deleteUser(userId: String) {
        viewModelScope.launch {
            _isLoading.value = true
            val token = authRepository.getToken()

            if (token == null) {
                _operationResult.value = Result.Error(
                    Exception("Not authenticated"),
                    "Please login"
                )
                _isLoading.value = false
                return@launch
            }

            val result = safeApiCall {
                adminApiService.deleteUser("Bearer $token", userId)
            }
            _operationResult.value = result
            _isLoading.value = false

            // Refresh user list
            if (result is Result.Success) {
                loadUsers()
            }
        }
    }

    /**
     * Disable user
     */
    fun disableUser(userId: String) {
        viewModelScope.launch {
            _isLoading.value = true
            val token = authRepository.getToken()

            if (token == null) {
                _isLoading.value = false
                return@launch
            }

            val result = safeApiCall {
                adminApiService.disableUser("Bearer $token", userId)
            }
            _operationResult.value = result.map { }
            _isLoading.value = false
        }
    }

    /**
     * Enable user
     */
    fun enableUser(userId: String) {
        viewModelScope.launch {
            _isLoading.value = true
            val token = authRepository.getToken()

            if (token == null) {
                _isLoading.value = false
                return@launch
            }

            val result = safeApiCall {
                adminApiService.enableUser("Bearer $token", userId)
            }
            _isLoading.value = false
        }
    }

    /**
     * Approve recipe
     */
    fun approveRecipe(recipeId: String) {
        viewModelScope.launch {
            _isLoading.value = true
            val token = authRepository.getToken()

            if (token == null) {
                _isLoading.value = false
                return@launch
            }

            val result = safeApiCall {
                adminApiService.approveRecipe("Bearer $token", recipeId)
            }
            _operationResult.value = result
            _isLoading.value = false
        }
    }

    /**
     * Reject recipe
     */
    fun rejectRecipe(recipeId: String, reason: String) {
        viewModelScope.launch {
            _isLoading.value = true
            val token = authRepository.getToken()

            if (token == null) {
                _isLoading.value = false
                return@launch
            }

            val result = safeApiCall {
                adminApiService.rejectRecipe("Bearer $token", recipeId, reason)
            }
            _operationResult.value = result
            _isLoading.value = false
        }
    }

    fun clearOperationResult() {
        _operationResult.value = Result.Idle
    }
}

// Extension to convert Result<T, E> to Result<Unit>
private fun <T> Result<T>.map(transform: (T) -> Unit): Result<Unit> {
    return when (this) {
        is Result.Success -> Result.Success(Unit)
        is Result.Error -> Result.Error(exception, message)
        is Result.Loading -> Result.Loading
        is Result.Idle -> Result.Idle
    }
}
