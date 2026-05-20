package edu.monash.fit5046.healthyrecipehub.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import edu.monash.fit5046.healthyrecipehub.context.TimeContextSimulator
import edu.monash.fit5046.healthyrecipehub.ui.navigation.Screen
import edu.monash.fit5046.healthyrecipehub.ui.theme.GreenPrimary
import edu.monash.fit5046.healthyrecipehub.ui.theme.OrangeSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigate: (String) -> Unit,
    onOpenDrawer: () -> Unit,
    userName: String = "User"
) {
    val contextSimulator = remember { TimeContextSimulator() }
    val contextMessage = remember { contextSimulator.getContextMessage() }
    val recommendation = remember { contextSimulator.getPrimaryRecommendation() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Healthy Recipe Hub", fontWeight = FontWeight.Bold, fontSize = 18.sp) },
                navigationIcon = {
                    IconButton(onClick = onOpenDrawer) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = GreenPrimary,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Welcome section
            Box(Modifier.fillMaxWidth().background(GreenPrimary).padding(horizontal = 24.dp, vertical = 28.dp)) {
                Column {
                    Text("Welcome back,", style = MaterialTheme.typography.titleMedium, color = Color.White.copy(alpha = 0.85f))
                    Text(userName, style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold, fontSize = 28.sp), color = Color.White)
                    Spacer(Modifier.height(4.dp))
                    Text("Let's cook something healthy today!", style = MaterialTheme.typography.bodyMedium, color = Color.White.copy(alpha = 0.75f))
                }
            }

            Spacer(Modifier.height(24.dp))

            // Today's Pick card with background image
            Card(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).height(200.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Box(Modifier.fillMaxSize()) {
                    AsyncImage(
                        model = "https://picsum.photos/seed/food/800/400",
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    Box(Modifier.fillMaxSize().background(Color.Black.copy(alpha = 0.45f)))
                    Column(Modifier.fillMaxSize().padding(20.dp), verticalArrangement = Arrangement.Bottom) {
                        Text("TODAY'S PICK", style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold, letterSpacing = 2.sp), color = Color.White.copy(alpha = 0.9f))
                        Spacer(Modifier.height(6.dp))
                        Text(recommendation.name, style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold), color = Color.White)
                        Text("${recommendation.calories} kcal", style = MaterialTheme.typography.bodyMedium, color = Color.White.copy(alpha = 0.85f))
                        Spacer(Modifier.height(10.dp))
                        Button(onClick = { onNavigate(Screen.Recipes.route) },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                            shape = RoundedCornerShape(20.dp)) {
                            Text("View Recipe", color = GreenPrimary, fontWeight = FontWeight.Medium)
                        }
                    }
                }
            }

            Spacer(Modifier.height(24.dp))

            // Quick Actions
            Text("Quick Actions", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold, color = Color(0xFF333333)),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp))
            Spacer(Modifier.height(12.dp))

            Row(Modifier.fillMaxWidth().padding(horizontal = 16.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                // Browse
                Button(onClick = { onNavigate(Screen.Recipes.route) },
                    modifier = Modifier.weight(1f).height(64.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = GreenPrimary.copy(alpha = 0.08f))) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(Icons.Outlined.Explore, null, tint = GreenPrimary, modifier = Modifier.size(24.dp))
                        Text("Browse", color = GreenPrimary, fontWeight = FontWeight.Medium, fontSize = 11.sp)
                    }
                }
                // Favorites
                Button(onClick = { onNavigate(Screen.Favorites.route) },
                    modifier = Modifier.weight(1f).height(64.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = OrangeSecondary.copy(alpha = 0.08f))) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(Icons.Outlined.FavoriteBorder, null, tint = OrangeSecondary, modifier = Modifier.size(24.dp))
                        Text("Favorites", color = OrangeSecondary, fontWeight = FontWeight.Medium, fontSize = 11.sp)
                    }
                }
                // Add Recipe
                Button(onClick = { onNavigate(Screen.AddRecipe.route) },
                    modifier = Modifier.weight(1f).height(64.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = GreenPrimary.copy(alpha = 0.08f))) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(Icons.Outlined.AddCircleOutline, null, tint = GreenPrimary, modifier = Modifier.size(24.dp))
                        Text("Add", color = GreenPrimary, fontWeight = FontWeight.Medium, fontSize = 11.sp)
                    }
                }
            }

            Spacer(Modifier.height(24.dp))

            // Motivational quote
            Card(Modifier.fillMaxWidth().padding(horizontal = 16.dp), shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = GreenPrimary.copy(alpha = 0.05f))) {
                Text("\"Healthy eating is a way of life, not a diet. Let's make every meal count!\"",
                    style = MaterialTheme.typography.bodyMedium.copy(fontStyle = androidx.compose.ui.text.font.FontStyle.Italic),
                    color = Color(0xFF666666), textAlign = TextAlign.Center, modifier = Modifier.padding(16.dp))
            }

            Spacer(Modifier.height(24.dp))
        }
    }
}
