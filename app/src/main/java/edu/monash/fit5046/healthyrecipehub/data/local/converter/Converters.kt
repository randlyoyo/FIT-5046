package edu.monash.fit5046.healthyrecipehub.data.local.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.monash.fit5046.healthyrecipehub.data.model.Ingredient

/**
 * Type Converters for Room Database
 * Handles complex data types (Lists, Objects) storage
 */
class ListConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromStringList(value: List<String>?): String {
        return gson.toJson(value ?: emptyList<String>())
    }

    @TypeConverter
    fun toStringList(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(value, listType) ?: emptyList()
    }

    @TypeConverter
    fun fromIngredientList(value: List<Ingredient>?): String {
        return gson.toJson(value ?: emptyList<Ingredient>())
    }

    @TypeConverter
    fun toIngredientList(value: String): List<Ingredient> {
        val listType = object : TypeToken<List<Ingredient>>() {}.type
        return gson.fromJson(value, listType) ?: emptyList()
    }
}

class TimestampConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): java.util.Date? {
        return value?.let { java.util.Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: java.util.Date?): Long? {
        return date?.time
    }
}
