package edu.monash.fit5046.healthyrecipehub.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

/**
 * Store/Health Food Store Model
 * For Mapbox map integration
 */
@Parcelize
data class Store(
    val id: String,
    val name: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val phone: String? = null,
    val website: String? = null,
    val rating: Float? = null,
    val openingHours: String? = null,
    val storeType: StoreType = StoreType.GENERAL,
    val isOrganic: Boolean = false,
    val isVeganFriendly: Boolean = false,
    val isGlutenFree: Boolean = false,
    val products: List<String> = emptyList()
) : Parcelable

enum class StoreType {
    GENERAL,
    ORGANIC,
    VEGAN,
    GLUTEN_FREE,
    HEALTH_FOOD,
    FARMERS_MARKET,
    SUPPLEMENT_STORE
}

/**
 * Map Location for user saved locations
 */
@Parcelize
@Entity(tableName = "saved_locations")
data class SavedLocation(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val userId: String,
    val name: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val category: String = "Home", // Home, Work, Gym, etc.
    val createdAt: Long = System.currentTimeMillis()
) : Parcelable
