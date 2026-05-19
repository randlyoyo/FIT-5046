package edu.monash.fit5046.healthyrecipehub.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import edu.monash.fit5046.healthyrecipehub.data.model.*
import kotlinx.coroutines.flow.Flow

/**
 * Shopping List Data Access Object
 */
@Dao
interface ShoppingDao {

    // ====== Shopping Lists ======

    @Query("SELECT * FROM shopping_lists WHERE userId = :userId ORDER BY createdAt DESC")
    fun getShoppingListsForUser(userId: String): Flow<List<ShoppingList>>

    @Query("SELECT * FROM shopping_lists WHERE id = :listId")
    suspend fun getShoppingListById(listId: Long): ShoppingList?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingList(list: ShoppingList): Long

    @Update
    suspend fun updateShoppingList(list: ShoppingList)

    @Delete
    suspend fun deleteShoppingList(list: ShoppingList)

    @Query("DELETE FROM shopping_lists WHERE userId = :userId")
    suspend fun deleteAllShoppingListsForUser(userId: String)

    @Query("UPDATE shopping_lists SET isCompleted = :isCompleted WHERE id = :listId")
    suspend fun updateShoppingListCompletion(listId: Long, isCompleted: Boolean)

    // ====== Shopping Items ======

    @Query("SELECT * FROM shopping_items WHERE listId = :listId ORDER BY category, name ASC")
    fun getItemsForList(listId: Long): Flow<List<ShoppingItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingItem(item: ShoppingItem): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingItems(items: List<ShoppingItem>)

    @Update
    suspend fun updateShoppingItem(item: ShoppingItem)

    @Delete
    suspend fun deleteShoppingItem(item: ShoppingItem)

    @Query("DELETE FROM shopping_items WHERE listId = :listId")
    suspend fun deleteItemsForList(listId: Long)

    @Query("UPDATE shopping_items SET isChecked = :isChecked WHERE id = :itemId")
    suspend fun updateItemCheckedStatus(itemId: Long, isChecked: Boolean)

    @Query("SELECT COUNT(*) FROM shopping_items WHERE listId = :listId AND isChecked = 1")
    suspend fun getCheckedItemCount(listId: Long): Int

    @Query("SELECT COUNT(*) FROM shopping_items WHERE listId = :listId")
    suspend fun getTotalItemCount(listId: Long): Int

    // ====== Complex Queries ======

    @Query("""
        SELECT sl.*, 
               (SELECT COUNT(*) FROM shopping_items WHERE listId = sl.id) as totalItems,
               (SELECT COUNT(*) FROM shopping_items WHERE listId = sl.id AND isChecked = 1) as checkedItems
        FROM shopping_lists sl
        WHERE sl.userId = :userId
        ORDER BY sl.createdAt DESC
    """)
    suspend fun getShoppingListsWithItemCounts(userId: String): List<ShoppingListWithCount>
}

/**
 * Shopping List with item count data class
 */
data class ShoppingListWithCount(
    val id: Long,
    val userId: String,
    val name: String,
    val createdAt: Long,
    val isCompleted: Boolean,
    val totalItems: Int,
    val checkedItems: Int
)
