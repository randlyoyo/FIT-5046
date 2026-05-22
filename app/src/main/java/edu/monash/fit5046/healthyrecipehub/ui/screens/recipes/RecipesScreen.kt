package edu.monash.fit5046.healthyrecipehub.ui.screens.recipes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import edu.monash.fit5046.healthyrecipehub.data.remote.api.MealDto
import edu.monash.fit5046.healthyrecipehub.ui.theme.GreenPrimary
import edu.monash.fit5046.healthyrecipehub.ui.theme.OrangeSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipesScreen(
    onNavigate: (String) -> Unit,
    onOpenDrawer: () -> Unit = {},
    recipes: List<MealDto> = emptyList(),
    onToggleFavorite: (MealDto, Boolean) -> Unit = { _, _ -> },
    favoriteIds: Set<String> = emptySet()
) {
    var searchQuery by remember { mutableStateOf("") }
    val filtered = remember(searchQuery, recipes) {
        if (searchQuery.isBlank()) recipes
        else recipes.filter { it.strMeal.contains(searchQuery, ignoreCase = true) }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Recipes", fontWeight = FontWeight.Bold) },
                navigationIcon = { IconButton(onClick = onOpenDrawer) { Icon(Icons.Default.Menu, "Menu") } },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = GreenPrimary, titleContentColor = Color.White)
            )
        }
    ) { paddingValues ->
        Column(Modifier.fillMaxSize().padding(paddingValues)) {
            Box(Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 12.dp)) {
                OutlinedTextField(
                    value = searchQuery, onValueChange = { searchQuery = it },
                    placeholder = { Text("Search recipes...", color = Color.Gray) },
                    leadingIcon = { Icon(Icons.Default.Search, null, tint = GreenPrimary) },
                    modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(24.dp),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = Color(0xFFE0E0E0), focusedBorderColor = GreenPrimary)
                )
            }
            if (filtered.isEmpty()) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(if (searchQuery.isBlank()) "Loading recipes from TheMealDB..." else "No results", color = Color.Gray, textAlign = TextAlign.Center)
                }
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(filtered, key = { it.idMeal }) { meal ->
                        RecipeCard(
                            meal = meal,
                            isFavorite = meal.idMeal in favoriteIds,
                            onClick = { onNavigate("recipe/${meal.idMeal}") },
                            onToggleFavorite = { onToggleFavorite(meal, meal.idMeal !in favoriteIds) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun RecipeCard(
    meal: MealDto,
    isFavorite: Boolean,
    onClick: () -> Unit,
    onToggleFavorite: () -> Unit
) {
    Card(
        onClick = onClick, modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp), elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            Box(Modifier.fillMaxWidth().height(130.dp)) {
                AsyncImage(
                    model = meal.strMealThumb?.let { "$it/preview" },
                    contentDescription = meal.strMeal,
                    modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)),
                    contentScale = ContentScale.Crop
                )
                Box(Modifier.align(Alignment.TopEnd).padding(4.dp)) {
                    IconButton(onClick = onToggleFavorite, modifier = Modifier.size(28.dp)) {
                        Icon(
                            if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            "Favorite", tint = if (isFavorite) OrangeSecondary else Color.White, modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
            Column(Modifier.padding(10.dp)) {
                Text(meal.strMeal, style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold, fontSize = 13.sp),
                    maxLines = 1, overflow = TextOverflow.Ellipsis, color = Color(0xFF333333))
                Spacer(Modifier.height(2.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(meal.strCategory ?: "General", style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp), color = Color.Gray)
                    Spacer(Modifier.width(6.dp))
                    Text(meal.strArea ?: "", style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp), color = GreenPrimary)
                }
            }
        }
    }
}
