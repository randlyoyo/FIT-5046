package edu.monash.fit5046.healthyrecipehub.data.remote.api;

/**
 * Admin API Service
 * Admin-only endpoints for user and recipe management
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\bJ(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\bJ(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\bJ(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\bJ(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\bJ2\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0010\u001a\u00020\u00112\b\b\u0003\u0010\u0012\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0013J>\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0010\u001a\u00020\u00112\b\b\u0003\u0010\u0012\u001a\u00020\u00112\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0017J2\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0010\u001a\u00020\u00112\b\b\u0003\u0010\u0012\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0013J(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u001c\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u001dJ\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010 J(\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\bJ(\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u001c\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u001dJ2\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010&\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\'J2\u0010(\u001a\b\u0012\u0004\u0012\u00020\"0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\u0016\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\'\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006)\u00c0\u0006\u0001"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/remote/api/AdminApiService;", "", "adminDeleteRecipe", "Lretrofit2/Response;", "", "token", "", "recipeId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "approveRecipe", "deleteUser", "userId", "disableUser", "enableUser", "getActivityLogs", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/ActivityLogsResponse;", "page", "", "limit", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllUsers", "Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/UsersResponse;", "role", "(Ljava/lang/String;IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPendingRecipes", "Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/RecipeResponse;", "getRecipeStatistics", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/RecipeStatisticsDto;", "days", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStatistics", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/StatisticsResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserById", "Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/UserResponse;", "getUserStatistics", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/UserStatisticsDto;", "rejectRecipe", "reason", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUserRole", "app_debug"})
public abstract interface AdminApiService {
    
    @retrofit2.http.GET(value = "/api/admin/users")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllUsers(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "role")
    @org.jetbrains.annotations.Nullable()
    java.lang.String role, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.dto.UsersResponse>> $completion);
    
    @retrofit2.http.GET(value = "/api/admin/users/{userId}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserById(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Path(value = "userId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.dto.UserResponse>> $completion);
    
    @retrofit2.http.PUT(value = "/api/admin/users/{userId}/role")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateUserRole(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Path(value = "userId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @retrofit2.http.Query(value = "role")
    @org.jetbrains.annotations.NotNull()
    java.lang.String role, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.dto.UserResponse>> $completion);
    
    @retrofit2.http.DELETE(value = "/api/admin/users/{userId}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteUser(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Path(value = "userId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.POST(value = "/api/admin/users/{userId}/disable")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object disableUser(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Path(value = "userId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.POST(value = "/api/admin/users/{userId}/enable")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object enableUser(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Path(value = "userId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.GET(value = "/api/admin/recipes/pending")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPendingRecipes(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "limit")
    int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.dto.RecipeResponse>> $completion);
    
    @retrofit2.http.POST(value = "/api/admin/recipes/{recipeId}/approve")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object approveRecipe(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Path(value = "recipeId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.POST(value = "/api/admin/recipes/{recipeId}/reject")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object rejectRecipe(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Path(value = "recipeId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, @retrofit2.http.Query(value = "reason")
    @org.jetbrains.annotations.NotNull()
    java.lang.String reason, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.DELETE(value = "/api/admin/recipes/{recipeId}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object adminDeleteRecipe(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Path(value = "recipeId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.GET(value = "/api/admin/statistics")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getStatistics(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.api.StatisticsResponse>> $completion);
    
    @retrofit2.http.GET(value = "/api/admin/statistics/users")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserStatistics(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Query(value = "days")
    int days, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.api.UserStatisticsDto>> $completion);
    
    @retrofit2.http.GET(value = "/api/admin/statistics/recipes")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRecipeStatistics(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Query(value = "days")
    int days, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.api.RecipeStatisticsDto>> $completion);
    
    @retrofit2.http.GET(value = "/api/admin/activity-logs")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getActivityLogs(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "limit")
    int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.api.ActivityLogsResponse>> $completion);
}