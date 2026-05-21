package edu.monash.fit5046.healthyrecipehub.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import edu.monash.fit5046.healthyrecipehub.data.model.*
import edu.monash.fit5046.healthyrecipehub.data.remote.dto.RecipeUploadRequest
import edu.monash.fit5046.healthyrecipehub.data.repository.AuthRepository
import edu.monash.fit5046.healthyrecipehub.data.repository.RecipeRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

/**
 * Recipe ViewModel
 * Manages recipe-related UI state and business logic
 */
class RecipeViewModel(application: Application) : AndroidViewModel(application) {

    private val recipeRepository: RecipeRepository = RecipeRepository.getInstance(application)
    private val authRepository: AuthRepository = AuthRepository.getInstance(application)

    // UI State
    private val _recipes = MutableLiveData<Resource<List<Recipe>>>()
    val recipes: LiveData<Resource<List<Recipe>>> = _recipes

    private val _currentRecipe = MutableLiveData<Resource<Recipe>>()
    val currentRecipe: LiveData<Resource<Recipe>> = _currentRecipe

    private val _searchResults = MutableLiveData<Resource<List<Recipe>>>()
    val searchResults: LiveData<Resource<List<Recipe>>> = _searchResults

    private val _favorites = MutableLiveData<Resource<List<Recipe>>>()
    val favorites: LiveData<Resource<List<Recipe>>> = _favorites

    private val _operationResult = MutableLiveData<Result<Unit>>()
    val operationResult: LiveData<Result<Unit>> = _operationResult

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    // Current filter
    private var currentFilter: RecipeFilter = RecipeFilter()

    /**
     * Load all recipes
     */
    fun loadRecipes() {
        viewModelScope.launch {
            _recipes.value = Resource.loading()

            // First load from local cache
            recipeRepository.getAllRecipes().collect { localRecipes ->
                if (localRecipes.isNotEmpty()) {
                    _recipes.value = Resource.success(localRecipes)
                }
            }

            // Then fetch from API
            val result = recipeRepository.fetchRecipesFromApi()
            when (result) {
                is Result.Success -> {
                    _recipes.value = Resource.success(result.data)
                }
                is Result.Error -> {
                    _recipes.value = Resource.error(result.message)
                }
                else -> { /* Do nothing */ }
            }
        }
    }

    /**
     * Load recipe by ID
     */
    fun loadRecipeById(recipeId: String) {
        viewModelScope.launch {
            _currentRecipe.value = Resource.loading()

            val localRecipe = recipeRepository.getRecipeById(recipeId)
            if (localRecipe != null) {
                _currentRecipe.value = Resource.success(localRecipe)
                return@launch
            }

            val result = recipeRepository.fetchRecipeById(recipeId)
            when (result) {
                is Result.Success -> {
                    _currentRecipe.value = Resource.success(result.data)
                }
                is Result.Error -> {
                    _currentRecipe.value = Resource.error(result.message)
                }
                else -> { /* Do nothing */ }
            }
        }
    }

    /**
     * Search recipes
     */
    fun searchRecipes(query: String) {
        viewModelScope.launch {
            _searchResults.value = Resource.loading()
            _isLoading.value = true

            val result = recipeRepository.searchRecipesApi(query)
            when (result) {
                is Result.Success -> {
                    _searchResults.value = Resource.success(result.data)
                }
                is Result.Error -> {
                    _searchResults.value = Resource.error(result.message)
                }
                else -> { /* Do nothing */ }
            }

            _isLoading.value = false
        }
    }

    /**
     * Filter recipes
     */
    fun filterRecipes(filter: RecipeFilter) {
        currentFilter = filter
        viewModelScope.launch {
            recipeRepository.filterRecipes(filter).collect { filteredRecipes ->
                _recipes.value = Resource.success(filteredRecipes)
            }
        }
    }

    /**
     * Load favorite recipes
     */
    fun loadFavorites() {
        viewModelScope.launch {
            _favorites.value = Resource.loading()

            recipeRepository.getFavoriteRecipes().collect { favoriteRecipes ->
                _favorites.value = Resource.success(favoriteRecipes)
            }
        }
    }

    /**
     * Add recipe to favorites
     */
    fun addToFavorites(recipeId: String) {
        viewModelScope.launch {
            try {
                recipeRepository.updateFavoriteStatus(recipeId, true)
                _favorites.value = Resource.success(recipeRepository.getFavoriteRecipes().first())
                _operationResult.value = Result.Success(Unit)
            } catch (e: Exception) {
                _operationResult.value = Result.Error(
                    e,
                    e.localizedMessage ?: "Failed to add favorite"
                )
            }
        }
    }

