package edu.monash.fit5046.healthyrecipehub.ui.recipe;

/**
 * Recipe Detail Activity - Compose Version
 * Shows full recipe information
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/ui/recipe/RecipeDetailActivity;", "Landroidx/activity/ComponentActivity;", "()V", "authViewModel", "Ledu/monash/fit5046/healthyrecipehub/ui/viewmodel/AuthViewModel;", "getAuthViewModel", "()Ledu/monash/fit5046/healthyrecipehub/ui/viewmodel/AuthViewModel;", "authViewModel$delegate", "Lkotlin/Lazy;", "recipeViewModel", "Ledu/monash/fit5046/healthyrecipehub/ui/viewmodel/RecipeViewModel;", "getRecipeViewModel", "()Ledu/monash/fit5046/healthyrecipehub/ui/viewmodel/RecipeViewModel;", "recipeViewModel$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_debug"})
public final class RecipeDetailActivity extends androidx.activity.ComponentActivity {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy recipeViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy authViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_RECIPE_ID = "extra_recipe_id";
    @org.jetbrains.annotations.NotNull()
    public static final edu.monash.fit5046.healthyrecipehub.ui.recipe.RecipeDetailActivity.Companion Companion = null;
    
    public RecipeDetailActivity() {
        super();
    }
    
    private final edu.monash.fit5046.healthyrecipehub.ui.viewmodel.RecipeViewModel getRecipeViewModel() {
        return null;
    }
    
    private final edu.monash.fit5046.healthyrecipehub.ui.viewmodel.AuthViewModel getAuthViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/ui/recipe/RecipeDetailActivity$Companion;", "", "()V", "EXTRA_RECIPE_ID", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}