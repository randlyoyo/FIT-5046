package edu.monash.fit5046.healthyrecipehub.ui.viewmodel

import android.app.Application
import android.net.Uri
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import edu.monash.fit5046.healthyrecipehub.data.SampleDataProvider
import edu.monash.fit5046.healthyrecipehub.data.local.database.AppDatabase
import edu.monash.fit5046.healthyrecipehub.data.model.Recipe
import edu.monash.fit5046.healthyrecipehub.data.model.Resource
import edu.monash.fit5046.healthyrecipehub.data.model.Result
import edu.monash.fit5046.healthyrecipehub.data.model.Ingredient
import edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularNutrient
import edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularNutritionSummary
import edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularApiService
import edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularRecipeSummary
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.util.UUID

class RecipeViewModel(application: Application) : AndroidViewModel(application) {
    companion object {
        private const val TAG = "RecipeViewModel"
        private const val FALLBACK_MESSAGE = "Showing offline sample recipes because Spoonacular is unavailable."
    }

    private data class FavoriteNutritionSnapshot(
        val calories: Int,
        val protein: Double,
        val carbs: Double,
        val fat: Double,
        val fiber: Double,
        val category: String,
        val difficulty: String
    )

    private val firestore = FirebaseFirestore.getInstance()
    private val storage = FirebaseStorage.getInstance()
    private val auth = FirebaseAuth.getInstance()
    private val spoon = SpoonacularApiService.getInstance()
    private val apiKey = SpoonacularApiService.API_KEY
    private val database = AppDatabase.getDatabase(application)
    private val fallbackRecipeCache = linkedMapOf<String, Recipe>()

    private val _recipes = MutableLiveData<Resource<List<SpoonacularRecipeSummary>>>()
    val recipes: LiveData<Resource<List<SpoonacularRecipeSummary>>> = _recipes

    private val _dailyPick = MutableLiveData<Resource<SpoonacularRecipeSummary>>()
    val dailyPick: LiveData<Resource<SpoonacularRecipeSummary>> = _dailyPick

    private val _currentRecipe = MutableLiveData<Resource<Recipe>>()
    val currentRecipe: LiveData<Resource<Recipe>> = _currentRecipe

    private val _favorites = MutableLiveData<Resource<List<Recipe>>>()
    val favorites: LiveData<Resource<List<Recipe>>> = _favorites

    private val _operationResult = MutableLiveData<Result<String>>()
    val operationResult: LiveData<Result<String>> = _operationResult

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init { loadRecipes(); loadDailyPick() }

    fun loadRecipes() {
        viewModelScope.launch {
            _recipes.value = Resource.loading()
            if (apiKey.isBlank()) {
                val fallbackRecipes = loadFallbackRecipeSummaries()
                Log.w(TAG, "Spoonacular API key missing. Falling back to local recipes.")
                _recipes.value = Resource.error(FALLBACK_MESSAGE, fallbackRecipes)
                return@launch
            }

            try {
                val resp = spoon.searchRecipes(apiKey, "", addInfo = true, addNutrition = true, number = 30)
                val results = resp.results.orEmpty()
                if (results.isNotEmpty()) {
                    fallbackRecipeCache.clear()
                    _recipes.value = Resource.success(results)
                } else {
                    val fallbackRecipes = loadFallbackRecipeSummaries()
                    Log.w(TAG, "Spoonacular returned an empty recipe list. Falling back to local recipes.")
                    _recipes.value = Resource.error(FALLBACK_MESSAGE, fallbackRecipes)
                }
            } catch (e: Exception) {
                val fallbackRecipes = loadFallbackRecipeSummaries()
                Log.e(TAG, "Failed to load Spoonacular recipes. Falling back to local recipes.", e)
                _recipes.value = Resource.error(FALLBACK_MESSAGE, fallbackRecipes)
            }
        }
    }

    fun loadDailyPick() {
        viewModelScope.launch {
            try {
                val resp = spoon.getRandomRecipes(apiKey, 1)
                resp.recipes?.firstOrNull()?.let { r ->
                    _dailyPick.value = Resource.success(
                        SpoonacularRecipeSummary(r.id, r.title, r.image, null,
                            r.nutrition?.let { edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularNutritionSummary(it.nutrients) })
                    )
                }
            } catch (_: Exception) { }
        }
    }

