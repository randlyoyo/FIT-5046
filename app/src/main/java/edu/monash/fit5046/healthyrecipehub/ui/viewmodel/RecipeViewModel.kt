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
import edu.monash.fit5046.healthyrecipehub.data.model.Recipe
import edu.monash.fit5046.healthyrecipehub.data.model.Resource
import edu.monash.fit5046.healthyrecipehub.data.model.Result
import edu.monash.fit5046.healthyrecipehub.data.model.Ingredient
import edu.monash.fit5046.healthyrecipehub.data.remote.api.MealDbApiService
import edu.monash.fit5046.healthyrecipehub.data.remote.api.MealDto
import edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularApiService
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.util.UUID

class RecipeViewModel(application: Application) : AndroidViewModel(application) {

    private val firestore = FirebaseFirestore.getInstance()
    private val storage = FirebaseStorage.getInstance()
    private val auth = FirebaseAuth.getInstance()
    private val mealDb = MealDbApiService.getInstance()
    private val spoon = SpoonacularApiService.getInstance()
    private val spoonKey = SpoonacularApiService.API_KEY

    private val _mealDbRecipes = MutableLiveData<Resource<List<MealDto>>>()
    val mealDbRecipes: LiveData<Resource<List<MealDto>>> = _mealDbRecipes

    private val _dailyPick = MutableLiveData<Resource<MealDto>>()
    val dailyPick: LiveData<Resource<MealDto>> = _dailyPick

    private val _currentRecipe = MutableLiveData<Resource<Recipe>>()
    val currentRecipe: LiveData<Resource<Recipe>> = _currentRecipe

    private val _favorites = MutableLiveData<Resource<List<Recipe>>>()
    val favorites: LiveData<Resource<List<Recipe>>> = _favorites

    private val _operationResult = MutableLiveData<Result<String>>()
    val operationResult: LiveData<Result<String>> = _operationResult

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init { loadMealDbRecipes(); loadDailyPick() }

    /** Load recipes from TheMealDB (free, no API key, no rate limit) */
    fun loadMealDbRecipes() {
        viewModelScope.launch {
            _mealDbRecipes.value = Resource.loading()
            try {
                val chicken = mealDb.filterByCategory("Chicken")
                val seafood = mealDb.filterByCategory("Seafood")
                val vegetarian = mealDb.filterByCategory("Vegetarian")
                val dessert = mealDb.filterByCategory("Dessert")
                val beef = mealDb.filterByCategory("Beef")
                val all = mutableListOf<MealDto>()
                chicken.meals?.let { all.addAll(it) }
                seafood.meals?.let { all.addAll(it) }
                vegetarian.meals?.let { all.addAll(it) }
                dessert.meals?.let { all.addAll(it) }
                beef.meals?.let { all.addAll(it) }
                _mealDbRecipes.value = Resource.success(all.distinctBy { it.idMeal })
            } catch (e: Exception) {
                _mealDbRecipes.value = Resource.error(e.message ?: "Failed")
            }
        }
    }

    /** Load daily pick from TheMealDB */
    fun loadDailyPick() {
        viewModelScope.launch {
            try {
                val resp = mealDb.getRandomMeal()
                resp.meals?.firstOrNull()?.let { _dailyPick.value = Resource.success(it) }
            } catch (_: Exception) { }
        }
    }

    /** Load recipe detail - try Spoonacular first (nutrition), fallback to TheMealDB */
    fun loadRecipeById(recipeId: String) {
        viewModelScope.launch {
            _currentRecipe.value = Resource.loading()
            try {
                if (recipeId.matches(Regex("^\\d+$")) && spoonKey.isNotBlank()) {
                    // Try Spoonacular for nutrition data
                    try {
                        val id = recipeId.toInt()
                        val detail = spoon.getRecipeInfo(id, spoonKey, includeNutrition = true)
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
                        _currentRecipe.value = Resource.success(Recipe(
                            id = recipeId, title = detail.title,
                            description = detail.summary?.replace(Regex("<[^>]*>"), "")?.take(300) ?: "",
                            imageUrl = detail.image, calories = calories, protein = protein, carbs = carbs, fat = fat,
                            prepTime = 5, cookTime = detail.readyInMinutes, servings = detail.servings, difficulty = difficulty,
                            category = detail.dishTypes?.firstOrNull()?.replaceFirstChar { it.uppercase() } ?: "Main Course",
                            cuisine = detail.cuisines?.firstOrNull() ?: "International",
                            dietaryTags = detail.diets?.filter { it.isNotBlank() } ?: emptyList(),
                            ingredients = ingredients, instructions = instructions
                        ))
                        return@launch
                    } catch (_: Exception) { /* Spoonacular failed, fall through to MealDB */ }
                }
                // Fallback: TheMealDB
                val resp = mealDb.lookupMealById(recipeId)
                val meal = resp.meals?.firstOrNull()
                if (meal != null) {
                    _currentRecipe.value = Resource.success(Recipe(
                        id = meal.idMeal, title = meal.strMeal,
                        description = meal.strCategory?.let { "$it dish" } ?: "",
                        imageUrl = meal.strMealThumb, cuisine = meal.strArea ?: "International",
                        category = meal.strCategory ?: "Main Course", difficulty = "Medium",
                        ingredients = buildIngredients(meal),
                        instructions = meal.strInstructions?.split("\n")?.filter { it.isNotBlank() }?.map { it.trim() } ?: emptyList()
                    ))
                } else {
                    // Last fallback: Firestore
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

private fun buildIngredients(meal: MealDto): List<Ingredient> {
    val names = listOf(meal.strIngredient1, meal.strIngredient2, meal.strIngredient3, meal.strIngredient4, meal.strIngredient5)
    val measures = listOf(meal.strMeasure1, meal.strMeasure2, meal.strMeasure3, meal.strMeasure4, meal.strMeasure5)
    val result = mutableListOf<Ingredient>()
    for (i in names.indices) {
        val n = names[i] ?: continue; if (n.isBlank()) continue
        val m = measures.getOrElse(i) { "" } ?: ""
        result.add(Ingredient(name = n.trim(), amount = 1.0, unit = m.trim().ifEmpty { "unit" }))
    }
    return result
}
