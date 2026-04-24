package edu.monash.fit5046.healthyrecipehub.ui.viewmodel;

/**
 * Admin ViewModel
 * Manages admin dashboard functionality
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010&\u001a\u00020\n2\u0006\u0010\'\u001a\u00020(J\u0006\u0010)\u001a\u00020\nJ\u000e\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020(J\u000e\u0010,\u001a\u00020\n2\u0006\u0010+\u001a\u00020(J\u000e\u0010-\u001a\u00020\n2\u0006\u0010+\u001a\u00020(J\u0006\u0010.\u001a\u00020\nJ\u001a\u0010/\u001a\u00020\n2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u000201J\u0016\u00103\u001a\u00020\n2\u0006\u0010\'\u001a\u00020(2\u0006\u00104\u001a\u00020(J\u0016\u00105\u001a\u00020\n2\u0006\u0010+\u001a\u00020(2\u0006\u00106\u001a\u000207R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001bR\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\f0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u001d\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\f0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR#\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\f0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001b\u00a8\u00068"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/ui/viewmodel/AdminViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_isLoading", "Landroidx/lifecycle/MutableLiveData;", "", "_operationResult", "Ledu/monash/fit5046/healthyrecipehub/data/model/Result;", "", "_recipeStats", "Ledu/monash/fit5046/healthyrecipehub/data/model/Resource;", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/RecipeStatisticsDto;", "_statistics", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/StatisticsResponse;", "_userStats", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/UserStatisticsDto;", "_users", "", "Ledu/monash/fit5046/healthyrecipehub/data/model/User;", "adminApiService", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/AdminApiService;", "authRepository", "Ledu/monash/fit5046/healthyrecipehub/data/repository/AuthRepository;", "isLoading", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "operationResult", "getOperationResult", "recipeStats", "getRecipeStats", "statistics", "getStatistics", "userStats", "getUserStats", "users", "getUsers", "approveRecipe", "recipeId", "", "clearOperationResult", "deleteUser", "userId", "disableUser", "enableUser", "loadStatistics", "loadUsers", "page", "", "limit", "rejectRecipe", "reason", "updateUserRole", "role", "Ledu/monash/fit5046/healthyrecipehub/data/model/UserRole;", "app_debug"})
public final class AdminViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final edu.monash.fit5046.healthyrecipehub.data.remote.api.AdminApiService adminApiService = null;
    @org.jetbrains.annotations.NotNull()
    private final edu.monash.fit5046.healthyrecipehub.data.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.User>>> _users = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.User>>> users = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<edu.monash.fit5046.healthyrecipehub.data.remote.api.StatisticsResponse>> _statistics = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<edu.monash.fit5046.healthyrecipehub.data.remote.api.StatisticsResponse>> statistics = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<edu.monash.fit5046.healthyrecipehub.data.remote.api.UserStatisticsDto>> _userStats = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<edu.monash.fit5046.healthyrecipehub.data.remote.api.UserStatisticsDto>> userStats = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<edu.monash.fit5046.healthyrecipehub.data.remote.api.RecipeStatisticsDto>> _recipeStats = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<edu.monash.fit5046.healthyrecipehub.data.remote.api.RecipeStatisticsDto>> recipeStats = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<kotlin.Unit>> _operationResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<kotlin.Unit>> operationResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading = null;
    
    public AdminViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.User>>> getUsers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<edu.monash.fit5046.healthyrecipehub.data.remote.api.StatisticsResponse>> getStatistics() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<edu.monash.fit5046.healthyrecipehub.data.remote.api.UserStatisticsDto>> getUserStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Resource<edu.monash.fit5046.healthyrecipehub.data.remote.api.RecipeStatisticsDto>> getRecipeStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<edu.monash.fit5046.healthyrecipehub.data.model.Result<kotlin.Unit>> getOperationResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    /**
     * Load all users
     */
    public final void loadUsers(int page, int limit) {
    }
    
    /**
     * Load statistics
     */
    public final void loadStatistics() {
    }
    
    /**
     * Update user role
     */
    public final void updateUserRole(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.UserRole role) {
    }
    
    /**
     * Delete user
     */
    public final void deleteUser(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
    }
    
    /**
     * Disable user
     */
    public final void disableUser(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
    }
    
    /**
     * Enable user
     */
    public final void enableUser(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
    }
    
    /**
     * Approve recipe
     */
    public final void approveRecipe(@org.jetbrains.annotations.NotNull()
    java.lang.String recipeId) {
    }
    
    /**
     * Reject recipe
     */
    public final void rejectRecipe(@org.jetbrains.annotations.NotNull()
    java.lang.String recipeId, @org.jetbrains.annotations.NotNull()
    java.lang.String reason) {
    }
    
    public final void clearOperationResult() {
    }
}