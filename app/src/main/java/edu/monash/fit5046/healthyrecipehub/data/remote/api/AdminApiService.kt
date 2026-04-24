package edu.monash.fit5046.healthyrecipehub.data.remote.api

import edu.monash.fit5046.healthyrecipehub.data.remote.dto.*
import retrofit2.Response
import retrofit2.http.*

/**
 * Admin API Service
 * Admin-only endpoints for user and recipe management
 */
interface AdminApiService {

    // ====== User Management ======

    @GET("/api/admin/users")
    suspend fun getAllUsers(
        @Header("Authorization") token: String,
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 50,
        @Query("role") role: String? = null
    ): Response<UsersResponse>

    @GET("/api/admin/users/{userId}")
    suspend fun getUserById(
        @Header("Authorization") token: String,
        @Path("userId") userId: String
    ): Response<UserResponse>

    @PUT("/api/admin/users/{userId}/role")
    suspend fun updateUserRole(
        @Header("Authorization") token: String,
        @Path("userId") userId: String,
        @Query("role") role: String
    ): Response<UserResponse>

    @DELETE("/api/admin/users/{userId}")
    suspend fun deleteUser(
        @Header("Authorization") token: String,
        @Path("userId") userId: String
    ): Response<Unit>

    @POST("/api/admin/users/{userId}/disable")
    suspend fun disableUser(
        @Header("Authorization") token: String,
        @Path("userId") userId: String
    ): Response<Unit>

    @POST("/api/admin/users/{userId}/enable")
    suspend fun enableUser(
        @Header("Authorization") token: String,
        @Path("userId") userId: String
    ): Response<Unit>

    // ====== Recipe Management ======

    @GET("/api/admin/recipes/pending")
    suspend fun getPendingRecipes(
        @Header("Authorization") token: String,
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20
    ): Response<RecipeResponse>

    @POST("/api/admin/recipes/{recipeId}/approve")
    suspend fun approveRecipe(
        @Header("Authorization") token: String,
        @Path("recipeId") recipeId: String
    ): Response<Unit>

    @POST("/api/admin/recipes/{recipeId}/reject")
    suspend fun rejectRecipe(
        @Header("Authorization") token: String,
        @Path("recipeId") recipeId: String,
        @Query("reason") reason: String
    ): Response<Unit>

    @DELETE("/api/admin/recipes/{recipeId}")
    suspend fun adminDeleteRecipe(
        @Header("Authorization") token: String,
        @Path("recipeId") recipeId: String
    ): Response<Unit>

    // ====== Statistics ======

    @GET("/api/admin/statistics")
    suspend fun getStatistics(
        @Header("Authorization") token: String
    ): Response<StatisticsResponse>

    @GET("/api/admin/statistics/users")
    suspend fun getUserStatistics(
        @Header("Authorization") token: String,
        @Query("days") days: Int = 30
    ): Response<UserStatisticsDto>

    @GET("/api/admin/statistics/recipes")
    suspend fun getRecipeStatistics(
        @Header("Authorization") token: String,
        @Query("days") days: Int = 30
    ): Response<RecipeStatisticsDto>

    @GET("/api/admin/activity-logs")
    suspend fun getActivityLogs(
        @Header("Authorization") token: String,
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 100
    ): Response<ActivityLogsResponse>
}

/**
 * Statistics DTOs
 */
data class StatisticsResponse(
    val totalUsers: Int,
    val totalRecipes: Int,
    val totalReviews: Int,
    val newUsersToday: Int,
    val recipesAddedToday: Int,
    val activeUsersToday: Int
)

data class UserStatisticsDto(
    val totalUsers: Int,
    val activeUsers: Int,
    val newUsersThisWeek: Int,
    val adminCount: Int,
    val userGrowthData: List<DailyCount>
)

data class RecipeStatisticsDto(
    val totalRecipes: Int,
    val recipesThisWeek: Int,
    val pendingRecipes: Int,
    val categoryDistribution: Map<String, Int>,
    val recipeGrowthData: List<DailyCount>
)

data class DailyCount(
    val date: String,
    val count: Int
)

data class ActivityLogsResponse(
    val logs: List<ActivityLogDto>,
    val total: Int
)

data class ActivityLogDto(
    val id: String,
    val userId: String,
    val userName: String,
    val activity: String,
    val details: String?,
    val timestamp: Long
)
