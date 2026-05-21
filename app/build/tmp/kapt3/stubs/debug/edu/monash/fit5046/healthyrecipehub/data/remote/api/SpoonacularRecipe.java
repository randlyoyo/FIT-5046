package edu.monash.fit5046.healthyrecipehub.data.remote.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u00bb\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0016J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bH\u00c6\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000bH\u00c6\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0013H\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010/\u001a\u00020\u0005H\u00c6\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\t\u00103\u001a\u00020\u0003H\u00c6\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bH\u00c6\u0003J\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bH\u00c6\u0003J\u0011\u00106\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bH\u00c6\u0003J\u00c7\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010;\u001a\u00020\u0003H\u00d6\u0001J\t\u0010<\u001a\u00020\u0005H\u00d6\u0001R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010 \u00a8\u0006="}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/remote/api/SpoonacularRecipe;", "", "id", "", "title", "", "image", "summary", "readyInMinutes", "servings", "dishTypes", "", "cuisines", "diets", "extendedIngredients", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/SpoonacularIngredient;", "analyzedInstructions", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/SpoonacularInstruction;", "nutrition", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/SpoonacularNutrition;", "sourceUrl", "spoonacularSourceUrl", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ledu/monash/fit5046/healthyrecipehub/data/remote/api/SpoonacularNutrition;Ljava/lang/String;Ljava/lang/String;)V", "getAnalyzedInstructions", "()Ljava/util/List;", "getCuisines", "getDiets", "getDishTypes", "getExtendedIngredients", "getId", "()I", "getImage", "()Ljava/lang/String;", "getNutrition", "()Ledu/monash/fit5046/healthyrecipehub/data/remote/api/SpoonacularNutrition;", "getReadyInMinutes", "getServings", "getSourceUrl", "getSpoonacularSourceUrl", "getSummary", "getTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class SpoonacularRecipe {
    private final int id = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String image = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String summary = null;
    private final int readyInMinutes = 0;
    private final int servings = 0;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> dishTypes = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> cuisines = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> diets = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularIngredient> extendedIngredients = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularInstruction> analyzedInstructions = null;
    @org.jetbrains.annotations.Nullable()
    private final edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularNutrition nutrition = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String sourceUrl = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String spoonacularSourceUrl = null;
    
    public SpoonacularRecipe(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.Nullable()
    java.lang.String image, @org.jetbrains.annotations.Nullable()
    java.lang.String summary, int readyInMinutes, int servings, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> dishTypes, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> cuisines, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> diets, @org.jetbrains.annotations.Nullable()
    java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularIngredient> extendedIngredients, @org.jetbrains.annotations.Nullable()
    java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularInstruction> analyzedInstructions, @org.jetbrains.annotations.Nullable()
    edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularNutrition nutrition, @org.jetbrains.annotations.Nullable()
    java.lang.String sourceUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String spoonacularSourceUrl) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getImage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSummary() {
        return null;
    }
    
    public final int getReadyInMinutes() {
        return 0;
    }
    
    public final int getServings() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getDishTypes() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getCuisines() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getDiets() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularIngredient> getExtendedIngredients() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularInstruction> getAnalyzedInstructions() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularNutrition getNutrition() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSourceUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSpoonacularSourceUrl() {
        return null;
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularIngredient> component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularInstruction> component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularNutrition component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component14() {
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int component6() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularRecipe copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.Nullable()
    java.lang.String image, @org.jetbrains.annotations.Nullable()
    java.lang.String summary, int readyInMinutes, int servings, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> dishTypes, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> cuisines, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> diets, @org.jetbrains.annotations.Nullable()
    java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularIngredient> extendedIngredients, @org.jetbrains.annotations.Nullable()
    java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularInstruction> analyzedInstructions, @org.jetbrains.annotations.Nullable()
    edu.monash.fit5046.healthyrecipehub.data.remote.api.SpoonacularNutrition nutrition, @org.jetbrains.annotations.Nullable()
    java.lang.String sourceUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String spoonacularSourceUrl) {
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