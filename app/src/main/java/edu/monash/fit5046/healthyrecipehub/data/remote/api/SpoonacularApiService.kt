package edu.monash.fit5046.healthyrecipehub.data.remote.api

import com.google.gson.annotations.SerializedName
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

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
interface SpoonacularApiService {

    @GET("recipes/complexSearch")
    suspend fun searchRecipes(
        @Query("apiKey") apiKey: String,
        @Query("query") query: String = "",
        @Query("cuisine") cuisine: String? = null,
        @Query("diet") diet: String? = null,
        @Query("type") type: String? = null,
        @Query("addRecipeInformation") addInfo: Boolean = true,
        @Query("addRecipeNutrition") addNutrition: Boolean = true,
        @Query("number") number: Int = 30,
        @Query("sort") sort: String = "popularity"
    ): SpoonacularSearchResponse

    @GET("recipes/{id}/information")
    suspend fun getRecipeInfo(
        @Path("id") recipeId: Int,
        @Query("apiKey") apiKey: String,
        @Query("includeNutrition") includeNutrition: Boolean = true
    ): SpoonacularRecipe

    @GET("recipes/random")
    suspend fun getRandomRecipes(
        @Query("apiKey") apiKey: String,
        @Query("number") number: Int = 1
    ): SpoonacularRandomResponse

    companion object {
        private const val BASE_URL = "https://api.spoonacular.com/"
        // Read from local.properties via BuildConfig
        // See local.properties.template for setup instructions
        val API_KEY: String by lazy { edu.monash.fit5046.healthyrecipehub.BuildConfig.SPOONACULAR_API_KEY }

        @Volatile
        private var instance: SpoonacularApiService? = null

        fun getInstance(): SpoonacularApiService {
            return instance ?: synchronized(this) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                instance = retrofit.create(SpoonacularApiService::class.java)
                instance!!
            }
        }
    }
}

// ====== Response Models ======

data class SpoonacularSearchResponse(
    val results: List<SpoonacularRecipeSummary>?,
    val totalResults: Int,
    val offset: Int,
    val number: Int
)

data class SpoonacularRandomResponse(
    val recipes: List<SpoonacularRecipe>?
)

data class SpoonacularRecipeSummary(
    val id: Int,
    val title: String,
    val image: String?,
    val imageType: String?,
    val nutrition: SpoonacularNutritionSummary?
)

data class SpoonacularNutritionSummary(
    val nutrients: List<SpoonacularNutrient>?
)

data class SpoonacularRecipe(
    val id: Int,
    val title: String,
    val image: String?,
    val summary: String?,
    val readyInMinutes: Int = 30,
    val servings: Int = 4,
    val dishTypes: List<String>? = null,
    val cuisines: List<String>? = null,
    val diets: List<String>? = null,
    val extendedIngredients: List<SpoonacularIngredient>? = null,
    val analyzedInstructions: List<SpoonacularInstruction>? = null,
    val nutrition: SpoonacularNutrition? = null,
    val sourceUrl: String? = null,
    val spoonacularSourceUrl: String? = null
)

data class SpoonacularIngredient(
    val id: Int,
    val name: String,
    val amount: Double = 1.0,
    val unit: String? = null,
    val original: String? = null,
    val image: String? = null
)

data class SpoonacularInstruction(
    val name: String,
    val steps: List<SpoonacularStep>? = null
)

data class SpoonacularStep(
    val number: Int,
    val step: String,
    val ingredients: List<SpoonacularStepIngredient>? = null
)

data class SpoonacularStepIngredient(
    val id: Int,
    val name: String
)

data class SpoonacularNutrition(
    val nutrients: List<SpoonacularNutrient>? = null
)

data class SpoonacularNutrient(
    val name: String? = null,
    val amount: Double = 0.0,
    val unit: String? = null,
    val percentOfDailyNeeds: Double = 0.0
)
