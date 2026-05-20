package edu.monash.fit5046.healthyrecipehub.ui.navigation

sealed class Screen(val route: String) {
    // Auth
    object Auth : Screen("auth")
    object ForgotPassword : Screen("forgot_password")
    
    // Main screens
    object Home : Screen("home")
    object Recipes : Screen("recipes")
    object RecipeDetail : Screen("recipe/{recipeId}") {
        fun createRoute(recipeId: String) = "recipe/$recipeId"
    }
    object AddRecipe : Screen("add_recipe")
    object Favorites : Screen("favorites")
    object Profile : Screen("profile")
    
    // Side drawer screens
    object Map : Screen("map")
    object AIAssistant : Screen("ai_assistant")
    object Charts : Screen("charts")
    object Email : Screen("email")
    object Settings : Screen("settings")
    object Admin : Screen("admin")
}
