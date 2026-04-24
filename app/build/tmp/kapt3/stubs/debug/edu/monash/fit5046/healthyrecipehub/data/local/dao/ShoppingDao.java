package edu.monash.fit5046.healthyrecipehub.data.local.dao;

/**
 * Shopping List Data Access Object
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00170\u00162\u0006\u0010\b\u001a\u00020\tH\'J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00170\u00162\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00172\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u001c\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u001d\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010\u001e\u001a\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0\u0017H\u00a7@\u00a2\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u001e\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020%H\u00a7@\u00a2\u0006\u0002\u0010&J\u0016\u0010\'\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010(\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u001e\u0010)\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010*\u001a\u00020%H\u00a7@\u00a2\u0006\u0002\u0010&\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006+\u00c0\u0006\u0001"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/local/dao/ShoppingDao;", "", "deleteAllShoppingListsForUser", "", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteItemsForList", "listId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteShoppingItem", "item", "Ledu/monash/fit5046/healthyrecipehub/data/model/ShoppingItem;", "(Ledu/monash/fit5046/healthyrecipehub/data/model/ShoppingItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteShoppingList", "list", "Ledu/monash/fit5046/healthyrecipehub/data/model/ShoppingList;", "(Ledu/monash/fit5046/healthyrecipehub/data/model/ShoppingList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCheckedItemCount", "", "getItemsForList", "Lkotlinx/coroutines/flow/Flow;", "", "getShoppingListById", "getShoppingListsForUser", "getShoppingListsWithItemCounts", "Ledu/monash/fit5046/healthyrecipehub/data/local/dao/ShoppingListWithCount;", "getTotalItemCount", "insertShoppingItem", "insertShoppingItems", "items", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertShoppingList", "updateItemCheckedStatus", "itemId", "isChecked", "", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateShoppingItem", "updateShoppingList", "updateShoppingListCompletion", "isCompleted", "app_debug"})
@androidx.room.Dao()
public abstract interface ShoppingDao {
    
    @androidx.room.Query(value = "SELECT * FROM shopping_lists WHERE userId = :userId ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.ShoppingList>> getShoppingListsForUser(@org.jetbrains.annotations.NotNull()
    java.lang.String userId);
    
    @androidx.room.Query(value = "SELECT * FROM shopping_lists WHERE id = :listId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getShoppingListById(long listId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.monash.fit5046.healthyrecipehub.data.model.ShoppingList> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertShoppingList(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.ShoppingList list, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateShoppingList(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.ShoppingList list, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteShoppingList(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.ShoppingList list, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM shopping_lists WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAllShoppingListsForUser(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE shopping_lists SET isCompleted = :isCompleted WHERE id = :listId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateShoppingListCompletion(long listId, boolean isCompleted, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM shopping_items WHERE listId = :listId ORDER BY category, name ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.ShoppingItem>> getItemsForList(long listId);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertShoppingItem(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.ShoppingItem item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertShoppingItems(@org.jetbrains.annotations.NotNull()
    java.util.List<edu.monash.fit5046.healthyrecipehub.data.model.ShoppingItem> items, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateShoppingItem(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.ShoppingItem item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteShoppingItem(@org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.model.ShoppingItem item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM shopping_items WHERE listId = :listId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteItemsForList(long listId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE shopping_items SET isChecked = :isChecked WHERE id = :itemId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateItemCheckedStatus(long itemId, boolean isChecked, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM shopping_items WHERE listId = :listId AND isChecked = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCheckedItemCount(long listId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM shopping_items WHERE listId = :listId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTotalItemCount(long listId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "\n        SELECT sl.*, \n               (SELECT COUNT(*) FROM shopping_items WHERE listId = sl.id) as totalItems,\n               (SELECT COUNT(*) FROM shopping_items WHERE listId = sl.id AND isChecked = 1) as checkedItems\n        FROM shopping_lists sl\n        WHERE sl.userId = :userId\n        ORDER BY sl.createdAt DESC\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getShoppingListsWithItemCounts(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<edu.monash.fit5046.healthyrecipehub.data.local.dao.ShoppingListWithCount>> $completion);
}