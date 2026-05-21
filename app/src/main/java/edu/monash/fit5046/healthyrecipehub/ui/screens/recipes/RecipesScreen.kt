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
import edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularRecipeSummary
import edu.monash.fit5046.healthyrecipehub.ui.theme.GreenPrimary
import edu.monash.fit5046.healthyrecipehub.ui.theme.OrangeSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipesScreen(
    onNavigate: (String) -> Unit,
    onOpenDrawer: () -> Unit = {},
    recipes: List<SpoonacularRecipeSummary> = emptyList(),
    isLoading: Boolean = false,
    infoMessage: String? = null,
    isUsingFallbackData: Boolean = false,
    onRetry: () -> Unit = {},
    onToggleFavorite: (SpoonacularRecipeSummary, Boolean) -> Unit = { _, _ -> },
    favoriteIds: Set<String> = emptySet()
) {
    var searchQuery by remember { mutableStateOf("") }
    val filtered = remember(searchQuery, recipes) {
        if (searchQuery.isBlank()) recipes
        else recipes.filter { it.title.contains(searchQuery, ignoreCase = true) }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Recipes", fontWeight = FontWeight.Bold) },
                navigationIcon = { IconButton(onClick = onOpenDrawer) { Icon(Icons.Default.Menu, "Menu") } },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = GreenPrimary, titleContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        Column(Modifier.fillMaxSize().padding(paddingValues)) {
            if (isUsingFallbackData && !infoMessage.isNullOrBlank()) {
                AssistChip(
                    onClick = onRetry,
                    label = { Text(infoMessage) },
                    modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 12.dp),
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = Color(0xFFFFF3CD),
                        labelColor = Color(0xFF6B4F00)
                    )
                )
            }
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
            if (isLoading && recipes.isEmpty()) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator(color = GreenPrimary)
                        Spacer(Modifier.height(12.dp))
                        Text("Loading recipes from Spoonacular...", color = Color.Gray, textAlign = TextAlign.Center)
                    }
                }
            } else if (filtered.isEmpty()) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(
                        modifier = Modifier.padding(horizontal = 24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        val emptyMessage = when {
                            searchQuery.isNotBlank() -> "No results"
                            !infoMessage.isNullOrBlank() -> infoMessage
                            else -> "No recipes available right now."
                        }
                        Text(emptyMessage, color = Color.Gray, textAlign = TextAlign.Center)
                        Spacer(Modifier.height(12.dp))
                        OutlinedButton(onClick = onRetry) {
                            Text("Retry")
                        }
                    }
                }
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(filtered, key = { it.id }) { recipe ->
                        RecipeCard(
                            recipe = recipe,
                            isFavorite = recipe.id.toString() in favoriteIds,
                            onClick = { onNavigate("recipe/${recipe.id}") },
                            onToggleFavorite = { onToggleFavorite(recipe, recipe.id.toString() !in favoriteIds) }
                        )
                    }
                }
                if (!isUsingFallbackData && !infoMessage.isNullOrBlank()) {
                    Text(
                        text = infoMessage,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                        color = Color.Gray,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}

@Composable
private fun RecipeCard(
    recipe: SpoonacularRecipeSummary,
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
                    model = recipe.image?.let { "$it" },
                    contentDescription = recipe.title,
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
                Text(recipe.title, style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold, fontSize = 13.sp),
                    maxLines = 1, overflow = TextOverflow.Ellipsis, color = Color(0xFF333333))
                Spacer(Modifier.height(4.dp))
                Text("Spoonacular recipe", style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp), color = Color.Gray)
            }
        }
    }
}
