package edu.monash.fit5046.healthyrecipehub.ui.recipe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import edu.monash.fit5046.healthyrecipehub.ui.screens.recipe.RecipeDetailScreen
import edu.monash.fit5046.healthyrecipehub.ui.theme.HealthyRecipeHubTheme
import edu.monash.fit5046.healthyrecipehub.ui.viewmodel.AuthViewModel
import edu.monash.fit5046.healthyrecipehub.ui.viewmodel.RecipeViewModel

/**
 * Recipe Detail Activity - Compose Version
 * Shows full recipe information
 */
class RecipeDetailActivity : ComponentActivity() {

    private val recipeViewModel: RecipeViewModel by viewModels()
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val recipeId = intent.getStringExtra(EXTRA_RECIPE_ID) ?: ""
        if (recipeId.isEmpty()) {
            finish()
            return
        }
        
        enableEdgeToEdge()
        
        setContent {
            HealthyRecipeHubTheme {
                RecipeDetailScreen(
                    recipeId = recipeId,
                    onNavigateBack = { finish() },
                    recipeViewModel = recipeViewModel,
                    authViewModel = authViewModel
                )
            }
        }
    }

    companion object {
        const val EXTRA_RECIPE_ID = "extra_recipe_id"
    }
}
