package edu.monash.fit5046.healthyrecipehub.ui.screens.recipe;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0018\u0010\b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a.\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u0018\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u00a8\u0006\u0014"}, d2 = {"InfoItem", "", "label", "", "value", "NutritionCard", "recipe", "Ledu/monash/fit5046/healthyrecipehub/data/model/Recipe;", "NutritionItem", "RecipeDetailScreen", "recipeId", "onNavigateBack", "Lkotlin/Function0;", "recipeViewModel", "Ledu/monash/fit5046/healthyrecipehub/ui/viewmodel/RecipeViewModel;", "authViewModel", "Ledu/monash/fit5046/healthyrecipehub/ui/viewmodel/AuthViewModel;", "shareRecipe", "context", "Landroid/content/Context;", "app_debug"})
public final class RecipeDetailScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void RecipeDetailScreen(@org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack, @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.ui.viewmodel.RecipeViewModel recipeViewModel, @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.ui.viewmodel.AuthViewModel authViewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void NutritionCard(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.Recipe recipe) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void NutritionItem(@org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    java.lang.String label) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void InfoItem(@org.jetbrains.annotations.NotNull()
    java.lang.String label, @org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    private static final void shareRecipe(android.content.Context context, edu.monash.fit5046.healthyrecipehub.data.model.Recipe recipe) {
    }
}