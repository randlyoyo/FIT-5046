package edu.monash.fit5046.healthyrecipehub.data.remote.api;

/**
 * AI Assistant API Service
 * Integration with Gemini AI for recipe suggestions and nutrition advice
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\fJ(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0010J(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0013H\u00a7@\u00a2\u0006\u0002\u0010\u0014J(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0013H\u00a7@\u00a2\u0006\u0002\u0010\u0014J(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0019H\u00a7@\u00a2\u0006\u0002\u0010\u001a\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u001b\u00c0\u0006\u0001"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/remote/api/AIApiService;", "", "analyzeNutrition", "Lretrofit2/Response;", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/NutritionAnalysisResponse;", "token", "", "request", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/NutritionAnalysisRequest;", "(Ljava/lang/String;Ledu/monash/fit5046/healthyrecipehub/data/remote/api/NutritionAnalysisRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearChatHistory", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHealthTips", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/HealthTipsResponse;", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/HealthTipsRequest;", "(Ljava/lang/String;Ledu/monash/fit5046/healthyrecipehub/data/remote/api/HealthTipsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMessage", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/AIChatResponse;", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/AIChatRequest;", "(Ljava/lang/String;Ledu/monash/fit5046/healthyrecipehub/data/remote/api/AIChatRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMessageStream", "Lokhttp3/ResponseBody;", "suggestRecipe", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/RecipeSuggestionResponse;", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/RecipeSuggestionRequest;", "(Ljava/lang/String;Ledu/monash/fit5046/healthyrecipehub/data/remote/api/RecipeSuggestionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface AIApiService {
    
    @retrofit2.http.POST(value = "/api/ai/chat")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object sendMessage(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.remote.api.AIChatRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.api.AIChatResponse>> $completion);
    
    @retrofit2.http.POST(value = "/api/ai/chat/stream")
    @retrofit2.http.Streaming()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object sendMessageStream(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.remote.api.AIChatRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.POST(value = "/api/ai/suggest-recipe")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object suggestRecipe(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.remote.api.RecipeSuggestionRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.api.RecipeSuggestionResponse>> $completion);
    
    @retrofit2.http.POST(value = "/api/ai/analyze-nutrition")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object analyzeNutrition(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.remote.api.NutritionAnalysisRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.api.NutritionAnalysisResponse>> $completion);
    
    @retrofit2.http.POST(value = "/api/ai/health-tips")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getHealthTips(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.remote.api.HealthTipsRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.api.HealthTipsResponse>> $completion);
    
    @retrofit2.http.POST(value = "/api/ai/chat/clear")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object clearChatHistory(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
}