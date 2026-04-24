package edu.monash.fit5046.healthyrecipehub.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import edu.monash.fit5046.healthyrecipehub.data.model.*
import kotlinx.coroutines.flow.Flow

/**
 * User Data Access Object
 */
@Dao
interface UserDao {

    // ====== User CRUD ======

    @Query("SELECT * FROM users WHERE id = :userId")
    suspend fun getUserById(userId: String): User?

    @Query("SELECT * FROM users WHERE id = :userId")
    fun getUserByIdLive(userId: String): LiveData<User?>

    @Query("SELECT * FROM users WHERE id = :userId")
    fun getUserByIdFlow(userId: String): Flow<User?>

    @Query("SELECT * FROM users WHERE email = :email")
    suspend fun getUserByEmail(email: String): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    // ====== User List Operations (Admin) ======

    @Query("SELECT * FROM users ORDER BY createdAt DESC")
    fun getAllUsers(): Flow<List<User>>

    @Query("SELECT * FROM users WHERE role = :role ORDER BY createdAt DESC")
    fun getUsersByRole(role: UserRole): Flow<List<User>>

    @Query("SELECT COUNT(*) FROM users")
    suspend fun getTotalUserCount(): Int

    @Query("SELECT COUNT(*) FROM users WHERE role = :role")
    suspend fun getUserCountByRole(role: UserRole): Int

    @Query("SELECT COUNT(*) FROM users WHERE createdAt >= :since")
    suspend fun getUserCountSince(since: Long): Int

    // ====== Activity Logs ======

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertActivityLog(log: UserActivityLog)

    @Query("SELECT * FROM activity_logs WHERE userId = :userId ORDER BY timestamp DESC LIMIT :limit")
    suspend fun getUserActivityLogs(userId: String, limit: Int = 100): List<UserActivityLog>

    @Query("SELECT * FROM activity_logs ORDER BY timestamp DESC LIMIT :limit")
    suspend fun getAllActivityLogs(limit: Int = 1000): List<UserActivityLog>

    @Query("DELETE FROM activity_logs WHERE timestamp < :before")
    suspend fun deleteOldActivityLogs(before: Long)

    // ====== Nutrition Logs ======

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNutritionLog(log: NutritionLog)

    @Query("SELECT * FROM nutrition_logs WHERE userId = :userId AND date = :date ORDER BY timestamp ASC")
    suspend fun getNutritionLogsForDate(userId: String, date: String): List<NutritionLog>

    @Query("""
        SELECT 
            SUM(calories) as totalCalories,
            SUM(protein) as totalProtein,
            SUM(carbs) as totalCarbs,
            SUM(fat) as totalFat
        FROM nutrition_logs 
        WHERE userId = :userId AND date = :date
    """)
    suspend fun getDailyNutritionSummary(userId: String, date: String): DailyNutritionSummary?

    @Query("SELECT * FROM nutrition_logs WHERE userId = :userId AND date BETWEEN :startDate AND :endDate ORDER BY date, timestamp")
    suspend fun getNutritionLogsForDateRange(
        userId: String,
        startDate: String,
        endDate: String
    ): List<NutritionLog>

    @Delete
    suspend fun deleteNutritionLog(log: NutritionLog)

    @Query("DELETE FROM nutrition_logs WHERE userId = :userId AND date = :date")
    suspend fun deleteNutritionLogsForDate(userId: String, date: String)

    // ====== Settings ======

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSettings(settings: AppSettings)

    @Query("SELECT * FROM app_settings WHERE userId = :userId")
    suspend fun getUserSettings(userId: String): AppSettings?

    @Update
    suspend fun updateSettings(settings: AppSettings)
}

/**
 * Daily Nutrition Summary Data Class
 */
data class DailyNutritionSummary(
    val totalCalories: Int?,
    val totalProtein: Double?,
    val totalCarbs: Double?,
    val totalFat: Double?
)
