package edu.monash.fit5046.healthyrecipehub.data.remote.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b9\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00b5\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0015J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u00103\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u00dd\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010?\u001a\u00020@H\u00d6\u0001J\t\u0010A\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017\u00a8\u0006B"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/remote/api/MealDto;", "", "idMeal", "", "strMeal", "strCategory", "strArea", "strInstructions", "strMealThumb", "strTags", "strYoutube", "strIngredient1", "strIngredient2", "strIngredient3", "strIngredient4", "strIngredient5", "strMeasure1", "strMeasure2", "strMeasure3", "strMeasure4", "strMeasure5", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIdMeal", "()Ljava/lang/String;", "getStrArea", "getStrCategory", "getStrIngredient1", "getStrIngredient2", "getStrIngredient3", "getStrIngredient4", "getStrIngredient5", "getStrInstructions", "getStrMeal", "getStrMealThumb", "getStrMeasure1", "getStrMeasure2", "getStrMeasure3", "getStrMeasure4", "getStrMeasure5", "getStrTags", "getStrYoutube", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class MealDto {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String idMeal = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String strMeal = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String strCategory = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String strArea = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String strInstructions = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String strMealThumb = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String strTags = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String strYoutube = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String strIngredient1 = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String strIngredient2 = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String strIngredient3 = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String strIngredient4 = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String strIngredient5 = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String strMeasure1 = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String strMeasure2 = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String strMeasure3 = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String strMeasure4 = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String strMeasure5 = null;
    
    public MealDto(@org.jetbrains.annotations.NotNull()
    java.lang.String idMeal, @org.jetbrains.annotations.NotNull()
    java.lang.String strMeal, @org.jetbrains.annotations.Nullable()
    java.lang.String strCategory, @org.jetbrains.annotations.Nullable()
    java.lang.String strArea, @org.jetbrains.annotations.Nullable()
    java.lang.String strInstructions, @org.jetbrains.annotations.Nullable()
    java.lang.String strMealThumb, @org.jetbrains.annotations.Nullable()
    java.lang.String strTags, @org.jetbrains.annotations.Nullable()
    java.lang.String strYoutube, @org.jetbrains.annotations.Nullable()
    java.lang.String strIngredient1, @org.jetbrains.annotations.Nullable()
    java.lang.String strIngredient2, @org.jetbrains.annotations.Nullable()
    java.lang.String strIngredient3, @org.jetbrains.annotations.Nullable()
    java.lang.String strIngredient4, @org.jetbrains.annotations.Nullable()
    java.lang.String strIngredient5, @org.jetbrains.annotations.Nullable()
    java.lang.String strMeasure1, @org.jetbrains.annotations.Nullable()
    java.lang.String strMeasure2, @org.jetbrains.annotations.Nullable()
    java.lang.String strMeasure3, @org.jetbrains.annotations.Nullable()
    java.lang.String strMeasure4, @org.jetbrains.annotations.Nullable()
    java.lang.String strMeasure5) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIdMeal() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStrMeal() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStrCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStrArea() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStrInstructions() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStrMealThumb() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStrTags() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStrYoutube() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStrIngredient1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStrIngredient2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStrIngredient3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStrIngredient4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStrIngredient5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStrMeasure1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStrMeasure2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStrMeasure3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStrMeasure4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStrMeasure5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component18() {
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final edu.monash.fit5046.healthyrecipehub.data.remote.api.MealDto copy(@org.jetbrains.annotations.NotNull()
    java.lang.String idMeal, @org.jetbrains.annotations.NotNull()
    java.lang.String strMeal, @org.jetbrains.annotations.Nullable()
    java.lang.String strCategory, @org.jetbrains.annotations.Nullable()
    java.lang.String strArea, @org.jetbrains.annotations.Nullable()
    java.lang.String strInstructions, @org.jetbrains.annotations.Nullable()
    java.lang.String strMealThumb, @org.jetbrains.annotations.Nullable()
    java.lang.String strTags, @org.jetbrains.annotations.Nullable()
    java.lang.String strYoutube, @org.jetbrains.annotations.Nullable()
    java.lang.String strIngredient1, @org.jetbrains.annotations.Nullable()
    java.lang.String strIngredient2, @org.jetbrains.annotations.Nullable()
    java.lang.String strIngredient3, @org.jetbrains.annotations.Nullable()
    java.lang.String strIngredient4, @org.jetbrains.annotations.Nullable()
    java.lang.String strIngredient5, @org.jetbrains.annotations.Nullable()
    java.lang.String strMeasure1, @org.jetbrains.annotations.Nullable()
    java.lang.String strMeasure2, @org.jetbrains.annotations.Nullable()
    java.lang.String strMeasure3, @org.jetbrains.annotations.Nullable()
    java.lang.String strMeasure4, @org.jetbrains.annotations.Nullable()
    java.lang.String strMeasure5) {
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