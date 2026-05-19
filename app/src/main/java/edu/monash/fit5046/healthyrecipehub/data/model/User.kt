package edu.monash.fit5046.healthyrecipehub.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

/**
 * User Entity
 * FIT5046 - User Data Model
 */
@Parcelize
@Entity(tableName = "users")
data class User(
    @PrimaryKey
    val id: String,
    val email: String,
    val displayName: String,
    val photoUrl: String? = null,
    val role: UserRole = UserRole.USER,
    val dietaryPreferences: List<String> = emptyList(),
    val allergies: List<String> = emptyList(),
    val dailyCalorieGoal: Int = 2000,
    val createdAt: Long = System.currentTimeMillis(),
    val lastLoginAt: Long = System.currentTimeMillis(),
    val isEmailVerified: Boolean = false,
    val isBiometricEnabled: Boolean = false
) : Parcelable

enum class UserRole {
    USER,
    ADMIN,
    NUTRITIONIST
}

/**
 * User Statistics for Admin Dashboard
 */
data class UserStatistics(
    val totalUsers: Int,
    val activeUsers: Int,
    val newUsersThisWeek: Int,
    val adminCount: Int
)

/**
 * User Activity Log
 */
@Entity(tableName = "activity_logs", primaryKeys = ["userId", "timestamp"])
data class UserActivityLog(
    val userId: String,
    val timestamp: Long = System.currentTimeMillis(),
    val activityType: ActivityType,
    val details: String? = null
)

enum class ActivityType {
    LOGIN,
    LOGOUT,
    RECIPE_VIEW,
    RECIPE_CREATE,
    RECIPE_EDIT,
    RECIPE_DELETE,
    RECIPE_FAVORITE,
    PROFILE_UPDATE,
    PASSWORD_CHANGE,
    EMAIL_SENT
}

/**
 * Nutrition Log for tracking user intake
 */
@Parcelize
@Entity(tableName = "nutrition_logs")
data class NutritionLog(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val userId: String,
    val date: String, // YYYY-MM-DD format
    val recipeId: String? = null,
    val mealType: MealType,
    val calories: Int,
    val protein: Double,
    val carbs: Double,
    val fat: Double,
    val timestamp: Long = System.currentTimeMillis()
) : Parcelable

enum class MealType {
    BREAKFAST,
    LUNCH,
    DINNER,
    SNACK
}
