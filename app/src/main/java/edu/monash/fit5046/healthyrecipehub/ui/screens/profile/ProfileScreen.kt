package edu.monash.fit5046.healthyrecipehub.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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

private val mockUser = User(
    id = "prototype-user",
    email = "jessie.tan@student.monash.edu",
    displayName = "Jessie Tan",
    role = UserRole.USER,
    dietaryPreferences = listOf("High Protein", "Vegetarian"),
    allergies = listOf("Peanuts"),
    dailyCalorieGoal = 2100,
    isEmailVerified = true,
    isBiometricEnabled = true
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    onNavigateBack: () -> Unit,
    user: User? = null,
    onOpenDrawer: (() -> Unit)? = null
) {
    val profile = user ?: mockUser

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile") },
                navigationIcon = {
                    IconButton(onClick = { onOpenDrawer?.invoke() ?: onNavigateBack() }) {
                        Icon(
                            imageVector = if (onOpenDrawer != null) Icons.Default.Menu else Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = if (onOpenDrawer != null) "Menu" else "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ProfileHeroCard(profile)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ProfileMetricCard(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.LocalFireDepartment,
                    value = "${profile.dailyCalorieGoal}",
                    label = "Daily goal",
                    accent = OrangeSecondary
                )
                ProfileMetricCard(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.Favorite,
                    value = "18",
                    label = "Saved meals",
                    accent = GreenPrimary
                )
                ProfileMetricCard(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.Schedule,
                    value = "6",
                    label = "Day streak",
                    accent = Color(0xFF4F6BED)
                )
            }

            DetailSectionCard(
                title = "Nutrition preferences",
                subtitle = "Mock data for the skeleton prototype"
            ) {
                PreferenceRow(profile.dietaryPreferences, GreenPrimary.copy(alpha = 0.12f), GreenPrimary)
                if (profile.allergies.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(8.dp))
                    PreferenceRow(
                        items = profile.allergies.map { "Avoid $it" },
                        background = OrangeSecondary.copy(alpha = 0.14f),
                        contentColor = OrangeSecondary
                    )
                }
            }

            DetailSectionCard(
                title = "Progress highlights",
                subtitle = "Designed for screenshot-ready presentation"
            ) {
                ProgressRow(
                    label = "Weekly recipe target",
                    value = "5 of 7 meals planned",
                    progress = 0.72f,
                    accent = GreenPrimary
                )
                Spacer(modifier = Modifier.height(12.dp))
                ProgressRow(
                    label = "Protein target",
                    value = "92g of 110g",
                    progress = 0.84f,
                    accent = Color(0xFF4F6BED)
                )
                Spacer(modifier = Modifier.height(12.dp))
                ProgressRow(
                    label = "Water reminder completion",
                    value = "6 of 8 reminders",
                    progress = 0.75f,
                    accent = OrangeSecondary
                )
            }

            DetailSectionCard(
                title = "Recent activity",
                subtitle = "Static timeline until backend history is ready"
            ) {
                ActivityItem(
                    icon = Icons.Default.Restaurant,
                    title = "Added Mediterranean grain bowl",
                    detail = "Recipe saved to favorites 2h ago"
                )
                ActivityItem(
                    icon = Icons.Default.Verified,
                    title = "Profile health goal updated",
                    detail = "Daily calorie target changed to 2100 kcal"
                )
                ActivityItem(
                    icon = Icons.Default.Favorite,
                    title = "Streak extended",
                    detail = "Six consecutive days with healthy meal tracking"
                )
            }
        }
    }
}

@Composable
private fun ProfileHeroCard(profile: User) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(72.dp)
                        .background(GreenPrimary.copy(alpha = 0.18f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = profile.displayName.take(1).uppercase(),
                        style = MaterialTheme.typography.headlineMedium,
                        color = GreenPrimary,
                        fontWeight = FontWeight.Bold
                    )
                }
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(
                        text = profile.displayName,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Text(
                        text = profile.email,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.78f)
                    )
                    Text(
                        text = if (profile.isEmailVerified) "Verified account" else "Verification pending",
                        style = MaterialTheme.typography.labelLarge,
                        color = GreenPrimary
                    )
                }
            }

            Text(
                text = "Focused on balanced, quick weekday meals with higher protein and low-fuss prep.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.9f)
            )
        }
    }
}

@Composable
private fun ProfileMetricCard(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    value: String,
    label: String,
    accent: Color
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(icon, contentDescription = null, tint = accent)
            Text(text = value, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Text(
                text = label,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        }
    }
}

@Composable
private fun DetailSectionCard(
    title: String,
    subtitle: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
            content()
        }
    }
}

@Composable
private fun PreferenceRow(
    items: List<String>,
    background: Color,
    contentColor: Color
) {
    Row(
        modifier = Modifier.horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items.forEach { item ->
            Box(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .background(background, RoundedCornerShape(50))
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Text(text = item, style = MaterialTheme.typography.bodySmall, color = contentColor)
            }
        }
    }
}

@Composable
private fun ProgressRow(
    label: String,
    value: String,
    progress: Float,
    accent: Color
) {
    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = label, style = MaterialTheme.typography.bodyMedium)
            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium,
                color = accent,
                fontWeight = FontWeight.SemiBold
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
                .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(50))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(progress.coerceIn(0f, 1f))
                    .height(10.dp)
                    .background(accent, RoundedCornerShape(50))
            )
        }
    }
}

@Composable
private fun ActivityItem(
    icon: ImageVector,
    title: String,
    detail: String
) {
    Row(verticalAlignment = Alignment.Top) {
        Icon(imageVector = icon, contentDescription = null, tint = GreenPrimary, modifier = Modifier.padding(top = 2.dp))
        Spacer(modifier = Modifier.width(10.dp))
        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            Text(text = title, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Medium)
            Text(
                text = detail,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        }
    }
}
