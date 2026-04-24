package edu.monash.fit5046.healthyrecipehub.data.repository;

/**
 * Recipe Repository
 * Single source of truth for recipe data
 * Manages local (Room) and remote (API) data sources
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u0000 D2\u00020\u0001:\u0001DB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u0012J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u0014J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@\u00a2\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010\u001bJ$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u0010\u000e\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u001dJ.\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160 0\n2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"H\u0086@\u00a2\u0006\u0002\u0010$J\u001a\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160 0&2\u0006\u0010\'\u001a\u00020(J\u0012\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160 0&J\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160 0&J\u0018\u0010+\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000e\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160&2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010-\u001a\u00020\"H\u0086@\u00a2\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u001a\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160 0&2\u0006\u00102\u001a\u00020\rJ\u001e\u00103\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u00104\u001a\u000205H\u0086@\u00a2\u0006\u0002\u00106J$\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u0014J\u0016\u00108\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010\u001bJ\u001c\u00109\u001a\u00020\u000b2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00160 H\u0086@\u00a2\u0006\u0002\u0010;J\u001a\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160 0&2\u0006\u0010=\u001a\u00020\rJ\"\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160 0\n2\u0006\u0010=\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0086@\u00a2\u0006\u0002\u0010.J\u001e\u0010@\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010A\u001a\u000205H\u0086@\u00a2\u0006\u0002\u00106J\u0016\u0010B\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010\u001bJ,\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@\u00a2\u0006\u0002\u0010CR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006E"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/repository/RecipeRepository;", "", "context", "Landroid/content/Context;", "apiService", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/RecipeApiService;", "recipeDao", "Ledu/monash/fit5046/healthyrecipehub/data/local/dao/RecipeDao;", "(Landroid/content/Context;Ledu/monash/fit5046/healthyrecipehub/data/remote/api/RecipeApiService;Ledu/monash/fit5046/healthyrecipehub/data/local/dao/RecipeDao;)V", "addReview", "Ledu/monash/fit5046/healthyrecipehub/data/model/Result;", "", "token", "", "recipeId", "rating", "", "comment", "(Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addToFavorites", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createRecipe", "Ledu/monash/fit5046/healthyrecipehub/data/model/Recipe;", "recipe", "Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/RecipeUploadRequest;", "(Ljava/lang/String;Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/RecipeUploadRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRecipe", "(Ledu/monash/fit5046/healthyrecipehub/data/model/Recipe;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRecipeById", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchRecipeById", "fetchRecipesFromApi", "", "page", "", "limit", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "filterRecipes", "Lkotlinx/coroutines/flow/Flow;", "filter", "Ledu/monash/fit5046/healthyrecipehub/data/model/RecipeFilter;", "getAllRecipes", "getFavoriteRecipes", "getRecipeById", "getRecipeByIdLive", "getRecipeCount", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecipeCountByCategory", "category", "getRecipesByAuthor", "authorId", "markRecipeOffline", "isOffline", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeFromFavorites", "saveRecipe", "saveRecipes", "recipes", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchRecipes", "query", "searchRecipesApi", "syncOfflineRecipes", "updateFavoriteStatus", "isFavorite", "updateRecipe", "(Ljava/lang/String;Ljava/lang/String;Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/RecipeUploadRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class RecipeRepository {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final edu.monash.fit5046.healthyrecipehub.data.remote.api.RecipeApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final edu.monash.fit5046.healthyrecipehub.data.local.dao.RecipeDao recipeDao = null;
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile edu.monash.fit5046.healthyrecipehub.data.repository.RecipeRepository instance;
    @org.jetbrains.annotations.NotNull()
    public static final edu.monash.fit5046.healthyrecipehub.data.repository.RecipeRepository.Companion Companion = null;
    
    public RecipeRepository(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.remote.api.RecipeApiService apiService, @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.local.dao.RecipeDao recipeDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>> getAllRecipes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<edu.monash.fit5046.healthyrecipehub.data.model.Recipe> getRecipeByIdLive(@org.jetbrains.annotations.NotNull()
    java.lang.String recipeId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getRecipeById(@org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.model.Recipe> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveRecipe(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.Recipe recipe, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveRecipes(@org.jetbrains.annotations.NotNull()
    java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe> recipes, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateRecipe(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.Recipe recipe, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteRecipe(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.Recipe recipe, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteRecipeById(@org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>> searchRecipes(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>> filterRecipes(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.RecipeFilter filter) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>> getFavoriteRecipes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>> getRecipesByAuthor(@org.jetbrains.annotations.NotNull()
    java.lang.String authorId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateFavoriteStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, boolean isFavorite, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object fetchRecipesFromApi(int page, int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.model.Result<? extends java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object fetchRecipeById(@org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.model.Result<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object searchRecipesApi(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.model.Result<? extends java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object createRecipe(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.remote.dto.RecipeUploadRequest recipe, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.model.Result<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateRecipe(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.remote.dto.RecipeUploadRequest recipe, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.model.Result<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteRecipe(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.model.Result<kotlin.Unit>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addToFavorites(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.model.Result<kotlin.Unit>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object removeFromFavorites(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.model.Result<kotlin.Unit>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addReview(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, float rating, @org.jetbrains.annotations.NotNull()
    java.lang.String comment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.model.Result<kotlin.Unit>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object syncOfflineRecipes(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.model.Result<kotlin.Unit>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object markRecipeOffline(@org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, boolean isOffline, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getRecipeCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getRecipeCountByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/repository/RecipeRepository$Companion;", "", "()V", "instance", "Ledu/monash/fit5046/healthyrecipehub/data/repository/RecipeRepository;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final edu.monash.fit5046.healthyrecipehub.data.repository.RecipeRepository getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}