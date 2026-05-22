package edu.monash.fit5046.healthyrecipehub.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.SmartToy
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import edu.monash.fit5046.healthyrecipehub.context.HealthContextManager
import edu.monash.fit5046.healthyrecipehub.data.remote.api.MealDto
import edu.monash.fit5046.healthyrecipehub.ui.navigation.Screen
import edu.monash.fit5046.healthyrecipehub.ui.theme.GreenPrimary
import edu.monash.fit5046.healthyrecipehub.ui.theme.OrangeSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigate: (String) -> Unit,
    onOpenDrawer: () -> Unit = {},
    userName: String = "User",
    dailyPick: MealDto? = null
) {
    val contextManager = remember { HealthContextManager() }
    val contextSummary = remember { contextManager.getContextSummary() }

    // Real recipe from Spoonacular as daily pick
    val pickId = dailyPick?.idMeal ?: ""
    val pickTitle = dailyPick?.strMeal ?: "Healthy Mixed Salad"
    val pickImage = dailyPick?.strMealThumb ?: "https://picsum.photos/seed/food/800/400"

    var aiSuggestion by remember { mutableStateOf("") }
    val aiSuggestions = remember {
        listOf(
            "Try our new High-Protein Buddha Bowl - only 380 cal!",
            "Based on your favorites, you might love the Grilled Salmon tonight.",
            "Quick prep tip: Prep quinoa and chop veggies on Sunday to save 2 hours weekly.",
            "Your weekly protein intake is 15% above target - great job!",
            "Craving something sweet? Try the Greek Yogurt Berry Parfait (290 cal)."
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Healthy Recipe Hub", fontWeight = FontWeight.Bold, fontSize = 18.sp) },
                navigationIcon = { IconButton(onClick = onOpenDrawer) { Icon(Icons.Default.Menu, "Menu") } },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = GreenPrimary, titleContentColor = Color.White, navigationIconContentColor = Color.White)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Welcome
            Box(Modifier.fillMaxWidth().background(GreenPrimary).padding(horizontal = 24.dp, vertical = 28.dp)) {
                Column {
                    Text("Welcome back,", style = MaterialTheme.typography.titleMedium, color = Color.White.copy(alpha = 0.85f))
                    Text(userName, style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold, fontSize = 28.sp), color = Color.White)
                    Spacer(Modifier.height(4.dp))
                    Text("Let's cook something healthy today!", style = MaterialTheme.typography.bodyMedium, color = Color.White.copy(alpha = 0.75f))
                }
            }

            // AI Suggestion - clickable
            Card(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 12.dp).clickable { onNavigate(Screen.AIAssistant.route) },
                shape = RoundedCornerShape(16.dp), colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F8FF))
            ) {
                Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.Top) {
                    Box(modifier = Modifier.size(48.dp).background(GreenPrimary.copy(alpha = 0.15f), RoundedCornerShape(12.dp)), contentAlignment = Alignment.Center) {
                        Icon(Icons.Default.SmartToy, null, tint = GreenPrimary, modifier = Modifier.size(28.dp))
                    }
                    Spacer(Modifier.size(12.dp))
                    Column(Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.AutoAwesome, null, tint = OrangeSecondary, modifier = Modifier.size(18.dp))
                            Spacer(Modifier.size(6.dp))
                            Text("AI Recommendation", style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold), color = Color(0xFF333333))
                            Spacer(Modifier.weight(1f))
                            Text("Open >", style = MaterialTheme.typography.labelSmall, color = GreenPrimary, fontWeight = FontWeight.Bold)
                        }
                        Spacer(Modifier.height(6.dp))
                        Text(aiSuggestion.ifEmpty { aiSuggestions.first() }, style = MaterialTheme.typography.bodyMedium, color = Color(0xFF555555))
                    }
                }
            }

            // Daily Pick - real Spoonacular recipe with real image
            Card(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).height(200.dp),
                shape = RoundedCornerShape(16.dp), elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Box(Modifier.fillMaxSize()) {
                    AsyncImage(model = pickImage, contentDescription = null, modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                    Box(Modifier.fillMaxSize().background(Color.Black.copy(alpha = 0.4f)))
                    Column(Modifier.fillMaxSize().padding(20.dp), verticalArrangement = Arrangement.Bottom) {
                        Text("TODAY'S PICK", style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold, letterSpacing = 2.sp), color = Color.White.copy(alpha = 0.9f))
                        Spacer(Modifier.height(6.dp))
                        Text(pickTitle, style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold), color = Color.White)
                        Spacer(Modifier.height(10.dp))
                        Button(onClick = { if (pickId.isNotBlank()) onNavigate(Screen.RecipeDetail.createRoute(pickId)) },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White), shape = RoundedCornerShape(20.dp), enabled = pickId.isNotBlank()) {
                            Text("View Recipe", color = GreenPrimary, fontWeight = FontWeight.Medium)
                        }
                    }
                }
            }

            // Context summary
            Card(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp), shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = GreenPrimary.copy(alpha = 0.08f))) {
                Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
                    Text(contextSummary, style = MaterialTheme.typography.bodySmall, color = Color(0xFF555555))
                }
            }

            Spacer(Modifier.height(8.dp))
            Text("Quick Actions", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold, color = Color(0xFF333333)), modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp))
            Spacer(Modifier.height(12.dp))

            Row(Modifier.fillMaxWidth().padding(horizontal = 16.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Button(onClick = { onNavigate(Screen.Recipes.route) }, modifier = Modifier.weight(1f).height(64.dp), shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = GreenPrimary)) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(Icons.Outlined.Explore, null, tint = Color.White, modifier = Modifier.size(24.dp))
                        Text("Browse", color = Color.White, fontWeight = FontWeight.Medium, fontSize = 11.sp)
                    }
                }
                Button(onClick = { onNavigate(Screen.Favorites.route) }, modifier = Modifier.weight(1f).height(64.dp), shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = OrangeSecondary)) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(Icons.Outlined.FavoriteBorder, null, tint = Color.White, modifier = Modifier.size(24.dp))
                        Text("Favorites", color = Color.White, fontWeight = FontWeight.Medium, fontSize = 11.sp)
                    }
                }
                Button(onClick = { onNavigate(Screen.AddRecipe.route) }, modifier = Modifier.weight(1f).height(64.dp), shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = GreenPrimary)) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(Icons.Outlined.AddCircleOutline, null, tint = Color.White, modifier = Modifier.size(24.dp))
                        Text("Add", color = Color.White, fontWeight = FontWeight.Medium, fontSize = 11.sp)
                    }
                }
            }

            Spacer(Modifier.height(24.dp))
            Card(Modifier.fillMaxWidth().padding(horizontal = 16.dp), shape = RoundedCornerShape(12.dp), colors = CardDefaults.cardColors(containerColor = GreenPrimary.copy(alpha = 0.05f))) {
                Text("\"Healthy eating is a way of life, not a diet. Let's make every meal count!\"",
                    style = MaterialTheme.typography.bodyMedium.copy(fontStyle = androidx.compose.ui.text.font.FontStyle.Italic),
                    color = Color(0xFF666666), textAlign = TextAlign.Center, modifier = Modifier.padding(16.dp))
            }
            Spacer(Modifier.height(24.dp))
        }
    }
}
