package edu.monash.fit5046.healthyrecipehub.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import edu.monash.fit5046.healthyrecipehub.data.model.Recipe
import edu.monash.fit5046.healthyrecipehub.data.model.Review
import kotlinx.coroutines.flow.Flow

/**
 * Recipe Data Access Object
 * Defines database operations for recipes
 */
@Dao
interface RecipeDao {

    // ====== Basic CRUD Operations ======

    @Query("SELECT * FROM recipes ORDER BY createdAt DESC")
    fun getAllRecipes(): Flow<List<Recipe>>

    @Query("SELECT * FROM recipes ORDER BY createdAt DESC")
    suspend fun getAllRecipesSync(): List<Recipe>

    @Query("SELECT * FROM recipes WHERE id = :recipeId")
    suspend fun getRecipeById(recipeId: String): Recipe?

    @Query("SELECT * FROM recipes WHERE id = :recipeId")
    fun getRecipeByIdLive(recipeId: String): LiveData<Recipe?>

    @Query("SELECT * FROM recipes WHERE id = :recipeId")
    fun getRecipeByIdFlow(recipeId: String): Flow<Recipe?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipe: Recipe)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipes(recipes: List<Recipe>)

    @Update
    suspend fun updateRecipe(recipe: Recipe)

    @Delete
    suspend fun deleteRecipe(recipe: Recipe)

    @Query("DELETE FROM recipes WHERE id = :recipeId")
    suspend fun deleteRecipeById(recipeId: String)

    // ====== Search & Filter Operations ======

    @Query("""
        SELECT * FROM recipes 
        WHERE title LIKE '%' || :query || '%' 
        OR description LIKE '%' || :query || '%'
        ORDER BY title ASC
    """)
    fun searchRecipes(query: String): Flow<List<Recipe>>

    @Query("SELECT * FROM recipes WHERE category = :category ORDER BY createdAt DESC")
    fun getRecipesByCategory(category: String): Flow<List<Recipe>>

    @Query("SELECT * FROM recipes WHERE cuisine = :cuisine ORDER BY createdAt DESC")
    fun getRecipesByCuisine(cuisine: String): Flow<List<Recipe>>

    @Query("SELECT * FROM recipes WHERE difficulty = :difficulty ORDER BY createdAt DESC")
    fun getRecipesByDifficulty(difficulty: String): Flow<List<Recipe>>

    @Query("SELECT * FROM recipes WHERE calories <= :maxCalories ORDER BY calories ASC")
    fun getRecipesByMaxCalories(maxCalories: Int): Flow<List<Recipe>>

    @Query("SELECT * FROM recipes WHERE nutritionScore >= :minScore ORDER BY nutritionScore DESC")
    fun getRecipesByMinNutritionScore(minScore: Double): Flow<List<Recipe>>

    @Query("SELECT * FROM recipes WHERE isFavorite = 1 ORDER BY createdAt DESC")
    fun getFavoriteRecipes(): Flow<List<Recipe>>

    @Query("SELECT * FROM recipes WHERE authorId = :authorId ORDER BY createdAt DESC")
    fun getRecipesByAuthor(authorId: String): Flow<List<Recipe>>

    // ====== Complex Queries ======

    @Query("""
        SELECT * FROM recipes 
        WHERE (title LIKE '%' || :query || '%' OR description LIKE '%' || :query || '%')
        AND (:category IS NULL OR category = :category)
        AND (:cuisine IS NULL OR cuisine = :cuisine)
        AND (:difficulty IS NULL OR difficulty = :difficulty)
        AND (:maxCalories IS NULL OR calories <= :maxCalories)
        ORDER BY 
            CASE WHEN :sortBy = 'NEWEST' THEN createdAt END DESC,
            CASE WHEN :sortBy = 'OLDEST' THEN createdAt END ASC,
            CASE WHEN :sortBy = 'CALORIES_LOW' THEN calories END ASC,
            CASE WHEN :sortBy = 'CALORIES_HIGH' THEN calories END DESC,
            CASE WHEN :sortBy = 'NUTRITION_SCORE' THEN nutritionScore END DESC,
            CASE WHEN :sortBy = 'PREP_TIME' THEN (prepTime + cookTime) END ASC
    """)
    fun filterRecipes(
        query: String = "",
        category: String? = null,
        cuisine: String? = null,
        difficulty: String? = null,
        maxCalories: Int? = null,
        sortBy: String = "NEWEST"
    ): Flow<List<Recipe>>

    // ====== Statistics ======

    @Query("SELECT COUNT(*) FROM recipes")
    suspend fun getRecipeCount(): Int

    @Query("SELECT COUNT(*) FROM recipes WHERE category = :category")
    suspend fun getRecipeCountByCategory(category: String): Int

    @Query("SELECT AVG(calories) FROM recipes")
    suspend fun getAverageCalories(): Double?

    @Query("SELECT AVG(nutritionScore) FROM recipes")
    suspend fun getAverageNutritionScore(): Double?

    // ====== Favorites Management ======

    @Query("UPDATE recipes SET isFavorite = :isFavorite WHERE id = :recipeId")
    suspend fun updateFavoriteStatus(recipeId: String, isFavorite: Boolean)

    // ====== Offline Support ======

    @Query("SELECT * FROM recipes WHERE isOffline = 1")
    suspend fun getOfflineRecipes(): List<Recipe>

    @Query("UPDATE recipes SET isOffline = :isOffline WHERE id = :recipeId")
    suspend fun updateOfflineStatus(recipeId: String, isOffline: Boolean)

    // ====== Batch Operations ======

    @Query("DELETE FROM recipes")
    suspend fun deleteAllRecipes()

    @Query("DELETE FROM recipes WHERE authorId = :authorId")
    suspend fun deleteRecipesByAuthor(authorId: String)

    // ====== Reviews ======

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReview(review: Review)

    @Query("SELECT * FROM reviews WHERE recipeId = :recipeId ORDER BY createdAt DESC")
    fun getReviewsForRecipe(recipeId: String): Flow<List<Review>>

    @Query("SELECT AVG(rating) FROM reviews WHERE recipeId = :recipeId")
    suspend fun getAverageRatingForRecipe(recipeId: String): Float?

    @Query("SELECT COUNT(*) FROM reviews WHERE recipeId = :recipeId")
    suspend fun getReviewCountForRecipe(recipeId: String): Int
}
