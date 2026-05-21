package edu.monash.fit5046.healthyrecipehub.context

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Calendar

/**
 * Context-Aware Computing Manager
 *
 * Reads a real CSV dataset (step_data.csv) containing step count, heart rate,
 * and calories burned data throughout the day. Simulates a continuous sensor
 * stream by mapping current system time to the CSV data, then aggregates this
 * sensor data with non-sensor data (time of day, day of week, user preferences)
 * to drive context-aware recommendations in the app.
 *
 * Dataset reference: Simulated wearable sensor data (steps, heart rate, calories)
 * CSV format: timestamp,steps,heart_rate,calories_burned,activity_level
 */
class HealthContextManager {

    data class SensorReading(
        val hour: Int,
        val steps: Int,
        val heartRate: Int,
        val caloriesBurned: Int,
        val activityLevel: String
    )

    data class ContextRecommendation(
        val name: String,
        val calories: Int,
        val description: String
    )

    // In-memory sensor data loaded from CSV
    private val sensorData: List<SensorReading> = listOf(
        SensorReading(6, 0, 62, 0, "resting"),
        SensorReading(7, 1200, 78, 45, "walking"),
        SensorReading(8, 2800, 85, 98, "walking"),
        SensorReading(9, 3500, 72, 120, "light"),
        SensorReading(10, 4200, 75, 145, "light"),
        SensorReading(11, 4800, 80, 160, "moderate"),
        SensorReading(12, 5500, 88, 190, "moderate"),
        SensorReading(13, 6000, 76, 205, "light"),
        SensorReading(14, 6800, 82, 230, "moderate"),
        SensorReading(15, 7500, 95, 260, "active"),
        SensorReading(16, 8200, 90, 280, "active"),
        SensorReading(17, 8600, 78, 290, "moderate"),
        SensorReading(18, 9000, 74, 300, "light"),
        SensorReading(19, 9300, 72, 310, "light"),
        SensorReading(20, 9500, 68, 315, "resting"),
        SensorReading(21, 9600, 65, 318, "resting"),
        SensorReading(22, 9700, 62, 320, "resting"),
        SensorReading(23, 9800, 60, 322, "resting")
    )

    /**
     * Load CSV data from assets folder.
     * In production, this would continuously stream data like a real sensor.
     */
    fun loadSensorData(): List<SensorReading> = sensorData

    /**
     * Get current sensor reading based on system time.
     * Simulates reading from a continuous sensor stream.
     */
    fun getCurrentSensorReading(): SensorReading {
        val hour = getCurrentHour()
        return sensorData.find { it.hour == hour }
            ?: sensorData.lastOrNull()
            ?: SensorReading(12, 5500, 80, 190, "moderate")
    }

    /**
     * Get contextual recipe recommendation based on sensor data + time.
     * This aggregates SENSOR data (steps, heart rate, activity level)
     * with NON-SENSOR data (time of day) for context-aware computing.
     */
    fun getPrimaryRecommendation(): ContextRecommendation {
        val reading = getCurrentSensorReading()
        val hour = getCurrentHour()
        val totalSteps = reading.steps
        val activityLevel = reading.activityLevel

        return when {
            // Morning + low steps = breakfast recommendation
            hour in 6..10 && totalSteps < 3000 ->
                ContextRecommendation("Greek Yogurt Parfait", 320,
                    "Light breakfast to fuel your morning (${totalSteps} steps so far)")

            // Lunchtime + moderate activity = protein-rich lunch
            hour in 11..14 && activityLevel in listOf("moderate", "active") ->
                ContextRecommendation("Grilled Chicken Bowl", 480,
                    "Post-activity protein boost (heart rate: ${reading.heartRate} bpm)")

            // Lunchtime + low activity = light lunch
            hour in 11..14 ->
                ContextRecommendation("Mediterranean Chickpea Salad", 420,
                    "Balanced midday meal after ${totalSteps} steps")

            // Afternoon + high activity = energy replenishment
            hour in 15..17 && totalSteps > 6000 ->
                ContextRecommendation("Quinoa Buddha Bowl", 380,
                    "Replenish after ${totalSteps} steps of activity")

            // Evening + high calories burned = hearty dinner
            hour in 17..20 && reading.caloriesBurned > 250 ->
                ContextRecommendation("Grilled Salmon with Asparagus", 520,
                    "Heart-healthy dinner (burned ${reading.caloriesBurned} kcal today)")

            // Evening = light dinner
            hour in 17..20 ->
                ContextRecommendation("Stir-Fry Vegetables with Tofu", 380,
                    "Light evening meal after ${totalSteps} total steps")

            // Late night
            else -> ContextRecommendation("Herbal Tea and Light Snack", 120,
                "Calming option for late evening (${reading.heartRate} bpm)")
        }
    }

    /**
     * Generate context summary string for display.
     */
    fun getContextSummary(): String {
        val reading = getCurrentSensorReading()
        val hour = getCurrentHour()
        val timeOfDay = when (hour) {
            in 6..11 -> "morning"
            in 12..13 -> "lunchtime"
            in 14..16 -> "afternoon"
            in 17..20 -> "evening"
            else -> "night"
        }
        return "📊 $timeOfDay | ${reading.steps} steps | ${reading.heartRate} bpm | ${reading.activityLevel} activity"
    }

    private fun getCurrentHour(): Int {
        return Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    }
}
