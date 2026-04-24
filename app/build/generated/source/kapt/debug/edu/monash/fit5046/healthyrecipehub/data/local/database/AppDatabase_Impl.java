package edu.monash.fit5046.healthyrecipehub.data.local.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import edu.monash.fit5046.healthyrecipehub.data.local.dao.RecipeDao;
import edu.monash.fit5046.healthyrecipehub.data.local.dao.RecipeDao_Impl;
import edu.monash.fit5046.healthyrecipehub.data.local.dao.ShoppingDao;
import edu.monash.fit5046.healthyrecipehub.data.local.dao.ShoppingDao_Impl;
import edu.monash.fit5046.healthyrecipehub.data.local.dao.UserDao;
import edu.monash.fit5046.healthyrecipehub.data.local.dao.UserDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile RecipeDao _recipeDao;

  private volatile UserDao _userDao;

  private volatile ShoppingDao _shoppingDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `recipes` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `description` TEXT NOT NULL, `imageUrl` TEXT, `calories` INTEGER NOT NULL, `protein` REAL NOT NULL, `carbs` REAL NOT NULL, `fat` REAL NOT NULL, `fiber` REAL NOT NULL, `sugar` REAL NOT NULL, `sodium` REAL NOT NULL, `prepTime` INTEGER NOT NULL, `cookTime` INTEGER NOT NULL, `servings` INTEGER NOT NULL, `difficulty` TEXT NOT NULL, `category` TEXT NOT NULL, `cuisine` TEXT NOT NULL, `dietaryTags` TEXT NOT NULL, `ingredients` TEXT NOT NULL, `instructions` TEXT NOT NULL, `nutritionScore` REAL NOT NULL, `authorId` TEXT NOT NULL, `authorName` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, `isFavorite` INTEGER NOT NULL, `isOffline` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `reviews` (`recipeId` TEXT NOT NULL, `userId` TEXT NOT NULL, `userName` TEXT NOT NULL, `rating` REAL NOT NULL, `comment` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`recipeId`, `userId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `users` (`id` TEXT NOT NULL, `email` TEXT NOT NULL, `displayName` TEXT NOT NULL, `photoUrl` TEXT, `role` TEXT NOT NULL, `dietaryPreferences` TEXT NOT NULL, `allergies` TEXT NOT NULL, `dailyCalorieGoal` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, `lastLoginAt` INTEGER NOT NULL, `isEmailVerified` INTEGER NOT NULL, `isBiometricEnabled` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `activity_logs` (`userId` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `activityType` TEXT NOT NULL, `details` TEXT, PRIMARY KEY(`userId`, `timestamp`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `nutrition_logs` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` TEXT NOT NULL, `date` TEXT NOT NULL, `recipeId` TEXT, `mealType` TEXT NOT NULL, `calories` INTEGER NOT NULL, `protein` REAL NOT NULL, `carbs` REAL NOT NULL, `fat` REAL NOT NULL, `timestamp` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `shopping_lists` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` TEXT NOT NULL, `name` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, `isCompleted` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `shopping_items` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `listId` INTEGER NOT NULL, `name` TEXT NOT NULL, `amount` REAL NOT NULL, `unit` TEXT NOT NULL, `isChecked` INTEGER NOT NULL, `category` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `saved_locations` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` TEXT NOT NULL, `name` TEXT NOT NULL, `address` TEXT NOT NULL, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `category` TEXT NOT NULL, `createdAt` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `sent_emails` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` TEXT NOT NULL, `recipientEmail` TEXT NOT NULL, `recipientName` TEXT, `subject` TEXT NOT NULL, `body` TEXT NOT NULL, `sentAt` INTEGER NOT NULL, `isSuccess` INTEGER NOT NULL, `errorMessage` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `chat_messages` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` TEXT NOT NULL, `message` TEXT NOT NULL, `isUser` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `app_settings` (`userId` TEXT NOT NULL, `isDarkMode` INTEGER NOT NULL, `fontSize` TEXT NOT NULL, `isHighContrast` INTEGER NOT NULL, `isScreenReaderOptimized` INTEGER NOT NULL, `notificationsEnabled` INTEGER NOT NULL, `dailyReminderTime` TEXT, `language` TEXT NOT NULL, PRIMARY KEY(`userId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '777f83226b320a65e7f3170dc4b283ca')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `recipes`");
        db.execSQL("DROP TABLE IF EXISTS `reviews`");
        db.execSQL("DROP TABLE IF EXISTS `users`");
        db.execSQL("DROP TABLE IF EXISTS `activity_logs`");
        db.execSQL("DROP TABLE IF EXISTS `nutrition_logs`");
        db.execSQL("DROP TABLE IF EXISTS `shopping_lists`");
        db.execSQL("DROP TABLE IF EXISTS `shopping_items`");
        db.execSQL("DROP TABLE IF EXISTS `saved_locations`");
        db.execSQL("DROP TABLE IF EXISTS `sent_emails`");
        db.execSQL("DROP TABLE IF EXISTS `chat_messages`");
        db.execSQL("DROP TABLE IF EXISTS `app_settings`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsRecipes = new HashMap<String, TableInfo.Column>(27);
        _columnsRecipes.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecipes.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecipes.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecipes.put("imageUrl", new TableInfo.Column("imageUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecipes.put("calories", new TableInfo.Column("calories", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecipes.put("protein", new TableInfo.Column("protein", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecipes.put("carbs", new TableInfo.Column("carbs", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecipes.put("fat", new TableInfo.Column("fat", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecipes.put("fiber", new TableInfo.Column("fiber", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecipes.put("sugar", new TableInfo.Column("sugar", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecipes.put("sodium", new TableInfo.Column("sodium", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecipes.put("prepTime", new TableInfo.Column("prepTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecipes.put("cookTime", new TableInfo.Column("cookTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecipes.put("servings", new TableInfo.Column("servings", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecipes.put("difficulty", new TableInfo.Column("difficulty", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecipes.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecipes.put("cuisine", new TableInfo.Column("cuisine", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecipes.put("dietaryTags", new TableInfo.Column("dietaryTags", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecipes.put("ingredients", new TableInfo.Column("ingredients", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecipes.put("instructions", new TableInfo.Column("instructions", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecipes.put("nutritionScore", new TableInfo.Column("nutritionScore", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecipes.put("authorId", new TableInfo.Column("authorId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecipes.put("authorName", new TableInfo.Column("authorName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecipes.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecipes.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecipes.put("isFavorite", new TableInfo.Column("isFavorite", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecipes.put("isOffline", new TableInfo.Column("isOffline", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRecipes = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRecipes = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRecipes = new TableInfo("recipes", _columnsRecipes, _foreignKeysRecipes, _indicesRecipes);
        final TableInfo _existingRecipes = TableInfo.read(db, "recipes");
        if (!_infoRecipes.equals(_existingRecipes)) {
          return new RoomOpenHelper.ValidationResult(false, "recipes(edu.monash.fit5046.healthyrecipehub.data.model.Recipe).\n"
                  + " Expected:\n" + _infoRecipes + "\n"
                  + " Found:\n" + _existingRecipes);
        }
        final HashMap<String, TableInfo.Column> _columnsReviews = new HashMap<String, TableInfo.Column>(6);
        _columnsReviews.put("recipeId", new TableInfo.Column("recipeId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReviews.put("userId", new TableInfo.Column("userId", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReviews.put("userName", new TableInfo.Column("userName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReviews.put("rating", new TableInfo.Column("rating", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReviews.put("comment", new TableInfo.Column("comment", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReviews.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysReviews = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesReviews = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoReviews = new TableInfo("reviews", _columnsReviews, _foreignKeysReviews, _indicesReviews);
        final TableInfo _existingReviews = TableInfo.read(db, "reviews");
        if (!_infoReviews.equals(_existingReviews)) {
          return new RoomOpenHelper.ValidationResult(false, "reviews(edu.monash.fit5046.healthyrecipehub.data.model.Review).\n"
                  + " Expected:\n" + _infoReviews + "\n"
                  + " Found:\n" + _existingReviews);
        }
        final HashMap<String, TableInfo.Column> _columnsUsers = new HashMap<String, TableInfo.Column>(12);
        _columnsUsers.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("displayName", new TableInfo.Column("displayName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("photoUrl", new TableInfo.Column("photoUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("role", new TableInfo.Column("role", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("dietaryPreferences", new TableInfo.Column("dietaryPreferences", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("allergies", new TableInfo.Column("allergies", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("dailyCalorieGoal", new TableInfo.Column("dailyCalorieGoal", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("lastLoginAt", new TableInfo.Column("lastLoginAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("isEmailVerified", new TableInfo.Column("isEmailVerified", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("isBiometricEnabled", new TableInfo.Column("isBiometricEnabled", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsers = new TableInfo("users", _columnsUsers, _foreignKeysUsers, _indicesUsers);
        final TableInfo _existingUsers = TableInfo.read(db, "users");
        if (!_infoUsers.equals(_existingUsers)) {
          return new RoomOpenHelper.ValidationResult(false, "users(edu.monash.fit5046.healthyrecipehub.data.model.User).\n"
                  + " Expected:\n" + _infoUsers + "\n"
                  + " Found:\n" + _existingUsers);
        }
        final HashMap<String, TableInfo.Column> _columnsActivityLogs = new HashMap<String, TableInfo.Column>(4);
        _columnsActivityLogs.put("userId", new TableInfo.Column("userId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsActivityLogs.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsActivityLogs.put("activityType", new TableInfo.Column("activityType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsActivityLogs.put("details", new TableInfo.Column("details", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysActivityLogs = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesActivityLogs = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoActivityLogs = new TableInfo("activity_logs", _columnsActivityLogs, _foreignKeysActivityLogs, _indicesActivityLogs);
        final TableInfo _existingActivityLogs = TableInfo.read(db, "activity_logs");
        if (!_infoActivityLogs.equals(_existingActivityLogs)) {
          return new RoomOpenHelper.ValidationResult(false, "activity_logs(edu.monash.fit5046.healthyrecipehub.data.model.UserActivityLog).\n"
                  + " Expected:\n" + _infoActivityLogs + "\n"
                  + " Found:\n" + _existingActivityLogs);
        }
        final HashMap<String, TableInfo.Column> _columnsNutritionLogs = new HashMap<String, TableInfo.Column>(10);
        _columnsNutritionLogs.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNutritionLogs.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNutritionLogs.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNutritionLogs.put("recipeId", new TableInfo.Column("recipeId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNutritionLogs.put("mealType", new TableInfo.Column("mealType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNutritionLogs.put("calories", new TableInfo.Column("calories", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNutritionLogs.put("protein", new TableInfo.Column("protein", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNutritionLogs.put("carbs", new TableInfo.Column("carbs", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNutritionLogs.put("fat", new TableInfo.Column("fat", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNutritionLogs.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNutritionLogs = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNutritionLogs = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNutritionLogs = new TableInfo("nutrition_logs", _columnsNutritionLogs, _foreignKeysNutritionLogs, _indicesNutritionLogs);
        final TableInfo _existingNutritionLogs = TableInfo.read(db, "nutrition_logs");
        if (!_infoNutritionLogs.equals(_existingNutritionLogs)) {
          return new RoomOpenHelper.ValidationResult(false, "nutrition_logs(edu.monash.fit5046.healthyrecipehub.data.model.NutritionLog).\n"
                  + " Expected:\n" + _infoNutritionLogs + "\n"
                  + " Found:\n" + _existingNutritionLogs);
        }
        final HashMap<String, TableInfo.Column> _columnsShoppingLists = new HashMap<String, TableInfo.Column>(5);
        _columnsShoppingLists.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsShoppingLists.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsShoppingLists.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsShoppingLists.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsShoppingLists.put("isCompleted", new TableInfo.Column("isCompleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysShoppingLists = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesShoppingLists = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoShoppingLists = new TableInfo("shopping_lists", _columnsShoppingLists, _foreignKeysShoppingLists, _indicesShoppingLists);
        final TableInfo _existingShoppingLists = TableInfo.read(db, "shopping_lists");
        if (!_infoShoppingLists.equals(_existingShoppingLists)) {
          return new RoomOpenHelper.ValidationResult(false, "shopping_lists(edu.monash.fit5046.healthyrecipehub.data.model.ShoppingList).\n"
                  + " Expected:\n" + _infoShoppingLists + "\n"
                  + " Found:\n" + _existingShoppingLists);
        }
        final HashMap<String, TableInfo.Column> _columnsShoppingItems = new HashMap<String, TableInfo.Column>(7);
        _columnsShoppingItems.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsShoppingItems.put("listId", new TableInfo.Column("listId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsShoppingItems.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsShoppingItems.put("amount", new TableInfo.Column("amount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsShoppingItems.put("unit", new TableInfo.Column("unit", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsShoppingItems.put("isChecked", new TableInfo.Column("isChecked", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsShoppingItems.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysShoppingItems = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesShoppingItems = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoShoppingItems = new TableInfo("shopping_items", _columnsShoppingItems, _foreignKeysShoppingItems, _indicesShoppingItems);
        final TableInfo _existingShoppingItems = TableInfo.read(db, "shopping_items");
        if (!_infoShoppingItems.equals(_existingShoppingItems)) {
          return new RoomOpenHelper.ValidationResult(false, "shopping_items(edu.monash.fit5046.healthyrecipehub.data.model.ShoppingItem).\n"
                  + " Expected:\n" + _infoShoppingItems + "\n"
                  + " Found:\n" + _existingShoppingItems);
        }
        final HashMap<String, TableInfo.Column> _columnsSavedLocations = new HashMap<String, TableInfo.Column>(8);
        _columnsSavedLocations.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSavedLocations.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSavedLocations.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSavedLocations.put("address", new TableInfo.Column("address", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSavedLocations.put("latitude", new TableInfo.Column("latitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSavedLocations.put("longitude", new TableInfo.Column("longitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSavedLocations.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSavedLocations.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSavedLocations = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSavedLocations = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSavedLocations = new TableInfo("saved_locations", _columnsSavedLocations, _foreignKeysSavedLocations, _indicesSavedLocations);
        final TableInfo _existingSavedLocations = TableInfo.read(db, "saved_locations");
        if (!_infoSavedLocations.equals(_existingSavedLocations)) {
          return new RoomOpenHelper.ValidationResult(false, "saved_locations(edu.monash.fit5046.healthyrecipehub.data.model.SavedLocation).\n"
                  + " Expected:\n" + _infoSavedLocations + "\n"
                  + " Found:\n" + _existingSavedLocations);
        }
        final HashMap<String, TableInfo.Column> _columnsSentEmails = new HashMap<String, TableInfo.Column>(9);
        _columnsSentEmails.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSentEmails.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSentEmails.put("recipientEmail", new TableInfo.Column("recipientEmail", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSentEmails.put("recipientName", new TableInfo.Column("recipientName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSentEmails.put("subject", new TableInfo.Column("subject", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSentEmails.put("body", new TableInfo.Column("body", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSentEmails.put("sentAt", new TableInfo.Column("sentAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSentEmails.put("isSuccess", new TableInfo.Column("isSuccess", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSentEmails.put("errorMessage", new TableInfo.Column("errorMessage", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSentEmails = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSentEmails = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSentEmails = new TableInfo("sent_emails", _columnsSentEmails, _foreignKeysSentEmails, _indicesSentEmails);
        final TableInfo _existingSentEmails = TableInfo.read(db, "sent_emails");
        if (!_infoSentEmails.equals(_existingSentEmails)) {
          return new RoomOpenHelper.ValidationResult(false, "sent_emails(edu.monash.fit5046.healthyrecipehub.data.model.SentEmail).\n"
                  + " Expected:\n" + _infoSentEmails + "\n"
                  + " Found:\n" + _existingSentEmails);
        }
        final HashMap<String, TableInfo.Column> _columnsChatMessages = new HashMap<String, TableInfo.Column>(5);
        _columnsChatMessages.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatMessages.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatMessages.put("message", new TableInfo.Column("message", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatMessages.put("isUser", new TableInfo.Column("isUser", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatMessages.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChatMessages = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesChatMessages = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoChatMessages = new TableInfo("chat_messages", _columnsChatMessages, _foreignKeysChatMessages, _indicesChatMessages);
        final TableInfo _existingChatMessages = TableInfo.read(db, "chat_messages");
        if (!_infoChatMessages.equals(_existingChatMessages)) {
          return new RoomOpenHelper.ValidationResult(false, "chat_messages(edu.monash.fit5046.healthyrecipehub.data.model.ChatMessage).\n"
                  + " Expected:\n" + _infoChatMessages + "\n"
                  + " Found:\n" + _existingChatMessages);
        }
        final HashMap<String, TableInfo.Column> _columnsAppSettings = new HashMap<String, TableInfo.Column>(8);
        _columnsAppSettings.put("userId", new TableInfo.Column("userId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppSettings.put("isDarkMode", new TableInfo.Column("isDarkMode", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppSettings.put("fontSize", new TableInfo.Column("fontSize", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppSettings.put("isHighContrast", new TableInfo.Column("isHighContrast", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppSettings.put("isScreenReaderOptimized", new TableInfo.Column("isScreenReaderOptimized", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppSettings.put("notificationsEnabled", new TableInfo.Column("notificationsEnabled", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppSettings.put("dailyReminderTime", new TableInfo.Column("dailyReminderTime", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppSettings.put("language", new TableInfo.Column("language", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAppSettings = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAppSettings = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAppSettings = new TableInfo("app_settings", _columnsAppSettings, _foreignKeysAppSettings, _indicesAppSettings);
        final TableInfo _existingAppSettings = TableInfo.read(db, "app_settings");
        if (!_infoAppSettings.equals(_existingAppSettings)) {
          return new RoomOpenHelper.ValidationResult(false, "app_settings(edu.monash.fit5046.healthyrecipehub.data.model.AppSettings).\n"
                  + " Expected:\n" + _infoAppSettings + "\n"
                  + " Found:\n" + _existingAppSettings);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "777f83226b320a65e7f3170dc4b283ca", "3860201d9883a68cb1a8ca77a9b90e65");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "recipes","reviews","users","activity_logs","nutrition_logs","shopping_lists","shopping_items","saved_locations","sent_emails","chat_messages","app_settings");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `recipes`");
      _db.execSQL("DELETE FROM `reviews`");
      _db.execSQL("DELETE FROM `users`");
      _db.execSQL("DELETE FROM `activity_logs`");
      _db.execSQL("DELETE FROM `nutrition_logs`");
      _db.execSQL("DELETE FROM `shopping_lists`");
      _db.execSQL("DELETE FROM `shopping_items`");
      _db.execSQL("DELETE FROM `saved_locations`");
      _db.execSQL("DELETE FROM `sent_emails`");
      _db.execSQL("DELETE FROM `chat_messages`");
      _db.execSQL("DELETE FROM `app_settings`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(RecipeDao.class, RecipeDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ShoppingDao.class, ShoppingDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public RecipeDao recipeDao() {
    if (_recipeDao != null) {
      return _recipeDao;
    } else {
      synchronized(this) {
        if(_recipeDao == null) {
          _recipeDao = new RecipeDao_Impl(this);
        }
        return _recipeDao;
      }
    }
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public ShoppingDao shoppingDao() {
    if (_shoppingDao != null) {
      return _shoppingDao;
    } else {
      synchronized(this) {
        if(_shoppingDao == null) {
          _shoppingDao = new ShoppingDao_Impl(this);
        }
        return _shoppingDao;
      }
    }
  }
}
