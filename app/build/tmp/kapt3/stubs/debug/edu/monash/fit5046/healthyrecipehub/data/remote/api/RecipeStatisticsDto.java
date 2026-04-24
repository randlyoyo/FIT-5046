package edu.monash.fit5046.healthyrecipehub.data.remote.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\u0015\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00c6\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0003JM\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001f\u001a\u00020\bH\u00d6\u0001R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010\u00a8\u0006 "}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/remote/api/RecipeStatisticsDto;", "", "totalRecipes", "", "recipesThisWeek", "pendingRecipes", "categoryDistribution", "", "", "recipeGrowthData", "", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/DailyCount;", "(IIILjava/util/Map;Ljava/util/List;)V", "getCategoryDistribution", "()Ljava/util/Map;", "getPendingRecipes", "()I", "getRecipeGrowthData", "()Ljava/util/List;", "getRecipesThisWeek", "getTotalRecipes", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class RecipeStatisticsDto {
    private final int totalRecipes = 0;
    private final int recipesThisWeek = 0;
    private final int pendingRecipes = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.Integer> categoryDistribution = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.api.DailyCount> recipeGrowthData = null;
    
    public RecipeStatisticsDto(int totalRecipes, int recipesThisWeek, int pendingRecipes, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Integer> categoryDistribution, @org.jetbrains.annotations.NotNull()
    java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.api.DailyCount> recipeGrowthData) {
        super();
    }
    
    public final int getTotalRecipes() {
        return 0;
    }
    
    public final int getRecipesThisWeek() {
        return 0;
    }
    
    public final int getPendingRecipes() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Integer> getCategoryDistribution() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.api.DailyCount> getRecipeGrowthData() {
        return null;
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int component3() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Integer> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.api.DailyCount> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final edu.monash.fit5046.healthyrecipehub.data.remote.api.RecipeStatisticsDto copy(int totalRecipes, int recipesThisWeek, int pendingRecipes, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Integer> categoryDistribution, @org.jetbrains.annotations.NotNull()
    java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.api.DailyCount> recipeGrowthData) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}