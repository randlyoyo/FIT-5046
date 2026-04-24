package edu.monash.fit5046.healthyrecipehub.data.local.dao;

/**
 * User Data Access Object
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u00a7@\u00a2\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00150\u001bH\'J \u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ$\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ,\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\"J\u000e\u0010#\u001a\u00020\u0018H\u00a7@\u00a2\u0006\u0002\u0010$J&\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u00a7@\u00a2\u0006\u0002\u0010&J\u0018\u0010\'\u001a\u0004\u0018\u00010\u00122\u0006\u0010(\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010)J\u0018\u0010*\u001a\u0004\u0018\u00010\u00122\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010)J\u0018\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u001b2\u0006\u0010\b\u001a\u00020\tH\'J\u0018\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120-2\u0006\u0010\b\u001a\u00020\tH\'J\u0016\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u000200H\u00a7@\u00a2\u0006\u0002\u00101J\u0016\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u0018\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010)J\u001c\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00150\u001b2\u0006\u0010/\u001a\u000200H\'J\u0016\u00107\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0016H\u00a7@\u00a2\u0006\u0002\u00108J\u0016\u00109\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010:\u001a\u00020\u00032\u0006\u0010;\u001a\u000205H\u00a7@\u00a2\u0006\u0002\u0010<J\u0016\u0010=\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0013J\u0016\u0010>\u001a\u00020\u00032\u0006\u0010;\u001a\u000205H\u00a7@\u00a2\u0006\u0002\u0010<J\u0016\u0010?\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0013\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006@\u00c0\u0006\u0001"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/local/dao/UserDao;", "", "deleteNutritionLog", "", "log", "Ledu/monash/fit5046/healthyrecipehub/data/model/NutritionLog;", "(Ledu/monash/fit5046/healthyrecipehub/data/model/NutritionLog;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteNutritionLogsForDate", "userId", "", "date", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOldActivityLogs", "before", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteUser", "user", "Ledu/monash/fit5046/healthyrecipehub/data/model/User;", "(Ledu/monash/fit5046/healthyrecipehub/data/model/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllActivityLogs", "", "Ledu/monash/fit5046/healthyrecipehub/data/model/UserActivityLog;", "limit", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllUsers", "Lkotlinx/coroutines/flow/Flow;", "getDailyNutritionSummary", "Ledu/monash/fit5046/healthyrecipehub/data/local/dao/DailyNutritionSummary;", "getNutritionLogsForDate", "getNutritionLogsForDateRange", "startDate", "endDate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTotalUserCount", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserActivityLogs", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserByEmail", "email", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserById", "getUserByIdFlow", "getUserByIdLive", "Landroidx/lifecycle/LiveData;", "getUserCountByRole", "role", "Ledu/monash/fit5046/healthyrecipehub/data/model/UserRole;", "(Ledu/monash/fit5046/healthyrecipehub/data/model/UserRole;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserCountSince", "since", "getUserSettings", "Ledu/monash/fit5046/healthyrecipehub/data/model/AppSettings;", "getUsersByRole", "insertActivityLog", "(Ledu/monash/fit5046/healthyrecipehub/data/model/UserActivityLog;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertNutritionLog", "insertSettings", "settings", "(Ledu/monash/fit5046/healthyrecipehub/data/model/AppSettings;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUser", "updateSettings", "updateUser", "app_debug"})
@androidx.room.Dao()
public abstract interface UserDao {
    
    @androidx.room.Query(value = "SELECT * FROM users WHERE id = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserById(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.model.User> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM users WHERE id = :userId")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.User> getUserByIdLive(@org.jetbrains.annotations.NotNull()
    java.lang.String userId);
    
    @androidx.room.Query(value = "SELECT * FROM users WHERE id = :userId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<edu.monash.fit5046.healthyrecipehub.data.model.User> getUserByIdFlow(@org.jetbrains.annotations.NotNull()
    java.lang.String userId);
    
    @androidx.room.Query(value = "SELECT * FROM users WHERE email = :email")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserByEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.model.User> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertUser(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.User user, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateUser(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.User user, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteUser(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.User user, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM users ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.User>> getAllUsers();
    
    @androidx.room.Query(value = "SELECT * FROM users WHERE role = :role ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.User>> getUsersByRole(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.UserRole role);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM users")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTotalUserCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM users WHERE role = :role")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserCountByRole(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.UserRole role, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM users WHERE createdAt >= :since")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserCountSince(long since, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertActivityLog(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.UserActivityLog log, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM activity_logs WHERE userId = :userId ORDER BY timestamp DESC LIMIT :limit")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserActivityLogs(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.UserActivityLog>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM activity_logs ORDER BY timestamp DESC LIMIT :limit")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllActivityLogs(int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.UserActivityLog>> $completion);
    
    @androidx.room.Query(value = "DELETE FROM activity_logs WHERE timestamp < :before")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteOldActivityLogs(long before, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertNutritionLog(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.NutritionLog log, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM nutrition_logs WHERE userId = :userId AND date = :date ORDER BY timestamp ASC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNutritionLogsForDate(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.NutritionLog>> $completion);
    
    @androidx.room.Query(value = "\n        SELECT \n            SUM(calories) as totalCalories,\n            SUM(protein) as totalProtein,\n            SUM(carbs) as totalCarbs,\n            SUM(fat) as totalFat\n        FROM nutrition_logs \n        WHERE userId = :userId AND date = :date\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getDailyNutritionSummary(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.local.dao.DailyNutritionSummary> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM nutrition_logs WHERE userId = :userId AND date BETWEEN :startDate AND :endDate ORDER BY date, timestamp")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNutritionLogsForDateRange(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String startDate, @org.jetbrains.annotations.NotNull()
    java.lang.String endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.NutritionLog>> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteNutritionLog(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.NutritionLog log, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM nutrition_logs WHERE userId = :userId AND date = :date")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteNutritionLogsForDate(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSettings(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.AppSettings settings, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM app_settings WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.model.AppSettings> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateSettings(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.AppSettings settings, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}