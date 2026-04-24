package edu.monash.fit5046.healthyrecipehub.data.remote.api

import edu.monash.fit5046.healthyrecipehub.data.remote.dto.*
import retrofit2.Response
import retrofit2.http.*

/**
 * Authentication API Service
 */
interface AuthApiService {

    @POST("/api/auth/login")
    suspend fun login(@Body request: LoginRequest): Response<AuthResponse>

    @POST("/api/auth/register")
    suspend fun register(@Body request: RegisterRequest): Response<AuthResponse>

    @POST("/api/auth/logout")
    suspend fun logout(
        @Header("Authorization") token: String
    ): Response<Unit>

    @POST("/api/auth/refresh")
    suspend fun refreshToken(
        @Header("Authorization") refreshToken: String
    ): Response<AuthResponse>

    @POST("/api/auth/forgot-password")
    suspend fun forgotPassword(@Body request: PasswordResetRequest): Response<Unit>

    @POST("/api/auth/change-password")
    suspend fun changePassword(
        @Header("Authorization") token: String,
        @Body request: ChangePasswordRequest
    ): Response<Unit>

    @POST("/api/auth/verify-email")
    suspend fun verifyEmail(@Query("token") token: String): Response<AuthResponse>

    @POST("/api/auth/resend-verification")
    suspend fun resendVerificationEmail(
        @Header("Authorization") token: String
    ): Response<Unit>

    @GET("/api/auth/me")
    suspend fun getCurrentUser(
        @Header("Authorization") token: String
    ): Response<UserResponse>

    @PUT("/api/auth/me")
    suspend fun updateProfile(
        @Header("Authorization") token: String,
        @Body request: UpdateProfileRequest
    ): Response<UserResponse>

    @DELETE("/api/auth/me")
    suspend fun deleteAccount(
        @Header("Authorization") token: String
    ): Response<Unit>
}