    /**
     * Remove recipe from favorites
     */
    fun removeFromFavorites(recipeId: String) {
        viewModelScope.launch {
            try {
                recipeRepository.updateFavoriteStatus(recipeId, false)
                _favorites.value = Resource.success(recipeRepository.getFavoriteRecipes().first())
                _operationResult.value = Result.Success(Unit)
            } catch (e: Exception) {
                _operationResult.value = Result.Error(
                    e,
                    e.localizedMessage ?: "Failed to remove favorite"
                )
            }
        }
    }

    /**
     * Create new recipe
     */
    fun createRecipe(recipe: RecipeUploadRequest) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val now = System.currentTimeMillis()
                val localRecipe = Recipe(
                    id = "local_$now",
                    title = recipe.title,
                    description = recipe.description,
                    imageUrl = recipe.imageUrl,
                    calories = recipe.calories,
                    protein = recipe.protein,
                    carbs = recipe.carbs,
                    fat = recipe.fat,
                    prepTime = recipe.prepTime,
                    cookTime = recipe.cookTime,
                    servings = recipe.servings,
                    difficulty = recipe.difficulty,
                    category = recipe.category,
                    cuisine = recipe.cuisine,
                    dietaryTags = recipe.dietaryTags,
                    ingredients = recipe.ingredients.map { it.toIngredient() },
                    instructions = recipe.instructions,
                    createdAt = now,
                    updatedAt = now,
                    isOffline = true
                )

                recipeRepository.saveRecipe(localRecipe)
                _recipes.value = Resource.success(recipeRepository.getAllRecipes().first())
                _operationResult.value = Result.Success(Unit)
            } catch (e: Exception) {
                _operationResult.value = Result.Error(
                    e,
                    e.localizedMessage ?: "Failed to save recipe"
                )
            }

            _isLoading.value = false
        }
    }

    /**
     * Update existing recipe
     */
    fun updateRecipe(recipeId: String, recipe: RecipeUploadRequest) {
        viewModelScope.launch {
            _isLoading.value = true
            val token = authRepository.getToken()

            if (token != null) {
                val result = recipeRepository.updateRecipe(token, recipeId, recipe)
                _operationResult.value = result.map { }
            } else {
                _operationResult.value = Result.Error(
                    Exception("Not authenticated"),
                    "Please login first"
                )
            }

            _isLoading.value = false
        }
    }

    /**
     * Delete recipe
     */
    fun deleteRecipe(recipeId: String) {
        viewModelScope.launch {
            _isLoading.value = true
            val token = authRepository.getToken()

            if (token != null) {
                val result = recipeRepository.deleteRecipe(token, recipeId)
                _operationResult.value = result
            } else {
                _operationResult.value = Result.Error(
                    Exception("Not authenticated"),
                    "Please login first"
                )
            }

            _isLoading.value = false
        }
    }

    /**
     * Add review to recipe
     */
    fun addReview(recipeId: String, rating: Float, comment: String) {
        viewModelScope.launch {
            _isLoading.value = true
            val token = authRepository.getToken()

            if (token != null) {
                val result = recipeRepository.addReview(token, recipeId, rating, comment)
                _operationResult.value = result
            } else {
                _operationResult.value = Result.Error(
                    Exception("Not authenticated"),
                    "Please login first"
                )
            }

            _isLoading.value = false
        }
    }

    /**
     * Get recipes by category
     */
    fun getRecipesByCategory(category: String) {
        viewModelScope.launch {
            _recipes.value = Resource.loading()

            recipeRepository.filterRecipes(
                RecipeFilter(category = category)
            ).collect { recipes ->
                _recipes.value = Resource.success(recipes)
            }
        }
    }

    /**
     * Get recipes by cuisine
     */
    fun getRecipesByCuisine(cuisine: String) {
        viewModelScope.launch {
            _recipes.value = Resource.loading()

            recipeRepository.filterRecipes(
                RecipeFilter(cuisine = cuisine)
            ).collect { recipes ->
                _recipes.value = Resource.success(recipes)
            }
        }
    }

    /**
     * Clear operation result
     */
    fun clearOperationResult() {
        _operationResult.value = Result.Idle
    }
}
