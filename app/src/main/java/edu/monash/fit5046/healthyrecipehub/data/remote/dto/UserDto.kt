package edu.monash.fit5046.healthyrecipehub.data.remote.dto

import com.google.gson.annotations.SerializedName
import edu.monash.fit5046.healthyrecipehub.data.model.User
import edu.monash.fit5046.healthyrecipehub.data.model.UserRole

/**
 * User Data Transfer Objects
 */
data class UserResponse(
    @SerializedName("success") val success: Boolean,
    @SerializedName("data") val data: UserDto? = null,
    @SerializedName("message") val message: String? = null
)

data class UsersResponse(
    @SerializedName("success") val success: Boolean,
    @SerializedName("data") val data: List<UserDto>? = null,
    @SerializedName("total") val total: Int? = null
)

data class UserDto(
    @SerializedName("id") val id: String,
    @SerializedName("email") val email: String,
    @SerializedName("displayName") val displayName: String,
    @SerializedName("photoUrl") val photoUrl: String? = null,
    @SerializedName("role") val role: String = "USER",
    @SerializedName("dietaryPreferences") val dietaryPreferences: List<String> = emptyList(),
    @SerializedName("allergies") val allergies: List<String> = emptyList(),
    @SerializedName("dailyCalorieGoal") val dailyCalorieGoal: Int = 2000,
    @SerializedName("createdAt") val createdAt: Long = System.currentTimeMillis(),
    @SerializedName("lastLoginAt") val lastLoginAt: Long = System.currentTimeMillis(),
    @SerializedName("isEmailVerified") val isEmailVerified: Boolean = false
) {
    fun toUser(): User {
        return User(
            id = id,
            email = email,
            displayName = displayName,
            photoUrl = photoUrl,
            role = UserRole.valueOf(role.uppercase()),
            dietaryPreferences = dietaryPreferences,
            allergies = allergies,
            dailyCalorieGoal = dailyCalorieGoal,
            createdAt = createdAt,
            lastLoginAt = lastLoginAt,
            isEmailVerified = isEmailVerified
        )
    }
}

/**
 * Login/Register Requests
 */
data class LoginRequest(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)

data class RegisterRequest(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("displayName") val displayName: String
)

data class UpdateProfileRequest(
    @SerializedName("displayName") val displayName: String? = null,
    @SerializedName("photoUrl") val photoUrl: String? = null,
    @SerializedName("dietaryPreferences") val dietaryPreferences: List<String>? = null,
    @SerializedName("allergies") val allergies: List<String>? = null,
    @SerializedName("dailyCalorieGoal") val dailyCalorieGoal: Int? = null
)

/**
 * Auth Response
 */
data class AuthResponse(
    @SerializedName("success") val success: Boolean,
    @SerializedName("token") val token: String? = null,
    @SerializedName("user") val user: UserDto? = null,
    @SerializedName("message") val message: String? = null,
    @SerializedName("requiresEmailVerification") val requiresEmailVerification: Boolean = false
)

/**
 * Password Reset
 */
data class PasswordResetRequest(
    @SerializedName("email") val email: String
)

/**
 * Change Password
 */
data class ChangePasswordRequest(
    @SerializedName("currentPassword") val currentPassword: String,
    @SerializedName("newPassword") val newPassword: String
)
