package edu.monash.fit5046.healthyrecipehub.data.repository;

/**
 * Authentication Repository
 * Manages user authentication state and session
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 B2\u00020\u0001:\u0001BB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0086@\u00a2\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0018H\u0002J\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u001f\u001a\u00020\u001aH\u0086@\u00a2\u0006\u0002\u0010 J\b\u0010!\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0#J\b\u0010$\u001a\u0004\u0018\u00010\u001aJ\u0006\u0010%\u001a\u00020&J\u0006\u0010\'\u001a\u00020&J*\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u001aH\u0082@\u00a2\u0006\u0002\u0010-J$\u0010.\u001a\b\u0012\u0004\u0012\u00020\r0\u00172\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u001aH\u0086@\u00a2\u0006\u0002\u0010\u001cJ\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0086@\u00a2\u0006\u0002\u00101J\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020\r0\u0017H\u0086@\u00a2\u0006\u0002\u00101J,\u00103\u001a\b\u0012\u0004\u0012\u00020\r0\u00172\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\u001aH\u0086@\u00a2\u0006\u0002\u00105J\b\u00106\u001a\u00020\u0018H\u0002J\u001a\u00107\u001a\u00020\u00182\b\u00108\u001a\u0004\u0018\u00010\u001a2\u0006\u00109\u001a\u00020\rH\u0002J\\\u0010:\u001a\b\u0012\u0004\u0012\u00020\r0\u00172\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u001a2\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010=2\u0010\b\u0002\u0010>\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010=2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@H\u0086@\u00a2\u0006\u0002\u0010AR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006C"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/repository/AuthRepository;", "", "context", "Landroid/content/Context;", "apiService", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/AuthApiService;", "database", "Ledu/monash/fit5046/healthyrecipehub/data/local/database/AppDatabase;", "(Landroid/content/Context;Ledu/monash/fit5046/healthyrecipehub/data/remote/api/AuthApiService;Ledu/monash/fit5046/healthyrecipehub/data/local/database/AppDatabase;)V", "_authState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ledu/monash/fit5046/healthyrecipehub/data/repository/AuthState;", "_currentUser", "Ledu/monash/fit5046/healthyrecipehub/data/model/User;", "authState", "Lkotlinx/coroutines/flow/StateFlow;", "getAuthState", "()Lkotlinx/coroutines/flow/StateFlow;", "currentUser", "getCurrentUser", "prefs", "Landroid/content/SharedPreferences;", "changePassword", "Ledu/monash/fit5046/healthyrecipehub/data/model/Result;", "", "currentPassword", "", "newPassword", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearAuthData", "forgotPassword", "email", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentUserId", "getCurrentUserLive", "Lkotlinx/coroutines/flow/Flow;", "getToken", "isAdmin", "", "isLoggedIn", "logActivity", "userId", "activityType", "Ledu/monash/fit5046/healthyrecipehub/data/model/ActivityType;", "details", "(Ljava/lang/String;Ledu/monash/fit5046/healthyrecipehub/data/model/ActivityType;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "password", "logout", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshUserData", "register", "displayName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreSession", "saveAuthData", "token", "user", "updateProfile", "photoUrl", "dietaryPreferences", "", "allergies", "dailyCalorieGoal", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class AuthRepository {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final edu.monash.fit5046.healthyrecipehub.data.remote.api.AuthApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final edu.monash.fit5046.healthyrecipehub.data.local.database.AppDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PREFS_NAME = "auth_prefs";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_TOKEN = "auth_token";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_REFRESH_TOKEN = "refresh_token";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_USER_ID = "user_id";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_IS_LOGGED_IN = "is_logged_in";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_LAST_LOGIN = "last_login";
    private static final boolean MOCK_MODE = true;
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile edu.monash.fit5046.healthyrecipehub.data.repository.AuthRepository instance;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<edu.monash.fit5046.healthyrecipehub.data.repository.AuthState> _authState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<edu.monash.fit5046.healthyrecipehub.data.repository.AuthState> authState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<edu.monash.fit5046.healthyrecipehub.data.model.User> _currentUser = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<edu.monash.fit5046.healthyrecipehub.data.model.User> currentUser = null;
    @org.jetbrains.annotations.NotNull()
    public static final edu.monash.fit5046.healthyrecipehub.data.repository.AuthRepository.Companion Companion = null;
    
    public AuthRepository(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.remote.api.AuthApiService apiService, @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.local.database.AppDatabase database) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<edu.monash.fit5046.healthyrecipehub.data.repository.AuthState> getAuthState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<edu.monash.fit5046.healthyrecipehub.data.model.User> getCurrentUser() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object login(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.model.Result<edu.monash.fit5046.healthyrecipehub.data.model.User>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object register(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    java.lang.String displayName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.model.Result<edu.monash.fit5046.healthyrecipehub.data.model.User>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object logout(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.model.Result<kotlin.Unit>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object forgotPassword(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.model.Result<kotlin.Unit>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object changePassword(@org.jetbrains.annotations.NotNull()
    java.lang.String currentPassword, @org.jetbrains.annotations.NotNull()
    java.lang.String newPassword, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.model.Result<kotlin.Unit>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateProfile(@org.jetbrains.annotations.Nullable()
    java.lang.String displayName, @org.jetbrains.annotations.Nullable()
    java.lang.String photoUrl, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> dietaryPreferences, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> allergies, @org.jetbrains.annotations.Nullable()
    java.lang.Integer dailyCalorieGoal, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.model.Result<edu.monash.fit5046.healthyrecipehub.data.model.User>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object refreshUserData(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.model.Result<edu.monash.fit5046.healthyrecipehub.data.model.User>> $completion) {
        return null;
    }
    
    private final void saveAuthData(java.lang.String token, edu.monash.fit5046.healthyrecipehub.data.model.User user) {
    }
    
    private final void clearAuthData() {
    }
    
    private final void restoreSession() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getToken() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCurrentUserId() {
        return null;
    }
    
    public final boolean isLoggedIn() {
        return false;
    }
    
    public final boolean isAdmin() {
        return false;
    }
    
    private final java.lang.Object logActivity(java.lang.String userId, edu.monash.fit5046.healthyrecipehub.data.model.ActivityType activityType, java.lang.String details, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<edu.monash.fit5046.healthyrecipehub.data.model.User> getCurrentUserLive() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/repository/AuthRepository$Companion;", "", "()V", "KEY_IS_LOGGED_IN", "", "KEY_LAST_LOGIN", "KEY_REFRESH_TOKEN", "KEY_TOKEN", "KEY_USER_ID", "MOCK_MODE", "", "PREFS_NAME", "instance", "Ledu/monash/fit5046/healthyrecipehub/data/repository/AuthRepository;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final edu.monash.fit5046.healthyrecipehub.data.repository.AuthRepository getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}