package edu.monash.fit5046.healthyrecipehub.data.remote.api;

/**
 * Retrofit Client Configuration
 * Singleton pattern for API client
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u00108\u001a\u00020-J\u0010\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\u000b\u001a\u0004\b$\u0010%R\u001b\u0010\'\u001a\u00020(8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010\u000b\u001a\u0004\b)\u0010*R\u001b\u0010,\u001a\u00020-8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010\u000b\u001a\u0004\b.\u0010/R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u0010\u000b\u001a\u0004\b3\u00104R\u000e\u00106\u001a\u000207X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006<"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/remote/api/RetrofitClient;", "", "()V", "BASE_URL", "", "DEV_BASE_URL", "adminApiService", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/AdminApiService;", "getAdminApiService", "()Ledu/monash/fit5046/healthyrecipehub/data/remote/api/AdminApiService;", "adminApiService$delegate", "Lkotlin/Lazy;", "aiApiService", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/AIApiService;", "getAiApiService", "()Ledu/monash/fit5046/healthyrecipehub/data/remote/api/AIApiService;", "aiApiService$delegate", "authApiService", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/AuthApiService;", "getAuthApiService", "()Ledu/monash/fit5046/healthyrecipehub/data/remote/api/AuthApiService;", "authApiService$delegate", "authInterceptor", "Lokhttp3/Interceptor;", "authToken", "emailApiService", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/EmailApiService;", "getEmailApiService", "()Ledu/monash/fit5046/healthyrecipehub/data/remote/api/EmailApiService;", "emailApiService$delegate", "isDevMode", "", "loggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "recipeApiService", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/RecipeApiService;", "getRecipeApiService", "()Ledu/monash/fit5046/healthyrecipehub/data/remote/api/RecipeApiService;", "recipeApiService$delegate", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "retrofit$delegate", "unsafeSslContext", "Ljavax/net/ssl/SSLContext;", "getUnsafeSslContext", "()Ljavax/net/ssl/SSLContext;", "unsafeSslContext$delegate", "unsafeTrustManager", "Ljavax/net/ssl/X509TrustManager;", "createDevClient", "setAuthToken", "", "token", "app_debug"})
public final class RetrofitClient {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String BASE_URL = "http://10.0.2.2:3000/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DEV_BASE_URL = "http://10.0.2.2:3000/";
    private static final boolean isDevMode = true;
    @org.jetbrains.annotations.Nullable()
    private static java.lang.String authToken;
    
    /**
     * Logging interceptor for debugging
     */
    @org.jetbrains.annotations.NotNull()
    private static final okhttp3.logging.HttpLoggingInterceptor loggingInterceptor = null;
    
    /**
     * Auth interceptor to add token to requests
     */
    @org.jetbrains.annotations.NotNull()
    private static final okhttp3.Interceptor authInterceptor = null;
    
    /**
     * Unsafe trust manager for development (allows self-signed certificates)
     */
    @org.jetbrains.annotations.NotNull()
    private static final javax.net.ssl.X509TrustManager unsafeTrustManager = null;
    
    /**
     * Unsafe SSL context for development
     */
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy unsafeSslContext$delegate = null;
    
    /**
     * OkHttp Client configuration
     */
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy okHttpClient$delegate = null;
    
    /**
     * Retrofit instance
     */
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy retrofit$delegate = null;
    
    /**
     * API Service instances
     */
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy recipeApiService$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy authApiService$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy adminApiService$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy emailApiService$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy aiApiService$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final edu.monash.fit5046.healthyrecipehub.data.remote.api.RetrofitClient INSTANCE = null;
    
    private RetrofitClient() {
        super();
    }
    
    public final void setAuthToken(@org.jetbrains.annotations.Nullable()
    java.lang.String token) {
    }
    
    /**
     * Unsafe SSL context for development
     */
    private final javax.net.ssl.SSLContext getUnsafeSslContext() {
        return null;
    }
    
    /**
     * OkHttp Client configuration
     */
    private final okhttp3.OkHttpClient getOkHttpClient() {
        return null;
    }
    
    /**
     * Retrofit instance
     */
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit getRetrofit() {
        return null;
    }
    
    /**
     * API Service instances
     */
    @org.jetbrains.annotations.NotNull()
    public final edu.monash.fit5046.healthyrecipehub.data.remote.api.RecipeApiService getRecipeApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final edu.monash.fit5046.healthyrecipehub.data.remote.api.AuthApiService getAuthApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final edu.monash.fit5046.healthyrecipehub.data.remote.api.AdminApiService getAdminApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final edu.monash.fit5046.healthyrecipehub.data.remote.api.EmailApiService getEmailApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final edu.monash.fit5046.healthyrecipehub.data.remote.api.AIApiService getAiApiService() {
        return null;
    }
    
    /**
     * Create development client (for local testing)
     */
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit createDevClient() {
        return null;
    }
}