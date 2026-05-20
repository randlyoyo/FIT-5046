package edu.monash.fit5046.healthyrecipehub.ui.screens.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import edu.monash.fit5046.healthyrecipehub.data.model.Result
import edu.monash.fit5046.healthyrecipehub.ui.theme.GreenPrimary
import edu.monash.fit5046.healthyrecipehub.ui.viewmodel.AuthViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordScreen(onNavigateBack: () -> Unit, viewModel: AuthViewModel) {
    val scope = rememberCoroutineScope()
    val snack = remember { SnackbarHostState() }
    var email by remember { mutableStateOf("") }
    val isLoading by viewModel.isLoading.observeAsState(false)
    val result by viewModel.passwordResetResult.observeAsState()

    LaunchedEffect(result) {
        when (result) {
            is Result.Success -> scope.launch { snack.showSnackbar("Password reset email sent! Check your inbox.") }
            is Result.Error -> scope.launch { snack.showSnackbar("Failed: ${(result as Result.Error).message}") }
            else -> {}
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Reset Password") },
                navigationIcon = { IconButton(onClick = onNavigateBack) { Icon(Icons.Default.ArrowBack, "Back") } },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = GreenPrimary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary))
        },
        snackbarHost = { SnackbarHost(snack) }
    ) { pv ->
        Column(Modifier.fillMaxSize().padding(pv).padding(24.dp).verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Forgot Your Password?", style = MaterialTheme.typography.headlineSmall, color = GreenPrimary)
            Spacer(Modifier.height(12.dp))
            Text("Enter your email and we'll send a reset link.",
                style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f))
            Spacer(Modifier.height(32.dp))
            OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email") },
                leadingIcon = { Icon(Icons.Default.Email, null) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Done),
                singleLine = true, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(24.dp))
            Button(onClick = {
                if (email.isEmpty()) scope.launch { snack.showSnackbar("Please enter your email") }
                else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
                    scope.launch { snack.showSnackbar("Please enter a valid email") }
                else viewModel.forgotPassword(email)
            }, enabled = !isLoading, modifier = Modifier.fillMaxWidth()) {
                if (isLoading) CircularProgressIndicator(Modifier.height(24.dp), strokeWidth = 2.dp)
                else Text("Send Reset Link")
            }
            Spacer(Modifier.height(16.dp))
            TextButton(onClick = onNavigateBack) { Text("Back to Login") }
        }
    }
}