    private fun cleanHtml(text: String?): String {
        if (text == null) return ""
        return text.replace(Regex("<[^>]*>"), "").replace("&amp;", "&")
            .replace("&lt;", "<").replace("&gt;", ">")
            .replace("&quot;", "\"").replace("&#39;", "'")
            .replace("&nbsp;", " ").replace(Regex("\\s+"), " ").trim()
    }

    fun loadRecipeById(recipeId: String) {
        viewModelScope.launch {
            _currentRecipe.value = Resource.loading()
            try {
                fallbackRecipeCache[recipeId]?.let { cachedRecipe ->
                    _currentRecipe.value = Resource.success(cachedRecipe)
                    return@launch
                }

                val id = recipeId.toIntOrNull()
                if (id != null) {
                    val detail = spoon.getRecipeInfo(id, apiKey, includeNutrition = true)
                    var calories = 0; var protein = 0.0; var carbs = 0.0; var fat = 0.0
                    detail.nutrition?.nutrients?.forEach { n ->
                        when (n.name?.lowercase()) {
                            "calories" -> calories = n.amount.toInt()
                            "protein" -> protein = n.amount
                            "carbohydrates" -> carbs = n.amount
                            "fat" -> fat = n.amount
                        }
                    }
                    val ingredients = detail.extendedIngredients?.map { ing ->
                        Ingredient(name = ing.name.replaceFirstChar { it.uppercase() }, amount = ing.amount, unit = ing.unit ?: "unit")
                    } ?: emptyList()
                    val instructions = detail.analyzedInstructions?.flatMap { instr ->
                        instr.steps?.map { it.step } ?: emptyList()
                    } ?: emptyList()
                    val difficulty = when { detail.readyInMinutes <= 20 -> "Easy"; detail.readyInMinutes <= 45 -> "Medium"; else -> "Hard" }
                    _currentRecipe.value = Resource.success(Recipe(id = recipeId, title = detail.title,
                        description = cleanHtml(detail.summary).take(300).ifEmpty { "A delicious meal" }, imageUrl = detail.image,
                        calories = calories, protein = protein, carbs = carbs, fat = fat,
                        prepTime = 5, cookTime = detail.readyInMinutes, servings = detail.servings, difficulty = difficulty,
                        category = detail.dishTypes?.firstOrNull()?.replaceFirstChar { it.uppercase() } ?: "Main Course",
                        cuisine = detail.cuisines?.firstOrNull() ?: "International",
                        dietaryTags = detail.diets?.filter { it.isNotBlank() } ?: emptyList(),
                        ingredients = ingredients, instructions = instructions,
                        nutritionScore = if (calories > 0) ((protein * 4 / calories * 100).coerceIn(0.0, 100.0) * 100).toInt() / 100.0 else 70.0))
                } else {
                    val doc = firestore.collection("recipes").document(recipeId).get().await()
                    if (doc.exists()) {
                        val r = doc.data ?: emptyMap()
                        _currentRecipe.value = Resource.success(Recipe(id = r["id"] as? String ?: recipeId, title = r["title"] as? String ?: "",
                            description = r["description"] as? String ?: "", imageUrl = r["imageUrl"] as? String,
                            calories = (r["calories"] as? Long)?.toInt() ?: 0, difficulty = r["difficulty"] as? String ?: "Medium",
                            authorId = r["authorId"] as? String ?: "", authorName = r["authorName"] as? String ?: ""))
                    } else { _currentRecipe.value = Resource.error("Recipe not found") }
                }
            } catch (e: Exception) { _currentRecipe.value = Resource.error(e.message ?: "Error") }
        }
    }

