package edu.monash.fit5046.healthyrecipehub.data.remote.api;

/**
 * Spoonacular API Integration
 *
 * Industry-standard recipe API with REAL nutrition data (calories, protein, fat, carbs),
 * cook time, servings, and high-quality images.
 *
 * API: https://spoonacular.com/food-api
 * Free tier: 150 points/day (1-2 points per request)
 *
 * TO USE: Sign up free at https://spoonacular.com/food-api → get API key
 * Then paste it into the API_KEY constant below.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019J\"\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ,\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJn\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0011\u001a\u00020\u00052\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0015\u001a\u00020\r2\b\b\u0003\u0010\u0016\u001a\u00020\r2\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\u0017\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0018\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u001a\u00c0\u0006\u0001"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/remote/api/SpoonacularApiService;", "", "getRandomRecipes", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/SpoonacularRandomResponse;", "apiKey", "", "number", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecipeInfo", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/SpoonacularRecipe;", "recipeId", "includeNutrition", "", "(ILjava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchRecipes", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/SpoonacularSearchResponse;", "query", "cuisine", "diet", "type", "addInfo", "addNutrition", "sort", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public abstract interface SpoonacularApiService {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String API_KEY = "67989404ea39423caf65f2dce67d5218";
    @org.jetbrains.annotations.NotNull()
    public static final edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularApiService.Companion Companion = null;
    
    @retrofit2.http.GET(value = "recipes/complexSearch")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchRecipes(@retrofit2.http.Query(value = "apiKey")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Query(value = "query")
    @org.jetbrains.annotations.NotNull()
    java.lang.String query, @retrofit2.http.Query(value = "cuisine")
    @org.jetbrains.annotations.Nullable()
    java.lang.String cuisine, @retrofit2.http.Query(value = "diet")
    @org.jetbrains.annotations.Nullable()
    java.lang.String diet, @retrofit2.http.Query(value = "type")
    @org.jetbrains.annotations.Nullable()
    java.lang.String type, @retrofit2.http.Query(value = "addRecipeInformation")
    boolean addInfo, @retrofit2.http.Query(value = "addRecipeNutrition")
    boolean addNutrition, @retrofit2.http.Query(value = "number")
    int number, @retrofit2.http.Query(value = "sort")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sort, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularSearchResponse> $completion);
    
    @retrofit2.http.GET(value = "recipes/{id}/information")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRecipeInfo(@retrofit2.http.Path(value = "id")
    int recipeId, @retrofit2.http.Query(value = "apiKey")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Query(value = "includeNutrition")
    boolean includeNutrition, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularRecipe> $completion);
    
    @retrofit2.http.GET(value = "recipes/random")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRandomRecipes(@retrofit2.http.Query(value = "apiKey")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Query(value = "number")
    int number, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularRandomResponse> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/remote/api/SpoonacularApiService$Companion;", "", "()V", "API_KEY", "", "BASE_URL", "instance", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/SpoonacularApiService;", "getInstance", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull()
        private static final java.lang.String BASE_URL = "https://api.spoonacular.com/";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String API_KEY = "67989404ea39423caf65f2dce67d5218";
        @kotlin.jvm.Volatile()
        @org.jetbrains.annotations.Nullable()
        private static volatile edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularApiService instance;
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularApiService getInstance() {
            return null;
        }
    }
}