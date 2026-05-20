package edu.monash.fit5046.healthyrecipehub.data.repository;

/**
 * Authentication Repository - Uses Firebase Auth + Firestore
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 O2\u00020\u0001:\u0001OB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0086@\u00a2\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u001cH\u0002J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$H\u0002J\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010&\u001a\u00020\u001eH\u0086@\u00a2\u0006\u0002\u0010\'J\b\u0010(\u001a\u0004\u0018\u00010\u001eJ\u000e\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0*J\u0010\u0010+\u001a\u0004\u0018\u00010\u001eH\u0086@\u00a2\u0006\u0002\u0010,J\b\u0010-\u001a\u0004\u0018\u00010\u001eJ\u0018\u0010.\u001a\u0004\u0018\u00010\u000b2\u0006\u0010/\u001a\u00020\u001eH\u0082@\u00a2\u0006\u0002\u0010\'J\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u000201J*\u00103\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u001e2\u0006\u00104\u001a\u0002052\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u001eH\u0082@\u00a2\u0006\u0002\u00107J$\u00108\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001b2\u0006\u0010&\u001a\u00020\u001e2\u0006\u00109\u001a\u00020\u001eH\u0086@\u00a2\u0006\u0002\u0010 J\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0086@\u00a2\u0006\u0002\u0010,J\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001bH\u0086@\u00a2\u0006\u0002\u0010,J,\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001b2\u0006\u0010&\u001a\u00020\u001e2\u0006\u00109\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\u001eH\u0086@\u00a2\u0006\u0002\u0010>J\u0010\u0010?\u001a\u00020\u001c2\u0006\u0010@\u001a\u00020\u000bH\u0002J\u0010\u0010A\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u001eH\u0002J\u0016\u0010B\u001a\u00020\u001c2\u0006\u0010@\u001a\u00020\u000bH\u0082@\u00a2\u0006\u0002\u0010CJ\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0086@\u00a2\u0006\u0002\u0010,J\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001b2\u0006\u0010F\u001a\u00020\u001eH\u0086@\u00a2\u0006\u0002\u0010\'J\\\u0010G\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001b2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u001e2\u0010\b\u0002\u0010I\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010J2\u0010\b\u0002\u0010K\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010J2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010MH\u0086@\u00a2\u0006\u0002\u0010NR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006P"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/repository/AuthRepository;", "", "context", "Landroid/content/Context;", "database", "Ledu/monash/fit5046/healthyrecipehub/data/local/database/AppDatabase;", "(Landroid/content/Context;Ledu/monash/fit5046/healthyrecipehub/data/local/database/AppDatabase;)V", "_authState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ledu/monash/fit5046/healthyrecipehub/data/repository/AuthState;", "_currentUser", "Ledu/monash/fit5046/healthyrecipehub/data/model/User;", "authState", "Lkotlinx/coroutines/flow/StateFlow;", "getAuthState", "()Lkotlinx/coroutines/flow/StateFlow;", "currentUser", "getCurrentUser", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "prefs", "Landroid/content/SharedPreferences;", "usersCollection", "Lcom/google/firebase/firestore/CollectionReference;", "changePassword", "Ledu/monash/fit5046/healthyrecipehub/data/model/Result;", "", "currentPassword", "", "newPassword", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearSession", "createUserFromFirebaseUser", "fb", "Lcom/google/firebase/auth/FirebaseUser;", "forgotPassword", "email", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentUserId", "getCurrentUserLive", "Lkotlinx/coroutines/flow/Flow;", "getIdToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getToken", "getUserFromFirestore", "userId", "isAdmin", "", "isLoggedIn", "logActivity", "type", "Ledu/monash/fit5046/healthyrecipehub/data/model/ActivityType;", "details", "(Ljava/lang/String;Ledu/monash/fit5046/healthyrecipehub/data/model/ActivityType;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "password", "logout", "refreshUserData", "register", "displayName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveSession", "user", "saveSessionId", "saveUserToFirestore", "(Ledu/monash/fit5046/healthyrecipehub/data/model/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendEmailVerification", "signInWithGoogle", "idToken", "updateProfile", "photoUrl", "dietaryPreferences", "", "allergies", "dailyCalorieGoal", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class AuthRepository {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final edu.monash.fit5046.healthyrecipehub.data.local.database.AppDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.auth.FirebaseAuth firebaseAuth = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.CollectionReference usersCollection = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PREFS_NAME = "auth_prefs";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_USER_ID = "user_id";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_IS_LOGGED_IN = "is_logged_in";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_LAST_LOGIN = "last_login";
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
    public final java.lang.Object signInWithGoogle(@org.jetbrains.annotations.NotNull()
    java.lang.String idToken, @org.jetbrains.annotations.NotNull()
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
    
    private final java.lang.Object saveUserToFirestore(edu.monash.fit5046.healthyrecipehub.data.model.User user, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object getUserFromFirestore(java.lang.String userId, kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.model.User> $completion) {
        return null;
    }
    
    private final edu.monash.fit5046.healthyrecipehub.data.model.User createUserFromFirebaseUser(com.google.firebase.auth.FirebaseUser fb) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object sendEmailVerification(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.model.Result<kotlin.Unit>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getToken() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getIdToken(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    private final void saveSessionId(java.lang.String userId) {
    }
    
    private final void saveSession(edu.monash.fit5046.healthyrecipehub.data.model.User user) {
    }
    
    private final void clearSession() {
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
    
    private final java.lang.Object logActivity(java.lang.String userId, edu.monash.fit5046.healthyrecipehub.data.model.ActivityType type, java.lang.String details, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<edu.monash.fit5046.healthyrecipehub.data.model.User> getCurrentUserLive() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/repository/AuthRepository$Companion;", "", "()V", "KEY_IS_LOGGED_IN", "", "KEY_LAST_LOGIN", "KEY_USER_ID", "PREFS_NAME", "instance", "Ledu/monash/fit5046/healthyrecipehub/data/repository/AuthRepository;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
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