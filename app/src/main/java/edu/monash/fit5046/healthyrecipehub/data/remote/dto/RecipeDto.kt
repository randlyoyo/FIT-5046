package edu.monash.fit5046.healthyrecipehub.data.remote.dto

import com.google.gson.annotations.SerializedName
import edu.monash.fit5046.healthyrecipehub.data.model.Ingredient
import edu.monash.fit5046.healthyrecipehub.data.model.Recipe

/**
 * Recipe Data Transfer Objects
 * For API communication
 */
data class RecipeResponse(
    @SerializedName("success") val success: Boolean,
    @SerializedName("data") val data: List<RecipeDto>? = null,
    @SerializedName("message") val message: String? = null,
    @SerializedName("total") val total: Int? = null
)

data class RecipeDto(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("imageUrl") val imageUrl: String? = null,
    @SerializedName("calories") val calories: Int = 0,
    @SerializedName("protein") val protein: Double = 0.0,
    @SerializedName("carbs") val carbs: Double = 0.0,
    @SerializedName("fat") val fat: Double = 0.0,
    @SerializedName("fiber") val fiber: Double = 0.0,
    @SerializedName("sugar") val sugar: Double = 0.0,
    @SerializedName("sodium") val sodium: Double = 0.0,
    @SerializedName("prepTime") val prepTime: Int = 0,
    @SerializedName("cookTime") val cookTime: Int = 0,
    @SerializedName("servings") val servings: Int = 1,
    @SerializedName("difficulty") val difficulty: String = "Medium",
    @SerializedName("category") val category: String = "Main Course",
    @SerializedName("cuisine") val cuisine: String = "International",
    @SerializedName("dietaryTags") val dietaryTags: List<String> = emptyList(),
    @SerializedName("ingredients") val ingredients: List<IngredientDto> = emptyList(),
    @SerializedName("instructions") val instructions: List<String> = emptyList(),
    @SerializedName("nutritionScore") val nutritionScore: Double = 0.0,
    @SerializedName("authorId") val authorId: String = "",
    @SerializedName("authorName") val authorName: String = "",
    @SerializedName("createdAt") val createdAt: Long = System.currentTimeMillis(),
    @SerializedName("updatedAt") val updatedAt: Long = System.currentTimeMillis()
) {
    fun toRecipe(): Recipe {
        return Recipe(
            id = id,
            title = title,
            description = description,
            imageUrl = imageUrl,
            calories = calories,
            protein = protein,
            carbs = carbs,
            fat = fat,
            fiber = fiber,
            sugar = sugar,
            sodium = sodium,
            prepTime = prepTime,
            cookTime = cookTime,
            servings = servings,
            difficulty = difficulty,
            category = category,
            cuisine = cuisine,
            dietaryTags = dietaryTags,
            ingredients = ingredients.map { it.toIngredient() },
            instructions = instructions,
            nutritionScore = nutritionScore,
            authorId = authorId,
            authorName = authorName,
            createdAt = createdAt,
            updatedAt = updatedAt
        )
    }
}

data class IngredientDto(
    @SerializedName("name") val name: String,
    @SerializedName("amount") val amount: Double,
    @SerializedName("unit") val unit: String,
    @SerializedName("optional") val optional: Boolean = false
) {
    fun toIngredient(): Ingredient {
        return Ingredient(
            name = name,
            amount = amount,
            unit = unit,
            optional = optional
        )
    }
}

/**
 * Recipe Upload Request
 */
data class RecipeUploadRequest(
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("imageUrl") val imageUrl: String? = null,
    @SerializedName("calories") val calories: Int = 0,
    @SerializedName("protein") val protein: Double = 0.0,
    @SerializedName("carbs") val carbs: Double = 0.0,
    @SerializedName("fat") val fat: Double = 0.0,
    @SerializedName("prepTime") val prepTime: Int = 0,
    @SerializedName("cookTime") val cookTime: Int = 0,
    @SerializedName("servings") val servings: Int = 1,
    @SerializedName("difficulty") val difficulty: String = "Medium",
    @SerializedName("category") val category: String = "Main Course",
    @SerializedName("cuisine") val cuisine: String = "International",
    @SerializedName("dietaryTags") val dietaryTags: List<String> = emptyList(),
    @SerializedName("ingredients") val ingredients: List<IngredientDto> = emptyList(),
    @SerializedName("instructions") val instructions: List<String> = emptyList()
)
