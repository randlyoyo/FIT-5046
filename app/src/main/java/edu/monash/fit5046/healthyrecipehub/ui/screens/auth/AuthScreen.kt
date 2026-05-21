package edu.monash.fit5046.healthyrecipehub.ui.screens.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.monash.fit5046.healthyrecipehub.data.model.Result
import edu.monash.fit5046.healthyrecipehub.ui.theme.GreenPrimary
import edu.monash.fit5046.healthyrecipehub.ui.viewmodel.AuthViewModel
import kotlinx.coroutines.launch

private val GoogleLogo = ImageVector.Builder(
    name = "GoogleLogo", defaultWidth = 24.dp, defaultHeight = 24.dp,
    viewportWidth = 48f, viewportHeight = 48f
).apply {
    path(fill = SolidColor(Color(0xFF4285F4)), pathFillType = PathFillType.EvenOdd) {
        moveTo(43.61f, 20.08f); horizontalLineTo(42f); verticalLineToRelative(-0.08f); horizontalLineTo(24.08f)
        verticalLineToRelative(7.84f); horizontalLineToRelative(11.13f)
        curveToRelative(-1.6f, 4.63f, -5.92f, 7.84f, -11.13f, 7.84f)
        curveToRelative(-6.63f, 0f, -12f, -5.37f, -12f, -12f); reflectiveCurveToRelative(5.37f, -12f, 12f, -12f)
        curveToRelative(3.23f, 0f, 6.15f, 1.28f, 8.32f, 3.33f); lineToRelative(5.54f, -5.52f)
        curveTo(34.13f, 5.6f, 29.43f, 3.2f, 24.08f, 3.2f)
        curveTo(12.56f, 3.2f, 3.28f, 12.48f, 3.28f, 24f); reflectiveCurveToRelative(9.28f, 20.8f, 20.8f, 20.8f)
        curveToRelative(10.48f, 0f, 19.52f, -7.44f, 19.52f, -20.8f)
        curveToRelative(0f, -1.36f, -0.2f, -2.64f, -0.44f, -3.92f); close()
    }
}.build()

@Composable
fun GoogleSignInButton(onClick: () -> Unit, enabled: Boolean = true) {
    OutlinedButton(onClick = onClick, enabled = enabled, modifier = Modifier.fillMaxWidth()) {
        Text("Sign in with Google")
    }
}

@Composable
fun AuthScreen(
    onNavigateToMain: () -> Unit,
    onNavigateToForgotPassword: () -> Unit = {},
    onGoogleSignIn: () -> Unit = {},
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
    val googleSignInResult by viewModel.googleSignInResult.observeAsState()

    LaunchedEffect(loginResult) {
        when (loginResult) {
            is Result.Success -> onNavigateToMain()
            is Result.Error -> scope.launch { snackbarHostState.showSnackbar((loginResult as Result.Error).message) }
            else -> {}
        }
    }
    LaunchedEffect(registerResult) {
        when (registerResult) {
            is Result.Success -> { scope.launch { snackbarHostState.showSnackbar("Registration successful! Check email for verification.") }; onNavigateToMain() }
            is Result.Error -> scope.launch { snackbarHostState.showSnackbar("Registration failed: ${(registerResult as Result.Error).message}") }
            else -> {}
        }
    }
    LaunchedEffect(googleSignInResult) {
        when (googleSignInResult) {
            is Result.Success -> { scope.launch { snackbarHostState.showSnackbar("Google Sign-In successful!") }; onNavigateToMain() }
            is Result.Error -> scope.launch { snackbarHostState.showSnackbar("Google Sign-In failed: ${(googleSignInResult as Result.Error).message}") }
            else -> {}
        }
    }
    LaunchedEffect(errorMessage) {
        errorMessage?.let { scope.launch { snackbarHostState.showSnackbar(it) } }
    }

    Scaffold(snackbarHost = { SnackbarHost(snackbarHostState) }) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).padding(24.dp).verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Healthy Recipe Hub", style = MaterialTheme.typography.headlineLarge, color = GreenPrimary)
            Spacer(Modifier.height(8.dp))
            Text(if (isLoginMode) "Login to your account" else "Create a new account",
                style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f))
            Spacer(Modifier.height(32.dp))

            OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email") },
                leadingIcon = { Icon(Icons.Default.Email, null) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
                singleLine = true, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(16.dp))

            if (!isLoginMode) {
                OutlinedTextField(value = displayName, onValueChange = { displayName = it }, label = { Text("Display Name") },
                    leadingIcon = { Icon(Icons.Default.Person, null) },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next), singleLine = true, modifier = Modifier.fillMaxWidth())
                Spacer(Modifier.height(16.dp))
            }

            OutlinedTextField(value = password, onValueChange = { password = it }, label = { Text("Password") },
                leadingIcon = { Icon(Icons.Default.Lock, null) },
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            if (passwordVisible) "Hide password" else "Show password")
                    }
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                singleLine = true, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(24.dp))

            Button(onClick = {
                val err = getValidationError(email, password, displayName, isLoginMode)
                if (err != null) scope.launch { snackbarHostState.showSnackbar(err) }
                else if (isLoginMode) viewModel.login(email, password)
                else viewModel.register(email, password, displayName)
            }, enabled = !isLoading, modifier = Modifier.fillMaxWidth()) {
                if (isLoading) CircularProgressIndicator(Modifier.height(24.dp), strokeWidth = 2.dp)
                else Text(if (isLoginMode) "Login" else "Register")
            }

            if (isLoginMode) {
                Spacer(Modifier.height(16.dp))
                HorizontalDivider(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f))
                Spacer(Modifier.height(8.dp))
                Text("Or continue with", style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                    modifier = Modifier.align(Alignment.CenterHorizontally))
                Spacer(Modifier.height(12.dp))

                GoogleSignInButton(onClick = onGoogleSignIn, enabled = !isLoading)
                Spacer(Modifier.height(8.dp))
                Spacer(Modifier.height(8.dp))
                TextButton(onClick = onNavigateToForgotPassword) { Text("Forgot Password?") }
            }

            Spacer(Modifier.height(24.dp))
            TextButton(onClick = { isLoginMode = !isLoginMode; viewModel.clearResults() }) {
                Text(if (isLoginMode) "Don't have an account? Register" else "Already have an account? Login")
            }
        }
    }
}

private fun getValidationError(email: String, password: String, displayName: String, isLoginMode: Boolean): String? {
    if (email.isEmpty()) return "Please enter your email"
    if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) return "Please enter a valid email"
    if (password.isEmpty()) return "Please enter your password"
    if (password.length < 8) return "Password must be at least 8 characters"
    if (!password.any { it.isUpperCase() }) return "Password must contain at least one uppercase letter"
    if (!password.any { it.isLowerCase() }) return "Password must contain at least one lowercase letter"
    if (!password.any { it.isDigit() }) return "Password must contain at least one digit"
    if (!password.any { !it.isLetterOrDigit() }) return "Password must contain at least one special character"
    if (!isLoginMode && displayName.isEmpty()) return "Please enter a display name"
    if (!isLoginMode && displayName.length < 2) return "Display name must be at least 2 characters"
    return null
}
