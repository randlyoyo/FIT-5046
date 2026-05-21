package edu.monash.fit5046.healthyrecipehub.ui.viewmodel

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import edu.monash.fit5046.healthyrecipehub.data.model.Recipe
import edu.monash.fit5046.healthyrecipehub.data.model.Resource
import edu.monash.fit5046.healthyrecipehub.data.model.Result
import edu.monash.fit5046.healthyrecipehub.data.model.Ingredient
import edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularApiService
import edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularRecipeSummary
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.util.UUID

class RecipeViewModel(application: Application) : AndroidViewModel(application) {

    private val firestore = FirebaseFirestore.getInstance()
    private val storage = FirebaseStorage.getInstance()
    private val auth = FirebaseAuth.getInstance()
    private val spoon = SpoonacularApiService.getInstance()
    private val apiKey = SpoonacularApiService.API_KEY

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
            try {
                val resp = spoon.searchRecipes(apiKey, "", addInfo = true, addNutrition = true, number = 30)
                _recipes.value = Resource.success(resp.results ?: emptyList())
            } catch (e: Exception) {
                _recipes.value = Resource.error(e.message ?: "Failed")
            }
        }
    }

    fun loadDailyPick() {
        viewModelScope.launch {
            try {
                val resp = spoon.getRandomRecipes(apiKey, 1)
                resp.recipes?.firstOrNull()?.let { r ->
                    _dailyPick.value = Resource.success(SpoonacularRecipeSummary(r.id, r.title, r.image, null,
                        r.nutrition?.let { edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularNutritionSummary(it.nutrients) }))
                }
            } catch (_: Exception) { }
        }
    }

    /** Clean HTML from Spoonacular summary text */
    private fun cleanHtml(text: String?): String {
        if (text == null) return ""
        return text
            .replace(Regex("<[^>]*>"), "")           // Remove HTML tags
            .replace("&amp;", "&")                    // HTML entities
            .replace("&lt;", "<")
            .replace("&gt;", ">")
            .replace("&quot;", "\"")
            .replace("&#39;", "'")
            .replace("&nbsp;", " ")
            .replace(Regex("\\s+"), " ")              // Collapse whitespace
            .trim()
    }

    fun loadRecipeById(recipeId: String) {
        viewModelScope.launch {
            _currentRecipe.value = Resource.loading()
            try {
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

                    val cleanDesc = cleanHtml(detail.summary).take(300)

                    val difficulty = when { detail.readyInMinutes <= 20 -> "Easy"; detail.readyInMinutes <= 45 -> "Medium"; else -> "Hard" }

                    _currentRecipe.value = Resource.success(Recipe(
                        id = recipeId, title = detail.title,
                        description = cleanDesc.ifEmpty { "A delicious meal" },
                        imageUrl = detail.image,
                        calories = calories, protein = protein, carbs = carbs, fat = fat,
                        prepTime = 5, cookTime = detail.readyInMinutes,
                        servings = detail.servings, difficulty = difficulty,
                        category = detail.dishTypes?.firstOrNull()?.replaceFirstChar { it.uppercase() } ?: "Main Course",
                        cuisine = detail.cuisines?.firstOrNull() ?: "International",
                        dietaryTags = detail.diets?.filter { it.isNotBlank() } ?: emptyList(),
                        ingredients = ingredients, instructions = instructions,
                        nutritionScore = if (calories > 0) ((protein * 4 / calories * 100).coerceIn(0.0, 100.0) * 100).toInt() / 100.0 else 70.0
                    ))
                } else {
                    val doc = firestore.collection("recipes").document(recipeId).get().await()
                    if (doc.exists()) {
                        val r = doc.data ?: emptyMap()
                        _currentRecipe.value = Resource.success(Recipe(
                            id = r["id"] as? String ?: recipeId, title = r["title"] as? String ?: "",
                            description = r["description"] as? String ?: "", imageUrl = r["imageUrl"] as? String,
                            calories = (r["calories"] as? Long)?.toInt() ?: 0, difficulty = r["difficulty"] as? String ?: "Medium",
                            authorId = r["authorId"] as? String ?: "", authorName = r["authorName"] as? String ?: ""
                        ))
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
                    Recipe(id = d["id"] as? String ?: doc.id, title = d["title"] as? String ?: "",
                        description = d["description"] as? String ?: "", imageUrl = d["imageUrl"] as? String,
                        calories = (d["calories"] as? Long)?.toInt() ?: 0, difficulty = d["difficulty"] as? String ?: "Medium")
                })
            } catch (e: Exception) { _favorites.value = Resource.error(e.message ?: "Failed") }
        }
    }

    fun toggleFavorite(recipe: Recipe, add: Boolean) {
        viewModelScope.launch {
            val uid = auth.currentUser?.uid ?: run { _operationResult.value = Result.Error(Exception("Auth"), "Please login first"); return@launch }
            try {
                val ref = firestore.collection("users").document(uid).collection("favorites")
                if (add) ref.document(recipe.id).set(mapOf("id" to recipe.id, "title" to recipe.title,
                    "imageUrl" to (recipe.imageUrl ?: ""), "calories" to recipe.calories,
                    "description" to recipe.description, "difficulty" to recipe.difficulty)).await()
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
}
