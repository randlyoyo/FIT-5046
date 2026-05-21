package edu.monash.fit5046.healthyrecipehub.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import edu.monash.fit5046.healthyrecipehub.data.model.User
import edu.monash.fit5046.healthyrecipehub.data.model.UserRole
import edu.monash.fit5046.healthyrecipehub.ui.theme.GreenPrimary
import edu.monash.fit5046.healthyrecipehub.ui.theme.OrangeSecondary
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private val mockUser = User(
    id = "prototype-user", email = "jessie.tan@student.monash.edu",
    displayName = "Jessie Tan", role = UserRole.USER,
    dietaryPreferences = listOf("High Protein", "Vegetarian"), allergies = listOf("Peanuts"),
    dailyCalorieGoal = 2100, isEmailVerified = true, isBiometricEnabled = true
)

private val dietOptions = listOf("Balanced", "High Protein", "Vegetarian", "Vegan", "Low Carb",
    "Keto", "Paleo", "Mediterranean", "Gluten-Free", "Dairy-Free")
private val goalOptions = listOf("Weight Loss", "Muscle Gain", "Maintain Weight", "General Health", "Energy Boost")

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    onNavigateBack: () -> Unit,
    onOpenDrawer: () -> Unit = {},
    onNavigateToSettings: () -> Unit = {},
    onNavigateToCharts: () -> Unit = {},
    onNavigateToMap: () -> Unit = {},
    user: User? = null
) {
    val profile = user ?: mockUser
    var displayName by remember { mutableStateOf(profile.displayName) }
    var selectedDiet by remember { mutableStateOf(profile.dietaryPreferences.firstOrNull() ?: "Balanced") }
    var selectedGoal by remember { mutableStateOf("Maintain Weight") }
    var dailyCalorieGoal by remember { mutableStateOf(profile.dailyCalorieGoal.toString()) }
    var targetDate by remember { mutableStateOf("") }
    var showDatePicker by remember { mutableStateOf(false) }
    var hasChanges by remember { mutableStateOf(false) }
    var savedMessage by remember { mutableStateOf<String?>(null) }
    var formError by remember { mutableStateOf<String?>(null) }
    val datePickerState = rememberDatePickerState()
    var dietExpanded by remember { mutableStateOf(false) }
    var goalExpanded by remember { mutableStateOf(false) }

    if (showDatePicker) {
        DatePickerDialog(onDismissRequest = { showDatePicker = false },
            confirmButton = { TextButton(onClick = {
                datePickerState.selectedDateMillis?.let { millis ->
                    targetDate = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(Date(millis))
                    hasChanges = true
                }; showDatePicker = false
            }) { Text("OK") } },
            dismissButton = { TextButton(onClick = { showDatePicker = false }) { Text("Cancel") } }
        ) { DatePicker(state = datePickerState) }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile") },
                navigationIcon = { IconButton(onClick = onOpenDrawer) { Icon(Icons.Default.Menu, "Menu") } },
                actions = {
                    IconButton(onClick = onNavigateToCharts) { Icon(Icons.Default.BarChart, null, tint = Color.White) }
                    IconButton(onClick = onNavigateToMap) { Icon(Icons.Default.LocationOn, null, tint = Color.White) }
                    IconButton(onClick = onNavigateToSettings) { Icon(Icons.Default.Settings, null, tint = Color.White) }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary, titleContentColor = MaterialTheme.colorScheme.onPrimary, navigationIconContentColor = MaterialTheme.colorScheme.onPrimary)
            )
        }
    ) { paddingValues ->
        Column(Modifier.fillMaxSize().padding(paddingValues).verticalScroll(rememberScrollState()).padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            ProfileHeroCard(profile)

            // Form: Dropdown + DatePicker + Save/Cancel
            Card(Modifier.fillMaxWidth(), elevation = CardDefaults.cardElevation(2.dp)) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text("Edit Profile", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    OutlinedTextField(value = displayName, onValueChange = { displayName = it; hasChanges = true }, label = { Text("Display Name") }, modifier = Modifier.fillMaxWidth(), singleLine = true)

                    ExposedDropdownMenuBox(expanded = dietExpanded, onExpandedChange = { dietExpanded = it }) {
                        OutlinedTextField(value = selectedDiet, onValueChange = {}, readOnly = true, label = { Text("Dietary Preference") },
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = dietExpanded) }, modifier = Modifier.menuAnchor().fillMaxWidth())
                        ExposedDropdownMenu(expanded = dietExpanded, onDismissRequest = { dietExpanded = false }) {
                            dietOptions.forEach { opt -> DropdownMenuItem(text = { Text(opt) }, onClick = { selectedDiet = opt; dietExpanded = false; hasChanges = true }) }
                        }
                    }

                    ExposedDropdownMenuBox(expanded = goalExpanded, onExpandedChange = { goalExpanded = it }) {
                        OutlinedTextField(value = selectedGoal, onValueChange = {}, readOnly = true, label = { Text("Health Goal") },
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = goalExpanded) }, modifier = Modifier.menuAnchor().fillMaxWidth())
                        ExposedDropdownMenu(expanded = goalExpanded, onDismissRequest = { goalExpanded = false }) {
                            goalOptions.forEach { opt -> DropdownMenuItem(text = { Text(opt) }, onClick = { selectedGoal = opt; goalExpanded = false; hasChanges = true }) }
                        }
                    }

                    OutlinedTextField(value = dailyCalorieGoal, onValueChange = { dailyCalorieGoal = it; hasChanges = true }, label = { Text("Daily Calorie Goal") }, modifier = Modifier.fillMaxWidth(), singleLine = true)
                    OutlinedTextField(value = targetDate, onValueChange = {}, readOnly = true, label = { Text("Target Date") }, modifier = Modifier.fillMaxWidth(), trailingIcon = { IconButton(onClick = { showDatePicker = true }) { Icon(Icons.Default.Schedule, "Pick date") } })

                    formError?.let { Text(it, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall) }
                    savedMessage?.let { Text(it, color = GreenPrimary, style = MaterialTheme.typography.bodySmall) }

                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        OutlinedButton(onClick = {
                            displayName = profile.displayName; selectedDiet = profile.dietaryPreferences.firstOrNull() ?: "Balanced"
                            selectedGoal = "Maintain Weight"; dailyCalorieGoal = profile.dailyCalorieGoal.toString(); targetDate = ""
                            hasChanges = false; formError = null; savedMessage = null
                        }, modifier = Modifier.weight(1f)) { Text("Cancel") }
                        Button(onClick = {
                            formError = null; savedMessage = null
                            if (displayName.isBlank()) { formError = "Display name cannot be empty"; return@Button }
                            val cal = dailyCalorieGoal.toIntOrNull()
                            if (cal == null || cal < 500 || cal > 5000) { formError = "Calorie goal must be between 500 and 5000"; return@Button }
                            savedMessage = "Saved! Diet: $selectedDiet"; hasChanges = false
                        }, modifier = Modifier.weight(1f), colors = ButtonDefaults.buttonColors(containerColor = GreenPrimary), enabled = hasChanges) { Text("Save", color = Color.White) }
                    }
                }
            }

            // Stats
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                ProfileMetricCard(Modifier.weight(1f), Icons.Default.LocalFireDepartment, dailyCalorieGoal, "Daily goal", OrangeSecondary)
                ProfileMetricCard(Modifier.weight(1f), Icons.Default.Favorite, "18", "Saved meals", GreenPrimary)
                ProfileMetricCard(Modifier.weight(1f), Icons.Default.Schedule, "6", "Day streak", Color(0xFF4F6BED))
            }

            // Recent activity
            Card(Modifier.fillMaxWidth(), elevation = CardDefaults.cardElevation(2.dp)) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text("Recent activity", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
                    ActivityItem(Icons.Default.Restaurant, "Added Mediterranean grain bowl", "Saved to favorites 2h ago")
                    ActivityItem(Icons.Default.Verified, "Profile health goal updated", "Calorie target changed to 2100 kcal")
                    ActivityItem(Icons.Default.Favorite, "Streak extended", "Six days with healthy meal tracking")
                }
            }
        }
    }
}

