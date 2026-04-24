package edu.monash.fit5046.healthyrecipehub.context

import java.util.Calendar

/**
 * Context-aware simulator that uses time of day as contextual information
 * to provide personalized recipe recommendations.
 * 
 * This demonstrates context-aware computing using simulated sensor data
 * (time-based context instead of physical sensors due to virtual device constraints).
 */
class TimeContextSimulator {
    
    /**
     * Represents different meal contexts based on time of day
     */
    enum class MealContext {
        BREAKFAST,      // 6:00 - 11:59
        LUNCH,          // 12:00 - 16:59
        DINNER,         // 17:00 - 21:59
        LATE_NIGHT      // 22:00 - 5:59
    }
    
    /**
     * Recipe database organized by meal context with healthy options
     */
    private val contextRecipeDatabase = mapOf(
        MealContext.BREAKFAST to listOf(
            ContextRecipe("Greek Yogurt Parfait", 320, "High protein breakfast with berries and granola"),
            ContextRecipe("Avocado Toast with Egg", 380, "Healthy fats and protein for sustained energy"),
            ContextRecipe("Oatmeal with Fruits", 290, "Fiber-rich whole grain breakfast")
        ),
        MealContext.LUNCH to listOf(
            ContextRecipe("Mediterranean Chickpea Salad", 420, "Light and refreshing plant-based lunch"),
            ContextRecipe("Grilled Chicken Bowl", 480, "High protein with quinoa and vegetables"),
            ContextRecipe("Vegetable Wrap", 350, "Portable and nutritious midday meal")
        ),
        MealContext.DINNER to listOf(
            ContextRecipe("Grilled Salmon with Asparagus", 520, "Heart-healthy dinner rich in omega-3"),
            ContextRecipe("Stir-Fry Vegetables with Tofu", 380, "Low-calorie nutrient-dense evening meal"),
            ContextRecipe("Lean Beef with Sweet Potato", 580, "Balanced protein and complex carbs")
        ),
        MealContext.LATE_NIGHT to listOf(
            ContextRecipe("Herbal Tea and Light Snack", 120, "Calming low-calorie option before sleep"),
            ContextRecipe("Small Fruit Salad", 150, "Easy to digest evening snack"),
            ContextRecipe("Warm Milk with Honey", 180, "Promotes relaxation and good sleep")
        )
    )
    
    /**
     * Gets current meal context based on system time
     * Simulates sensor data reading from device's time sensor
     */
    fun getCurrentContext(): MealContext {
        val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        return when (hour) {
            in 6..11 -> MealContext.BREAKFAST
            in 12..16 -> MealContext.LUNCH
            in 17..21 -> MealContext.DINNER
            else -> MealContext.LATE_NIGHT
        }
    }
    
    /**
     * Gets contextual recommendations based on current time
     */
    fun getRecommendations(): List<ContextRecipe> {
        return contextRecipeDatabase[getCurrentContext()] ?: emptyList()
    }
    
    /**
     * Gets the primary recommendation for display
     */
    fun getPrimaryRecommendation(): ContextRecipe {
        return getRecommendations().firstOrNull()
            ?: ContextRecipe("Healthy Mixed Salad", 350, "Balanced nutrition for any time")
    }
    
    /**
     * Generates context-aware message for the user
     */
    fun getContextMessage(): String {
        val context = getCurrentContext()
        val time = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        return when (context) {
            MealContext.BREAKFAST -> "Good morning! ($time:00) Start your day with energy:"
            MealContext.LUNCH -> "It's lunchtime! ($time:00) Refuel with these balanced meals:"
            MealContext.DINNER -> "Dinner time! ($time:00) End your day with nutritious choices:"
            MealContext.LATE_NIGHT -> "Late evening ($time:00). Consider these light options:"
        }
    }
    
    /**
     * Data class representing a context-aware recipe recommendation
     */
    data class ContextRecipe(
        val name: String,
        val calories: Int,
        val description: String
    )
}
