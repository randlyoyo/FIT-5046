package edu.monash.fit5046.healthyrecipehub.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import edu.monash.fit5046.healthyrecipehub.data.local.converter.ListConverter
import edu.monash.fit5046.healthyrecipehub.data.local.converter.TimestampConverter
import edu.monash.fit5046.healthyrecipehub.data.local.dao.*
import edu.monash.fit5046.healthyrecipehub.data.model.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Room Database for Healthy Recipe Hub
 * Main database containing all entities
 */
@Database(
    entities = [
        Recipe::class,
        Review::class,
        User::class,
        UserActivityLog::class,
        NutritionLog::class,
        ShoppingList::class,
        ShoppingItem::class,
        SavedLocation::class,
        SentEmail::class,
        ChatMessage::class,
        AppSettings::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(ListConverter::class, TimestampConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao
    abstract fun userDao(): UserDao
    abstract fun shoppingDao(): ShoppingDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "healthy_recipe_hub_database"
                )
                    .addCallback(DatabaseCallback())
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

    /**
     * Database callback for initial setup
     */
    private class DatabaseCallback : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            // Initialize database with default data if needed
            CoroutineScope(Dispatchers.IO).launch {
                // Can pre-populate data here
            }
        }

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            // Called when database is opened
        }
    }
}
