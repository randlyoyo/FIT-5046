package edu.monash.fit5046.healthyrecipehub.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010)\u001a\u00020\u00112\b\u0010*\u001a\u0004\u0018\u00010\u0011H\u0002J:\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u00112\u0006\u00101\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u000104J\u0006\u00105\u001a\u00020,J\u0006\u00106\u001a\u00020,J\u000e\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020\u0011J\u0006\u00109\u001a\u00020,J\u0016\u0010:\u001a\u00020,2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u000eR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\f0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R#\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00070\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u001d\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R#\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\f0\u00070\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u000e\u0010%\u001a\u00020&X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020(X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006="}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/ui/viewmodel/RecipeViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_currentRecipe", "Landroidx/lifecycle/MutableLiveData;", "Ledu/monash/fit5046/healthyrecipehub/data/model/Resource;", "Ledu/monash/fit5046/healthyrecipehub/data/model/Recipe;", "_dailyPick", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/SpoonacularRecipeSummary;", "_favorites", "", "_isLoading", "", "_operationResult", "Ledu/monash/fit5046/healthyrecipehub/data/model/Result;", "", "_recipes", "apiKey", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "currentRecipe", "Landroidx/lifecycle/LiveData;", "getCurrentRecipe", "()Landroidx/lifecycle/LiveData;", "dailyPick", "getDailyPick", "favorites", "getFavorites", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "isLoading", "operationResult", "getOperationResult", "recipes", "getRecipes", "spoon", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/SpoonacularApiService;", "storage", "Lcom/google/firebase/storage/FirebaseStorage;", "cleanHtml", "text", "createRecipe", "", "title", "description", "ingredients", "instructions", "calories", "", "imageUri", "Landroid/net/Uri;", "loadDailyPick", "loadFavorites", "loadRecipeById", "recipeId", "loadRecipes", "toggleFavorite", "recipe", "add", "app_debug"})
public final class RecipeViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.storage.FirebaseStorage storage = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.auth.FirebaseAuth auth = null;
    @org.jetbrains.annotations.NotNull()
    private final edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularApiService spoon = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String apiKey = "67989404ea39423caf65f2dce67d5218";
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularRecipeSummary>>> _recipes = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularRecipeSummary>>> recipes = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularRecipeSummary>> _dailyPick = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularRecipeSummary>> dailyPick = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>> _currentRecipe = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>> currentRecipe = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>>> _favorites = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>>> favorites = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<java.lang.String>> _operationResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<java.lang.String>> operationResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading = null;
    
    public RecipeViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularRecipeSummary>>> getRecipes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularRecipeSummary>> getDailyPick() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>> getCurrentRecipe() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Recipe>>> getFavorites() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<java.lang.String>> getOperationResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    public final void loadRecipes() {
    }
    
    public final void loadDailyPick() {
    }
    
    /**
     * Clean HTML from Spoonacular summary text
     */
    private final java.lang.String cleanHtml(java.lang.String text) {
        return null;
    }
    
    public final void loadRecipeById(@org.jetbrains.annotations.NotNull()
    java.lang.String recipeId) {
    }
    
    public final void loadFavorites() {
    }
    
    public final void toggleFavorite(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.Recipe recipe, boolean add) {
    }
    
    public final void createRecipe(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String ingredients, @org.jetbrains.annotations.NotNull()
    java.lang.String instructions, int calories, @org.jetbrains.annotations.Nullable()
    android.net.Uri imageUri) {
    }
}