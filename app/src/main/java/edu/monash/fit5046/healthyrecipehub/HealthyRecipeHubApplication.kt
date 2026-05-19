package edu.monash.fit5046.healthyrecipehub

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import com.google.firebase.FirebaseApp
import edu.monash.fit5046.healthyrecipehub.data.SampleDataProvider
import edu.monash.fit5046.healthyrecipehub.data.local.database.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

/**
 * Application class for Healthy Recipe Hub
 * Initializes Firebase, notification channels, database, and sample data
 */
class HealthyRecipeHubApplication : Application() {

    companion object {
        const val CHANNEL_ID_DEFAULT = "healthy_recipe_hub_default"
        const val CHANNEL_ID_RECIPE = "healthy_recipe_hub_recipe"
        const val CHANNEL_ID_NUTRITION = "healthy_recipe_hub_nutrition"
    }

    private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onCreate() {
        super.onCreate()

        // Initialize Firebase
        FirebaseApp.initializeApp(this)

        // Initialize database and populate sample data
        val database = AppDatabase.getDatabase(this)
        populateSampleData(database)

        // Create notification channels (Android O+)
        createNotificationChannels()
    }

    private fun populateSampleData(database: AppDatabase) {
        applicationScope.launch {
            try {
                // Check if database is empty
                val existingRecipes = database.recipeDao().getAllRecipesSync()
                if (existingRecipes.isEmpty()) {
                    // Populate with sample data
                    val sampleRecipes = SampleDataProvider.getSampleRecipes()
                    sampleRecipes.forEach { recipe ->
                        database.recipeDao().insertRecipe(recipe)
                    }
                }
            } catch (e: Exception) {
                // Silent fail - don't crash app if data population fails
                e.printStackTrace()
            }
        }
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            // Default channel
            val defaultChannel = NotificationChannel(
                CHANNEL_ID_DEFAULT,
                "General Notifications",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "General app notifications"
            }

            // Recipe channel
            val recipeChannel = NotificationChannel(
                CHANNEL_ID_RECIPE,
                "Recipe Updates",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "New recipes and recipe recommendations"
            }

            // Nutrition channel
            val nutritionChannel = NotificationChannel(
                CHANNEL_ID_NUTRITION,
                "Nutrition Reminders",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Daily nutrition goals and reminders"
            }

            notificationManager.createNotificationChannels(
                listOf(defaultChannel, recipeChannel, nutritionChannel)
            )
        }
    }
}
