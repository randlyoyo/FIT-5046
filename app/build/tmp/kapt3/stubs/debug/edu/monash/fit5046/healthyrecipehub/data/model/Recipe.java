package edu.monash.fit5046.healthyrecipehub.data.model;

/**
 * Recipe Entity for Room Database
 * FIT5046 - Healthy Recipe Hub Data Model
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b@\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u00a1\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0017\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017\u0012\b\b\u0002\u0010\u001b\u001a\u00020\n\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\"\u0012\b\b\u0002\u0010#\u001a\u00020\"\u00a2\u0006\u0002\u0010$J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\t\u0010E\u001a\u00020\nH\u00c6\u0003J\t\u0010F\u001a\u00020\nH\u00c6\u0003J\t\u0010G\u001a\u00020\bH\u00c6\u0003J\t\u0010H\u001a\u00020\bH\u00c6\u0003J\t\u0010I\u001a\u00020\bH\u00c6\u0003J\t\u0010J\u001a\u00020\u0003H\u00c6\u0003J\t\u0010K\u001a\u00020\u0003H\u00c6\u0003J\t\u0010L\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017H\u00c6\u0003J\u000f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00190\u0017H\u00c6\u0003J\t\u0010O\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017H\u00c6\u0003J\t\u0010Q\u001a\u00020\nH\u00c6\u0003J\t\u0010R\u001a\u00020\u0003H\u00c6\u0003J\t\u0010S\u001a\u00020\u0003H\u00c6\u0003J\t\u0010T\u001a\u00020\u001fH\u00c6\u0003J\t\u0010U\u001a\u00020\u001fH\u00c6\u0003J\t\u0010V\u001a\u00020\"H\u00c6\u0003J\t\u0010W\u001a\u00020\"H\u00c6\u0003J\t\u0010X\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010Z\u001a\u00020\bH\u00c6\u0003J\t\u0010[\u001a\u00020\nH\u00c6\u0003J\t\u0010\\\u001a\u00020\nH\u00c6\u0003J\t\u0010]\u001a\u00020\nH\u00c6\u0003J\t\u0010^\u001a\u00020\nH\u00c6\u0003J\u00ab\u0002\u0010_\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00172\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\b\b\u0002\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"H\u00c6\u0001J\t\u0010`\u001a\u00020\bH\u00d6\u0001J\u0013\u0010a\u001a\u00020\"2\b\u0010b\u001a\u0004\u0018\u00010cH\u00d6\u0003J\t\u0010d\u001a\u00020\bH\u00d6\u0001J\t\u0010e\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020\bH\u00d6\u0001R\u0011\u0010\u001c\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u001d\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010&R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u000b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010&R\u0011\u0010\u0011\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010)R\u0011\u0010\u001e\u001a\u00020\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010&R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010&R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010&R\u0011\u0010\f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010+R\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010+R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010&R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010&R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u00103R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u00103R\u0011\u0010!\u001a\u00020\"\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010;R\u0011\u0010#\u001a\u00020\"\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010;R\u0011\u0010\u001b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010+R\u0011\u0010\u0010\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010)R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010+R\u0011\u0010\u0012\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010)R\u0011\u0010\u000f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010+R\u0011\u0010\u000e\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010+R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010&R\u0011\u0010 \u001a\u00020\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010/\u00a8\u0006k"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/model/Recipe;", "Landroid/os/Parcelable;", "id", "", "title", "description", "imageUrl", "calories", "", "protein", "", "carbs", "fat", "fiber", "sugar", "sodium", "prepTime", "cookTime", "servings", "difficulty", "category", "cuisine", "dietaryTags", "", "ingredients", "Ledu/monash/fit5046/healthyrecipehub/data/model/Ingredient;", "instructions", "nutritionScore", "authorId", "authorName", "createdAt", "", "updatedAt", "isFavorite", "", "isOffline", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IDDDDDDIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;DLjava/lang/String;Ljava/lang/String;JJZZ)V", "getAuthorId", "()Ljava/lang/String;", "getAuthorName", "getCalories", "()I", "getCarbs", "()D", "getCategory", "getCookTime", "getCreatedAt", "()J", "getCuisine", "getDescription", "getDietaryTags", "()Ljava/util/List;", "getDifficulty", "getFat", "getFiber", "getId", "getImageUrl", "getIngredients", "getInstructions", "()Z", "getNutritionScore", "getPrepTime", "getProtein", "getServings", "getSodium", "getSugar", "getTitle", "getUpdatedAt", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
@kotlinx.parcelize.Parcelize()
@androidx.room.Entity(tableName = "recipes")
@androidx.room.TypeConverters(value = {edu.monash.fit5046.healthyrecipehub.data.local.converter.ListConverter.class})
public final class Recipe implements android.os.Parcelable {
    @androidx.room.PrimaryKey()
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String imageUrl = null;
    private final int calories = 0;
    private final double protein = 0.0;
    private final double carbs = 0.0;
    private final double fat = 0.0;
    private final double fiber = 0.0;
    private final double sugar = 0.0;
    private final double sodium = 0.0;
    private final int prepTime = 0;
    private final int cookTime = 0;
    private final int servings = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String difficulty = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String category = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String cuisine = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> dietaryTags = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Ingredient> ingredients = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> instructions = null;
    private final double nutritionScore = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String authorId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String authorName = null;
    private final long createdAt = 0L;
    private final long updatedAt = 0L;
    private final boolean isFavorite = false;
    private final boolean isOffline = false;
    
    public Recipe(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.lang.String imageUrl, int calories, double protein, double carbs, double fat, double fiber, double sugar, double sodium, int prepTime, int cookTime, int servings, @org.jetbrains.annotations.NotNull()
    java.lang.String difficulty, @org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    java.lang.String cuisine, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> dietaryTags, @org.jetbrains.annotations.NotNull()
    java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Ingredient> ingredients, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> instructions, double nutritionScore, @org.jetbrains.annotations.NotNull()
    java.lang.String authorId, @org.jetbrains.annotations.NotNull()
    java.lang.String authorName, long createdAt, long updatedAt, boolean isFavorite, boolean isOffline) {
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
    public final java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Ingredient> getIngredients() {
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
    
    public final boolean isFavorite() {
        return false;
    }
    
    public final boolean isOffline() {
        return false;
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
    public final java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Ingredient> component19() {
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
    
    public final boolean component26() {
        return false;
    }
    
    public final boolean component27() {
        return false;
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
    public final edu.monash.fit5046.healthyrecipehub.data.model.Recipe copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.lang.String imageUrl, int calories, double protein, double carbs, double fat, double fiber, double sugar, double sodium, int prepTime, int cookTime, int servings, @org.jetbrains.annotations.NotNull()
    java.lang.String difficulty, @org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    java.lang.String cuisine, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> dietaryTags, @org.jetbrains.annotations.NotNull()
    java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.Ingredient> ingredients, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> instructions, double nutritionScore, @org.jetbrains.annotations.NotNull()
    java.lang.String authorId, @org.jetbrains.annotations.NotNull()
    java.lang.String authorName, long createdAt, long updatedAt, boolean isFavorite, boolean isOffline) {
        return null;
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
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
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
}