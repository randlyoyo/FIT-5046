package edu.monash.fit5046.healthyrecipehub.data.local.dao;

/**
 * Recipe Data Access Object
 * Defines database operations for recipes
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ]\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u000bH\'\u00a2\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u0010H\'J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0014\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u0010H\'J\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010#\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0018\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00102\u0006\u0010\n\u001a\u00020\u000bH\'J\u0018\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070&2\u0006\u0010\n\u001a\u00020\u000bH\'J\u000e\u0010\'\u001a\u00020\u0017H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010(\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u001c\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u00102\u0006\u0010\u000e\u001a\u00020\u000bH\'J\u001c\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u000bH\'J\u001c\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u00102\u0006\u0010\u0014\u001a\u00020\u000bH\'J\u001c\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u00102\u0006\u0010\u0015\u001a\u00020\u000bH\'J\u001c\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\'J\u001c\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u00102\u0006\u0010/\u001a\u00020\u001dH\'J\u0016\u00100\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u001c\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002020\u00110\u00102\u0006\u0010\n\u001a\u00020\u000bH\'J\u0016\u00103\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u001c\u00104\u001a\u00020\u00032\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u00a7@\u00a2\u0006\u0002\u00106J\u0016\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u000202H\u00a7@\u00a2\u0006\u0002\u00109J\u001c\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u000bH\'J\u001e\u0010;\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020=H\u00a7@\u00a2\u0006\u0002\u0010>J\u001e\u0010?\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020=H\u00a7@\u00a2\u0006\u0002\u0010>J\u0016\u0010A\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\b\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006B\u00c0\u0006\u0001"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/local/dao/RecipeDao;", "", "deleteAllRecipes", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRecipe", "recipe", "Ledu/monash/fit5046/healthyrecipehub/data/model/Recipe;", "(Ledu/monash/fit5046/healthyrecipehub/data/model/Recipe;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRecipeById", "recipeId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRecipesByAuthor", "authorId", "filterRecipes", "Lkotlinx/coroutines/flow/Flow;", "", "query", "category", "cuisine", "difficulty", "maxCalories", "", "sortBy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "getAllRecipes", "getAllRecipesSync", "getAverageCalories", "", "getAverageNutritionScore", "getAverageRatingForRecipe", "", "getFavoriteRecipes", "getOfflineRecipes", "getRecipeById", "getRecipeByIdFlow", "getRecipeByIdLive", "Landroidx/lifecycle/LiveData;", "getRecipeCount", "getRecipeCountByCategory", "getRecipesByAuthor", "getRecipesByCategory", "getRecipesByCuisine", "getRecipesByDifficulty", "getRecipesByMaxCalories", "getRecipesByMinNutritionScore", "minScore", "getReviewCountForRecipe", "getReviewsForRecipe", "Ledu/monash/fit5046/healthyrecipehub/data/model/Review;", "insertRecipe", "insertRecipes", "recipes", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertReview", "review", "(Ledu/monash/fit5046/healthyrecipehub/data/model/Review;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchRecipes", "updateFavoriteStatus", "isFavorite", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateOfflineStatus", "isOffline", "updateRecipe", "app_debug"})
@androidx.room.Dao()
public abstract interface RecipeDao {
    
    @androidx.room.Query(value = "SELECT * FROM recipes ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>> getAllRecipes();
    
    @androidx.room.Query(value = "SELECT * FROM recipes ORDER BY createdAt DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllRecipesSync(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM recipes WHERE id = :recipeId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRecipeById(@org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.model.Recipe> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM recipes WHERE id = :recipeId")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Recipe> getRecipeByIdLive(@org.jetbrains.annotations.NotNull()
    java.lang.String recipeId);
    
    @androidx.room.Query(value = "SELECT * FROM recipes WHERE id = :recipeId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<edu.monash.fit5046.healthyrecipehub.data.model.Recipe> getRecipeByIdFlow(@org.jetbrains.annotations.NotNull()
    java.lang.String recipeId);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertRecipe(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.Recipe recipe, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertRecipes(@org.jetbrains.annotations.NotNull()
    java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe> recipes, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateRecipe(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.Recipe recipe, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteRecipe(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.Recipe recipe, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM recipes WHERE id = :recipeId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteRecipeById(@org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "\n        SELECT * FROM recipes \n        WHERE title LIKE \'%\' || :query || \'%\' \n        OR description LIKE \'%\' || :query || \'%\'\n        ORDER BY title ASC\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>> searchRecipes(@org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    @androidx.room.Query(value = "SELECT * FROM recipes WHERE category = :category ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>> getRecipesByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category);
    
    @androidx.room.Query(value = "SELECT * FROM recipes WHERE cuisine = :cuisine ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>> getRecipesByCuisine(@org.jetbrains.annotations.NotNull()
    java.lang.String cuisine);
    
    @androidx.room.Query(value = "SELECT * FROM recipes WHERE difficulty = :difficulty ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>> getRecipesByDifficulty(@org.jetbrains.annotations.NotNull()
    java.lang.String difficulty);
    
    @androidx.room.Query(value = "SELECT * FROM recipes WHERE calories <= :maxCalories ORDER BY calories ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>> getRecipesByMaxCalories(int maxCalories);
    
    @androidx.room.Query(value = "SELECT * FROM recipes WHERE nutritionScore >= :minScore ORDER BY nutritionScore DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>> getRecipesByMinNutritionScore(double minScore);
    
    @androidx.room.Query(value = "SELECT * FROM recipes WHERE isFavorite = 1 ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>> getFavoriteRecipes();
    
    @androidx.room.Query(value = "SELECT * FROM recipes WHERE authorId = :authorId ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>> getRecipesByAuthor(@org.jetbrains.annotations.NotNull()
    java.lang.String authorId);
    
    @androidx.room.Query(value = "\n        SELECT * FROM recipes \n        WHERE (title LIKE \'%\' || :query || \'%\' OR description LIKE \'%\' || :query || \'%\')\n        AND (:category IS NULL OR category = :category)\n        AND (:cuisine IS NULL OR cuisine = :cuisine)\n        AND (:difficulty IS NULL OR difficulty = :difficulty)\n        AND (:maxCalories IS NULL OR calories <= :maxCalories)\n        ORDER BY \n            CASE WHEN :sortBy = \'NEWEST\' THEN createdAt END DESC,\n            CASE WHEN :sortBy = \'OLDEST\' THEN createdAt END ASC,\n            CASE WHEN :sortBy = \'CALORIES_LOW\' THEN calories END ASC,\n            CASE WHEN :sortBy = \'CALORIES_HIGH\' THEN calories END DESC,\n            CASE WHEN :sortBy = \'NUTRITION_SCORE\' THEN nutritionScore END DESC,\n            CASE WHEN :sortBy = \'PREP_TIME\' THEN (prepTime + cookTime) END ASC\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>> filterRecipes(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.Nullable()
    java.lang.String category, @org.jetbrains.annotations.Nullable()
    java.lang.String cuisine, @org.jetbrains.annotations.Nullable()
    java.lang.String difficulty, @org.jetbrains.annotations.Nullable()
    java.lang.Integer maxCalories, @org.jetbrains.annotations.NotNull()
    java.lang.String sortBy);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM recipes")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRecipeCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM recipes WHERE category = :category")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRecipeCountByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT AVG(calories) FROM recipes")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAverageCalories(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion);
    
    @androidx.room.Query(value = "SELECT AVG(nutritionScore) FROM recipes")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAverageNutritionScore(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion);
    
    @androidx.room.Query(value = "UPDATE recipes SET isFavorite = :isFavorite WHERE id = :recipeId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateFavoriteStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, boolean isFavorite, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM recipes WHERE isOffline = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getOfflineRecipes(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>> $completion);
    
    @androidx.room.Query(value = "UPDATE recipes SET isOffline = :isOffline WHERE id = :recipeId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateOfflineStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, boolean isOffline, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM recipes")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAllRecipes(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM recipes WHERE authorId = :authorId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteRecipesByAuthor(@org.jetbrains.annotations.NotNull()
    java.lang.String authorId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertReview(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.Review review, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM reviews WHERE recipeId = :recipeId ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Review>> getReviewsForRecipe(@org.jetbrains.annotations.NotNull()
    java.lang.String recipeId);
    
    @androidx.room.Query(value = "SELECT AVG(rating) FROM reviews WHERE recipeId = :recipeId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAverageRatingForRecipe(@org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Float> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM reviews WHERE recipeId = :recipeId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getReviewCountForRecipe(@org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}