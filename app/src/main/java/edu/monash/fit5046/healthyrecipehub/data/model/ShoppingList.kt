package edu.monash.fit5046.healthyrecipehub.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

/**
 * Shopping List Entity
 */
@Parcelize
@Entity(tableName = "shopping_lists")
data class ShoppingList(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val userId: String,
    val name: String,
    val createdAt: Long = System.currentTimeMillis(),
    val isCompleted: Boolean = false
) : Parcelable

/**
 * Shopping List Item
 */
@Parcelize
@Entity(tableName = "shopping_items")
data class ShoppingItem(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val listId: Long,
    val name: String,
    val amount: Double,
    val unit: String,
    val isChecked: Boolean = false,
    val category: String = "Other" // Produce, Dairy, Meat, Pantry, etc.
) : Parcelable

/**
 * Email Template for Email Center
 */
@Parcelize
data class EmailTemplate(
    val id: String,
    val name: String,
    val subject: String,
    val body: String,
    val isHtml: Boolean = false
) : Parcelable

/**
 * Sent Email Record
 */
@Entity(tableName = "sent_emails")
data class SentEmail(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val userId: String,
    val recipientEmail: String,
    val recipientName: String? = null,
    val subject: String,
    val body: String,
    val sentAt: Long = System.currentTimeMillis(),
    val isSuccess: Boolean = true,
    val errorMessage: String? = null
)

/**
 * AI Chat Message
 */
@Parcelize
@Entity(tableName = "chat_messages")
data class ChatMessage(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val userId: String,
    val message: String,
    val isUser: Boolean, // true = user message, false = AI response
    val timestamp: Long = System.currentTimeMillis()
) : Parcelable

/**
 * App Settings
 */
@Entity(tableName = "app_settings")
data class AppSettings(
    @PrimaryKey
    val userId: String,
    val isDarkMode: Boolean = false,
    val fontSize: FontSize = FontSize.MEDIUM,
    val isHighContrast: Boolean = false,
    val isScreenReaderOptimized: Boolean = false,
    val notificationsEnabled: Boolean = true,
    val dailyReminderTime: String? = null, // HH:mm format
    val language: String = "en"
)

enum class FontSize {
    SMALL,
    MEDIUM,
    LARGE,
    EXTRA_LARGE
}
