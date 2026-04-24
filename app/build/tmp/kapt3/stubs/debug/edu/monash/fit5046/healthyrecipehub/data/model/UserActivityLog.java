package edu.monash.fit5046.healthyrecipehub.data.model;

/**
 * User Activity Log
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r\u00a8\u0006\u001c"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/model/UserActivityLog;", "", "userId", "", "timestamp", "", "activityType", "Ledu/monash/fit5046/healthyrecipehub/data/model/ActivityType;", "details", "(Ljava/lang/String;JLedu/monash/fit5046/healthyrecipehub/data/model/ActivityType;Ljava/lang/String;)V", "getActivityType", "()Ledu/monash/fit5046/healthyrecipehub/data/model/ActivityType;", "getDetails", "()Ljava/lang/String;", "getTimestamp", "()J", "getUserId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
@androidx.room.Entity(tableName = "activity_logs", primaryKeys = {"userId", "timestamp"})
public final class UserActivityLog {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String userId = null;
    private final long timestamp = 0L;
    @org.jetbrains.annotations.NotNull()
    private final edu.monash.fit5046.healthyrecipehub.data.model.ActivityType activityType = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String details = null;
    
    public UserActivityLog(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, long timestamp, @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.ActivityType activityType, @org.jetbrains.annotations.Nullable()
    java.lang.String details) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserId() {
        return null;
    }
    
    public final long getTimestamp() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final edu.monash.fit5046.healthyrecipehub.data.model.ActivityType getActivityType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDetails() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    public final long component2() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final edu.monash.fit5046.healthyrecipehub.data.model.ActivityType component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final edu.monash.fit5046.healthyrecipehub.data.model.UserActivityLog copy(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, long timestamp, @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.ActivityType activityType, @org.jetbrains.annotations.Nullable()
    java.lang.String details) {
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