package edu.monash.fit5046.healthyrecipehub.ui.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import edu.monash.fit5046.healthyrecipehub.R
import edu.monash.fit5046.healthyrecipehub.ui.main.MainActivity
import edu.monash.fit5046.healthyrecipehub.ui.screens.auth.AuthScreen
import edu.monash.fit5046.healthyrecipehub.ui.screens.auth.ForgotPasswordScreen
import edu.monash.fit5046.healthyrecipehub.ui.theme.HealthyRecipeHubTheme
import edu.monash.fit5046.healthyrecipehub.ui.viewmodel.AuthViewModel

class AuthActivity : ComponentActivity() {
    companion object { private const val TAG = "AuthActivity" }

    private val viewModel: AuthViewModel by viewModels()
    private var googleSignInClient: com.google.android.gms.auth.api.signin.GoogleSignInClient? = null

    private val googleSignInLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        try {
            val account = GoogleSignIn.getSignedInAccountFromIntent(result.data).getResult(Exception::class.java)
            account?.idToken?.let { viewModel.signInWithGoogle(it) }
        } catch (e: Exception) { Log.e(TAG, "Google Sign-In failed", e) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Always show login screen - no auto-login

        try {
            val webClientId = getString(R.string.default_web_client_id)
            if (webClientId.isNotEmpty()) {
                googleSignInClient = GoogleSignIn.getClient(this,
                    GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(webClientId).requestEmail().build())
            }
        } catch (e: Exception) { Log.w(TAG, "Google Sign-In not configured") }

        enableEdgeToEdge()
        setContent {
            var showForgot by remember { mutableStateOf(false) }
            HealthyRecipeHubTheme {
                if (showForgot) ForgotPasswordScreen(onNavigateBack = { showForgot = false }, viewModel = viewModel)
                else AuthScreen(
                    onNavigateToMain = { navigateToMain() },
                    onNavigateToForgotPassword = { showForgot = true },
                    onGoogleSignIn = {
                        // Sign out first to always show account picker
                        googleSignInClient?.signOut()?.addOnCompleteListener {
                            googleSignInClient?.signInIntent?.let { googleSignInLauncher.launch(it) }
                        }
                    },
                    viewModel = viewModel)
            }
        }
    }

    private fun navigateToMain() {
        startActivity(Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }); finish()
    }

    override fun onDestroy() { super.onDestroy(); viewModel.clearResults() }
}
