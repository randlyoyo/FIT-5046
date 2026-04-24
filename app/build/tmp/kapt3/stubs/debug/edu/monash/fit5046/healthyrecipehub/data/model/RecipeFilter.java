package edu.monash.fit5046.healthyrecipehub.data.model;

/**
 * Recipe Filter Options
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0017J\u0010\u0010$\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001aJ\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u00c6\u0003J\t\u0010&\u001a\u00020\u000eH\u00c6\u0003Jn\u0010\'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u00c6\u0001\u00a2\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010,\u001a\u00020\bH\u00d6\u0001J\t\u0010-\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006."}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/model/RecipeFilter;", "", "query", "", "category", "cuisine", "difficulty", "maxCalories", "", "minNutritionScore", "", "dietaryTags", "", "sortBy", "Ledu/monash/fit5046/healthyrecipehub/data/model/SortOption;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/util/List;Ledu/monash/fit5046/healthyrecipehub/data/model/SortOption;)V", "getCategory", "()Ljava/lang/String;", "getCuisine", "getDietaryTags", "()Ljava/util/List;", "getDifficulty", "getMaxCalories", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMinNutritionScore", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getQuery", "getSortBy", "()Ledu/monash/fit5046/healthyrecipehub/data/model/SortOption;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/util/List;Ledu/monash/fit5046/healthyrecipehub/data/model/SortOption;)Ledu/monash/fit5046/healthyrecipehub/data/model/RecipeFilter;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class RecipeFilter {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String query = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String category = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String cuisine = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String difficulty = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer maxCalories = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double minNutritionScore = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> dietaryTags = null;
    @org.jetbrains.annotations.NotNull()
    private final edu.monash.fit5046.healthyrecipehub.data.model.SortOption sortBy = null;
    
    public RecipeFilter(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.Nullable()
    java.lang.String category, @org.jetbrains.annotations.Nullable()
    java.lang.String cuisine, @org.jetbrains.annotations.Nullable()
    java.lang.String difficulty, @org.jetbrains.annotations.Nullable()
    java.lang.Integer maxCalories, @org.jetbrains.annotations.Nullable()
    java.lang.Double minNutritionScore, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> dietaryTags, @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.SortOption sortBy) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getQuery() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCuisine() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDifficulty() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getMaxCalories() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getMinNutritionScore() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getDietaryTags() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final edu.monash.fit5046.healthyrecipehub.data.model.SortOption getSortBy() {
        return null;
    }
    
    public RecipeFilter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final edu.monash.fit5046.healthyrecipehub.data.model.SortOption component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final edu.monash.fit5046.healthyrecipehub.data.model.RecipeFilter copy(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.Nullable()
    java.lang.String category, @org.jetbrains.annotations.Nullable()
    java.lang.String cuisine, @org.jetbrains.annotations.Nullable()
    java.lang.String difficulty, @org.jetbrains.annotations.Nullable()
    java.lang.Integer maxCalories, @org.jetbrains.annotations.Nullable()
    java.lang.Double minNutritionScore, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> dietaryTags, @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.SortOption sortBy) {
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