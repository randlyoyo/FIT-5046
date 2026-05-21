package edu.monash.fit5046.healthyrecipehub.ui.screens.recipe

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import edu.monash.fit5046.healthyrecipehub.data.model.Recipe
import edu.monash.fit5046.healthyrecipehub.data.model.Result
import edu.monash.fit5046.healthyrecipehub.data.model.Status
import edu.monash.fit5046.healthyrecipehub.ui.theme.GreenPrimary
import edu.monash.fit5046.healthyrecipehub.ui.theme.OrangeSecondary
import edu.monash.fit5046.healthyrecipehub.ui.viewmodel.AuthViewModel
import edu.monash.fit5046.healthyrecipehub.ui.viewmodel.RecipeViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailScreen(
    recipeId: String,
    onNavigateBack: () -> Unit,
    recipeViewModel: RecipeViewModel,
    authViewModel: AuthViewModel
) {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val context = LocalContext.current
    
    val currentRecipeResource by recipeViewModel.currentRecipe.observeAsState()
    val operationResult by recipeViewModel.operationResult.observeAsState()
    
    var currentRecipe by remember { mutableStateOf<Recipe?>(null) }
    var isFavorite by remember { mutableStateOf(false) }
    var showDeleteDialog by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }
    
    // Load recipe
    LaunchedEffect(recipeId) {
        recipeViewModel.loadRecipeById(recipeId)
    }
    
    // Handle recipe resource changes
    LaunchedEffect(currentRecipeResource) {
        currentRecipeResource?.let { resource ->
            when (resource.status) {
                Status.SUCCESS -> {
                    isLoading = false
                    resource.data?.let { recipe ->
                        currentRecipe = recipe
                        isFavorite = recipe.isFavorite
                    }
                }
                Status.ERROR -> {
                    isLoading = false
                    scope.launch {
                        snackbarHostState.showSnackbar("Error: ${resource.message}")
                    }
                }
                Status.LOADING -> isLoading = true
                else -> {}
            }
        }
    }
    
    // Handle operation results
    LaunchedEffect(operationResult) {
        when (operationResult) {
            is Result.Success -> {
                scope.launch {
                    snackbarHostState.showSnackbar(
                        if (isFavorite) "Added to favorites" else "Removed from favorites"
                    )
                }
            }
            is Result.Error -> {
                scope.launch {
                    snackbarHostState.showSnackbar("Error: ${(operationResult as Result.Error).message}")
                }
                // Revert UI state
                isFavorite = !isFavorite
            }
            else -> {}
        }
    }
    
    val canEdit = authViewModel.getCurrentUserId() == currentRecipe?.authorId || authViewModel.isAdmin()
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(currentRecipe?.title ?: "Recipe") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    if (canEdit) {
                        IconButton(onClick = { /* Edit */ }) {
                            Icon(Icons.Default.Edit, contentDescription = "Edit")
                        }
                    }
                    IconButton(
                        onClick = {
                            recipeViewModel.deleteRecipe(recipeId)
                            onNavigateBack()
                        }
                    ) {
                        Icon(Icons.Default.Delete, contentDescription = "Delete")
                    }
                    IconButton(
                        onClick = {
                            currentRecipe?.let { shareRecipe(context, it) }
                        }
                    ) {
                        Icon(Icons.Default.Share, contentDescription = "Share")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = GreenPrimary,
                    titleContentColor = androidx.compose.ui.graphics.Color.White,
                    navigationIconContentColor = androidx.compose.ui.graphics.Color.White,
                    actionIconContentColor = androidx.compose.ui.graphics.Color.White
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    isFavorite = !isFavorite
                    if (isFavorite) {
                        recipeViewModel.addToFavorites(recipeId)
                    } else {
                        recipeViewModel.removeFromFavorites(recipeId)
                    }
                },
                containerColor = OrangeSecondary
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite",
                    tint = androidx.compose.ui.graphics.Color.White
                )
            }
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        if (isLoading) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        } else {
            currentRecipe?.let { recipe ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp)
                ) {
                    // Description
                    Text(
                        text = recipe.description,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Nutrition Card
                    NutritionCard(recipe)
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Recipe Info Row
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        InfoItem("Time", "${recipe.prepTime + recipe.cookTime} min")
                        InfoItem("Servings", "${recipe.servings}")
                        InfoItem("Difficulty", recipe.difficulty)
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Tags
                    if (recipe.dietaryTags.isNotEmpty()) {
                        Text(
                            text = recipe.dietaryTags.joinToString(" • "),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                    
                    HorizontalDivider()
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Ingredients
                    Text(
                        text = "Ingredients",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    recipe.ingredients.forEach { ingredient ->
                        Text(
                            text = "• ${ingredient.name}: ${ingredient.amount} ${ingredient.unit}${if (ingredient.optional) " (optional)" else ""}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    HorizontalDivider()
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Instructions
                    Text(
                        text = "Instructions",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    recipe.instructions.forEachIndexed { index, instruction ->
                        Text(
                            text = "${index + 1}. $instruction",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Author
                    Text(
                        text = "By ${recipe.authorName}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                }
            } ?: run {
                // No recipe loaded
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Recipe not found")
                }
            }
        }
    }
    
    // Delete confirmation dialog
    if (showDeleteDialog) {
        AlertDialog(
            onDismissRequest = { showDeleteDialog = false },
            title = { Text("Delete Recipe") },
            text = { Text("Are you sure you want to delete this recipe?") },
            confirmButton = {
                TextButton(
                    onClick = {
                        recipeViewModel.deleteRecipe(recipeId)
                        showDeleteDialog = false
                        onNavigateBack()
                    }
                ) {
                    Text("Delete", color = MaterialTheme.colorScheme.error)
                }
            },
            dismissButton = {
                TextButton(onClick = { showDeleteDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
fun NutritionCard(recipe: Recipe) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Nutrition per serving",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                NutritionItem("${recipe.calories}", "kcal")
                NutritionItem("${recipe.protein}", "protein")
                NutritionItem("${recipe.carbs}", "carbs")
                NutritionItem("${recipe.fat}", "fat")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Health Score: ${recipe.nutritionScore}/100",
                style = MaterialTheme.typography.bodyMedium,
                color = GreenPrimary
            )
        }
    }
}

@Composable
fun NutritionItem(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = value, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        Text(text = label, style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
fun InfoItem(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = value, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        Text(text = label, style = MaterialTheme.typography.bodySmall)
    }
}

private fun shareRecipe(context: android.content.Context, recipe: Recipe) {
    val shareText = buildString {
        append("🍽️ ${recipe.title}\n\n")
        append("${recipe.description}\n\n")
        append("Nutrition per serving:\n")
        append("• ${recipe.calories} kcal\n")
        append("• ${recipe.protein}g protein\n")
        append("• ${recipe.carbs}g carbs\n")
        append("• ${recipe.fat}g fat\n\n")
        append("Shared from Healthy Recipe Hub")
    }
    
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, recipe.title)
        putExtra(Intent.EXTRA_TEXT, shareText)
    }
    context.startActivity(Intent.createChooser(intent, "Share Recipe"))
}
