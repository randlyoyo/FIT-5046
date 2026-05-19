package edu.monash.fit5046.healthyrecipehub.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import edu.monash.fit5046.healthyrecipehub.data.repository.AuthState
import edu.monash.fit5046.healthyrecipehub.ui.MainApp
import edu.monash.fit5046.healthyrecipehub.ui.auth.AuthActivity
import edu.monash.fit5046.healthyrecipehub.ui.viewmodel.AuthViewModel
import edu.monash.fit5046.healthyrecipehub.ui.viewmodel.RecipeViewModel
import kotlinx.coroutines.launch

/**
 * Main Activity - Entry point after login
 * Now using Jetpack Compose for all UI
 */
class MainActivity : ComponentActivity() {

    private val authViewModel: AuthViewModel by viewModels()
    private val recipeViewModel: RecipeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        enableEdgeToEdge()
        
        // Check authentication state
        observeAuthState()
        
        setContent {
            MainApp(
                authViewModel = authViewModel,
                recipeViewModel = recipeViewModel
            )
        }
    }

    private fun observeAuthState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                var hadUser = false
                authViewModel.currentUser.collect { user ->
                    if (user != null) {
                        hadUser = true
                    } else if (hadUser) {
                        // User was logged in but now logged out - redirect to login
                        startActivity(Intent(this@MainActivity, AuthActivity::class.java))
                        finish()
                    }
                }
            }
        }
    }
}
