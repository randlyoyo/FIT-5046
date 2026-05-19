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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import edu.monash.fit5046.healthyrecipehub.data.model.Result
import edu.monash.fit5046.healthyrecipehub.ui.theme.GreenPrimary
import edu.monash.fit5046.healthyrecipehub.ui.viewmodel.AuthViewModel
import kotlinx.coroutines.launch

@Composable
fun AuthScreen(
    onNavigateToMain: () -> Unit,
    viewModel: AuthViewModel
) {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    
    var isLoginMode by remember { mutableStateOf(true) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var displayName by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    
    val isLoading by viewModel.isLoading.observeAsState(false)
    val errorMessage by viewModel.errorMessage.observeAsState()
    val loginResult by viewModel.loginResult.observeAsState()
    val registerResult by viewModel.registerResult.observeAsState()
    val passwordResetResult by viewModel.passwordResetResult.observeAsState()
    
    // Handle results
    LaunchedEffect(loginResult) {
        when (loginResult) {
            is Result.Success -> onNavigateToMain()
            is Result.Error -> {
                scope.launch {
                    snackbarHostState.showSnackbar((loginResult as Result.Error).message)
                }
            }
            else -> {}
        }
    }
    
    LaunchedEffect(registerResult) {
        when (registerResult) {
            is Result.Success -> {
                scope.launch {
                    snackbarHostState.showSnackbar("Registration successful!")
                }
                onNavigateToMain()
            }
            is Result.Error -> {
                scope.launch {
                    snackbarHostState.showSnackbar("Registration failed: ${(registerResult as Result.Error).message}")
                }
            }
            else -> {}
        }
    }
    
    LaunchedEffect(passwordResetResult) {
        when (passwordResetResult) {
            is Result.Success -> {
                scope.launch {
                    snackbarHostState.showSnackbar("Password reset email sent!")
                }
            }
            is Result.Error -> {
                scope.launch {
                    snackbarHostState.showSnackbar("Failed: ${(passwordResetResult as Result.Error).message}")
                }
            }
            else -> {}
        }
    }
    
    LaunchedEffect(errorMessage) {
        errorMessage?.let {
            scope.launch {
                snackbarHostState.showSnackbar(it)
            }
        }
    }
    
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // App Logo/Title
            Text(
                text = "Healthy Recipe Hub",
                style = MaterialTheme.typography.headlineLarge,
                color = GreenPrimary
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = if (isLoginMode) "Login to your account" else "Create a new account",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Email field
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Display name field (register only)
            if (!isLoginMode) {
                OutlinedTextField(
                    value = displayName,
                    onValueChange = { displayName = it },
                    label = { Text("Display Name") },
                    leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                
                Spacer(modifier = Modifier.height(16.dp))
            }
            
            // Password field
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Default.Lock else Icons.Default.Lock,
                            contentDescription = if (passwordVisible) "Hide password" else "Show password"
                        )
                    }
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Action button
            Button(
                onClick = {
                    val validationError = getValidationError(email, password, displayName, isLoginMode)
                    if (validationError != null) {
                        scope.launch { snackbarHostState.showSnackbar(validationError) }
                    } else if (isLoginMode) {
                        viewModel.login(email, password)
                    } else {
                        viewModel.register(email, password, displayName)
                    }
                },
                enabled = !isLoading,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.height(24.dp),
                        strokeWidth = 2.dp
                    )
                } else {
                    Text(if (isLoginMode) "Login" else "Register")
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Forgot password (login only)
            if (isLoginMode) {
                TextButton(
                    onClick = {
                        if (email.isNotEmpty()) {
                            viewModel.forgotPassword(email)
                        } else {
                            scope.launch {
                                snackbarHostState.showSnackbar("Please enter your email")
                            }
                        }
                    }
                ) {
                    Text("Forgot Password?")
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Biometric login placeholder
                OutlinedButton(
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar("Biometric login coming soon")
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Biometric Login")
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Toggle mode
            TextButton(
                onClick = {
                    isLoginMode = !isLoginMode
                    viewModel.clearResults()
                }
            ) {
                Text(
                    if (isLoginMode) "Don't have an account? Register"
                    else "Already have an account? Login"
                )
            }
        }
    }
}

private fun getValidationError(email: String, password: String, displayName: String, isLoginMode: Boolean): String? {
    if (email.isEmpty()) return "Please enter your email"
    if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) return "Please enter a valid email"
    if (password.isEmpty()) return "Please enter your password"
    if (password.length < 6) return "Password must be at least 6 characters"
    if (!isLoginMode && displayName.isEmpty()) return "Please enter a display name"
    return null
}
