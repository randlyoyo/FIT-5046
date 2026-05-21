package edu.monash.fit5046.healthyrecipehub.data.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * TheMealDB Public API Integration
 *
 * Free public recipe API that provides real meal data.
 * Used as Retrofit + Public API requirement for the assignment.
 *
 * API: https://www.themealdb.com/api.php
 * Free tier: No API key required for test endpoints
 */
interface MealDbApiService {

    @GET("api/json/v1/1/search.php")
    suspend fun searchMeals(@Query("s") query: String): MealDbResponse

    @GET("api/json/v1/1/lookup.php")
    suspend fun lookupMealById(@Query("i") mealId: String): MealDbResponse

    @GET("api/json/v1/1/filter.php")
    suspend fun filterByCategory(@Query("c") category: String): MealDbResponse

    @GET("api/json/v1/1/categories.php")
    suspend fun getCategories(): MealDbCategoryResponse

    @GET("api/json/v1/1/random.php")
    suspend fun getRandomMeal(): MealDbResponse

    @GET("api/json/v1/1/random.php")
    suspend fun getSingleRandomMeal(): MealDbResponse

    companion object {
        private const val BASE_URL = "https://www.themealdb.com/"

        @Volatile
        private var instance: MealDbApiService? = null

        fun getInstance(): MealDbApiService {
            return instance ?: synchronized(this) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                instance = retrofit.create(MealDbApiService::class.java)
                instance!!
            }
        }
    }
}

// Response models
data class MealDbResponse(
    val meals: List<MealDto>?
)

data class MealDbCategoryResponse(
    val categories: List<MealCategoryDto>?
)

data class MealDto(
    val idMeal: String,
    val strMeal: String,
    val strCategory: String?,
    val strArea: String?,
    val strInstructions: String?,
    val strMealThumb: String?,
    val strTags: String?,
    val strYoutube: String?,
    val strIngredient1: String?,
    val strIngredient2: String?,
    val strIngredient3: String?,
    val strIngredient4: String?,
    val strIngredient5: String?,
    val strMeasure1: String?,
    val strMeasure2: String?,
    val strMeasure3: String?,
    val strMeasure4: String?,
    val strMeasure5: String?
)

data class MealCategoryDto(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String?,
    val strCategoryDescription: String?
)
