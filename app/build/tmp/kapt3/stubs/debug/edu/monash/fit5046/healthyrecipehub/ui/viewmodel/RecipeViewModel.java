package edu.monash.fit5046.healthyrecipehub.ui.viewmodel;

/**
 * Recipe ViewModel
 * Manages recipe-related UI state and business logic
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\'J\u000e\u0010+\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\'J\u0006\u0010,\u001a\u00020\u000fJ\u000e\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\'J\u000e\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u0015J\u000e\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\'J\u000e\u00105\u001a\u00020\u000f2\u0006\u00106\u001a\u00020\'J\u0006\u00107\u001a\u00020\u000fJ\u000e\u00108\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\'J\u0006\u00109\u001a\u00020\u000fJ\u000e\u0010:\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\'J\u000e\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\'J\u0016\u0010=\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\'2\u0006\u0010.\u001a\u00020/R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R#\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n0\u00070\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n0\u00070\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R#\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n0\u00070\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019\u00a8\u0006>"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/ui/viewmodel/RecipeViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_currentRecipe", "Landroidx/lifecycle/MutableLiveData;", "Ledu/monash/fit5046/healthyrecipehub/data/model/Resource;", "Ledu/monash/fit5046/healthyrecipehub/data/model/Recipe;", "_favorites", "", "_isLoading", "", "_operationResult", "Ledu/monash/fit5046/healthyrecipehub/data/model/Result;", "", "_recipes", "_searchResults", "authRepository", "Ledu/monash/fit5046/healthyrecipehub/data/repository/AuthRepository;", "currentFilter", "Ledu/monash/fit5046/healthyrecipehub/data/model/RecipeFilter;", "currentRecipe", "Landroidx/lifecycle/LiveData;", "getCurrentRecipe", "()Landroidx/lifecycle/LiveData;", "favorites", "getFavorites", "isLoading", "operationResult", "getOperationResult", "recipeRepository", "Ledu/monash/fit5046/healthyrecipehub/data/repository/RecipeRepository;", "recipes", "getRecipes", "searchResults", "getSearchResults", "addReview", "recipeId", "", "rating", "", "comment", "addToFavorites", "clearOperationResult", "createRecipe", "recipe", "Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/RecipeUploadRequest;", "deleteRecipe", "filterRecipes", "filter", "getRecipesByCategory", "category", "getRecipesByCuisine", "cuisine", "loadFavorites", "loadRecipeById", "loadRecipes", "removeFromFavorites", "searchRecipes", "query", "updateRecipe", "app_debug"})
public final class RecipeViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final edu.monash.fit5046.healthyrecipehub.data.repository.RecipeRepository recipeRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final edu.monash.fit5046.healthyrecipehub.data.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>>> _recipes = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>>> recipes = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>> _currentRecipe = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>> currentRecipe = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>>> _searchResults = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>>> searchResults = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>>> _favorites = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>>> favorites = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<kotlin.Unit>> _operationResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<kotlin.Unit>> operationResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private edu.monash.fit5046.healthyrecipehub.data.model.RecipeFilter currentFilter;
    
    public RecipeViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>>> getRecipes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>> getCurrentRecipe() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>>> getSearchResults() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>>> getFavorites() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<kotlin.Unit>> getOperationResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    /**
     * Load all recipes
     */
    public final void loadRecipes() {
    }
    
    /**
     * Load recipe by ID
     */
    public final void loadRecipeById(@org.jetbrains.annotations.NotNull()
    java.lang.String recipeId) {
    }
    
    /**
     * Search recipes
     */
    public final void searchRecipes(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    /**
     * Filter recipes
     */
    public final void filterRecipes(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.RecipeFilter filter) {
    }
    
    /**
     * Load favorite recipes
     */
    public final void loadFavorites() {
    }
    
    /**
     * Add recipe to favorites
     */
    public final void addToFavorites(@org.jetbrains.annotations.NotNull()
    java.lang.String recipeId) {
    }
    
    /**
     * Remove recipe from favorites
     */
    public final void removeFromFavorites(@org.jetbrains.annotations.NotNull()
    java.lang.String recipeId) {
    }
    
    /**
     * Create new recipe
     */
    public final void createRecipe(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.remote.dto.RecipeUploadRequest recipe) {
    }
    
    /**
     * Update existing recipe
     */
    public final void updateRecipe(@org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.remote.dto.RecipeUploadRequest recipe) {
    }
    
    /**
     * Delete recipe
     */
    public final void deleteRecipe(@org.jetbrains.annotations.NotNull()
    java.lang.String recipeId) {
    }
    
    /**
     * Add review to recipe
     */
    public final void addReview(@org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, float rating, @org.jetbrains.annotations.NotNull()
    java.lang.String comment) {
    }
    
    /**
     * Get recipes by category
     */
    public final void getRecipesByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category) {
    }
    
    /**
     * Get recipes by cuisine
     */
    public final void getRecipesByCuisine(@org.jetbrains.annotations.NotNull()
    java.lang.String cuisine) {
    }
    
    /**
     * Clear operation result
     */
    public final void clearOperationResult() {
    }
}