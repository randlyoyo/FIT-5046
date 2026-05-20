package edu.monash.fit5046.healthyrecipehub.ui.screens.recipes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import edu.monash.fit5046.healthyrecipehub.data.model.Recipe
import edu.monash.fit5046.healthyrecipehub.ui.navigation.Screen
import edu.monash.fit5046.healthyrecipehub.ui.theme.GreenPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipesScreen(
    onNavigate: (String) -> Unit,
    onOpenDrawer: () -> Unit,
    recipes: List<Recipe> = emptyList(),
    onToggleFavorite: (String, Boolean) -> Unit = { _, _ -> }
) {
    var searchQuery by remember { mutableStateOf("") }
    val filteredRecipes = remember(searchQuery, recipes) {
        if (searchQuery.isBlank()) recipes
        else recipes.filter { it.title.contains(searchQuery, ignoreCase = true) ||
            it.description?.contains(searchQuery, ignoreCase = true) == true }
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Recipes", fontWeight = FontWeight.Bold) },
                navigationIcon = { IconButton(onClick = onOpenDrawer) { Icon(Icons.Default.Menu, "Menu") } },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = GreenPrimary,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White))
        }
    ) { paddingValues ->
        Column(Modifier.fillMaxSize().padding(paddingValues)) {
            // Search bar with rounded shape
            Box(Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 12.dp)) {
                androidx.compose.material3.OutlinedTextField(
                    value = searchQuery, onValueChange = { searchQuery = it },
                    placeholder = { Text("Search recipes...", color = Color.Gray) },
                    leadingIcon = { Icon(Icons.Default.Search, null, tint = GreenPrimary) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    singleLine = true,
                    colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xFFE0E0E0),
                        focusedBorderColor = GreenPrimary))
            }

            if (filteredRecipes.isEmpty()) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(if (searchQuery.isBlank()) "No recipes yet\nTap + to add your first recipe!" else "No results for \"$searchQuery\"",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Gray, textAlign = TextAlign.Center)
                }
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(filteredRecipes, key = { it.id }) { recipe ->
                        RecipeGridCard(recipe = recipe, onClick = {
                            onNavigate(Screen.RecipeDetail.createRoute(recipe.id))
                        }, onToggleFavorite = { onToggleFavorite(recipe.id, !recipe.isFavorite) })
                    }
                }
            }
        }
    }
}

@Composable
fun RecipeGridCard(recipe: Recipe, onClick: () -> Unit, onToggleFavorite: () -> Unit = {}) {
    Card(onClick = onClick, modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)) {
        Column {
            Box(Modifier.fillMaxWidth().height(120.dp)) {
                AsyncImage(model = recipe.imageUrl ?: "", contentDescription = recipe.title,
                    modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)),
                    contentScale = ContentScale.Crop)
                // Favorite button overlay
                Box(Modifier.align(Alignment.TopEnd).padding(4.dp)) {
                    IconButton(onClick = onToggleFavorite, modifier = Modifier.size(28.dp).background(
                        Color.Black.copy(alpha = 0.2f), RoundedCornerShape(14.dp))) {
                        Icon(
                            if (recipe.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            "Favorite", tint = Color.White, modifier = Modifier.size(18.dp))
                    }
                }
            }
            Column(Modifier.padding(10.dp)) {
                Text(recipe.title, style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.Bold, fontSize = 14.sp),
                    maxLines = 1, overflow = TextOverflow.Ellipsis, color = Color(0xFF333333))
                Spacer(Modifier.height(3.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("${recipe.calories} cal", style = MaterialTheme.typography.labelSmall.copy(
                        fontSize = 11.sp, fontWeight = FontWeight.Medium), color = GreenPrimary)
                    Spacer(Modifier.width(6.dp))
                    Text(recipe.difficulty, style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp),
                        color = Color.Gray)
                }
            }
        }
    }
}
