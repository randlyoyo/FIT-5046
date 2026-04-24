package edu.monash.fit5046.healthyrecipehub.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import edu.monash.fit5046.healthyrecipehub.data.local.converter.ListConverter;
import edu.monash.fit5046.healthyrecipehub.data.model.ActivityType;
import edu.monash.fit5046.healthyrecipehub.data.model.AppSettings;
import edu.monash.fit5046.healthyrecipehub.data.model.FontSize;
import edu.monash.fit5046.healthyrecipehub.data.model.MealType;
import edu.monash.fit5046.healthyrecipehub.data.model.NutritionLog;
import edu.monash.fit5046.healthyrecipehub.data.model.User;
import edu.monash.fit5046.healthyrecipehub.data.model.UserActivityLog;
import edu.monash.fit5046.healthyrecipehub.data.model.UserRole;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
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
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<User> __insertionAdapterOfUser;

  private final ListConverter __listConverter = new ListConverter();

  private final EntityInsertionAdapter<UserActivityLog> __insertionAdapterOfUserActivityLog;

  private final EntityInsertionAdapter<NutritionLog> __insertionAdapterOfNutritionLog;

  private final EntityInsertionAdapter<AppSettings> __insertionAdapterOfAppSettings;

  private final EntityDeletionOrUpdateAdapter<User> __deletionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<NutritionLog> __deletionAdapterOfNutritionLog;

  private final EntityDeletionOrUpdateAdapter<User> __updateAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<AppSettings> __updateAdapterOfAppSettings;

  private final SharedSQLiteStatement __preparedStmtOfDeleteOldActivityLogs;

  private final SharedSQLiteStatement __preparedStmtOfDeleteNutritionLogsForDate;

  public UserDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `users` (`id`,`email`,`displayName`,`photoUrl`,`role`,`dietaryPreferences`,`allergies`,`dailyCalorieGoal`,`createdAt`,`lastLoginAt`,`isEmailVerified`,`isBiometricEnabled`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final User entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getEmail() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getEmail());
        }
        if (entity.getDisplayName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDisplayName());
        }
        if (entity.getPhotoUrl() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getPhotoUrl());
        }
        statement.bindString(5, __UserRole_enumToString(entity.getRole()));
        final String _tmp = __listConverter.fromStringList(entity.getDietaryPreferences());
        if (_tmp == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, _tmp);
        }
        final String _tmp_1 = __listConverter.fromStringList(entity.getAllergies());
        if (_tmp_1 == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, _tmp_1);
        }
        statement.bindLong(8, entity.getDailyCalorieGoal());
        statement.bindLong(9, entity.getCreatedAt());
        statement.bindLong(10, entity.getLastLoginAt());
        final int _tmp_2 = entity.isEmailVerified() ? 1 : 0;
        statement.bindLong(11, _tmp_2);
        final int _tmp_3 = entity.isBiometricEnabled() ? 1 : 0;
        statement.bindLong(12, _tmp_3);
      }
    };
    this.__insertionAdapterOfUserActivityLog = new EntityInsertionAdapter<UserActivityLog>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `activity_logs` (`userId`,`timestamp`,`activityType`,`details`) VALUES (?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserActivityLog entity) {
        if (entity.getUserId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getUserId());
        }
        statement.bindLong(2, entity.getTimestamp());
        statement.bindString(3, __ActivityType_enumToString(entity.getActivityType()));
        if (entity.getDetails() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDetails());
        }
      }
    };
    this.__insertionAdapterOfNutritionLog = new EntityInsertionAdapter<NutritionLog>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `nutrition_logs` (`id`,`userId`,`date`,`recipeId`,`mealType`,`calories`,`protein`,`carbs`,`fat`,`timestamp`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final NutritionLog entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getUserId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getUserId());
        }
        if (entity.getDate() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDate());
        }
        if (entity.getRecipeId() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getRecipeId());
        }
        statement.bindString(5, __MealType_enumToString(entity.getMealType()));
        statement.bindLong(6, entity.getCalories());
        statement.bindDouble(7, entity.getProtein());
        statement.bindDouble(8, entity.getCarbs());
        statement.bindDouble(9, entity.getFat());
        statement.bindLong(10, entity.getTimestamp());
      }
    };
    this.__insertionAdapterOfAppSettings = new EntityInsertionAdapter<AppSettings>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `app_settings` (`userId`,`isDarkMode`,`fontSize`,`isHighContrast`,`isScreenReaderOptimized`,`notificationsEnabled`,`dailyReminderTime`,`language`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AppSettings entity) {
        if (entity.getUserId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getUserId());
        }
        final int _tmp = entity.isDarkMode() ? 1 : 0;
        statement.bindLong(2, _tmp);
        statement.bindString(3, __FontSize_enumToString(entity.getFontSize()));
        final int _tmp_1 = entity.isHighContrast() ? 1 : 0;
        statement.bindLong(4, _tmp_1);
        final int _tmp_2 = entity.isScreenReaderOptimized() ? 1 : 0;
        statement.bindLong(5, _tmp_2);
        final int _tmp_3 = entity.getNotificationsEnabled() ? 1 : 0;
        statement.bindLong(6, _tmp_3);
        if (entity.getDailyReminderTime() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getDailyReminderTime());
        }
        if (entity.getLanguage() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getLanguage());
        }
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `users` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final User entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__deletionAdapterOfNutritionLog = new EntityDeletionOrUpdateAdapter<NutritionLog>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `nutrition_logs` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final NutritionLog entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `users` SET `id` = ?,`email` = ?,`displayName` = ?,`photoUrl` = ?,`role` = ?,`dietaryPreferences` = ?,`allergies` = ?,`dailyCalorieGoal` = ?,`createdAt` = ?,`lastLoginAt` = ?,`isEmailVerified` = ?,`isBiometricEnabled` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final User entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getEmail() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getEmail());
        }
        if (entity.getDisplayName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDisplayName());
        }
        if (entity.getPhotoUrl() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getPhotoUrl());
        }
        statement.bindString(5, __UserRole_enumToString(entity.getRole()));
        final String _tmp = __listConverter.fromStringList(entity.getDietaryPreferences());
        if (_tmp == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, _tmp);
        }
        final String _tmp_1 = __listConverter.fromStringList(entity.getAllergies());
        if (_tmp_1 == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, _tmp_1);
        }
        statement.bindLong(8, entity.getDailyCalorieGoal());
        statement.bindLong(9, entity.getCreatedAt());
        statement.bindLong(10, entity.getLastLoginAt());
        final int _tmp_2 = entity.isEmailVerified() ? 1 : 0;
        statement.bindLong(11, _tmp_2);
        final int _tmp_3 = entity.isBiometricEnabled() ? 1 : 0;
        statement.bindLong(12, _tmp_3);
        if (entity.getId() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getId());
        }
      }
    };
    this.__updateAdapterOfAppSettings = new EntityDeletionOrUpdateAdapter<AppSettings>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `app_settings` SET `userId` = ?,`isDarkMode` = ?,`fontSize` = ?,`isHighContrast` = ?,`isScreenReaderOptimized` = ?,`notificationsEnabled` = ?,`dailyReminderTime` = ?,`language` = ? WHERE `userId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AppSettings entity) {
        if (entity.getUserId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getUserId());
        }
        final int _tmp = entity.isDarkMode() ? 1 : 0;
        statement.bindLong(2, _tmp);
        statement.bindString(3, __FontSize_enumToString(entity.getFontSize()));
        final int _tmp_1 = entity.isHighContrast() ? 1 : 0;
        statement.bindLong(4, _tmp_1);
        final int _tmp_2 = entity.isScreenReaderOptimized() ? 1 : 0;
        statement.bindLong(5, _tmp_2);
        final int _tmp_3 = entity.getNotificationsEnabled() ? 1 : 0;
        statement.bindLong(6, _tmp_3);
        if (entity.getDailyReminderTime() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getDailyReminderTime());
        }
        if (entity.getLanguage() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getLanguage());
        }
        if (entity.getUserId() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getUserId());
        }
      }
    };
    this.__preparedStmtOfDeleteOldActivityLogs = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM activity_logs WHERE timestamp < ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteNutritionLogsForDate = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM nutrition_logs WHERE userId = ? AND date = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertUser(final User user, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUser.insert(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertActivityLog(final UserActivityLog log,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUserActivityLog.insert(log);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertNutritionLog(final NutritionLog log,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfNutritionLog.insert(log);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertSettings(final AppSettings settings,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfAppSettings.insert(settings);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteUser(final User user, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfUser.handle(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteNutritionLog(final NutritionLog log,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfNutritionLog.handle(log);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateUser(final User user, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfUser.handle(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateSettings(final AppSettings settings,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfAppSettings.handle(settings);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteOldActivityLogs(final long before,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteOldActivityLogs.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, before);
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
          __preparedStmtOfDeleteOldActivityLogs.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteNutritionLogsForDate(final String userId, final String date,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteNutritionLogsForDate.acquire();
        int _argIndex = 1;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        _argIndex = 2;
        if (date == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, date);
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
          __preparedStmtOfDeleteNutritionLogsForDate.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getUserById(final String userId, final Continuation<? super User> $completion) {
    final String _sql = "SELECT * FROM users WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<User>() {
      @Override
      @Nullable
      public User call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "displayName");
          final int _cursorIndexOfPhotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUrl");
          final int _cursorIndexOfRole = CursorUtil.getColumnIndexOrThrow(_cursor, "role");
          final int _cursorIndexOfDietaryPreferences = CursorUtil.getColumnIndexOrThrow(_cursor, "dietaryPreferences");
          final int _cursorIndexOfAllergies = CursorUtil.getColumnIndexOrThrow(_cursor, "allergies");
          final int _cursorIndexOfDailyCalorieGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "dailyCalorieGoal");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfLastLoginAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastLoginAt");
          final int _cursorIndexOfIsEmailVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "isEmailVerified");
          final int _cursorIndexOfIsBiometricEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "isBiometricEnabled");
          final User _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpDisplayName;
            if (_cursor.isNull(_cursorIndexOfDisplayName)) {
              _tmpDisplayName = null;
            } else {
              _tmpDisplayName = _cursor.getString(_cursorIndexOfDisplayName);
            }
            final String _tmpPhotoUrl;
            if (_cursor.isNull(_cursorIndexOfPhotoUrl)) {
              _tmpPhotoUrl = null;
            } else {
              _tmpPhotoUrl = _cursor.getString(_cursorIndexOfPhotoUrl);
            }
            final UserRole _tmpRole;
            _tmpRole = __UserRole_stringToEnum(_cursor.getString(_cursorIndexOfRole));
            final List<String> _tmpDietaryPreferences;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDietaryPreferences)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDietaryPreferences);
            }
            _tmpDietaryPreferences = __listConverter.toStringList(_tmp);
            final List<String> _tmpAllergies;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfAllergies)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfAllergies);
            }
            _tmpAllergies = __listConverter.toStringList(_tmp_1);
            final int _tmpDailyCalorieGoal;
            _tmpDailyCalorieGoal = _cursor.getInt(_cursorIndexOfDailyCalorieGoal);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpLastLoginAt;
            _tmpLastLoginAt = _cursor.getLong(_cursorIndexOfLastLoginAt);
            final boolean _tmpIsEmailVerified;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsEmailVerified);
            _tmpIsEmailVerified = _tmp_2 != 0;
            final boolean _tmpIsBiometricEnabled;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsBiometricEnabled);
            _tmpIsBiometricEnabled = _tmp_3 != 0;
            _result = new User(_tmpId,_tmpEmail,_tmpDisplayName,_tmpPhotoUrl,_tmpRole,_tmpDietaryPreferences,_tmpAllergies,_tmpDailyCalorieGoal,_tmpCreatedAt,_tmpLastLoginAt,_tmpIsEmailVerified,_tmpIsBiometricEnabled);
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
  public LiveData<User> getUserByIdLive(final String userId) {
    final String _sql = "SELECT * FROM users WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[] {"users"}, false, new Callable<User>() {
      @Override
      @Nullable
      public User call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "displayName");
          final int _cursorIndexOfPhotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUrl");
          final int _cursorIndexOfRole = CursorUtil.getColumnIndexOrThrow(_cursor, "role");
          final int _cursorIndexOfDietaryPreferences = CursorUtil.getColumnIndexOrThrow(_cursor, "dietaryPreferences");
          final int _cursorIndexOfAllergies = CursorUtil.getColumnIndexOrThrow(_cursor, "allergies");
          final int _cursorIndexOfDailyCalorieGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "dailyCalorieGoal");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfLastLoginAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastLoginAt");
          final int _cursorIndexOfIsEmailVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "isEmailVerified");
          final int _cursorIndexOfIsBiometricEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "isBiometricEnabled");
          final User _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpDisplayName;
            if (_cursor.isNull(_cursorIndexOfDisplayName)) {
              _tmpDisplayName = null;
            } else {
              _tmpDisplayName = _cursor.getString(_cursorIndexOfDisplayName);
            }
            final String _tmpPhotoUrl;
            if (_cursor.isNull(_cursorIndexOfPhotoUrl)) {
              _tmpPhotoUrl = null;
            } else {
              _tmpPhotoUrl = _cursor.getString(_cursorIndexOfPhotoUrl);
            }
            final UserRole _tmpRole;
            _tmpRole = __UserRole_stringToEnum(_cursor.getString(_cursorIndexOfRole));
            final List<String> _tmpDietaryPreferences;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDietaryPreferences)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDietaryPreferences);
            }
            _tmpDietaryPreferences = __listConverter.toStringList(_tmp);
            final List<String> _tmpAllergies;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfAllergies)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfAllergies);
            }
            _tmpAllergies = __listConverter.toStringList(_tmp_1);
            final int _tmpDailyCalorieGoal;
            _tmpDailyCalorieGoal = _cursor.getInt(_cursorIndexOfDailyCalorieGoal);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpLastLoginAt;
            _tmpLastLoginAt = _cursor.getLong(_cursorIndexOfLastLoginAt);
            final boolean _tmpIsEmailVerified;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsEmailVerified);
            _tmpIsEmailVerified = _tmp_2 != 0;
            final boolean _tmpIsBiometricEnabled;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsBiometricEnabled);
            _tmpIsBiometricEnabled = _tmp_3 != 0;
            _result = new User(_tmpId,_tmpEmail,_tmpDisplayName,_tmpPhotoUrl,_tmpRole,_tmpDietaryPreferences,_tmpAllergies,_tmpDailyCalorieGoal,_tmpCreatedAt,_tmpLastLoginAt,_tmpIsEmailVerified,_tmpIsBiometricEnabled);
          } else {
            _result = null;
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
  public Flow<User> getUserByIdFlow(final String userId) {
    final String _sql = "SELECT * FROM users WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"users"}, new Callable<User>() {
      @Override
      @Nullable
      public User call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "displayName");
          final int _cursorIndexOfPhotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUrl");
          final int _cursorIndexOfRole = CursorUtil.getColumnIndexOrThrow(_cursor, "role");
          final int _cursorIndexOfDietaryPreferences = CursorUtil.getColumnIndexOrThrow(_cursor, "dietaryPreferences");
          final int _cursorIndexOfAllergies = CursorUtil.getColumnIndexOrThrow(_cursor, "allergies");
          final int _cursorIndexOfDailyCalorieGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "dailyCalorieGoal");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfLastLoginAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastLoginAt");
          final int _cursorIndexOfIsEmailVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "isEmailVerified");
          final int _cursorIndexOfIsBiometricEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "isBiometricEnabled");
          final User _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpDisplayName;
            if (_cursor.isNull(_cursorIndexOfDisplayName)) {
              _tmpDisplayName = null;
            } else {
              _tmpDisplayName = _cursor.getString(_cursorIndexOfDisplayName);
            }
            final String _tmpPhotoUrl;
            if (_cursor.isNull(_cursorIndexOfPhotoUrl)) {
              _tmpPhotoUrl = null;
            } else {
              _tmpPhotoUrl = _cursor.getString(_cursorIndexOfPhotoUrl);
            }
            final UserRole _tmpRole;
            _tmpRole = __UserRole_stringToEnum(_cursor.getString(_cursorIndexOfRole));
            final List<String> _tmpDietaryPreferences;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDietaryPreferences)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDietaryPreferences);
            }
            _tmpDietaryPreferences = __listConverter.toStringList(_tmp);
            final List<String> _tmpAllergies;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfAllergies)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfAllergies);
            }
            _tmpAllergies = __listConverter.toStringList(_tmp_1);
            final int _tmpDailyCalorieGoal;
            _tmpDailyCalorieGoal = _cursor.getInt(_cursorIndexOfDailyCalorieGoal);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpLastLoginAt;
            _tmpLastLoginAt = _cursor.getLong(_cursorIndexOfLastLoginAt);
            final boolean _tmpIsEmailVerified;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsEmailVerified);
            _tmpIsEmailVerified = _tmp_2 != 0;
            final boolean _tmpIsBiometricEnabled;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsBiometricEnabled);
            _tmpIsBiometricEnabled = _tmp_3 != 0;
            _result = new User(_tmpId,_tmpEmail,_tmpDisplayName,_tmpPhotoUrl,_tmpRole,_tmpDietaryPreferences,_tmpAllergies,_tmpDailyCalorieGoal,_tmpCreatedAt,_tmpLastLoginAt,_tmpIsEmailVerified,_tmpIsBiometricEnabled);
          } else {
            _result = null;
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
  public Object getUserByEmail(final String email, final Continuation<? super User> $completion) {
    final String _sql = "SELECT * FROM users WHERE email = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, email);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<User>() {
      @Override
      @Nullable
      public User call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "displayName");
          final int _cursorIndexOfPhotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUrl");
          final int _cursorIndexOfRole = CursorUtil.getColumnIndexOrThrow(_cursor, "role");
          final int _cursorIndexOfDietaryPreferences = CursorUtil.getColumnIndexOrThrow(_cursor, "dietaryPreferences");
          final int _cursorIndexOfAllergies = CursorUtil.getColumnIndexOrThrow(_cursor, "allergies");
          final int _cursorIndexOfDailyCalorieGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "dailyCalorieGoal");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfLastLoginAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastLoginAt");
          final int _cursorIndexOfIsEmailVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "isEmailVerified");
          final int _cursorIndexOfIsBiometricEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "isBiometricEnabled");
          final User _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpDisplayName;
            if (_cursor.isNull(_cursorIndexOfDisplayName)) {
              _tmpDisplayName = null;
            } else {
              _tmpDisplayName = _cursor.getString(_cursorIndexOfDisplayName);
            }
            final String _tmpPhotoUrl;
            if (_cursor.isNull(_cursorIndexOfPhotoUrl)) {
              _tmpPhotoUrl = null;
            } else {
              _tmpPhotoUrl = _cursor.getString(_cursorIndexOfPhotoUrl);
            }
            final UserRole _tmpRole;
            _tmpRole = __UserRole_stringToEnum(_cursor.getString(_cursorIndexOfRole));
            final List<String> _tmpDietaryPreferences;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDietaryPreferences)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDietaryPreferences);
            }
            _tmpDietaryPreferences = __listConverter.toStringList(_tmp);
            final List<String> _tmpAllergies;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfAllergies)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfAllergies);
            }
            _tmpAllergies = __listConverter.toStringList(_tmp_1);
            final int _tmpDailyCalorieGoal;
            _tmpDailyCalorieGoal = _cursor.getInt(_cursorIndexOfDailyCalorieGoal);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpLastLoginAt;
            _tmpLastLoginAt = _cursor.getLong(_cursorIndexOfLastLoginAt);
            final boolean _tmpIsEmailVerified;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsEmailVerified);
            _tmpIsEmailVerified = _tmp_2 != 0;
            final boolean _tmpIsBiometricEnabled;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsBiometricEnabled);
            _tmpIsBiometricEnabled = _tmp_3 != 0;
            _result = new User(_tmpId,_tmpEmail,_tmpDisplayName,_tmpPhotoUrl,_tmpRole,_tmpDietaryPreferences,_tmpAllergies,_tmpDailyCalorieGoal,_tmpCreatedAt,_tmpLastLoginAt,_tmpIsEmailVerified,_tmpIsBiometricEnabled);
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
  public Flow<List<User>> getAllUsers() {
    final String _sql = "SELECT * FROM users ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"users"}, new Callable<List<User>>() {
      @Override
      @NonNull
      public List<User> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "displayName");
          final int _cursorIndexOfPhotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUrl");
          final int _cursorIndexOfRole = CursorUtil.getColumnIndexOrThrow(_cursor, "role");
          final int _cursorIndexOfDietaryPreferences = CursorUtil.getColumnIndexOrThrow(_cursor, "dietaryPreferences");
          final int _cursorIndexOfAllergies = CursorUtil.getColumnIndexOrThrow(_cursor, "allergies");
          final int _cursorIndexOfDailyCalorieGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "dailyCalorieGoal");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfLastLoginAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastLoginAt");
          final int _cursorIndexOfIsEmailVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "isEmailVerified");
          final int _cursorIndexOfIsBiometricEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "isBiometricEnabled");
          final List<User> _result = new ArrayList<User>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final User _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpDisplayName;
            if (_cursor.isNull(_cursorIndexOfDisplayName)) {
              _tmpDisplayName = null;
            } else {
              _tmpDisplayName = _cursor.getString(_cursorIndexOfDisplayName);
            }
            final String _tmpPhotoUrl;
            if (_cursor.isNull(_cursorIndexOfPhotoUrl)) {
              _tmpPhotoUrl = null;
            } else {
              _tmpPhotoUrl = _cursor.getString(_cursorIndexOfPhotoUrl);
            }
            final UserRole _tmpRole;
            _tmpRole = __UserRole_stringToEnum(_cursor.getString(_cursorIndexOfRole));
            final List<String> _tmpDietaryPreferences;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDietaryPreferences)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDietaryPreferences);
            }
            _tmpDietaryPreferences = __listConverter.toStringList(_tmp);
            final List<String> _tmpAllergies;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfAllergies)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfAllergies);
            }
            _tmpAllergies = __listConverter.toStringList(_tmp_1);
            final int _tmpDailyCalorieGoal;
            _tmpDailyCalorieGoal = _cursor.getInt(_cursorIndexOfDailyCalorieGoal);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpLastLoginAt;
            _tmpLastLoginAt = _cursor.getLong(_cursorIndexOfLastLoginAt);
            final boolean _tmpIsEmailVerified;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsEmailVerified);
            _tmpIsEmailVerified = _tmp_2 != 0;
            final boolean _tmpIsBiometricEnabled;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsBiometricEnabled);
            _tmpIsBiometricEnabled = _tmp_3 != 0;
            _item = new User(_tmpId,_tmpEmail,_tmpDisplayName,_tmpPhotoUrl,_tmpRole,_tmpDietaryPreferences,_tmpAllergies,_tmpDailyCalorieGoal,_tmpCreatedAt,_tmpLastLoginAt,_tmpIsEmailVerified,_tmpIsBiometricEnabled);
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
  public Flow<List<User>> getUsersByRole(final UserRole role) {
    final String _sql = "SELECT * FROM users WHERE role = ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, __UserRole_enumToString(role));
    return CoroutinesRoom.createFlow(__db, false, new String[] {"users"}, new Callable<List<User>>() {
      @Override
      @NonNull
      public List<User> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "displayName");
          final int _cursorIndexOfPhotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUrl");
          final int _cursorIndexOfRole = CursorUtil.getColumnIndexOrThrow(_cursor, "role");
          final int _cursorIndexOfDietaryPreferences = CursorUtil.getColumnIndexOrThrow(_cursor, "dietaryPreferences");
          final int _cursorIndexOfAllergies = CursorUtil.getColumnIndexOrThrow(_cursor, "allergies");
          final int _cursorIndexOfDailyCalorieGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "dailyCalorieGoal");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfLastLoginAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastLoginAt");
          final int _cursorIndexOfIsEmailVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "isEmailVerified");
          final int _cursorIndexOfIsBiometricEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "isBiometricEnabled");
          final List<User> _result = new ArrayList<User>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final User _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpDisplayName;
            if (_cursor.isNull(_cursorIndexOfDisplayName)) {
              _tmpDisplayName = null;
            } else {
              _tmpDisplayName = _cursor.getString(_cursorIndexOfDisplayName);
            }
            final String _tmpPhotoUrl;
            if (_cursor.isNull(_cursorIndexOfPhotoUrl)) {
              _tmpPhotoUrl = null;
            } else {
              _tmpPhotoUrl = _cursor.getString(_cursorIndexOfPhotoUrl);
            }
            final UserRole _tmpRole;
            _tmpRole = __UserRole_stringToEnum(_cursor.getString(_cursorIndexOfRole));
            final List<String> _tmpDietaryPreferences;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDietaryPreferences)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDietaryPreferences);
            }
            _tmpDietaryPreferences = __listConverter.toStringList(_tmp);
            final List<String> _tmpAllergies;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfAllergies)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfAllergies);
            }
            _tmpAllergies = __listConverter.toStringList(_tmp_1);
            final int _tmpDailyCalorieGoal;
            _tmpDailyCalorieGoal = _cursor.getInt(_cursorIndexOfDailyCalorieGoal);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpLastLoginAt;
            _tmpLastLoginAt = _cursor.getLong(_cursorIndexOfLastLoginAt);
            final boolean _tmpIsEmailVerified;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsEmailVerified);
            _tmpIsEmailVerified = _tmp_2 != 0;
            final boolean _tmpIsBiometricEnabled;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsBiometricEnabled);
            _tmpIsBiometricEnabled = _tmp_3 != 0;
            _item = new User(_tmpId,_tmpEmail,_tmpDisplayName,_tmpPhotoUrl,_tmpRole,_tmpDietaryPreferences,_tmpAllergies,_tmpDailyCalorieGoal,_tmpCreatedAt,_tmpLastLoginAt,_tmpIsEmailVerified,_tmpIsBiometricEnabled);
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
  public Object getTotalUserCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM users";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
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
  public Object getUserCountByRole(final UserRole role,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM users WHERE role = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, __UserRole_enumToString(role));
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
  public Object getUserCountSince(final long since,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM users WHERE createdAt >= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, since);
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
  public Object getUserActivityLogs(final String userId, final int limit,
      final Continuation<? super List<UserActivityLog>> $completion) {
    final String _sql = "SELECT * FROM activity_logs WHERE userId = ? ORDER BY timestamp DESC LIMIT ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, limit);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<UserActivityLog>>() {
      @Override
      @NonNull
      public List<UserActivityLog> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfActivityType = CursorUtil.getColumnIndexOrThrow(_cursor, "activityType");
          final int _cursorIndexOfDetails = CursorUtil.getColumnIndexOrThrow(_cursor, "details");
          final List<UserActivityLog> _result = new ArrayList<UserActivityLog>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final UserActivityLog _item;
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final ActivityType _tmpActivityType;
            _tmpActivityType = __ActivityType_stringToEnum(_cursor.getString(_cursorIndexOfActivityType));
            final String _tmpDetails;
            if (_cursor.isNull(_cursorIndexOfDetails)) {
              _tmpDetails = null;
            } else {
              _tmpDetails = _cursor.getString(_cursorIndexOfDetails);
            }
            _item = new UserActivityLog(_tmpUserId,_tmpTimestamp,_tmpActivityType,_tmpDetails);
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

  @Override
  public Object getAllActivityLogs(final int limit,
      final Continuation<? super List<UserActivityLog>> $completion) {
    final String _sql = "SELECT * FROM activity_logs ORDER BY timestamp DESC LIMIT ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, limit);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<UserActivityLog>>() {
      @Override
      @NonNull
      public List<UserActivityLog> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfActivityType = CursorUtil.getColumnIndexOrThrow(_cursor, "activityType");
          final int _cursorIndexOfDetails = CursorUtil.getColumnIndexOrThrow(_cursor, "details");
          final List<UserActivityLog> _result = new ArrayList<UserActivityLog>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final UserActivityLog _item;
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final ActivityType _tmpActivityType;
            _tmpActivityType = __ActivityType_stringToEnum(_cursor.getString(_cursorIndexOfActivityType));
            final String _tmpDetails;
            if (_cursor.isNull(_cursorIndexOfDetails)) {
              _tmpDetails = null;
            } else {
              _tmpDetails = _cursor.getString(_cursorIndexOfDetails);
            }
            _item = new UserActivityLog(_tmpUserId,_tmpTimestamp,_tmpActivityType,_tmpDetails);
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

  @Override
  public Object getNutritionLogsForDate(final String userId, final String date,
      final Continuation<? super List<NutritionLog>> $completion) {
    final String _sql = "SELECT * FROM nutrition_logs WHERE userId = ? AND date = ? ORDER BY timestamp ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    _argIndex = 2;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<NutritionLog>>() {
      @Override
      @NonNull
      public List<NutritionLog> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfRecipeId = CursorUtil.getColumnIndexOrThrow(_cursor, "recipeId");
          final int _cursorIndexOfMealType = CursorUtil.getColumnIndexOrThrow(_cursor, "mealType");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "protein");
          final int _cursorIndexOfCarbs = CursorUtil.getColumnIndexOrThrow(_cursor, "carbs");
          final int _cursorIndexOfFat = CursorUtil.getColumnIndexOrThrow(_cursor, "fat");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final List<NutritionLog> _result = new ArrayList<NutritionLog>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final NutritionLog _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final String _tmpRecipeId;
            if (_cursor.isNull(_cursorIndexOfRecipeId)) {
              _tmpRecipeId = null;
            } else {
              _tmpRecipeId = _cursor.getString(_cursorIndexOfRecipeId);
            }
            final MealType _tmpMealType;
            _tmpMealType = __MealType_stringToEnum(_cursor.getString(_cursorIndexOfMealType));
            final int _tmpCalories;
            _tmpCalories = _cursor.getInt(_cursorIndexOfCalories);
            final double _tmpProtein;
            _tmpProtein = _cursor.getDouble(_cursorIndexOfProtein);
            final double _tmpCarbs;
            _tmpCarbs = _cursor.getDouble(_cursorIndexOfCarbs);
            final double _tmpFat;
            _tmpFat = _cursor.getDouble(_cursorIndexOfFat);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            _item = new NutritionLog(_tmpId,_tmpUserId,_tmpDate,_tmpRecipeId,_tmpMealType,_tmpCalories,_tmpProtein,_tmpCarbs,_tmpFat,_tmpTimestamp);
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

  @Override
  public Object getDailyNutritionSummary(final String userId, final String date,
      final Continuation<? super DailyNutritionSummary> $completion) {
    final String _sql = "\n"
            + "        SELECT \n"
            + "            SUM(calories) as totalCalories,\n"
            + "            SUM(protein) as totalProtein,\n"
            + "            SUM(carbs) as totalCarbs,\n"
            + "            SUM(fat) as totalFat\n"
            + "        FROM nutrition_logs \n"
            + "        WHERE userId = ? AND date = ?\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    _argIndex = 2;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<DailyNutritionSummary>() {
      @Override
      @Nullable
      public DailyNutritionSummary call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTotalCalories = 0;
          final int _cursorIndexOfTotalProtein = 1;
          final int _cursorIndexOfTotalCarbs = 2;
          final int _cursorIndexOfTotalFat = 3;
          final DailyNutritionSummary _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmpTotalCalories;
            if (_cursor.isNull(_cursorIndexOfTotalCalories)) {
              _tmpTotalCalories = null;
            } else {
              _tmpTotalCalories = _cursor.getInt(_cursorIndexOfTotalCalories);
            }
            final Double _tmpTotalProtein;
            if (_cursor.isNull(_cursorIndexOfTotalProtein)) {
              _tmpTotalProtein = null;
            } else {
              _tmpTotalProtein = _cursor.getDouble(_cursorIndexOfTotalProtein);
            }
            final Double _tmpTotalCarbs;
            if (_cursor.isNull(_cursorIndexOfTotalCarbs)) {
              _tmpTotalCarbs = null;
            } else {
              _tmpTotalCarbs = _cursor.getDouble(_cursorIndexOfTotalCarbs);
            }
            final Double _tmpTotalFat;
            if (_cursor.isNull(_cursorIndexOfTotalFat)) {
              _tmpTotalFat = null;
            } else {
              _tmpTotalFat = _cursor.getDouble(_cursorIndexOfTotalFat);
            }
            _result = new DailyNutritionSummary(_tmpTotalCalories,_tmpTotalProtein,_tmpTotalCarbs,_tmpTotalFat);
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
  public Object getNutritionLogsForDateRange(final String userId, final String startDate,
      final String endDate, final Continuation<? super List<NutritionLog>> $completion) {
    final String _sql = "SELECT * FROM nutrition_logs WHERE userId = ? AND date BETWEEN ? AND ? ORDER BY date, timestamp";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    _argIndex = 2;
    if (startDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, startDate);
    }
    _argIndex = 3;
    if (endDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, endDate);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<NutritionLog>>() {
      @Override
      @NonNull
      public List<NutritionLog> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfRecipeId = CursorUtil.getColumnIndexOrThrow(_cursor, "recipeId");
          final int _cursorIndexOfMealType = CursorUtil.getColumnIndexOrThrow(_cursor, "mealType");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "protein");
          final int _cursorIndexOfCarbs = CursorUtil.getColumnIndexOrThrow(_cursor, "carbs");
          final int _cursorIndexOfFat = CursorUtil.getColumnIndexOrThrow(_cursor, "fat");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final List<NutritionLog> _result = new ArrayList<NutritionLog>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final NutritionLog _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final String _tmpRecipeId;
            if (_cursor.isNull(_cursorIndexOfRecipeId)) {
              _tmpRecipeId = null;
            } else {
              _tmpRecipeId = _cursor.getString(_cursorIndexOfRecipeId);
            }
            final MealType _tmpMealType;
            _tmpMealType = __MealType_stringToEnum(_cursor.getString(_cursorIndexOfMealType));
            final int _tmpCalories;
            _tmpCalories = _cursor.getInt(_cursorIndexOfCalories);
            final double _tmpProtein;
            _tmpProtein = _cursor.getDouble(_cursorIndexOfProtein);
            final double _tmpCarbs;
            _tmpCarbs = _cursor.getDouble(_cursorIndexOfCarbs);
            final double _tmpFat;
            _tmpFat = _cursor.getDouble(_cursorIndexOfFat);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            _item = new NutritionLog(_tmpId,_tmpUserId,_tmpDate,_tmpRecipeId,_tmpMealType,_tmpCalories,_tmpProtein,_tmpCarbs,_tmpFat,_tmpTimestamp);
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

  @Override
  public Object getUserSettings(final String userId,
      final Continuation<? super AppSettings> $completion) {
    final String _sql = "SELECT * FROM app_settings WHERE userId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<AppSettings>() {
      @Override
      @Nullable
      public AppSettings call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfIsDarkMode = CursorUtil.getColumnIndexOrThrow(_cursor, "isDarkMode");
          final int _cursorIndexOfFontSize = CursorUtil.getColumnIndexOrThrow(_cursor, "fontSize");
          final int _cursorIndexOfIsHighContrast = CursorUtil.getColumnIndexOrThrow(_cursor, "isHighContrast");
          final int _cursorIndexOfIsScreenReaderOptimized = CursorUtil.getColumnIndexOrThrow(_cursor, "isScreenReaderOptimized");
          final int _cursorIndexOfNotificationsEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "notificationsEnabled");
          final int _cursorIndexOfDailyReminderTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dailyReminderTime");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final AppSettings _result;
          if (_cursor.moveToFirst()) {
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final boolean _tmpIsDarkMode;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsDarkMode);
            _tmpIsDarkMode = _tmp != 0;
            final FontSize _tmpFontSize;
            _tmpFontSize = __FontSize_stringToEnum(_cursor.getString(_cursorIndexOfFontSize));
            final boolean _tmpIsHighContrast;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsHighContrast);
            _tmpIsHighContrast = _tmp_1 != 0;
            final boolean _tmpIsScreenReaderOptimized;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsScreenReaderOptimized);
            _tmpIsScreenReaderOptimized = _tmp_2 != 0;
            final boolean _tmpNotificationsEnabled;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfNotificationsEnabled);
            _tmpNotificationsEnabled = _tmp_3 != 0;
            final String _tmpDailyReminderTime;
            if (_cursor.isNull(_cursorIndexOfDailyReminderTime)) {
              _tmpDailyReminderTime = null;
            } else {
              _tmpDailyReminderTime = _cursor.getString(_cursorIndexOfDailyReminderTime);
            }
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            _result = new AppSettings(_tmpUserId,_tmpIsDarkMode,_tmpFontSize,_tmpIsHighContrast,_tmpIsScreenReaderOptimized,_tmpNotificationsEnabled,_tmpDailyReminderTime,_tmpLanguage);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private String __UserRole_enumToString(@NonNull final UserRole _value) {
    switch (_value) {
      case USER: return "USER";
      case ADMIN: return "ADMIN";
      case NUTRITIONIST: return "NUTRITIONIST";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private String __ActivityType_enumToString(@NonNull final ActivityType _value) {
    switch (_value) {
      case LOGIN: return "LOGIN";
      case LOGOUT: return "LOGOUT";
      case RECIPE_VIEW: return "RECIPE_VIEW";
      case RECIPE_CREATE: return "RECIPE_CREATE";
      case RECIPE_EDIT: return "RECIPE_EDIT";
      case RECIPE_DELETE: return "RECIPE_DELETE";
      case RECIPE_FAVORITE: return "RECIPE_FAVORITE";
      case PROFILE_UPDATE: return "PROFILE_UPDATE";
      case PASSWORD_CHANGE: return "PASSWORD_CHANGE";
      case EMAIL_SENT: return "EMAIL_SENT";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private String __MealType_enumToString(@NonNull final MealType _value) {
    switch (_value) {
      case BREAKFAST: return "BREAKFAST";
      case LUNCH: return "LUNCH";
      case DINNER: return "DINNER";
      case SNACK: return "SNACK";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private String __FontSize_enumToString(@NonNull final FontSize _value) {
    switch (_value) {
      case SMALL: return "SMALL";
      case MEDIUM: return "MEDIUM";
      case LARGE: return "LARGE";
      case EXTRA_LARGE: return "EXTRA_LARGE";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private UserRole __UserRole_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "USER": return UserRole.USER;
      case "ADMIN": return UserRole.ADMIN;
      case "NUTRITIONIST": return UserRole.NUTRITIONIST;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }

  private ActivityType __ActivityType_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "LOGIN": return ActivityType.LOGIN;
      case "LOGOUT": return ActivityType.LOGOUT;
      case "RECIPE_VIEW": return ActivityType.RECIPE_VIEW;
      case "RECIPE_CREATE": return ActivityType.RECIPE_CREATE;
      case "RECIPE_EDIT": return ActivityType.RECIPE_EDIT;
      case "RECIPE_DELETE": return ActivityType.RECIPE_DELETE;
      case "RECIPE_FAVORITE": return ActivityType.RECIPE_FAVORITE;
      case "PROFILE_UPDATE": return ActivityType.PROFILE_UPDATE;
      case "PASSWORD_CHANGE": return ActivityType.PASSWORD_CHANGE;
      case "EMAIL_SENT": return ActivityType.EMAIL_SENT;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }

  private MealType __MealType_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "BREAKFAST": return MealType.BREAKFAST;
      case "LUNCH": return MealType.LUNCH;
      case "DINNER": return MealType.DINNER;
      case "SNACK": return MealType.SNACK;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }

  private FontSize __FontSize_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "SMALL": return FontSize.SMALL;
      case "MEDIUM": return FontSize.MEDIUM;
      case "LARGE": return FontSize.LARGE;
      case "EXTRA_LARGE": return FontSize.EXTRA_LARGE;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }
}
