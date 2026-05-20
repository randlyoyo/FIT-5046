package edu.monash.fit5046.healthyrecipehub.ui.viewmodel;

/**
 * Authentication ViewModel
 * Manages authentication UI state
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\'\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\nJ\u0006\u00100\u001a\u00020\bJ\u0006\u00101\u001a\u00020\bJ\u000e\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\nJ\b\u00104\u001a\u0004\u0018\u00010\nJ\u0006\u00105\u001a\u00020\u000eJ\u0006\u00106\u001a\u00020\u000eJ\u0016\u00107\u001a\u00020\b2\u0006\u00103\u001a\u00020\n2\u0006\u00108\u001a\u00020\nJ\u0006\u00109\u001a\u00020\bJ\u0006\u0010:\u001a\u00020\bJ\u001e\u0010;\u001a\u00020\b2\u0006\u00103\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\u0006\u0010<\u001a\u00020\nJ\u0006\u0010=\u001a\u00020\bJ\u000e\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\nJS\u0010@\u001a\u00020\b2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010B\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010C2\u0010\b\u0002\u0010D\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010C2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F\u00a2\u0006\u0002\u0010GR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u001d\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u001d\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u001d\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u001d\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u001d\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001d\u00a8\u0006H"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/ui/viewmodel/AuthViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_changePasswordResult", "Landroidx/lifecycle/MutableLiveData;", "Ledu/monash/fit5046/healthyrecipehub/data/model/Result;", "", "_errorMessage", "", "_googleSignInResult", "Ledu/monash/fit5046/healthyrecipehub/data/model/User;", "_isLoading", "", "_loginResult", "_passwordResetResult", "_profileUpdateResult", "_registerResult", "authRepository", "Ledu/monash/fit5046/healthyrecipehub/data/repository/AuthRepository;", "authState", "Lkotlinx/coroutines/flow/StateFlow;", "Ledu/monash/fit5046/healthyrecipehub/data/repository/AuthState;", "getAuthState", "()Lkotlinx/coroutines/flow/StateFlow;", "changePasswordResult", "Landroidx/lifecycle/LiveData;", "getChangePasswordResult", "()Landroidx/lifecycle/LiveData;", "currentUser", "getCurrentUser", "errorMessage", "getErrorMessage", "googleSignInResult", "getGoogleSignInResult", "isLoading", "loginResult", "getLoginResult", "passwordResetResult", "getPasswordResetResult", "profileUpdateResult", "getProfileUpdateResult", "registerResult", "getRegisterResult", "changePassword", "currentPassword", "newPassword", "clearError", "clearResults", "forgotPassword", "email", "getCurrentUserId", "isAdmin", "isLoggedIn", "login", "password", "logout", "refreshUserData", "register", "displayName", "sendEmailVerification", "signInWithGoogle", "idToken", "updateProfile", "photoUrl", "dietaryPreferences", "", "allergies", "dailyCalorieGoal", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;)V", "app_debug"})
public final class AuthViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final edu.monash.fit5046.healthyrecipehub.data.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<edu.monash.fit5046.healthyrecipehub.data.repository.AuthState> authState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<edu.monash.fit5046.healthyrecipehub.data.model.User> currentUser = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<edu.monash.fit5046.healthyrecipehub.data.model.User>> _loginResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<edu.monash.fit5046.healthyrecipehub.data.model.User>> loginResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<edu.monash.fit5046.healthyrecipehub.data.model.User>> _registerResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<edu.monash.fit5046.healthyrecipehub.data.model.User>> registerResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<kotlin.Unit>> _passwordResetResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<kotlin.Unit>> passwordResetResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<kotlin.Unit>> _changePasswordResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<kotlin.Unit>> changePasswordResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<edu.monash.fit5046.healthyrecipehub.data.model.User>> _profileUpdateResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<edu.monash.fit5046.healthyrecipehub.data.model.User>> profileUpdateResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<edu.monash.fit5046.healthyrecipehub.data.model.User>> _googleSignInResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<edu.monash.fit5046.healthyrecipehub.data.model.User>> googleSignInResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> errorMessage = null;
    
    public AuthViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<edu.monash.fit5046.healthyrecipehub.data.repository.AuthState> getAuthState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<edu.monash.fit5046.healthyrecipehub.data.model.User> getCurrentUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<edu.monash.fit5046.healthyrecipehub.data.model.User>> getLoginResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<edu.monash.fit5046.healthyrecipehub.data.model.User>> getRegisterResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<kotlin.Unit>> getPasswordResetResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<kotlin.Unit>> getChangePasswordResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<edu.monash.fit5046.healthyrecipehub.data.model.User>> getProfileUpdateResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<edu.monash.fit5046.healthyrecipehub.data.model.User>> getGoogleSignInResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getErrorMessage() {
        return null;
    }
    
    /**
     * Login with email and password
     */
    public final void login(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    /**
     * Register new account
     */
    public final void register(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    java.lang.String displayName) {
    }
    
    /**
     * Sign in with Google ID token
     */
    public final void signInWithGoogle(@org.jetbrains.annotations.NotNull()
    java.lang.String idToken) {
    }
    
    /**
     * Logout current user
     */
    public final void logout() {
    }
    
    /**
     * Send password reset email
     */
    public final void forgotPassword(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
    }
    
    /**
     * Change password
     */
    public final void changePassword(@org.jetbrains.annotations.NotNull()
    java.lang.String currentPassword, @org.jetbrains.annotations.NotNull()
    java.lang.String newPassword) {
    }
    
    /**
     * Update user profile
     */
    public final void updateProfile(@org.jetbrains.annotations.Nullable()
    java.lang.String displayName, @org.jetbrains.annotations.Nullable()
    java.lang.String photoUrl, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> dietaryPreferences, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> allergies, @org.jetbrains.annotations.Nullable()
    java.lang.Integer dailyCalorieGoal) {
    }
    
    /**
     * Refresh current user data
     */
    public final void refreshUserData() {
    }
    
    /**
     * Check if user is logged in
     */
    public final boolean isLoggedIn() {
        return false;
    }
    
    /**
     * Check if current user is admin
     */
    public final boolean isAdmin() {
        return false;
    }
    
    /**
     * Get current user ID
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCurrentUserId() {
        return null;
    }
    
    /**
     * Clear error message
     */
    public final void clearError() {
    }
    
    /**
     * Clear results
     */
    public final void sendEmailVerification() {
    }
    
    public final void clearResults() {
    }
}