    fun loadFavorites() {
        viewModelScope.launch {
            _favorites.value = Resource.loading()
            val uid = auth.currentUser?.uid ?: run { _favorites.value = Resource.error("Please login first"); return@launch }
            try {
                val snap = firestore.collection("users").document(uid).collection("favorites").get().await()
                _favorites.value = Resource.success(snap.documents.mapNotNull { doc ->
                    val d = doc.data ?: return@mapNotNull null
                    val title = d["title"] as? String ?: ""
                    val snapshot = estimateFavoriteNutrition(
                        title = title,
                        category = d["category"] as? String,
                        difficulty = d["difficulty"] as? String,
                        calories = (d["calories"] as? Number)?.toInt(),
                        protein = (d["protein"] as? Number)?.toDouble(),
                        carbs = (d["carbs"] as? Number)?.toDouble(),
                        fat = (d["fat"] as? Number)?.toDouble(),
                        fiber = (d["fiber"] as? Number)?.toDouble()
                    )

                    Recipe(
                        id = d["id"] as? String ?: doc.id,
                        title = title,
                        description = d["description"] as? String ?: "",
                        imageUrl = d["imageUrl"] as? String,
                        calories = snapshot.calories,
                        protein = snapshot.protein,
                        carbs = snapshot.carbs,
                        fat = snapshot.fat,
                        fiber = snapshot.fiber,
                        category = snapshot.category,
                        difficulty = snapshot.difficulty
                    )
                })
            } catch (e: Exception) { _favorites.value = Resource.error(e.message ?: "Failed") }
        }
    }

    fun toggleFavorite(recipe: Recipe, add: Boolean) {
        viewModelScope.launch {
            val uid = auth.currentUser?.uid ?: run { _operationResult.value = Result.Error(Exception("Auth"), "Please login first"); return@launch }
            try {
                val ref = firestore.collection("users").document(uid).collection("favorites")
                if (add) {
                    val snapshot = estimateFavoriteNutrition(
                        title = recipe.title,
                        category = recipe.category,
                        difficulty = recipe.difficulty,
                        calories = recipe.calories,
                        protein = recipe.protein,
                        carbs = recipe.carbs,
                        fat = recipe.fat,
                        fiber = recipe.fiber
                    )
                    ref.document(recipe.id).set(
                        mapOf(
                            "id" to recipe.id,
                            "title" to recipe.title,
                            "imageUrl" to (recipe.imageUrl ?: ""),
                            "description" to recipe.description,
                            "calories" to snapshot.calories,
                            "protein" to snapshot.protein,
                            "carbs" to snapshot.carbs,
                            "fat" to snapshot.fat,
                            "fiber" to snapshot.fiber,
                            "category" to snapshot.category,
                            "difficulty" to snapshot.difficulty
                        )
                    ).await()
                }
                else ref.document(recipe.id).delete().await()
                _operationResult.value = Result.Success(if (add) "Added" else "Removed"); loadFavorites()
            } catch (e: Exception) { _operationResult.value = Result.Error(e, e.message ?: "Failed") }
        }
    }

    fun createRecipe(title: String, description: String, ingredients: String, instructions: String, calories: Int, imageUri: Uri? = null) {
        viewModelScope.launch {
            _isLoading.value = true
            val uid = auth.currentUser?.uid; val name = auth.currentUser?.displayName ?: "User"
            if (uid == null) { _operationResult.value = Result.Error(Exception("Auth"), "Please login first"); _isLoading.value = false; return@launch }
            try {
                var imageUrl = ""
                if (imageUri != null) {
                    val ref = storage.reference.child("recipe_images/${UUID.randomUUID()}.jpg")
                    ref.putFile(imageUri).await(); imageUrl = ref.downloadUrl.await().toString()
                }
                val id = "recipe_${System.currentTimeMillis()}"
                firestore.collection("recipes").document(id).set(mapOf("id" to id, "title" to title.trim(),
                    "description" to description.trim(), "imageUrl" to imageUrl, "calories" to calories,
                    "difficulty" to "Medium", "authorId" to uid, "authorName" to name,
                    "createdAt" to System.currentTimeMillis())).await()
                _operationResult.value = Result.Success("Recipe saved!")
            } catch (e: Exception) { _operationResult.value = Result.Error(e, e.message ?: "Failed") }
            _isLoading.value = false
        }
    }

