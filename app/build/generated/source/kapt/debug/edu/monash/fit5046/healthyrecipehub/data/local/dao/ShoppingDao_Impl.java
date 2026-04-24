package edu.monash.fit5046.healthyrecipehub.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import edu.monash.fit5046.healthyrecipehub.data.model.ShoppingItem;
import edu.monash.fit5046.healthyrecipehub.data.model.ShoppingList;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ShoppingDao_Impl implements ShoppingDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ShoppingList> __insertionAdapterOfShoppingList;

  private final EntityInsertionAdapter<ShoppingItem> __insertionAdapterOfShoppingItem;

  private final EntityDeletionOrUpdateAdapter<ShoppingList> __deletionAdapterOfShoppingList;

  private final EntityDeletionOrUpdateAdapter<ShoppingItem> __deletionAdapterOfShoppingItem;

  private final EntityDeletionOrUpdateAdapter<ShoppingList> __updateAdapterOfShoppingList;

  private final EntityDeletionOrUpdateAdapter<ShoppingItem> __updateAdapterOfShoppingItem;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllShoppingListsForUser;

  private final SharedSQLiteStatement __preparedStmtOfUpdateShoppingListCompletion;

  private final SharedSQLiteStatement __preparedStmtOfDeleteItemsForList;

  private final SharedSQLiteStatement __preparedStmtOfUpdateItemCheckedStatus;

  public ShoppingDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfShoppingList = new EntityInsertionAdapter<ShoppingList>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `shopping_lists` (`id`,`userId`,`name`,`createdAt`,`isCompleted`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ShoppingList entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getUserId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getUserId());
        }
        if (entity.getName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getName());
        }
        statement.bindLong(4, entity.getCreatedAt());
        final int _tmp = entity.isCompleted() ? 1 : 0;
        statement.bindLong(5, _tmp);
      }
    };
    this.__insertionAdapterOfShoppingItem = new EntityInsertionAdapter<ShoppingItem>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `shopping_items` (`id`,`listId`,`name`,`amount`,`unit`,`isChecked`,`category`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ShoppingItem entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getListId());
        if (entity.getName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getName());
        }
        statement.bindDouble(4, entity.getAmount());
        if (entity.getUnit() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getUnit());
        }
        final int _tmp = entity.isChecked() ? 1 : 0;
        statement.bindLong(6, _tmp);
        if (entity.getCategory() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getCategory());
        }
      }
    };
    this.__deletionAdapterOfShoppingList = new EntityDeletionOrUpdateAdapter<ShoppingList>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `shopping_lists` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ShoppingList entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__deletionAdapterOfShoppingItem = new EntityDeletionOrUpdateAdapter<ShoppingItem>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `shopping_items` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ShoppingItem entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfShoppingList = new EntityDeletionOrUpdateAdapter<ShoppingList>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `shopping_lists` SET `id` = ?,`userId` = ?,`name` = ?,`createdAt` = ?,`isCompleted` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ShoppingList entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getUserId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getUserId());
        }
        if (entity.getName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getName());
        }
        statement.bindLong(4, entity.getCreatedAt());
        final int _tmp = entity.isCompleted() ? 1 : 0;
        statement.bindLong(5, _tmp);
        statement.bindLong(6, entity.getId());
      }
    };
    this.__updateAdapterOfShoppingItem = new EntityDeletionOrUpdateAdapter<ShoppingItem>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `shopping_items` SET `id` = ?,`listId` = ?,`name` = ?,`amount` = ?,`unit` = ?,`isChecked` = ?,`category` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ShoppingItem entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getListId());
        if (entity.getName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getName());
        }
        statement.bindDouble(4, entity.getAmount());
        if (entity.getUnit() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getUnit());
        }
        final int _tmp = entity.isChecked() ? 1 : 0;
        statement.bindLong(6, _tmp);
        if (entity.getCategory() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getCategory());
        }
        statement.bindLong(8, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteAllShoppingListsForUser = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM shopping_lists WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateShoppingListCompletion = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE shopping_lists SET isCompleted = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteItemsForList = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM shopping_items WHERE listId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateItemCheckedStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE shopping_items SET isChecked = ? WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertShoppingList(final ShoppingList list,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfShoppingList.insertAndReturnId(list);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertShoppingItem(final ShoppingItem item,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfShoppingItem.insertAndReturnId(item);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertShoppingItems(final List<ShoppingItem> items,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfShoppingItem.insert(items);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteShoppingList(final ShoppingList list,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfShoppingList.handle(list);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteShoppingItem(final ShoppingItem item,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfShoppingItem.handle(item);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateShoppingList(final ShoppingList list,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfShoppingList.handle(list);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateShoppingItem(final ShoppingItem item,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfShoppingItem.handle(item);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllShoppingListsForUser(final String userId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllShoppingListsForUser.acquire();
        int _argIndex = 1;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAllShoppingListsForUser.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateShoppingListCompletion(final long listId, final boolean isCompleted,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateShoppingListCompletion.acquire();
        int _argIndex = 1;
        final int _tmp = isCompleted ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, listId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateShoppingListCompletion.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteItemsForList(final long listId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteItemsForList.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, listId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteItemsForList.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateItemCheckedStatus(final long itemId, final boolean isChecked,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateItemCheckedStatus.acquire();
        int _argIndex = 1;
        final int _tmp = isChecked ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, itemId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateItemCheckedStatus.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<ShoppingList>> getShoppingListsForUser(final String userId) {
    final String _sql = "SELECT * FROM shopping_lists WHERE userId = ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"shopping_lists"}, new Callable<List<ShoppingList>>() {
      @Override
      @NonNull
      public List<ShoppingList> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final List<ShoppingList> _result = new ArrayList<ShoppingList>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ShoppingList _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final boolean _tmpIsCompleted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp != 0;
            _item = new ShoppingList(_tmpId,_tmpUserId,_tmpName,_tmpCreatedAt,_tmpIsCompleted);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getShoppingListById(final long listId,
      final Continuation<? super ShoppingList> $completion) {
    final String _sql = "SELECT * FROM shopping_lists WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, listId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<ShoppingList>() {
      @Override
      @Nullable
      public ShoppingList call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final ShoppingList _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final boolean _tmpIsCompleted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp != 0;
            _result = new ShoppingList(_tmpId,_tmpUserId,_tmpName,_tmpCreatedAt,_tmpIsCompleted);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<ShoppingItem>> getItemsForList(final long listId) {
    final String _sql = "SELECT * FROM shopping_items WHERE listId = ? ORDER BY category, name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, listId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"shopping_items"}, new Callable<List<ShoppingItem>>() {
      @Override
      @NonNull
      public List<ShoppingItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfListId = CursorUtil.getColumnIndexOrThrow(_cursor, "listId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "unit");
          final int _cursorIndexOfIsChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "isChecked");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final List<ShoppingItem> _result = new ArrayList<ShoppingItem>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ShoppingItem _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpListId;
            _tmpListId = _cursor.getLong(_cursorIndexOfListId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpUnit;
            if (_cursor.isNull(_cursorIndexOfUnit)) {
              _tmpUnit = null;
            } else {
              _tmpUnit = _cursor.getString(_cursorIndexOfUnit);
            }
            final boolean _tmpIsChecked;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsChecked);
            _tmpIsChecked = _tmp != 0;
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            _item = new ShoppingItem(_tmpId,_tmpListId,_tmpName,_tmpAmount,_tmpUnit,_tmpIsChecked,_tmpCategory);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getCheckedItemCount(final long listId,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM shopping_items WHERE listId = ? AND isChecked = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, listId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getTotalItemCount(final long listId,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM shopping_items WHERE listId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, listId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getShoppingListsWithItemCounts(final String userId,
      final Continuation<? super List<ShoppingListWithCount>> $completion) {
    final String _sql = "\n"
            + "        SELECT sl.*, \n"
            + "               (SELECT COUNT(*) FROM shopping_items WHERE listId = sl.id) as totalItems,\n"
            + "               (SELECT COUNT(*) FROM shopping_items WHERE listId = sl.id AND isChecked = 1) as checkedItems\n"
            + "        FROM shopping_lists sl\n"
            + "        WHERE sl.userId = ?\n"
            + "        ORDER BY sl.createdAt DESC\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<ShoppingListWithCount>>() {
      @Override
      @NonNull
      public List<ShoppingListWithCount> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfTotalItems = CursorUtil.getColumnIndexOrThrow(_cursor, "totalItems");
          final int _cursorIndexOfCheckedItems = CursorUtil.getColumnIndexOrThrow(_cursor, "checkedItems");
          final List<ShoppingListWithCount> _result = new ArrayList<ShoppingListWithCount>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ShoppingListWithCount _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final boolean _tmpIsCompleted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp != 0;
            final int _tmpTotalItems;
            _tmpTotalItems = _cursor.getInt(_cursorIndexOfTotalItems);
            final int _tmpCheckedItems;
            _tmpCheckedItems = _cursor.getInt(_cursorIndexOfCheckedItems);
            _item = new ShoppingListWithCount(_tmpId,_tmpUserId,_tmpName,_tmpCreatedAt,_tmpIsCompleted,_tmpTotalItems,_tmpCheckedItems);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
