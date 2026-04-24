package edu.monash.fit5046.healthyrecipehub.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import edu.monash.fit5046.healthyrecipehub.ui.main.MainActivity
import edu.monash.fit5046.healthyrecipehub.ui.screens.auth.AuthScreen
import edu.monash.fit5046.healthyrecipehub.ui.theme.HealthyRecipeHubTheme
import edu.monash.fit5046.healthyrecipehub.ui.viewmodel.AuthViewModel

/**
 * Authentication Activity - Compose Version
 * Handles login and registration
 */
class AuthActivity : ComponentActivity() {

    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Check if already logged in
        if (viewModel.isLoggedIn()) {
            navigateToMain()
            return
        }
        
        enableEdgeToEdge()
        
        setContent {
            HealthyRecipeHubTheme {
                AuthScreen(
                    onNavigateToMain = { navigateToMain() },
                    viewModel = viewModel
                )
            }
        }
    }

    private fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.clearResults()
    }
}
