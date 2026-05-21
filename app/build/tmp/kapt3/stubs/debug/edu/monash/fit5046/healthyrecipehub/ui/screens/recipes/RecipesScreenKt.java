package edu.monash.fit5046.healthyrecipehub.ui.screens.recipes;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\u001a4\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003\u001aX\u0010\t\u001a\u00020\u00012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u0011H\u0007\u00a8\u0006\u0012"}, d2 = {"RecipeCard", "", "recipe", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/SpoonacularRecipeSummary;", "isFavorite", "", "onClick", "Lkotlin/Function0;", "onToggleFavorite", "RecipesScreen", "onNavigate", "Lkotlin/Function1;", "", "recipes", "", "Lkotlin/Function2;", "favoriteIds", "", "app_debug"})
public final class RecipesScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void RecipesScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onNavigate, @org.jetbrains.annotations.NotNull()
    java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularRecipeSummary> recipes, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularRecipeSummary, ? super java.lang.Boolean, kotlin.Unit> onToggleFavorite, @org.jetbrains.annotations.NotNull()
    java.util.Set<java.lang.String> favoriteIds) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void RecipeCard(edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularRecipeSummary recipe, boolean isFavorite, kotlin.jvm.functions.Function0<kotlin.Unit> onClick, kotlin.jvm.functions.Function0<kotlin.Unit> onToggleFavorite) {
    }
}