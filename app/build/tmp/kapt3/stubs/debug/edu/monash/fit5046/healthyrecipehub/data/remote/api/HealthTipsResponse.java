package edu.monash.fit5046.healthyrecipehub.data.remote.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nH\u00c6\u0003J=\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\nH\u00d6\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001e"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/remote/api/HealthTipsResponse;", "", "success", "", "tips", "", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/HealthTip;", "dailyTargets", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/DailyTargets;", "error", "", "(ZLjava/util/List;Ledu/monash/fit5046/healthyrecipehub/data/remote/api/DailyTargets;Ljava/lang/String;)V", "getDailyTargets", "()Ledu/monash/fit5046/healthyrecipehub/data/remote/api/DailyTargets;", "getError", "()Ljava/lang/String;", "getSuccess", "()Z", "getTips", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class HealthTipsResponse {
    private final boolean success = false;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.api.HealthTip> tips = null;
    @org.jetbrains.annotations.Nullable()
    private final edu.monash.fit5046.healthyrecipehub.data.remote.api.DailyTargets dailyTargets = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String error = null;
    
    public HealthTipsResponse(boolean success, @org.jetbrains.annotations.Nullable()
    java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.api.HealthTip> tips, @org.jetbrains.annotations.Nullable()
    edu.monash.fit5046.healthyrecipehub.data.remote.api.DailyTargets dailyTargets, @org.jetbrains.annotations.Nullable()
    java.lang.String error) {
        super();
    }
    
    public final boolean getSuccess() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.api.HealthTip> getTips() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final edu.monash.fit5046.healthyrecipehub.data.remote.api.DailyTargets getDailyTargets() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getError() {
        return null;
    }
    
    public final boolean component1() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.api.HealthTip> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final edu.monash.fit5046.healthyrecipehub.data.remote.api.DailyTargets component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final edu.monash.fit5046.healthyrecipehub.data.remote.api.HealthTipsResponse copy(boolean success, @org.jetbrains.annotations.Nullable()
    java.util.List<edu.monash.fit5046.healthyrecipehub.data.remote.api.HealthTip> tips, @org.jetbrains.annotations.Nullable()
    edu.monash.fit5046.healthyrecipehub.data.remote.api.DailyTargets dailyTargets, @org.jetbrains.annotations.Nullable()
    java.lang.String error) {
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