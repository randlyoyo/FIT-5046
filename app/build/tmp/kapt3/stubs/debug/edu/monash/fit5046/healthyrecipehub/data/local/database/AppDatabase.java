package edu.monash.fit5046.healthyrecipehub.data.local.database;

/**
 * Room Database for Healthy Recipe Hub
 * Main database containing all entities
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\'\u0018\u0000 \t2\u00020\u0001:\u0002\t\nB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\u000b"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/local/database/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "recipeDao", "Ledu/monash/fit5046/healthyrecipehub/data/local/dao/RecipeDao;", "shoppingDao", "Ledu/monash/fit5046/healthyrecipehub/data/local/dao/ShoppingDao;", "userDao", "Ledu/monash/fit5046/healthyrecipehub/data/local/dao/UserDao;", "Companion", "DatabaseCallback", "app_debug"})
@androidx.room.Database(entities = {edu.monash.fit5046.healthyrecipehub.data.model.Recipe.class, edu.monash.fit5046.healthyrecipehub.data.model.Review.class, edu.monash.fit5046.healthyrecipehub.data.model.User.class, edu.monash.fit5046.healthyrecipehub.data.model.UserActivityLog.class, edu.monash.fit5046.healthyrecipehub.data.model.NutritionLog.class, edu.monash.fit5046.healthyrecipehub.data.model.ShoppingList.class, edu.monash.fit5046.healthyrecipehub.data.model.ShoppingItem.class, edu.monash.fit5046.healthyrecipehub.data.model.SavedLocation.class, edu.monash.fit5046.healthyrecipehub.data.model.SentEmail.class, edu.monash.fit5046.healthyrecipehub.data.model.ChatMessage.class, edu.monash.fit5046.healthyrecipehub.data.model.AppSettings.class}, version = 1, exportSchema = false)
@androidx.room.TypeConverters(value = {edu.monash.fit5046.healthyrecipehub.data.local.converter.ListConverter.class, edu.monash.fit5046.healthyrecipehub.data.local.converter.TimestampConverter.class})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile edu.monash.fit5046.healthyrecipehub.data.local.database.AppDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final edu.monash.fit5046.healthyrecipehub.data.local.database.AppDatabase.Companion Companion = null;
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract edu.monash.fit5046.healthyrecipehub.data.local.dao.RecipeDao recipeDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract edu.monash.fit5046.healthyrecipehub.data.local.dao.UserDao userDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract edu.monash.fit5046.healthyrecipehub.data.local.dao.ShoppingDao shoppingDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/local/database/AppDatabase$Companion;", "", "()V", "INSTANCE", "Ledu/monash/fit5046/healthyrecipehub/data/local/database/AppDatabase;", "getDatabase", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final edu.monash.fit5046.healthyrecipehub.data.local.database.AppDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
    
    /**
     * Database callback for initial setup
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/local/database/AppDatabase$DatabaseCallback;", "Landroidx/room/RoomDatabase$Callback;", "()V", "onCreate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "onOpen", "app_debug"})
    static final class DatabaseCallback extends androidx.room.RoomDatabase.Callback {
        
        public DatabaseCallback() {
            super();
        }
        
        @java.lang.Override()
        public void onCreate(@org.jetbrains.annotations.NotNull()
        androidx.sqlite.db.SupportSQLiteDatabase db) {
        }
        
        @java.lang.Override()
        public void onOpen(@org.jetbrains.annotations.NotNull()
        androidx.sqlite.db.SupportSQLiteDatabase db) {
        }
    }
}