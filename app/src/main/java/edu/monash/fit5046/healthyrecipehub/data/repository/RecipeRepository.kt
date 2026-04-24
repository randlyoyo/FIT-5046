package edu.monash.fit5046.healthyrecipehub.data.repository

import android.content.Context
import edu.monash.fit5046.healthyrecipehub.data.local.dao.RecipeDao
import edu.monash.fit5046.healthyrecipehub.data.local.database.AppDatabase
import edu.monash.fit5046.healthyrecipehub.data.model.*
import edu.monash.fit5046.healthyrecipehub.data.remote.api.RecipeApiService
import edu.monash.fit5046.healthyrecipehub.data.remote.api.safeApiCall
import edu.monash.fit5046.healthyrecipehub.data.remote.dto.RecipeUploadRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Recipe Repository
 * Single source of truth for recipe data
 * Manages local (Room) and remote (API) data sources
 */
class RecipeRepository(
    private val context: Context,
    private val apiService: RecipeApiService,
    private val recipeDao: RecipeDao
) {

    companion object {
        @Volatile
        private var instance: RecipeRepository? = null

        fun getInstance(context: Context): RecipeRepository {
            return instance ?: synchronized(this) {
                val database = AppDatabase.getDatabase(context)
                instance = RecipeRepository(
                    context,
                    edu.monash.fit5046.healthyrecipehub.data.remote.api.RetrofitClient.recipeApiService,
                    database.recipeDao()
                )
                instance!!
            }
        }
    }

    // ====== Local Database Operations ======

    fun getAllRecipes(): Flow<List<Recipe>> = recipeDao.getAllRecipes()

    fun getRecipeByIdLive(recipeId: String): Flow<Recipe?> = recipeDao.getRecipeByIdFlow(recipeId)

    suspend fun getRecipeById(recipeId: String): Recipe? = recipeDao.getRecipeById(recipeId)

    suspend fun saveRecipe(recipe: Recipe) = recipeDao.insertRecipe(recipe)

    suspend fun saveRecipes(recipes: List<Recipe>) = recipeDao.insertRecipes(recipes)

    suspend fun updateRecipe(recipe: Recipe) = recipeDao.updateRecipe(recipe)

    suspend fun deleteRecipe(recipe: Recipe) = recipeDao.deleteRecipe(recipe)

    suspend fun deleteRecipeById(recipeId: String) = recipeDao.deleteRecipeById(recipeId)

    // ====== Search & Filter ======

    fun searchRecipes(query: String): Flow<List<Recipe>> = recipeDao.searchRecipes(query)

    fun filterRecipes(filter: RecipeFilter): Flow<List<Recipe>> {
        return recipeDao.filterRecipes(
            query = filter.query,
            category = filter.category,
            cuisine = filter.cuisine,
            difficulty = filter.difficulty,
            maxCalories = filter.maxCalories,
            sortBy = filter.sortBy.name
        )
    }

    fun getFavoriteRecipes(): Flow<List<Recipe>> = recipeDao.getFavoriteRecipes()

    fun getRecipesByAuthor(authorId: String): Flow<List<Recipe>> = recipeDao.getRecipesByAuthor(authorId)

    suspend fun updateFavoriteStatus(recipeId: String, isFavorite: Boolean) {
        recipeDao.updateFavoriteStatus(recipeId, isFavorite)
    }

    // ====== API Operations ======

    suspend fun fetchRecipesFromApi(page: Int = 1, limit: Int = 20): Result<List<Recipe>> {
        return when (val result = safeApiCall { apiService.getAllRecipes(page, limit) }) {
            is Result.Success -> {
                val recipes = result.data.data?.map { it.toRecipe() } ?: emptyList()
                // Cache to local database
                recipeDao.insertRecipes(recipes)
                Result.Success(recipes)
            }
            is Result.Error -> result
            is Result.Loading -> Result.Loading
            is Result.Idle -> Result.Idle
        }
    }

    suspend fun fetchRecipeById(recipeId: String): Result<Recipe> {
        return when (val result = safeApiCall { apiService.getRecipeById(recipeId) }) {
            is Result.Success -> {
                val recipe = result.data.data?.firstOrNull()?.toRecipe()
                if (recipe != null) {
                    recipeDao.insertRecipe(recipe)
                    Result.Success(recipe)
                } else {
                    Result.Error(Exception("Recipe not found"), "Recipe not found")
                }
            }
            is Result.Error -> result
            is Result.Loading -> Result.Loading
            is Result.Idle -> Result.Idle
        }
    }

    suspend fun searchRecipesApi(query: String): Result<List<Recipe>> {
        return when (val result = safeApiCall { apiService.searchRecipes(query) }) {
            is Result.Success -> {
                val recipes = result.data.data?.map { it.toRecipe() } ?: emptyList()
                Result.Success(recipes)
            }
            is Result.Error -> result
            is Result.Loading -> Result.Loading
            is Result.Idle -> Result.Idle
        }
    }

    // ====== Create/Update/Delete via API ======

    suspend fun createRecipe(token: String, recipe: RecipeUploadRequest): Result<Recipe> {
        return when (val result = safeApiCall { apiService.createRecipe(token, recipe) }) {
            is Result.Success -> {
                val newRecipe = result.data.data?.firstOrNull()?.toRecipe()
                if (newRecipe != null) {
                    recipeDao.insertRecipe(newRecipe)
                    Result.Success(newRecipe)
                } else {
                    Result.Error(Exception("Failed to create recipe"), "Failed to create recipe")
                }
            }
            is Result.Error -> result
            is Result.Loading -> Result.Loading
            is Result.Idle -> Result.Idle
        }
    }

    suspend fun updateRecipe(token: String, recipeId: String, recipe: RecipeUploadRequest): Result<Recipe> {
        return when (val result = safeApiCall { apiService.updateRecipe(token, recipeId, recipe) }) {
            is Result.Success -> {
                val updatedRecipe = result.data.data?.firstOrNull()?.toRecipe()
                if (updatedRecipe != null) {
                    recipeDao.updateRecipe(updatedRecipe)
                    Result.Success(updatedRecipe)
                } else {
                    Result.Error(Exception("Failed to update recipe"), "Failed to update recipe")
                }
            }
            is Result.Error -> result
            is Result.Loading -> Result.Loading
            is Result.Idle -> Result.Idle
        }
    }

    suspend fun deleteRecipe(token: String, recipeId: String): Result<Unit> {
        return when (val result = safeApiCall { apiService.deleteRecipe(token, recipeId) }) {
            is Result.Success -> {
                recipeDao.deleteRecipeById(recipeId)
                Result.Success(Unit)
            }
            is Result.Error -> result
            is Result.Loading -> Result.Loading
            is Result.Idle -> Result.Idle
        }
    }

    // ====== Favorites API ======

    suspend fun addToFavorites(token: String, recipeId: String): Result<Unit> {
        return when (val result = safeApiCall { apiService.addToFavorites(token, recipeId) }) {
            is Result.Success -> {
                recipeDao.updateFavoriteStatus(recipeId, true)
                Result.Success(Unit)
            }
            is Result.Error -> result
            is Result.Loading -> Result.Loading
            is Result.Idle -> Result.Idle
        }
    }

    suspend fun removeFromFavorites(token: String, recipeId: String): Result<Unit> {
        return when (val result = safeApiCall { apiService.removeFromFavorites(token, recipeId) }) {
            is Result.Success -> {
                recipeDao.updateFavoriteStatus(recipeId, false)
                Result.Success(Unit)
            }
            is Result.Error -> result
            is Result.Loading -> Result.Loading
            is Result.Idle -> Result.Idle
        }
    }

    // ====== Reviews ======

    suspend fun addReview(
        token: String,
        recipeId: String,
        rating: Float,
        comment: String
    ): Result<Unit> {
        val request = edu.monash.fit5046.healthyrecipehub.data.remote.api.ReviewRequest(rating, comment)
        return when (val result = safeApiCall { apiService.addReview(token, recipeId, request) }) {
            is Result.Success -> Result.Success(Unit)
            is Result.Error -> result
            is Result.Loading -> Result.Loading
            is Result.Idle -> Result.Idle
        }
    }

    // ====== Offline Support ======

    suspend fun syncOfflineRecipes(): Result<Unit> {
        val offlineRecipes = recipeDao.getOfflineRecipes()
        // Logic to sync offline recipes when back online
        return Result.Success(Unit)
    }

    suspend fun markRecipeOffline(recipeId: String, isOffline: Boolean) {
        recipeDao.updateOfflineStatus(recipeId, isOffline)
    }

    // ====== Statistics ======

    suspend fun getRecipeCount(): Int = recipeDao.getRecipeCount()

    suspend fun getRecipeCountByCategory(category: String): Int = recipeDao.getRecipeCountByCategory(category)
}