    private suspend fun loadFallbackRecipeSummaries(): List<SpoonacularRecipeSummary> {
        val localRecipes = runCatching { database.recipeDao().getAllRecipesSync() }
            .onFailure { Log.e(TAG, "Failed to read fallback recipes from Room.", it) }
            .getOrDefault(emptyList())
            .ifEmpty { SampleDataProvider.getSampleRecipes() }

        fallbackRecipeCache.clear()
        return localRecipes.mapIndexed { index, recipe ->
            val fallbackId = -1000 - index
            fallbackRecipeCache[fallbackId.toString()] = recipe.copy(id = fallbackId.toString())
            SpoonacularRecipeSummary(
                id = fallbackId,
                title = recipe.title,
                image = recipe.imageUrl,
                imageType = null,
                nutrition = SpoonacularNutritionSummary(
                    nutrients = listOf(
                        SpoonacularNutrient(name = "Calories", amount = recipe.calories.toDouble(), unit = "kcal"),
                        SpoonacularNutrient(name = "Protein", amount = recipe.protein, unit = "g"),
                        SpoonacularNutrient(name = "Carbohydrates", amount = recipe.carbs, unit = "g"),
                        SpoonacularNutrient(name = "Fat", amount = recipe.fat, unit = "g")
                    )
                )
            )
        }
    }

    private fun estimateFavoriteNutrition(
        title: String,
        category: String?,
        difficulty: String?,
        calories: Int?,
        protein: Double?,
        carbs: Double?,
        fat: Double?,
        fiber: Double?
    ): FavoriteNutritionSnapshot {
        val titleLower = title.lowercase()
        val normalizedCategory = category?.takeIf { it.isNotBlank() } ?: when {
            titleLower.contains("breakfast") || titleLower.contains("oats") || titleLower.contains("toast") || titleLower.contains("parfait") -> "Breakfast"
            titleLower.contains("dessert") || titleLower.contains("cake") || titleLower.contains("cookie") || titleLower.contains("ice cream") -> "Dessert"
            titleLower.contains("snack") || titleLower.contains("bite") || titleLower.contains("bar") -> "Snack"
            titleLower.contains("salad") || titleLower.contains("vegetable") -> "Salad"
            else -> "Main Course"
        }
        val normalizedDifficulty = difficulty?.takeIf { it.isNotBlank() } ?: when {
            normalizedCategory == "Breakfast" || normalizedCategory == "Snack" || normalizedCategory == "Salad" -> "Easy"
            titleLower.contains("stew") || titleLower.contains("roast") || titleLower.contains("braised") -> "Hard"
            else -> "Medium"
        }

        val fallback = when {
            titleLower.contains("salad") || titleLower.contains("vegetable") ->
                FavoriteNutritionSnapshot(260, 10.0, 30.0, 9.0, 8.0, "Salad", "Easy")
            titleLower.contains("chicken") || titleLower.contains("salmon") || titleLower.contains("beef") ->
                FavoriteNutritionSnapshot(560, 38.0, 35.0, 22.0, 5.0, "Main Course", "Medium")
            normalizedCategory == "Breakfast" ->
                FavoriteNutritionSnapshot(350, 18.0, 42.0, 10.0, 6.0, "Breakfast", "Easy")
            normalizedCategory == "Snack" ->
                FavoriteNutritionSnapshot(220, 8.0, 24.0, 9.0, 4.0, "Snack", "Easy")
            normalizedCategory == "Dessert" ->
                FavoriteNutritionSnapshot(300, 6.0, 45.0, 12.0, 3.0, "Dessert", "Medium")
            else ->
                FavoriteNutritionSnapshot(520, 32.0, 48.0, 18.0, 7.0, "Main Course", "Medium")
        }

        return FavoriteNutritionSnapshot(
            calories = calories?.takeIf { it > 0 } ?: fallback.calories,
            protein = protein?.takeIf { it > 0.0 } ?: fallback.protein,
            carbs = carbs?.takeIf { it > 0.0 } ?: fallback.carbs,
            fat = fat?.takeIf { it > 0.0 } ?: fallback.fat,
            fiber = fiber?.takeIf { it > 0.0 } ?: fallback.fiber,
            category = normalizedCategory.ifBlank { fallback.category },
            difficulty = normalizedDifficulty.ifBlank { fallback.difficulty }
        )
    }
}
