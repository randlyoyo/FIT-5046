package edu.monash.fit5046.healthyrecipehub.data.remote.api;

/**
 * TheMealDB Public API Integration
 *
 * Free public recipe API that provides real meal data.
 * Used as Retrofit + Public API requirement for the assignment.
 *
 * API: https://www.themealdb.com/api.php
 * Free tier: No API key required for test endpoints
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\u000b\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0018\u0010\f\u001a\u00020\u00032\b\b\u0001\u0010\r\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u000e\u001a\u00020\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0011\u00c0\u0006\u0001"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/remote/api/MealDbApiService;", "", "filterByCategory", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/MealDbResponse;", "category", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCategories", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/MealDbCategoryResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRandomMeal", "getSingleRandomMeal", "lookupMealById", "mealId", "searchMeals", "query", "Companion", "app_debug"})
public abstract interface MealDbApiService {
    @org.jetbrains.annotations.NotNull()
    public static final edu.monash.fit5046.healthyrecipehub.data.remote.api.MealDbApiService.Companion Companion = null;
    
    @retrofit2.http.GET(value = "api/json/v1/1/search.php")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchMeals(@retrofit2.http.Query(value = "s")
    @org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.remote.api.MealDbResponse> $completion);
    
    @retrofit2.http.GET(value = "api/json/v1/1/lookup.php")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object lookupMealById(@retrofit2.http.Query(value = "i")
    @org.jetbrains.annotations.NotNull()
    java.lang.String mealId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.remote.api.MealDbResponse> $completion);
    
    @retrofit2.http.GET(value = "api/json/v1/1/filter.php")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object filterByCategory(@retrofit2.http.Query(value = "c")
    @org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.remote.api.MealDbResponse> $completion);
    
    @retrofit2.http.GET(value = "api/json/v1/1/categories.php")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCategories(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.remote.api.MealDbCategoryResponse> $completion);
    
    @retrofit2.http.GET(value = "api/json/v1/1/random.php")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRandomMeal(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.remote.api.MealDbResponse> $completion);
    
    @retrofit2.http.GET(value = "api/json/v1/1/random.php")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSingleRandomMeal(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.remote.api.MealDbResponse> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/remote/api/MealDbApiService$Companion;", "", "()V", "BASE_URL", "", "instance", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/MealDbApiService;", "getInstance", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull()
        private static final java.lang.String BASE_URL = "https://www.themealdb.com/";
        @kotlin.jvm.Volatile()
        @org.jetbrains.annotations.Nullable()
        private static volatile edu.monash.fit5046.healthyrecipehub.data.remote.api.MealDbApiService instance;
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final edu.monash.fit5046.healthyrecipehub.data.remote.api.MealDbApiService getInstance() {
            return null;
        }
    }
}