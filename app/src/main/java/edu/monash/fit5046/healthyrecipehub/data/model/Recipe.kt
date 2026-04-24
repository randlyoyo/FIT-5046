package edu.monash.fit5046.healthyrecipehub.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import edu.monash.fit5046.healthyrecipehub.data.local.converter.ListConverter
import kotlinx.parcelize.Parcelize

/**
 * Recipe Entity for Room Database
 * FIT5046 - Healthy Recipe Hub Data Model
 */
@Parcelize
@Entity(tableName = "recipes")
@TypeConverters(ListConverter::class)
data class Recipe(
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String? = null,
    val calories: Int = 0,
    val protein: Double = 0.0,
    val carbs: Double = 0.0,
    val fat: Double = 0.0,
    val fiber: Double = 0.0,
    val sugar: Double = 0.0,
    val sodium: Double = 0.0,
    val prepTime: Int = 0, // in minutes
    val cookTime: Int = 0, // in minutes
    val servings: Int = 1,
    val difficulty: String = "Medium", // Easy, Medium, Hard
    val category: String = "Main Course", // Breakfast, Lunch, Dinner, Snack, Dessert
    val cuisine: String = "International", // Italian, Asian, Mexican, etc.
    val dietaryTags: List<String> = emptyList(), // Vegan, Gluten-Free, Keto, etc.
    val ingredients: List<Ingredient> = emptyList(),
    val instructions: List<String> = emptyList(),
    val nutritionScore: Double = 0.0, // 0-100 health score
    val authorId: String = "",
    val authorName: String = "",
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
    val isFavorite: Boolean = false,
    val isOffline: Boolean = false
) : Parcelable

@Parcelize
data class Ingredient(
    val name: String,
    val amount: Double,
    val unit: String, // g, kg, ml, l, cup, tbsp, tsp, piece
    val optional: Boolean = false
) : Parcelable

/**
 * Recipe Review/Comment
 */
@Parcelize
@Entity(tableName = "reviews", primaryKeys = ["recipeId", "userId"])
data class Review(
    val recipeId: String,
    val userId: String,
    val userName: String,
    val rating: Float, // 1-5
    val comment: String,
    val createdAt: Long = System.currentTimeMillis()
) : Parcelable

/**
 * Nutrition Summary for Charts
 */
data class NutritionSummary(
    val calories: Int,
    val protein: Double,
    val carbs: Double,
    val fat: Double,
    val fiber: Double
)

/**
 * Recipe Filter Options
 */
data class RecipeFilter(
    val query: String = "",
    val category: String? = null,
    val cuisine: String? = null,
    val difficulty: String? = null,
    val maxCalories: Int? = null,
    val minNutritionScore: Double? = null,
    val dietaryTags: List<String> = emptyList(),
    val sortBy: SortOption = SortOption.NEWEST
)

enum class SortOption {
    NEWEST,
    OLDEST,
    CALORIES_LOW,
    CALORIES_HIGH,
    NUTRITION_SCORE,
    PREP_TIME
}
