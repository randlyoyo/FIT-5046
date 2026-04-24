package edu.monash.fit5046.healthyrecipehub.data.remote.dto;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b;\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0017\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017\u0012\b\b\u0002\u0010\u001b\u001a\u00020\n\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u00a2\u0006\u0002\u0010!J\t\u0010@\u001a\u00020\u0003H\u00c6\u0003J\t\u0010A\u001a\u00020\nH\u00c6\u0003J\t\u0010B\u001a\u00020\nH\u00c6\u0003J\t\u0010C\u001a\u00020\bH\u00c6\u0003J\t\u0010D\u001a\u00020\bH\u00c6\u0003J\t\u0010E\u001a\u00020\bH\u00c6\u0003J\t\u0010F\u001a\u00020\u0003H\u00c6\u0003J\t\u0010G\u001a\u00020\u0003H\u00c6\u0003J\t\u0010H\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017H\u00c6\u0003J\u000f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00190\u0017H\u00c6\u0003J\t\u0010K\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017H\u00c6\u0003J\t\u0010M\u001a\u00020\nH\u00c6\u0003J\t\u0010N\u001a\u00020\u0003H\u00c6\u0003J\t\u0010O\u001a\u00020\u0003H\u00c6\u0003J\t\u0010P\u001a\u00020\u001fH\u00c6\u0003J\t\u0010Q\u001a\u00020\u001fH\u00c6\u0003J\t\u0010R\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010T\u001a\u00020\bH\u00c6\u0003J\t\u0010U\u001a\u00020\nH\u00c6\u0003J\t\u0010V\u001a\u00020\nH\u00c6\u0003J\t\u0010W\u001a\u00020\nH\u00c6\u0003J\t\u0010X\u001a\u00020\nH\u00c6\u0003J\u0097\u0002\u0010Y\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00172\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\b\b\u0002\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001fH\u00c6\u0001J\u0013\u0010Z\u001a\u00020[2\b\u0010\\\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010]\u001a\u00020\bH\u00d6\u0001J\u0006\u0010^\u001a\u00020_J\t\u0010`\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u001c\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\u001d\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0016\u0010\u0011\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010&R\u0016\u0010\u001e\u001a\u00020\u001f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010#R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010#R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00178\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010#R\u0016\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010(R\u0016\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010(R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010#R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010#R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00178\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00100R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00178\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00100R\u0016\u0010\u001b\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010(R\u0016\u0010\u0010\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010&R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010(R\u0016\u0010\u0012\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010&R\u0016\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010(R\u0016\u0010\u000e\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010(R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010#R\u0016\u0010 \u001a\u00020\u001f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010,\u00a8\u0006a"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/RecipeDto;", "", "id", "", "title", "description", "imageUrl", "calories", "", "protein", "", "carbs", "fat", "fiber", "sugar", "sodium", "prepTime", "cookTime", "servings", "difficulty", "category", "cuisine", "dietaryTags", "", "ingredients", "Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/IngredientDto;", "instructions", "nutritionScore", "authorId", "authorName", "createdAt", "", "updatedAt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IDDDDDDIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;DLjava/lang/String;Ljava/lang/String;JJ)V", "getAuthorId", "()Ljava/lang/String;", "getAuthorName", "getCalories", "()I", "getCarbs", "()D", "getCategory", "getCookTime", "getCreatedAt", "()J", "getCuisine", "getDescription", "getDietaryTags", "()Ljava/util/List;", "getDifficulty", "getFat", "getFiber", "getId", "getImageUrl", "getIngredients", "getInstructions", "getNutritionScore", "getPrepTime", "getProtein", "getServings", "getSodium", "getSugar", "getTitle", "getUpdatedAt", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toRecipe", "Ledu/monash/fit5046/healthyrecipehub/data/model/Recipe;", "toString", "app_debug"})
public final class RecipeDto {
    @com.google.gson.annotations.SerializedName(value = "id")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
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
    @com.google.gson.annotations.SerializedName(value = "fiber")
    private final double fiber = 0.0;
    @com.google.gson.annotations.SerializedName(value = "sugar")
    private final double sugar = 0.0;
    @com.google.gson.annotations.SerializedName(value = "sodium")
    private final double sodium = 0.0;
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
    @com.google.gson.annotations.SerializedName(value = "nutritionScore")
    private final double nutritionScore = 0.0;
    @com.google.gson.annotations.SerializedName(value = "authorId")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String authorId = null;
    @com.google.gson.annotations.SerializedName(value = "authorName")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String authorName = null;
    @com.google.gson.annotations.SerializedName(value = "createdAt")
    private final long createdAt = 0L;
    @com.google.gson.annotations.SerializedName(value = "updatedAt")
    private final long updatedAt = 0L;
    
    public RecipeDto(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.lang.String imageUrl, int calories, double protein, double carbs, double fat, double fiber, double sugar, double sodium, int prepTime, int cookTime, int servings, @org.jetbrains.annotations.NotNull()
    java.lang.String difficulty, @org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    java.lang.String cuisine, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> dietaryTags, @org.jetbrains.annotations.NotNull()
    java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.dto.IngredientDto> ingredients, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> instructions, double nutritionScore, @org.jetbrains.annotations.NotNull()
    java.lang.String authorId, @org.jetbrains.annotations.NotNull()
    java.lang.String authorName, long createdAt, long updatedAt) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
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
    
    public final double getFiber() {
        return 0.0;
    }
    
    public final double getSugar() {
        return 0.0;
    }
    
    public final double getSodium() {
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
    
    public final double getNutritionScore() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAuthorId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAuthorName() {
        return null;
    }
    
    public final long getCreatedAt() {
        return 0L;
    }
    
    public final long getUpdatedAt() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final edu.monash.fit5046.healthyrecipehub.data.model.Recipe toRecipe() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    public final double component10() {
        return 0.0;
    }
    
    public final double component11() {
        return 0.0;
    }
    
    public final int component12() {
        return 0;
    }
    
    public final int component13() {
        return 0;
    }
    
    public final int component14() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.dto.IngredientDto> component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component20() {
        return null;
    }
    
    public final double component21() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component22() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component23() {
        return null;
    }
    
    public final long component24() {
        return 0L;
    }
    
    public final long component25() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final double component6() {
        return 0.0;
    }
    
    public final double component7() {
        return 0.0;
    }
    
    public final double component8() {
        return 0.0;
    }
    
    public final double component9() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final edu.monash.fit5046.healthyrecipehub.data.remote.dto.RecipeDto copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.lang.String imageUrl, int calories, double protein, double carbs, double fat, double fiber, double sugar, double sodium, int prepTime, int cookTime, int servings, @org.jetbrains.annotations.NotNull()
    java.lang.String difficulty, @org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    java.lang.String cuisine, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> dietaryTags, @org.jetbrains.annotations.NotNull()
    java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.dto.IngredientDto> ingredients, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> instructions, double nutritionScore, @org.jetbrains.annotations.NotNull()
    java.lang.String authorId, @org.jetbrains.annotations.NotNull()
    java.lang.String authorName, long createdAt, long updatedAt) {
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