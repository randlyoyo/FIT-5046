package edu.monash.fit5046.healthyrecipehub.data.remote.api;

/**
 * Recipe API Service Interface
 * Retrofit interface for recipe-related API calls
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\t\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\rJ(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0012J(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\rJ2\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0015\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0016Jd\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u001e\u001a\u00020\u001c2\b\b\u0003\u0010\u001f\u001a\u00020\u001cH\u00a7@\u00a2\u0006\u0002\u0010 J<\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0003\u0010\u001e\u001a\u00020\u001c2\b\b\u0003\u0010\u001f\u001a\u00020\u001c2\b\b\u0003\u0010\"\u001a\u00020\u00062\b\b\u0003\u0010#\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010$J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010&J\u001e\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010&J$\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040)0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010&J2\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0018\u001a\u00020\u00062\b\b\u0003\u0010\u001e\u001a\u00020\u001c2\b\b\u0003\u0010\u001f\u001a\u00020\u001cH\u00a7@\u00a2\u0006\u0002\u0010+J2\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0003\u0010\u001e\u001a\u00020\u001c2\b\b\u0003\u0010\u001f\u001a\u00020\u001cH\u00a7@\u00a2\u0006\u0002\u0010+J(\u0010-\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\rJ2\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010/\u001a\u00020\u00062\b\b\u0003\u0010\u001e\u001a\u00020\u001c2\b\b\u0003\u0010\u001f\u001a\u00020\u001cH\u00a7@\u00a2\u0006\u0002\u0010+J2\u00100\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u00101\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u00062\u00c0\u0006\u0001"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/remote/api/RecipeApiService;", "", "addReview", "Lretrofit2/Response;", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/ReviewDto;", "token", "", "recipeId", "review", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/ReviewRequest;", "(Ljava/lang/String;Ljava/lang/String;Ledu/monash/fit5046/healthyrecipehub/data/remote/api/ReviewRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addToFavorites", "", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createRecipe", "Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/RecipeResponse;", "recipe", "Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/RecipeUploadRequest;", "(Ljava/lang/String;Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/RecipeUploadRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRecipe", "deleteReview", "reviewId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "filterRecipes", "category", "cuisine", "difficulty", "maxCalories", "", "dietaryTags", "page", "limit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllRecipes", "sortBy", "order", "(IILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavoriteRecipes", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecipeById", "getRecipeReviews", "", "getRecipesByCategory", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecipesByCuisine", "removeFromFavorites", "searchRecipes", "query", "updateRecipe", "(Ljava/lang/String;Ljava/lang/String;Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/RecipeUploadRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface RecipeApiService {
    
    @retrofit2.http.GET(value = "/apiRecipes")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllRecipes(@retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "sortBy")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sortBy, @retrofit2.http.Query(value = "order")
    @org.jetbrains.annotations.NotNull()
    java.lang.String order, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.dto.RecipeResponse>> $completion);
    
    @retrofit2.http.GET(value = "/apiRecipeById/{recipeId}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRecipeById(@retrofit2.http.Path(value = "recipeId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.dto.RecipeResponse>> $completion);
    
    @retrofit2.http.GET(value = "/apiRecipes/search")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchRecipes(@retrofit2.http.Query(value = "q")
    @org.jetbrains.annotations.NotNull()
    java.lang.String query, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "limit")
    int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.dto.RecipeResponse>> $completion);
    
    @retrofit2.http.GET(value = "/apiRecipes/category/{category}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRecipesByCategory(@retrofit2.http.Path(value = "category")
    @org.jetbrains.annotations.NotNull()
    java.lang.String category, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "limit")
    int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.dto.RecipeResponse>> $completion);
    
    @retrofit2.http.GET(value = "/apiRecipes/cuisine/{cuisine}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRecipesByCuisine(@retrofit2.http.Path(value = "cuisine")
    @org.jetbrains.annotations.NotNull()
    java.lang.String cuisine, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "limit")
    int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.dto.RecipeResponse>> $completion);
    
    @retrofit2.http.GET(value = "/apiRecipes/filter")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object filterRecipes(@retrofit2.http.Query(value = "category")
    @org.jetbrains.annotations.Nullable()
    java.lang.String category, @retrofit2.http.Query(value = "cuisine")
    @org.jetbrains.annotations.Nullable()
    java.lang.String cuisine, @retrofit2.http.Query(value = "difficulty")
    @org.jetbrains.annotations.Nullable()
    java.lang.String difficulty, @retrofit2.http.Query(value = "maxCalories")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer maxCalories, @retrofit2.http.Query(value = "dietaryTags")
    @org.jetbrains.annotations.Nullable()
    java.lang.String dietaryTags, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "limit")
    int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.dto.RecipeResponse>> $completion);
    
    @retrofit2.http.POST(value = "/apiRecipes")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createRecipe(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.remote.dto.RecipeUploadRequest recipe, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.dto.RecipeResponse>> $completion);
    
    @retrofit2.http.PUT(value = "/apiRecipes/{recipeId}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateRecipe(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Path(value = "recipeId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.remote.dto.RecipeUploadRequest recipe, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.dto.RecipeResponse>> $completion);
    
    @retrofit2.http.DELETE(value = "/apiRecipes/{recipeId}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteRecipe(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Path(value = "recipeId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.GET(value = "/apiRecipes/favorites")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getFavoriteRecipes(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.dto.RecipeResponse>> $completion);
    
    @retrofit2.http.POST(value = "/apiRecipes/{recipeId}/favorite")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addToFavorites(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Path(value = "recipeId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.DELETE(value = "/apiRecipes/{recipeId}/favorite")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object removeFromFavorites(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Path(value = "recipeId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.GET(value = "/apiRecipes/{recipeId}/reviews")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRecipeReviews(@retrofit2.http.Path(value = "recipeId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.api.ReviewDto>>> $completion);
    
    @retrofit2.http.POST(value = "/apiRecipes/{recipeId}/reviews")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addReview(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Path(value = "recipeId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.remote.api.ReviewRequest review, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.api.ReviewDto>> $completion);
    
    @retrofit2.http.DELETE(value = "/apiRecipes/{recipeId}/reviews/{reviewId}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteReview(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Path(value = "recipeId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, @retrofit2.http.Path(value = "reviewId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String reviewId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
}