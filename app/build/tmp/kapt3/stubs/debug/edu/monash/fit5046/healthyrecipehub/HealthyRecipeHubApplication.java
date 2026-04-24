package edu.monash.fit5046.healthyrecipehub;

/**
 * Application class for Healthy Recipe Hub
 * Initializes Firebase, notification channels, database, and sample data
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/HealthyRecipeHubApplication;", "Landroid/app/Application;", "()V", "applicationScope", "Lkotlinx/coroutines/CoroutineScope;", "createNotificationChannels", "", "onCreate", "populateSampleData", "database", "Ledu/monash/fit5046/healthyrecipehub/data/local/database/AppDatabase;", "Companion", "app_debug"})
public final class HealthyRecipeHubApplication extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHANNEL_ID_DEFAULT = "healthy_recipe_hub_default";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHANNEL_ID_RECIPE = "healthy_recipe_hub_recipe";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHANNEL_ID_NUTRITION = "healthy_recipe_hub_nutrition";
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope applicationScope = null;
    @org.jetbrains.annotations.NotNull()
    public static final edu.monash.fit5046.healthyrecipehub.HealthyRecipeHubApplication.Companion Companion = null;
    
    public HealthyRecipeHubApplication() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    private final void populateSampleData(edu.monash.fit5046.healthyrecipehub.data.local.database.AppDatabase database) {
    }
    
    private final void createNotificationChannels() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/HealthyRecipeHubApplication$Companion;", "", "()V", "CHANNEL_ID_DEFAULT", "", "CHANNEL_ID_NUTRITION", "CHANNEL_ID_RECIPE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}