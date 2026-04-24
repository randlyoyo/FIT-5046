package edu.monash.fit5046.healthyrecipehub.data.model;

/**
 * Store/Health Food Store Model
 * For Mapbox map integration
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015\u00a2\u0006\u0002\u0010\u0016J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u000fH\u00c6\u0003J\t\u0010+\u001a\u00020\u0011H\u00c6\u0003J\t\u0010,\u001a\u00020\u0011H\u00c6\u0003J\t\u0010-\u001a\u00020\u0011H\u00c6\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015H\u00c6\u0003J\t\u0010/\u001a\u00020\u0003H\u00c6\u0003J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\t\u00101\u001a\u00020\u0007H\u00c6\u0003J\t\u00102\u001a\u00020\u0007H\u00c6\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010$J\u000b\u00106\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u00a8\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015H\u00c6\u0001\u00a2\u0006\u0002\u00108J\t\u00109\u001a\u00020:H\u00d6\u0001J\u0013\u0010;\u001a\u00020\u00112\b\u0010<\u001a\u0004\u0018\u00010=H\u00d6\u0003J\t\u0010>\u001a\u00020:H\u00d6\u0001J\t\u0010?\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020:H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0013\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001aR\u0011\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018\u00a8\u0006E"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/model/Store;", "Landroid/os/Parcelable;", "id", "", "name", "address", "latitude", "", "longitude", "phone", "website", "rating", "", "openingHours", "storeType", "Ledu/monash/fit5046/healthyrecipehub/data/model/StoreType;", "isOrganic", "", "isVeganFriendly", "isGlutenFree", "products", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDLjava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ledu/monash/fit5046/healthyrecipehub/data/model/StoreType;ZZZLjava/util/List;)V", "getAddress", "()Ljava/lang/String;", "getId", "()Z", "getLatitude", "()D", "getLongitude", "getName", "getOpeningHours", "getPhone", "getProducts", "()Ljava/util/List;", "getRating", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getStoreType", "()Ledu/monash/fit5046/healthyrecipehub/data/model/StoreType;", "getWebsite", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDLjava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ledu/monash/fit5046/healthyrecipehub/data/model/StoreType;ZZZLjava/util/List;)Ledu/monash/fit5046/healthyrecipehub/data/model/Store;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
@kotlinx.parcelize.Parcelize()
public final class Store implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String address = null;
    private final double latitude = 0.0;
    private final double longitude = 0.0;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String phone = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String website = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Float rating = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String openingHours = null;
    @org.jetbrains.annotations.NotNull()
    private final edu.monash.fit5046.healthyrecipehub.data.model.StoreType storeType = null;
    private final boolean isOrganic = false;
    private final boolean isVeganFriendly = false;
    private final boolean isGlutenFree = false;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> products = null;
    
    public Store(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String address, double latitude, double longitude, @org.jetbrains.annotations.Nullable()
    java.lang.String phone, @org.jetbrains.annotations.Nullable()
    java.lang.String website, @org.jetbrains.annotations.Nullable()
    java.lang.Float rating, @org.jetbrains.annotations.Nullable()
    java.lang.String openingHours, @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.StoreType storeType, boolean isOrganic, boolean isVeganFriendly, boolean isGlutenFree, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> products) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAddress() {
        return null;
    }
    
    public final double getLatitude() {
        return 0.0;
    }
    
    public final double getLongitude() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPhone() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getWebsite() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float getRating() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getOpeningHours() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final edu.monash.fit5046.healthyrecipehub.data.model.StoreType getStoreType() {
        return null;
    }
    
    public final boolean isOrganic() {
        return false;
    }
    
    public final boolean isVeganFriendly() {
        return false;
    }
    
    public final boolean isGlutenFree() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getProducts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final edu.monash.fit5046.healthyrecipehub.data.model.StoreType component10() {
        return null;
    }
    
    public final boolean component11() {
        return false;
    }
    
    public final boolean component12() {
        return false;
    }
    
    public final boolean component13() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    public final double component4() {
        return 0.0;
    }
    
    public final double component5() {
        return 0.0;
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
    public final java.lang.Float component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final edu.monash.fit5046.healthyrecipehub.data.model.Store copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String address, double latitude, double longitude, @org.jetbrains.annotations.Nullable()
    java.lang.String phone, @org.jetbrains.annotations.Nullable()
    java.lang.String website, @org.jetbrains.annotations.Nullable()
    java.lang.Float rating, @org.jetbrains.annotations.Nullable()
    java.lang.String openingHours, @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.StoreType storeType, boolean isOrganic, boolean isVeganFriendly, boolean isGlutenFree, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> products) {
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