@Composable
private fun ProfileHeroCard(profile: User) {
    Card(Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)) {
        Row(Modifier.padding(20.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(Modifier.size(64.dp).background(GreenPrimary.copy(alpha = 0.18f), CircleShape), contentAlignment = Alignment.Center) {
                Text(profile.displayName.take(1).uppercase(), style = MaterialTheme.typography.headlineMedium, color = GreenPrimary, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.width(16.dp))
            Column {
                Text(profile.displayName, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                Text(profile.email, style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
                Text(if (profile.isEmailVerified) "Verified account" else "Pending", style = MaterialTheme.typography.labelMedium, color = GreenPrimary)
            }
        }
    }
}

@Composable
private fun ProfileMetricCard(modifier: Modifier, icon: ImageVector, value: String, label: String, accent: Color) {
    Card(modifier = modifier, elevation = CardDefaults.cardElevation(2.dp)) {
        Column(Modifier.padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(icon, null, tint = accent, modifier = Modifier.size(24.dp))
            Text(value, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Text(label, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
        }
    }
}

@Composable
private fun ActivityItem(icon: ImageVector, title: String, detail: String) {
    Row(verticalAlignment = Alignment.Top) {
        Icon(icon, null, tint = GreenPrimary, modifier = Modifier.size(20.dp))
        Spacer(Modifier.width(10.dp))
        Column {
            Text(title, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Medium)
            Text(detail, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
        }
    }
}
