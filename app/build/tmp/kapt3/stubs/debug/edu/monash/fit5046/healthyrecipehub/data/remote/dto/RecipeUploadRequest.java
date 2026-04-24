package edu.monash.fit5046.healthyrecipehub.data.remote.dto;

/**
 * Recipe Upload Request
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u00b5\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0013\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013\u00a2\u0006\u0002\u0010\u0017J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u0007H\u00c6\u0003J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\u0003H\u00c6\u0003J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u00c6\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00150\u0013H\u00c6\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u00c6\u0003J\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\u0007H\u00c6\u0003J\t\u00107\u001a\u00020\tH\u00c6\u0003J\t\u00108\u001a\u00020\tH\u00c6\u0003J\t\u00109\u001a\u00020\tH\u00c6\u0003J\t\u0010:\u001a\u00020\u0007H\u00c6\u0003J\t\u0010;\u001a\u00020\u0007H\u00c6\u0003J\u00bd\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00132\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u00c6\u0001J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010@\u001a\u00020\u0007H\u00d6\u0001J\t\u0010A\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\r\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00138\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00138\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00138\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\"R\u0016\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0016\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001d\u00a8\u0006B"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/RecipeUploadRequest;", "", "title", "", "description", "imageUrl", "calories", "", "protein", "", "carbs", "fat", "prepTime", "cookTime", "servings", "difficulty", "category", "cuisine", "dietaryTags", "", "ingredients", "Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/IngredientDto;", "instructions", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IDDDIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getCalories", "()I", "getCarbs", "()D", "getCategory", "()Ljava/lang/String;", "getCookTime", "getCuisine", "getDescription", "getDietaryTags", "()Ljava/util/List;", "getDifficulty", "getFat", "getImageUrl", "getIngredients", "getInstructions", "getPrepTime", "getProtein", "getServings", "getTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class RecipeUploadRequest {
    @com.google.gson.annotations.SerializedName(value = "title")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @com.google.gson.annotations.SerializedName(value = "description")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    @com.google.gson.annotations.SerializedName(value = "imageUrl")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String imageUrl = null;
    @com.google.gson.annotations.SerializedName(value = "calories")
    private final int calories = 0;
    @com.google.gson.annotations.SerializedName(value = "protein")
    private final double protein = 0.0;
    @com.google.gson.annotations.SerializedName(value = "carbs")
    private final double carbs = 0.0;
    @com.google.gson.annotations.SerializedName(value = "fat")
    private final double fat = 0.0;
    @com.google.gson.annotations.SerializedName(value = "prepTime")
    private final int prepTime = 0;
    @com.google.gson.annotations.SerializedName(value = "cookTime")
    private final int cookTime = 0;
    @com.google.gson.annotations.SerializedName(value = "servings")
    private final int servings = 0;
    @com.google.gson.annotations.SerializedName(value = "difficulty")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String difficulty = null;
    @com.google.gson.annotations.SerializedName(value = "category")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String category = null;
    @com.google.gson.annotations.SerializedName(value = "cuisine")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String cuisine = null;
    @com.google.gson.annotations.SerializedName(value = "dietaryTags")
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> dietaryTags = null;
    @com.google.gson.annotations.SerializedName(value = "ingredients")
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.dto.IngredientDto> ingredients = null;
    @com.google.gson.annotations.SerializedName(value = "instructions")
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> instructions = null;
    
    public RecipeUploadRequest(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.lang.String imageUrl, int calories, double protein, double carbs, double fat, int prepTime, int cookTime, int servings, @org.jetbrains.annotations.NotNull()
    java.lang.String difficulty, @org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    java.lang.String cuisine, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> dietaryTags, @org.jetbrains.annotations.NotNull()
    java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.dto.IngredientDto> ingredients, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> instructions) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getImageUrl() {
        return null;
    }
    
    public final int getCalories() {
        return 0;
    }
    
    public final double getProtein() {
        return 0.0;
    }
    
    public final double getCarbs() {
        return 0.0;
    }
    
    public final double getFat() {
        return 0.0;
    }
    
    public final int getPrepTime() {
        return 0;
    }
    
    public final int getCookTime() {
        return 0;
    }
    
    public final int getServings() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDifficulty() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCuisine() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getDietaryTags() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.dto.IngredientDto> getIngredients() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getInstructions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    public final int component10() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.dto.IngredientDto> component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final double component5() {
        return 0.0;
    }
    
    public final double component6() {
        return 0.0;
    }
    
    public final double component7() {
        return 0.0;
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int component9() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final edu.monash.fit5046.healthyrecipehub.data.remote.dto.RecipeUploadRequest copy(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.lang.String imageUrl, int calories, double protein, double carbs, double fat, int prepTime, int cookTime, int servings, @org.jetbrains.annotations.NotNull()
    java.lang.String difficulty, @org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    java.lang.String cuisine, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> dietaryTags, @org.jetbrains.annotations.NotNull()
    java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.dto.IngredientDto> ingredients, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> instructions) {
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