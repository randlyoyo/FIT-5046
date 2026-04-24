package edu.monash.fit5046.healthyrecipehub.data.remote.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Streaming
import okhttp3.ResponseBody

/**
 * AI Assistant API Service
 * Integration with Gemini AI for recipe suggestions and nutrition advice
 */
interface AIApiService {

    @POST("/api/ai/chat")
    suspend fun sendMessage(
        @Header("Authorization") token: String,
        @Body request: AIChatRequest
    ): Response<AIChatResponse>

    @POST("/api/ai/chat/stream")
    @Streaming
    suspend fun sendMessageStream(
        @Header("Authorization") token: String,
        @Body request: AIChatRequest
    ): Response<ResponseBody>

    @POST("/api/ai/suggest-recipe")
    suspend fun suggestRecipe(
        @Header("Authorization") token: String,
        @Body request: RecipeSuggestionRequest
    ): Response<RecipeSuggestionResponse>

    @POST("/api/ai/analyze-nutrition")
    suspend fun analyzeNutrition(
        @Header("Authorization") token: String,
        @Body request: NutritionAnalysisRequest
    ): Response<NutritionAnalysisResponse>

    @POST("/api/ai/health-tips")
    suspend fun getHealthTips(
        @Header("Authorization") token: String,
        @Body request: HealthTipsRequest
    ): Response<HealthTipsResponse>

    @POST("/api/ai/chat/clear")
    suspend fun clearChatHistory(
        @Header("Authorization") token: String
    ): Response<Unit>
}

data class AIChatRequest(
    val message: String,
    val context: String? = null, // "general", "recipe", "nutrition"
    val language: String = "zh-CN"
)

data class AIChatResponse(
    val success: Boolean,
    val response: String? = null,
    val suggestions: List<String>? = null,
    val error: String? = null
)

data class RecipeSuggestionRequest(
    val ingredients: List<String>? = null,
    val dietaryPreferences: List<String>? = null,
    val maxCalories: Int? = null,
    val mealType: String? = null, // breakfast, lunch, dinner, snack
    val cuisine: String? = null,
    val cookingTime: Int? = null // max minutes
)

data class RecipeSuggestionResponse(
    val success: Boolean,
    val suggestions: List<AIRecipeSuggestion>? = null,
    val error: String? = null
)

data class AIRecipeSuggestion(
    val title: String,
    val description: String,
    val ingredients: List<String>,
    val instructions: List<String>,
    val estimatedCalories: Int,
    val estimatedPrepTime: Int,
    val nutritionInfo: AINutritionInfo
)

data class AINutritionInfo(
    val protein: String,
    val carbs: String,
    val fat: String,
    val fiber: String,
    val healthBenefits: List<String>
)

data class NutritionAnalysisRequest(
    val recipeDescription: String? = null,
    val ingredients: List<String>? = null,
    val servings: Int = 1
)

data class NutritionAnalysisResponse(
    val success: Boolean,
    val analysis: NutritionAnalysis? = null,
    val error: String? = null
)

data class NutritionAnalysis(
    val estimatedCalories: Int,
    val macros: Macros,
    val healthScore: Int, // 0-100
    val recommendations: List<String>,
    val warnings: List<String>
)

data class Macros(
    val protein: Double,
    val carbs: Double,
    val fat: Double,
    val fiber: Double
)

data class HealthTipsRequest(
    val goal: String, // "weight_loss", "muscle_gain", "maintenance", "general_health"
    val dietaryRestrictions: List<String>? = null,
    val activityLevel: String? = "moderate" // "sedentary", "light", "moderate", "active", "very_active"
)

data class HealthTipsResponse(
    val success: Boolean,
    val tips: List<HealthTip>? = null,
    val dailyTargets: DailyTargets? = null,
    val error: String? = null
)

data class HealthTip(
    val category: String,
    val tip: String,
    val priority: String // "high", "medium", "low"
)

data class DailyTargets(
    val calories: Int,
    val protein: Int, // grams
    val carbs: Int,
    val fat: Int,
    val water: Int // ml
)
