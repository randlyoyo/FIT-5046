package edu.monash.fit5046.healthyrecipehub.data.remote.dto;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006H\u00c6\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006H\u00c6\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJV\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u00c6\u0001\u00a2\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\tH\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012\u00a8\u0006 "}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/UpdateProfileRequest;", "", "displayName", "", "photoUrl", "dietaryPreferences", "", "allergies", "dailyCalorieGoal", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;)V", "getAllergies", "()Ljava/util/List;", "getDailyCalorieGoal", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDietaryPreferences", "getDisplayName", "()Ljava/lang/String;", "getPhotoUrl", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;)Ledu/monash/fit5046/healthyrecipehub/data/remote/dto/UpdateProfileRequest;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class UpdateProfileRequest {
    @com.google.gson.annotations.SerializedName(value = "displayName")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String displayName = null;
    @com.google.gson.annotations.SerializedName(value = "photoUrl")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String photoUrl = null;
    @com.google.gson.annotations.SerializedName(value = "dietaryPreferences")
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> dietaryPreferences = null;
    @com.google.gson.annotations.SerializedName(value = "allergies")
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> allergies = null;
    @com.google.gson.annotations.SerializedName(value = "dailyCalorieGoal")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer dailyCalorieGoal = null;
    
    public UpdateProfileRequest(@org.jetbrains.annotations.Nullable()
    java.lang.String displayName, @org.jetbrains.annotations.Nullable()
    java.lang.String photoUrl, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> dietaryPreferences, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> allergies, @org.jetbrains.annotations.Nullable()
    java.lang.Integer dailyCalorieGoal) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDisplayName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPhotoUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getDietaryPreferences() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getAllergies() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getDailyCalorieGoal() {
        return null;
    }
    
    public UpdateProfileRequest() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final edu.monash.fit5046.healthyrecipehub.data.remote.dto.UpdateProfileRequest copy(@org.jetbrains.annotations.Nullable()
    java.lang.String displayName, @org.jetbrains.annotations.Nullable()
    java.lang.String photoUrl, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> dietaryPreferences, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> allergies, @org.jetbrains.annotations.Nullable()
    java.lang.Integer dailyCalorieGoal) {
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