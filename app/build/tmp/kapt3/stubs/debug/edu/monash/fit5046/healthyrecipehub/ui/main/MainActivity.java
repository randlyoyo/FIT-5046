package edu.monash.fit5046.healthyrecipehub.ui.main;

/**
 * Main Activity - Entry point after login
 * Now using Jetpack Compose for all UI
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/ui/main/MainActivity;", "Landroidx/activity/ComponentActivity;", "()V", "authViewModel", "Ledu/monash/fit5046/healthyrecipehub/ui/viewmodel/AuthViewModel;", "getAuthViewModel", "()Ledu/monash/fit5046/healthyrecipehub/ui/viewmodel/AuthViewModel;", "authViewModel$delegate", "Lkotlin/Lazy;", "recipeViewModel", "Ledu/monash/fit5046/healthyrecipehub/ui/viewmodel/RecipeViewModel;", "getRecipeViewModel", "()Ledu/monash/fit5046/healthyrecipehub/ui/viewmodel/RecipeViewModel;", "recipeViewModel$delegate", "observeAuthState", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class MainActivity extends androidx.activity.ComponentActivity {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy authViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy recipeViewModel$delegate = null;
    
    public MainActivity() {
        super();
    }
    
    private final edu.monash.fit5046.healthyrecipehub.ui.viewmodel.AuthViewModel getAuthViewModel() {
        return null;
    }
    
    private final edu.monash.fit5046.healthyrecipehub.ui.viewmodel.RecipeViewModel getRecipeViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void observeAuthState() {
    }
}