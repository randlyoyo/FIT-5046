package edu.monash.fit5046.healthyrecipehub.data.remote.api;

/**
 * Authentication API Service
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u0013H\u00a7@\u00a2\u0006\u0002\u0010\u0014J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u0016\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u0018H\u00a7@\u00a2\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u000bJ(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u001cH\u00a7@\u00a2\u0006\u0002\u0010\u001dJ\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u000b\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u001f\u00c0\u0006\u0001"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/remote/api/AuthApiService;", "", "changePassword", "Lretrofit2/Response;", "", "token", "", "request", "Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/ChangePasswordRequest;", "(Ljava/lang/String;Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/ChangePasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAccount", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forgotPassword", "Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/PasswordResetRequest;", "(Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/PasswordResetRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentUser", "Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/UserResponse;", "login", "Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/AuthResponse;", "Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/LoginRequest;", "(Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "refreshToken", "register", "Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/RegisterRequest;", "(Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/RegisterRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resendVerificationEmail", "updateProfile", "Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/UpdateProfileRequest;", "(Ljava/lang/String;Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/UpdateProfileRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyEmail", "app_debug"})
public abstract interface AuthApiService {
    
    @retrofit2.http.POST(value = "/api/auth/login")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object login(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.remote.dto.LoginRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.dto.AuthResponse>> $completion);
    
    @retrofit2.http.POST(value = "/api/auth/register")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object register(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.remote.dto.RegisterRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.dto.AuthResponse>> $completion);
    
    @retrofit2.http.POST(value = "/api/auth/logout")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object logout(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.POST(value = "/api/auth/refresh")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object refreshToken(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String refreshToken, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.dto.AuthResponse>> $completion);
    
    @retrofit2.http.POST(value = "/api/auth/forgot-password")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object forgotPassword(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.remote.dto.PasswordResetRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.POST(value = "/api/auth/change-password")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object changePassword(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.remote.dto.ChangePasswordRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.POST(value = "/api/auth/verify-email")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object verifyEmail(@retrofit2.http.Query(value = "token")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.dto.AuthResponse>> $completion);
    
    @retrofit2.http.POST(value = "/api/auth/resend-verification")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object resendVerificationEmail(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.GET(value = "/api/auth/me")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCurrentUser(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.dto.UserResponse>> $completion);
    
    @retrofit2.http.PUT(value = "/api/auth/me")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateProfile(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.remote.dto.UpdateProfileRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.dto.UserResponse>> $completion);
    
    @retrofit2.http.DELETE(value = "/api/auth/me")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAccount(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
}