package edu.monash.fit5046.healthyrecipehub.data.remote.api

import edu.monash.fit5046.healthyrecipehub.data.remote.dto.*
import retrofit2.Response
import retrofit2.http.*

/**
 * Recipe API Service Interface
 * Retrofit interface for recipe-related API calls
 */
interface RecipeApiService {

    // ====== Public Recipe Endpoints ======

    @GET("/apiRecipes")
    suspend fun getAllRecipes(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20,
        @Query("sortBy") sortBy: String = "createdAt",
        @Query("order") order: String = "desc"
    ): Response<RecipeResponse>

    @GET("/apiRecipeById/{recipeId}")
    suspend fun getRecipeById(
        @Path("recipeId") recipeId: String
    ): Response<RecipeResponse>

    @GET("/apiRecipes/search")
    suspend fun searchRecipes(
        @Query("q") query: String,
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20
    ): Response<RecipeResponse>

    @GET("/apiRecipes/category/{category}")
    suspend fun getRecipesByCategory(
        @Path("category") category: String,
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20
    ): Response<RecipeResponse>

    @GET("/apiRecipes/cuisine/{cuisine}")
    suspend fun getRecipesByCuisine(
        @Path("cuisine") cuisine: String,
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20
    ): Response<RecipeResponse>

    @GET("/apiRecipes/filter")
    suspend fun filterRecipes(
        @Query("category") category: String? = null,
        @Query("cuisine") cuisine: String? = null,
        @Query("difficulty") difficulty: String? = null,
        @Query("maxCalories") maxCalories: Int? = null,
        @Query("dietaryTags") dietaryTags: String? = null,
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20
    ): Response<RecipeResponse>

    // ====== Authenticated Recipe Endpoints ======

    @POST("/apiRecipes")
    suspend fun createRecipe(
        @Header("Authorization") token: String,
        @Body recipe: RecipeUploadRequest
    ): Response<RecipeResponse>

    @PUT("/apiRecipes/{recipeId}")
    suspend fun updateRecipe(
        @Header("Authorization") token: String,
        @Path("recipeId") recipeId: String,
        @Body recipe: RecipeUploadRequest
    ): Response<RecipeResponse>

    @DELETE("/apiRecipes/{recipeId}")
    suspend fun deleteRecipe(
        @Header("Authorization") token: String,
        @Path("recipeId") recipeId: String
    ): Response<Unit>

    // ====== Favorites ======

    @GET("/apiRecipes/favorites")
    suspend fun getFavoriteRecipes(
        @Header("Authorization") token: String
    ): Response<RecipeResponse>

    @POST("/apiRecipes/{recipeId}/favorite")
    suspend fun addToFavorites(
        @Header("Authorization") token: String,
        @Path("recipeId") recipeId: String
    ): Response<Unit>

    @DELETE("/apiRecipes/{recipeId}/favorite")
    suspend fun removeFromFavorites(
        @Header("Authorization") token: String,
        @Path("recipeId") recipeId: String
    ): Response<Unit>

    // ====== Reviews ======

    @GET("/apiRecipes/{recipeId}/reviews")
    suspend fun getRecipeReviews(
        @Path("recipeId") recipeId: String
    ): Response<List<ReviewDto>>

    @POST("/apiRecipes/{recipeId}/reviews")
    suspend fun addReview(
        @Header("Authorization") token: String,
        @Path("recipeId") recipeId: String,
        @Body review: ReviewRequest
    ): Response<ReviewDto>

    @DELETE("/apiRecipes/{recipeId}/reviews/{reviewId}")
    suspend fun deleteReview(
        @Header("Authorization") token: String,
        @Path("recipeId") recipeId: String,
        @Path("reviewId") reviewId: String
    ): Response<Unit>
}

/**
 * Review DTO
 */
data class ReviewDto(
    val id: String,
    val recipeId: String,
    val userId: String,
    val userName: String,
    val rating: Float,
    val comment: String,
    val createdAt: Long
)

data class ReviewRequest(
    val rating: Float,
    val comment: String
)
