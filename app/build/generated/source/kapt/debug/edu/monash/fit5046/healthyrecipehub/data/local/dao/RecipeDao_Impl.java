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
import edu.monash.fit5046.healthyrecipehub.data.model.Ingredient;
import edu.monash.fit5046.healthyrecipehub.data.model.Recipe;
import edu.monash.fit5046.healthyrecipehub.data.model.Review;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Float;
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
public final class RecipeDao_Impl implements RecipeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Recipe> __insertionAdapterOfRecipe;

  private final ListConverter __listConverter = new ListConverter();

  private final EntityInsertionAdapter<Review> __insertionAdapterOfReview;

  private final EntityDeletionOrUpdateAdapter<Recipe> __deletionAdapterOfRecipe;

  private final EntityDeletionOrUpdateAdapter<Recipe> __updateAdapterOfRecipe;

  private final SharedSQLiteStatement __preparedStmtOfDeleteRecipeById;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFavoriteStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdateOfflineStatus;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllRecipes;

  private final SharedSQLiteStatement __preparedStmtOfDeleteRecipesByAuthor;

  public RecipeDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRecipe = new EntityInsertionAdapter<Recipe>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `recipes` (`id`,`title`,`description`,`imageUrl`,`calories`,`protein`,`carbs`,`fat`,`fiber`,`sugar`,`sodium`,`prepTime`,`cookTime`,`servings`,`difficulty`,`category`,`cuisine`,`dietaryTags`,`ingredients`,`instructions`,`nutritionScore`,`authorId`,`authorName`,`createdAt`,`updatedAt`,`isFavorite`,`isOffline`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Recipe entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescription());
        }
        if (entity.getImageUrl() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getImageUrl());
        }
        statement.bindLong(5, entity.getCalories());
        statement.bindDouble(6, entity.getProtein());
        statement.bindDouble(7, entity.getCarbs());
        statement.bindDouble(8, entity.getFat());
        statement.bindDouble(9, entity.getFiber());
        statement.bindDouble(10, entity.getSugar());
        statement.bindDouble(11, entity.getSodium());
        statement.bindLong(12, entity.getPrepTime());
        statement.bindLong(13, entity.getCookTime());
        statement.bindLong(14, entity.getServings());
        if (entity.getDifficulty() == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.getDifficulty());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, entity.getCategory());
        }
        if (entity.getCuisine() == null) {
          statement.bindNull(17);
        } else {
          statement.bindString(17, entity.getCuisine());
        }
        final String _tmp = __listConverter.fromStringList(entity.getDietaryTags());
        if (_tmp == null) {
          statement.bindNull(18);
        } else {
          statement.bindString(18, _tmp);
        }
        final String _tmp_1 = __listConverter.fromIngredientList(entity.getIngredients());
        if (_tmp_1 == null) {
          statement.bindNull(19);
        } else {
          statement.bindString(19, _tmp_1);
        }
        final String _tmp_2 = __listConverter.fromStringList(entity.getInstructions());
        if (_tmp_2 == null) {
          statement.bindNull(20);
        } else {
          statement.bindString(20, _tmp_2);
        }
        statement.bindDouble(21, entity.getNutritionScore());
        if (entity.getAuthorId() == null) {
          statement.bindNull(22);
        } else {
          statement.bindString(22, entity.getAuthorId());
        }
        if (entity.getAuthorName() == null) {
          statement.bindNull(23);
        } else {
          statement.bindString(23, entity.getAuthorName());
        }
        statement.bindLong(24, entity.getCreatedAt());
        statement.bindLong(25, entity.getUpdatedAt());
        final int _tmp_3 = entity.isFavorite() ? 1 : 0;
        statement.bindLong(26, _tmp_3);
        final int _tmp_4 = entity.isOffline() ? 1 : 0;
        statement.bindLong(27, _tmp_4);
      }
    };
    this.__insertionAdapterOfReview = new EntityInsertionAdapter<Review>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `reviews` (`recipeId`,`userId`,`userName`,`rating`,`comment`,`createdAt`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Review entity) {
        if (entity.getRecipeId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getRecipeId());
        }
        if (entity.getUserId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getUserId());
        }
        if (entity.getUserName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getUserName());
        }
        statement.bindDouble(4, entity.getRating());
        if (entity.getComment() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getComment());
        }
        statement.bindLong(6, entity.getCreatedAt());
      }
    };
    this.__deletionAdapterOfRecipe = new EntityDeletionOrUpdateAdapter<Recipe>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `recipes` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Recipe entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__updateAdapterOfRecipe = new EntityDeletionOrUpdateAdapter<Recipe>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `recipes` SET `id` = ?,`title` = ?,`description` = ?,`imageUrl` = ?,`calories` = ?,`protein` = ?,`carbs` = ?,`fat` = ?,`fiber` = ?,`sugar` = ?,`sodium` = ?,`prepTime` = ?,`cookTime` = ?,`servings` = ?,`difficulty` = ?,`category` = ?,`cuisine` = ?,`dietaryTags` = ?,`ingredients` = ?,`instructions` = ?,`nutritionScore` = ?,`authorId` = ?,`authorName` = ?,`createdAt` = ?,`updatedAt` = ?,`isFavorite` = ?,`isOffline` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Recipe entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescription());
        }
        if (entity.getImageUrl() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getImageUrl());
        }
        statement.bindLong(5, entity.getCalories());
        statement.bindDouble(6, entity.getProtein());
        statement.bindDouble(7, entity.getCarbs());
        statement.bindDouble(8, entity.getFat());
        statement.bindDouble(9, entity.getFiber());
        statement.bindDouble(10, entity.getSugar());
        statement.bindDouble(11, entity.getSodium());
        statement.bindLong(12, entity.getPrepTime());
        statement.bindLong(13, entity.getCookTime());
        statement.bindLong(14, entity.getServings());
        if (entity.getDifficulty() == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.getDifficulty());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, entity.getCategory());
        }
        if (entity.getCuisine() == null) {
          statement.bindNull(17);
        } else {
          statement.bindString(17, entity.getCuisine());
        }
        final String _tmp = __listConverter.fromStringList(entity.getDietaryTags());
        if (_tmp == null) {
          statement.bindNull(18);
        } else {
          statement.bindString(18, _tmp);
        }
        final String _tmp_1 = __listConverter.fromIngredientList(entity.getIngredients());
        if (_tmp_1 == null) {
          statement.bindNull(19);
        } else {
          statement.bindString(19, _tmp_1);
        }
        final String _tmp_2 = __listConverter.fromStringList(entity.getInstructions());
        if (_tmp_2 == null) {
          statement.bindNull(20);
        } else {
          statement.bindString(20, _tmp_2);
        }
        statement.bindDouble(21, entity.getNutritionScore());
        if (entity.getAuthorId() == null) {
          statement.bindNull(22);
        } else {
          statement.bindString(22, entity.getAuthorId());
        }
        if (entity.getAuthorName() == null) {
          statement.bindNull(23);
        } else {
          statement.bindString(23, entity.getAuthorName());
        }
        statement.bindLong(24, entity.getCreatedAt());
        statement.bindLong(25, entity.getUpdatedAt());
        final int _tmp_3 = entity.isFavorite() ? 1 : 0;
        statement.bindLong(26, _tmp_3);
        final int _tmp_4 = entity.isOffline() ? 1 : 0;
        statement.bindLong(27, _tmp_4);
        if (entity.getId() == null) {
          statement.bindNull(28);
        } else {
          statement.bindString(28, entity.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteRecipeById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM recipes WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateFavoriteStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE recipes SET isFavorite = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateOfflineStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE recipes SET isOffline = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllRecipes = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM recipes";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteRecipesByAuthor = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM recipes WHERE authorId = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertRecipe(final Recipe recipe, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfRecipe.insert(recipe);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertRecipes(final List<Recipe> recipes,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfRecipe.insert(recipes);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertReview(final Review review, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfReview.insert(review);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteRecipe(final Recipe recipe, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfRecipe.handle(recipe);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateRecipe(final Recipe recipe, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfRecipe.handle(recipe);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteRecipeById(final String recipeId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteRecipeById.acquire();
        int _argIndex = 1;
        if (recipeId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, recipeId);
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
          __preparedStmtOfDeleteRecipeById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateFavoriteStatus(final String recipeId, final boolean isFavorite,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateFavoriteStatus.acquire();
        int _argIndex = 1;
        final int _tmp = isFavorite ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        if (recipeId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, recipeId);
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
          __preparedStmtOfUpdateFavoriteStatus.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateOfflineStatus(final String recipeId, final boolean isOffline,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateOfflineStatus.acquire();
        int _argIndex = 1;
        final int _tmp = isOffline ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        if (recipeId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, recipeId);
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
          __preparedStmtOfUpdateOfflineStatus.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllRecipes(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllRecipes.acquire();
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
          __preparedStmtOfDeleteAllRecipes.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteRecipesByAuthor(final String authorId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteRecipesByAuthor.acquire();
        int _argIndex = 1;
        if (authorId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, authorId);
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
          __preparedStmtOfDeleteRecipesByAuthor.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Recipe>> getAllRecipes() {
    final String _sql = "SELECT * FROM recipes ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"recipes"}, new Callable<List<Recipe>>() {
      @Override
      @NonNull
      public List<Recipe> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "protein");
          final int _cursorIndexOfCarbs = CursorUtil.getColumnIndexOrThrow(_cursor, "carbs");
          final int _cursorIndexOfFat = CursorUtil.getColumnIndexOrThrow(_cursor, "fat");
          final int _cursorIndexOfFiber = CursorUtil.getColumnIndexOrThrow(_cursor, "fiber");
          final int _cursorIndexOfSugar = CursorUtil.getColumnIndexOrThrow(_cursor, "sugar");
          final int _cursorIndexOfSodium = CursorUtil.getColumnIndexOrThrow(_cursor, "sodium");
          final int _cursorIndexOfPrepTime = CursorUtil.getColumnIndexOrThrow(_cursor, "prepTime");
          final int _cursorIndexOfCookTime = CursorUtil.getColumnIndexOrThrow(_cursor, "cookTime");
          final int _cursorIndexOfServings = CursorUtil.getColumnIndexOrThrow(_cursor, "servings");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfCuisine = CursorUtil.getColumnIndexOrThrow(_cursor, "cuisine");
          final int _cursorIndexOfDietaryTags = CursorUtil.getColumnIndexOrThrow(_cursor, "dietaryTags");
          final int _cursorIndexOfIngredients = CursorUtil.getColumnIndexOrThrow(_cursor, "ingredients");
          final int _cursorIndexOfInstructions = CursorUtil.getColumnIndexOrThrow(_cursor, "instructions");
          final int _cursorIndexOfNutritionScore = CursorUtil.getColumnIndexOrThrow(_cursor, "nutritionScore");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorName");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsOffline = CursorUtil.getColumnIndexOrThrow(_cursor, "isOffline");
          final List<Recipe> _result = new ArrayList<Recipe>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Recipe _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final int _tmpCalories;
            _tmpCalories = _cursor.getInt(_cursorIndexOfCalories);
            final double _tmpProtein;
            _tmpProtein = _cursor.getDouble(_cursorIndexOfProtein);
            final double _tmpCarbs;
            _tmpCarbs = _cursor.getDouble(_cursorIndexOfCarbs);
            final double _tmpFat;
            _tmpFat = _cursor.getDouble(_cursorIndexOfFat);
            final double _tmpFiber;
            _tmpFiber = _cursor.getDouble(_cursorIndexOfFiber);
            final double _tmpSugar;
            _tmpSugar = _cursor.getDouble(_cursorIndexOfSugar);
            final double _tmpSodium;
            _tmpSodium = _cursor.getDouble(_cursorIndexOfSodium);
            final int _tmpPrepTime;
            _tmpPrepTime = _cursor.getInt(_cursorIndexOfPrepTime);
            final int _tmpCookTime;
            _tmpCookTime = _cursor.getInt(_cursorIndexOfCookTime);
            final int _tmpServings;
            _tmpServings = _cursor.getInt(_cursorIndexOfServings);
            final String _tmpDifficulty;
            if (_cursor.isNull(_cursorIndexOfDifficulty)) {
              _tmpDifficulty = null;
            } else {
              _tmpDifficulty = _cursor.getString(_cursorIndexOfDifficulty);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpCuisine;
            if (_cursor.isNull(_cursorIndexOfCuisine)) {
              _tmpCuisine = null;
            } else {
              _tmpCuisine = _cursor.getString(_cursorIndexOfCuisine);
            }
            final List<String> _tmpDietaryTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDietaryTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDietaryTags);
            }
            _tmpDietaryTags = __listConverter.toStringList(_tmp);
            final List<Ingredient> _tmpIngredients;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfIngredients)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfIngredients);
            }
            _tmpIngredients = __listConverter.toIngredientList(_tmp_1);
            final List<String> _tmpInstructions;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfInstructions)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfInstructions);
            }
            _tmpInstructions = __listConverter.toStringList(_tmp_2);
            final double _tmpNutritionScore;
            _tmpNutritionScore = _cursor.getDouble(_cursorIndexOfNutritionScore);
            final String _tmpAuthorId;
            if (_cursor.isNull(_cursorIndexOfAuthorId)) {
              _tmpAuthorId = null;
            } else {
              _tmpAuthorId = _cursor.getString(_cursorIndexOfAuthorId);
            }
            final String _tmpAuthorName;
            if (_cursor.isNull(_cursorIndexOfAuthorName)) {
              _tmpAuthorName = null;
            } else {
              _tmpAuthorName = _cursor.getString(_cursorIndexOfAuthorName);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final boolean _tmpIsFavorite;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_3 != 0;
            final boolean _tmpIsOffline;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsOffline);
            _tmpIsOffline = _tmp_4 != 0;
            _item = new Recipe(_tmpId,_tmpTitle,_tmpDescription,_tmpImageUrl,_tmpCalories,_tmpProtein,_tmpCarbs,_tmpFat,_tmpFiber,_tmpSugar,_tmpSodium,_tmpPrepTime,_tmpCookTime,_tmpServings,_tmpDifficulty,_tmpCategory,_tmpCuisine,_tmpDietaryTags,_tmpIngredients,_tmpInstructions,_tmpNutritionScore,_tmpAuthorId,_tmpAuthorName,_tmpCreatedAt,_tmpUpdatedAt,_tmpIsFavorite,_tmpIsOffline);
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
  public Object getAllRecipesSync(final Continuation<? super List<Recipe>> $completion) {
    final String _sql = "SELECT * FROM recipes ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Recipe>>() {
      @Override
      @NonNull
      public List<Recipe> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "protein");
          final int _cursorIndexOfCarbs = CursorUtil.getColumnIndexOrThrow(_cursor, "carbs");
          final int _cursorIndexOfFat = CursorUtil.getColumnIndexOrThrow(_cursor, "fat");
          final int _cursorIndexOfFiber = CursorUtil.getColumnIndexOrThrow(_cursor, "fiber");
          final int _cursorIndexOfSugar = CursorUtil.getColumnIndexOrThrow(_cursor, "sugar");
          final int _cursorIndexOfSodium = CursorUtil.getColumnIndexOrThrow(_cursor, "sodium");
          final int _cursorIndexOfPrepTime = CursorUtil.getColumnIndexOrThrow(_cursor, "prepTime");
          final int _cursorIndexOfCookTime = CursorUtil.getColumnIndexOrThrow(_cursor, "cookTime");
          final int _cursorIndexOfServings = CursorUtil.getColumnIndexOrThrow(_cursor, "servings");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfCuisine = CursorUtil.getColumnIndexOrThrow(_cursor, "cuisine");
          final int _cursorIndexOfDietaryTags = CursorUtil.getColumnIndexOrThrow(_cursor, "dietaryTags");
          final int _cursorIndexOfIngredients = CursorUtil.getColumnIndexOrThrow(_cursor, "ingredients");
          final int _cursorIndexOfInstructions = CursorUtil.getColumnIndexOrThrow(_cursor, "instructions");
          final int _cursorIndexOfNutritionScore = CursorUtil.getColumnIndexOrThrow(_cursor, "nutritionScore");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorName");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsOffline = CursorUtil.getColumnIndexOrThrow(_cursor, "isOffline");
          final List<Recipe> _result = new ArrayList<Recipe>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Recipe _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final int _tmpCalories;
            _tmpCalories = _cursor.getInt(_cursorIndexOfCalories);
            final double _tmpProtein;
            _tmpProtein = _cursor.getDouble(_cursorIndexOfProtein);
            final double _tmpCarbs;
            _tmpCarbs = _cursor.getDouble(_cursorIndexOfCarbs);
            final double _tmpFat;
            _tmpFat = _cursor.getDouble(_cursorIndexOfFat);
            final double _tmpFiber;
            _tmpFiber = _cursor.getDouble(_cursorIndexOfFiber);
            final double _tmpSugar;
            _tmpSugar = _cursor.getDouble(_cursorIndexOfSugar);
            final double _tmpSodium;
            _tmpSodium = _cursor.getDouble(_cursorIndexOfSodium);
            final int _tmpPrepTime;
            _tmpPrepTime = _cursor.getInt(_cursorIndexOfPrepTime);
            final int _tmpCookTime;
            _tmpCookTime = _cursor.getInt(_cursorIndexOfCookTime);
            final int _tmpServings;
            _tmpServings = _cursor.getInt(_cursorIndexOfServings);
            final String _tmpDifficulty;
            if (_cursor.isNull(_cursorIndexOfDifficulty)) {
              _tmpDifficulty = null;
            } else {
              _tmpDifficulty = _cursor.getString(_cursorIndexOfDifficulty);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpCuisine;
            if (_cursor.isNull(_cursorIndexOfCuisine)) {
              _tmpCuisine = null;
            } else {
              _tmpCuisine = _cursor.getString(_cursorIndexOfCuisine);
            }
            final List<String> _tmpDietaryTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDietaryTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDietaryTags);
            }
            _tmpDietaryTags = __listConverter.toStringList(_tmp);
            final List<Ingredient> _tmpIngredients;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfIngredients)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfIngredients);
            }
            _tmpIngredients = __listConverter.toIngredientList(_tmp_1);
            final List<String> _tmpInstructions;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfInstructions)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfInstructions);
            }
            _tmpInstructions = __listConverter.toStringList(_tmp_2);
            final double _tmpNutritionScore;
            _tmpNutritionScore = _cursor.getDouble(_cursorIndexOfNutritionScore);
            final String _tmpAuthorId;
            if (_cursor.isNull(_cursorIndexOfAuthorId)) {
              _tmpAuthorId = null;
            } else {
              _tmpAuthorId = _cursor.getString(_cursorIndexOfAuthorId);
            }
            final String _tmpAuthorName;
            if (_cursor.isNull(_cursorIndexOfAuthorName)) {
              _tmpAuthorName = null;
            } else {
              _tmpAuthorName = _cursor.getString(_cursorIndexOfAuthorName);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final boolean _tmpIsFavorite;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_3 != 0;
            final boolean _tmpIsOffline;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsOffline);
            _tmpIsOffline = _tmp_4 != 0;
            _item = new Recipe(_tmpId,_tmpTitle,_tmpDescription,_tmpImageUrl,_tmpCalories,_tmpProtein,_tmpCarbs,_tmpFat,_tmpFiber,_tmpSugar,_tmpSodium,_tmpPrepTime,_tmpCookTime,_tmpServings,_tmpDifficulty,_tmpCategory,_tmpCuisine,_tmpDietaryTags,_tmpIngredients,_tmpInstructions,_tmpNutritionScore,_tmpAuthorId,_tmpAuthorName,_tmpCreatedAt,_tmpUpdatedAt,_tmpIsFavorite,_tmpIsOffline);
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
  public Object getRecipeById(final String recipeId,
      final Continuation<? super Recipe> $completion) {
    final String _sql = "SELECT * FROM recipes WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (recipeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, recipeId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Recipe>() {
      @Override
      @Nullable
      public Recipe call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "protein");
          final int _cursorIndexOfCarbs = CursorUtil.getColumnIndexOrThrow(_cursor, "carbs");
          final int _cursorIndexOfFat = CursorUtil.getColumnIndexOrThrow(_cursor, "fat");
          final int _cursorIndexOfFiber = CursorUtil.getColumnIndexOrThrow(_cursor, "fiber");
          final int _cursorIndexOfSugar = CursorUtil.getColumnIndexOrThrow(_cursor, "sugar");
          final int _cursorIndexOfSodium = CursorUtil.getColumnIndexOrThrow(_cursor, "sodium");
          final int _cursorIndexOfPrepTime = CursorUtil.getColumnIndexOrThrow(_cursor, "prepTime");
          final int _cursorIndexOfCookTime = CursorUtil.getColumnIndexOrThrow(_cursor, "cookTime");
          final int _cursorIndexOfServings = CursorUtil.getColumnIndexOrThrow(_cursor, "servings");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfCuisine = CursorUtil.getColumnIndexOrThrow(_cursor, "cuisine");
          final int _cursorIndexOfDietaryTags = CursorUtil.getColumnIndexOrThrow(_cursor, "dietaryTags");
          final int _cursorIndexOfIngredients = CursorUtil.getColumnIndexOrThrow(_cursor, "ingredients");
          final int _cursorIndexOfInstructions = CursorUtil.getColumnIndexOrThrow(_cursor, "instructions");
          final int _cursorIndexOfNutritionScore = CursorUtil.getColumnIndexOrThrow(_cursor, "nutritionScore");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorName");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsOffline = CursorUtil.getColumnIndexOrThrow(_cursor, "isOffline");
          final Recipe _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final int _tmpCalories;
            _tmpCalories = _cursor.getInt(_cursorIndexOfCalories);
            final double _tmpProtein;
            _tmpProtein = _cursor.getDouble(_cursorIndexOfProtein);
            final double _tmpCarbs;
            _tmpCarbs = _cursor.getDouble(_cursorIndexOfCarbs);
            final double _tmpFat;
            _tmpFat = _cursor.getDouble(_cursorIndexOfFat);
            final double _tmpFiber;
            _tmpFiber = _cursor.getDouble(_cursorIndexOfFiber);
            final double _tmpSugar;
            _tmpSugar = _cursor.getDouble(_cursorIndexOfSugar);
            final double _tmpSodium;
            _tmpSodium = _cursor.getDouble(_cursorIndexOfSodium);
            final int _tmpPrepTime;
            _tmpPrepTime = _cursor.getInt(_cursorIndexOfPrepTime);
            final int _tmpCookTime;
            _tmpCookTime = _cursor.getInt(_cursorIndexOfCookTime);
            final int _tmpServings;
            _tmpServings = _cursor.getInt(_cursorIndexOfServings);
            final String _tmpDifficulty;
            if (_cursor.isNull(_cursorIndexOfDifficulty)) {
              _tmpDifficulty = null;
            } else {
              _tmpDifficulty = _cursor.getString(_cursorIndexOfDifficulty);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpCuisine;
            if (_cursor.isNull(_cursorIndexOfCuisine)) {
              _tmpCuisine = null;
            } else {
              _tmpCuisine = _cursor.getString(_cursorIndexOfCuisine);
            }
            final List<String> _tmpDietaryTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDietaryTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDietaryTags);
            }
            _tmpDietaryTags = __listConverter.toStringList(_tmp);
            final List<Ingredient> _tmpIngredients;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfIngredients)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfIngredients);
            }
            _tmpIngredients = __listConverter.toIngredientList(_tmp_1);
            final List<String> _tmpInstructions;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfInstructions)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfInstructions);
            }
            _tmpInstructions = __listConverter.toStringList(_tmp_2);
            final double _tmpNutritionScore;
            _tmpNutritionScore = _cursor.getDouble(_cursorIndexOfNutritionScore);
            final String _tmpAuthorId;
            if (_cursor.isNull(_cursorIndexOfAuthorId)) {
              _tmpAuthorId = null;
            } else {
              _tmpAuthorId = _cursor.getString(_cursorIndexOfAuthorId);
            }
            final String _tmpAuthorName;
            if (_cursor.isNull(_cursorIndexOfAuthorName)) {
              _tmpAuthorName = null;
            } else {
              _tmpAuthorName = _cursor.getString(_cursorIndexOfAuthorName);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final boolean _tmpIsFavorite;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_3 != 0;
            final boolean _tmpIsOffline;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsOffline);
            _tmpIsOffline = _tmp_4 != 0;
            _result = new Recipe(_tmpId,_tmpTitle,_tmpDescription,_tmpImageUrl,_tmpCalories,_tmpProtein,_tmpCarbs,_tmpFat,_tmpFiber,_tmpSugar,_tmpSodium,_tmpPrepTime,_tmpCookTime,_tmpServings,_tmpDifficulty,_tmpCategory,_tmpCuisine,_tmpDietaryTags,_tmpIngredients,_tmpInstructions,_tmpNutritionScore,_tmpAuthorId,_tmpAuthorName,_tmpCreatedAt,_tmpUpdatedAt,_tmpIsFavorite,_tmpIsOffline);
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
  public LiveData<Recipe> getRecipeByIdLive(final String recipeId) {
    final String _sql = "SELECT * FROM recipes WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (recipeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, recipeId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[] {"recipes"}, false, new Callable<Recipe>() {
      @Override
      @Nullable
      public Recipe call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "protein");
          final int _cursorIndexOfCarbs = CursorUtil.getColumnIndexOrThrow(_cursor, "carbs");
          final int _cursorIndexOfFat = CursorUtil.getColumnIndexOrThrow(_cursor, "fat");
          final int _cursorIndexOfFiber = CursorUtil.getColumnIndexOrThrow(_cursor, "fiber");
          final int _cursorIndexOfSugar = CursorUtil.getColumnIndexOrThrow(_cursor, "sugar");
          final int _cursorIndexOfSodium = CursorUtil.getColumnIndexOrThrow(_cursor, "sodium");
          final int _cursorIndexOfPrepTime = CursorUtil.getColumnIndexOrThrow(_cursor, "prepTime");
          final int _cursorIndexOfCookTime = CursorUtil.getColumnIndexOrThrow(_cursor, "cookTime");
          final int _cursorIndexOfServings = CursorUtil.getColumnIndexOrThrow(_cursor, "servings");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfCuisine = CursorUtil.getColumnIndexOrThrow(_cursor, "cuisine");
          final int _cursorIndexOfDietaryTags = CursorUtil.getColumnIndexOrThrow(_cursor, "dietaryTags");
          final int _cursorIndexOfIngredients = CursorUtil.getColumnIndexOrThrow(_cursor, "ingredients");
          final int _cursorIndexOfInstructions = CursorUtil.getColumnIndexOrThrow(_cursor, "instructions");
          final int _cursorIndexOfNutritionScore = CursorUtil.getColumnIndexOrThrow(_cursor, "nutritionScore");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorName");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsOffline = CursorUtil.getColumnIndexOrThrow(_cursor, "isOffline");
          final Recipe _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final int _tmpCalories;
            _tmpCalories = _cursor.getInt(_cursorIndexOfCalories);
            final double _tmpProtein;
            _tmpProtein = _cursor.getDouble(_cursorIndexOfProtein);
            final double _tmpCarbs;
            _tmpCarbs = _cursor.getDouble(_cursorIndexOfCarbs);
            final double _tmpFat;
            _tmpFat = _cursor.getDouble(_cursorIndexOfFat);
            final double _tmpFiber;
            _tmpFiber = _cursor.getDouble(_cursorIndexOfFiber);
            final double _tmpSugar;
            _tmpSugar = _cursor.getDouble(_cursorIndexOfSugar);
            final double _tmpSodium;
            _tmpSodium = _cursor.getDouble(_cursorIndexOfSodium);
            final int _tmpPrepTime;
            _tmpPrepTime = _cursor.getInt(_cursorIndexOfPrepTime);
            final int _tmpCookTime;
            _tmpCookTime = _cursor.getInt(_cursorIndexOfCookTime);
            final int _tmpServings;
            _tmpServings = _cursor.getInt(_cursorIndexOfServings);
            final String _tmpDifficulty;
            if (_cursor.isNull(_cursorIndexOfDifficulty)) {
              _tmpDifficulty = null;
            } else {
              _tmpDifficulty = _cursor.getString(_cursorIndexOfDifficulty);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpCuisine;
            if (_cursor.isNull(_cursorIndexOfCuisine)) {
              _tmpCuisine = null;
            } else {
              _tmpCuisine = _cursor.getString(_cursorIndexOfCuisine);
            }
            final List<String> _tmpDietaryTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDietaryTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDietaryTags);
            }
            _tmpDietaryTags = __listConverter.toStringList(_tmp);
            final List<Ingredient> _tmpIngredients;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfIngredients)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfIngredients);
            }
            _tmpIngredients = __listConverter.toIngredientList(_tmp_1);
            final List<String> _tmpInstructions;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfInstructions)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfInstructions);
            }
            _tmpInstructions = __listConverter.toStringList(_tmp_2);
            final double _tmpNutritionScore;
            _tmpNutritionScore = _cursor.getDouble(_cursorIndexOfNutritionScore);
            final String _tmpAuthorId;
            if (_cursor.isNull(_cursorIndexOfAuthorId)) {
              _tmpAuthorId = null;
            } else {
              _tmpAuthorId = _cursor.getString(_cursorIndexOfAuthorId);
            }
            final String _tmpAuthorName;
            if (_cursor.isNull(_cursorIndexOfAuthorName)) {
              _tmpAuthorName = null;
            } else {
              _tmpAuthorName = _cursor.getString(_cursorIndexOfAuthorName);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final boolean _tmpIsFavorite;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_3 != 0;
            final boolean _tmpIsOffline;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsOffline);
            _tmpIsOffline = _tmp_4 != 0;
            _result = new Recipe(_tmpId,_tmpTitle,_tmpDescription,_tmpImageUrl,_tmpCalories,_tmpProtein,_tmpCarbs,_tmpFat,_tmpFiber,_tmpSugar,_tmpSodium,_tmpPrepTime,_tmpCookTime,_tmpServings,_tmpDifficulty,_tmpCategory,_tmpCuisine,_tmpDietaryTags,_tmpIngredients,_tmpInstructions,_tmpNutritionScore,_tmpAuthorId,_tmpAuthorName,_tmpCreatedAt,_tmpUpdatedAt,_tmpIsFavorite,_tmpIsOffline);
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
  public Flow<Recipe> getRecipeByIdFlow(final String recipeId) {
    final String _sql = "SELECT * FROM recipes WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (recipeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, recipeId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"recipes"}, new Callable<Recipe>() {
      @Override
      @Nullable
      public Recipe call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "protein");
          final int _cursorIndexOfCarbs = CursorUtil.getColumnIndexOrThrow(_cursor, "carbs");
          final int _cursorIndexOfFat = CursorUtil.getColumnIndexOrThrow(_cursor, "fat");
          final int _cursorIndexOfFiber = CursorUtil.getColumnIndexOrThrow(_cursor, "fiber");
          final int _cursorIndexOfSugar = CursorUtil.getColumnIndexOrThrow(_cursor, "sugar");
          final int _cursorIndexOfSodium = CursorUtil.getColumnIndexOrThrow(_cursor, "sodium");
          final int _cursorIndexOfPrepTime = CursorUtil.getColumnIndexOrThrow(_cursor, "prepTime");
          final int _cursorIndexOfCookTime = CursorUtil.getColumnIndexOrThrow(_cursor, "cookTime");
          final int _cursorIndexOfServings = CursorUtil.getColumnIndexOrThrow(_cursor, "servings");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfCuisine = CursorUtil.getColumnIndexOrThrow(_cursor, "cuisine");
          final int _cursorIndexOfDietaryTags = CursorUtil.getColumnIndexOrThrow(_cursor, "dietaryTags");
          final int _cursorIndexOfIngredients = CursorUtil.getColumnIndexOrThrow(_cursor, "ingredients");
          final int _cursorIndexOfInstructions = CursorUtil.getColumnIndexOrThrow(_cursor, "instructions");
          final int _cursorIndexOfNutritionScore = CursorUtil.getColumnIndexOrThrow(_cursor, "nutritionScore");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorName");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsOffline = CursorUtil.getColumnIndexOrThrow(_cursor, "isOffline");
          final Recipe _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final int _tmpCalories;
            _tmpCalories = _cursor.getInt(_cursorIndexOfCalories);
            final double _tmpProtein;
            _tmpProtein = _cursor.getDouble(_cursorIndexOfProtein);
            final double _tmpCarbs;
            _tmpCarbs = _cursor.getDouble(_cursorIndexOfCarbs);
            final double _tmpFat;
            _tmpFat = _cursor.getDouble(_cursorIndexOfFat);
            final double _tmpFiber;
            _tmpFiber = _cursor.getDouble(_cursorIndexOfFiber);
            final double _tmpSugar;
            _tmpSugar = _cursor.getDouble(_cursorIndexOfSugar);
            final double _tmpSodium;
            _tmpSodium = _cursor.getDouble(_cursorIndexOfSodium);
            final int _tmpPrepTime;
            _tmpPrepTime = _cursor.getInt(_cursorIndexOfPrepTime);
            final int _tmpCookTime;
            _tmpCookTime = _cursor.getInt(_cursorIndexOfCookTime);
            final int _tmpServings;
            _tmpServings = _cursor.getInt(_cursorIndexOfServings);
            final String _tmpDifficulty;
            if (_cursor.isNull(_cursorIndexOfDifficulty)) {
              _tmpDifficulty = null;
            } else {
              _tmpDifficulty = _cursor.getString(_cursorIndexOfDifficulty);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpCuisine;
            if (_cursor.isNull(_cursorIndexOfCuisine)) {
              _tmpCuisine = null;
            } else {
              _tmpCuisine = _cursor.getString(_cursorIndexOfCuisine);
            }
            final List<String> _tmpDietaryTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDietaryTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDietaryTags);
            }
            _tmpDietaryTags = __listConverter.toStringList(_tmp);
            final List<Ingredient> _tmpIngredients;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfIngredients)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfIngredients);
            }
            _tmpIngredients = __listConverter.toIngredientList(_tmp_1);
            final List<String> _tmpInstructions;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfInstructions)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfInstructions);
            }
            _tmpInstructions = __listConverter.toStringList(_tmp_2);
            final double _tmpNutritionScore;
            _tmpNutritionScore = _cursor.getDouble(_cursorIndexOfNutritionScore);
            final String _tmpAuthorId;
            if (_cursor.isNull(_cursorIndexOfAuthorId)) {
              _tmpAuthorId = null;
            } else {
              _tmpAuthorId = _cursor.getString(_cursorIndexOfAuthorId);
            }
            final String _tmpAuthorName;
            if (_cursor.isNull(_cursorIndexOfAuthorName)) {
              _tmpAuthorName = null;
            } else {
              _tmpAuthorName = _cursor.getString(_cursorIndexOfAuthorName);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final boolean _tmpIsFavorite;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_3 != 0;
            final boolean _tmpIsOffline;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsOffline);
            _tmpIsOffline = _tmp_4 != 0;
            _result = new Recipe(_tmpId,_tmpTitle,_tmpDescription,_tmpImageUrl,_tmpCalories,_tmpProtein,_tmpCarbs,_tmpFat,_tmpFiber,_tmpSugar,_tmpSodium,_tmpPrepTime,_tmpCookTime,_tmpServings,_tmpDifficulty,_tmpCategory,_tmpCuisine,_tmpDietaryTags,_tmpIngredients,_tmpInstructions,_tmpNutritionScore,_tmpAuthorId,_tmpAuthorName,_tmpCreatedAt,_tmpUpdatedAt,_tmpIsFavorite,_tmpIsOffline);
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
  public Flow<List<Recipe>> searchRecipes(final String query) {
    final String _sql = "\n"
            + "        SELECT * FROM recipes \n"
            + "        WHERE title LIKE '%' || ? || '%' \n"
            + "        OR description LIKE '%' || ? || '%'\n"
            + "        ORDER BY title ASC\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"recipes"}, new Callable<List<Recipe>>() {
      @Override
      @NonNull
      public List<Recipe> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "protein");
          final int _cursorIndexOfCarbs = CursorUtil.getColumnIndexOrThrow(_cursor, "carbs");
          final int _cursorIndexOfFat = CursorUtil.getColumnIndexOrThrow(_cursor, "fat");
          final int _cursorIndexOfFiber = CursorUtil.getColumnIndexOrThrow(_cursor, "fiber");
          final int _cursorIndexOfSugar = CursorUtil.getColumnIndexOrThrow(_cursor, "sugar");
          final int _cursorIndexOfSodium = CursorUtil.getColumnIndexOrThrow(_cursor, "sodium");
          final int _cursorIndexOfPrepTime = CursorUtil.getColumnIndexOrThrow(_cursor, "prepTime");
          final int _cursorIndexOfCookTime = CursorUtil.getColumnIndexOrThrow(_cursor, "cookTime");
          final int _cursorIndexOfServings = CursorUtil.getColumnIndexOrThrow(_cursor, "servings");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfCuisine = CursorUtil.getColumnIndexOrThrow(_cursor, "cuisine");
          final int _cursorIndexOfDietaryTags = CursorUtil.getColumnIndexOrThrow(_cursor, "dietaryTags");
          final int _cursorIndexOfIngredients = CursorUtil.getColumnIndexOrThrow(_cursor, "ingredients");
          final int _cursorIndexOfInstructions = CursorUtil.getColumnIndexOrThrow(_cursor, "instructions");
          final int _cursorIndexOfNutritionScore = CursorUtil.getColumnIndexOrThrow(_cursor, "nutritionScore");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorName");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsOffline = CursorUtil.getColumnIndexOrThrow(_cursor, "isOffline");
          final List<Recipe> _result = new ArrayList<Recipe>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Recipe _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final int _tmpCalories;
            _tmpCalories = _cursor.getInt(_cursorIndexOfCalories);
            final double _tmpProtein;
            _tmpProtein = _cursor.getDouble(_cursorIndexOfProtein);
            final double _tmpCarbs;
            _tmpCarbs = _cursor.getDouble(_cursorIndexOfCarbs);
            final double _tmpFat;
            _tmpFat = _cursor.getDouble(_cursorIndexOfFat);
            final double _tmpFiber;
            _tmpFiber = _cursor.getDouble(_cursorIndexOfFiber);
            final double _tmpSugar;
            _tmpSugar = _cursor.getDouble(_cursorIndexOfSugar);
            final double _tmpSodium;
            _tmpSodium = _cursor.getDouble(_cursorIndexOfSodium);
            final int _tmpPrepTime;
            _tmpPrepTime = _cursor.getInt(_cursorIndexOfPrepTime);
            final int _tmpCookTime;
            _tmpCookTime = _cursor.getInt(_cursorIndexOfCookTime);
            final int _tmpServings;
            _tmpServings = _cursor.getInt(_cursorIndexOfServings);
            final String _tmpDifficulty;
            if (_cursor.isNull(_cursorIndexOfDifficulty)) {
              _tmpDifficulty = null;
            } else {
              _tmpDifficulty = _cursor.getString(_cursorIndexOfDifficulty);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpCuisine;
            if (_cursor.isNull(_cursorIndexOfCuisine)) {
              _tmpCuisine = null;
            } else {
              _tmpCuisine = _cursor.getString(_cursorIndexOfCuisine);
            }
            final List<String> _tmpDietaryTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDietaryTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDietaryTags);
            }
            _tmpDietaryTags = __listConverter.toStringList(_tmp);
            final List<Ingredient> _tmpIngredients;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfIngredients)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfIngredients);
            }
            _tmpIngredients = __listConverter.toIngredientList(_tmp_1);
            final List<String> _tmpInstructions;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfInstructions)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfInstructions);
            }
            _tmpInstructions = __listConverter.toStringList(_tmp_2);
            final double _tmpNutritionScore;
            _tmpNutritionScore = _cursor.getDouble(_cursorIndexOfNutritionScore);
            final String _tmpAuthorId;
            if (_cursor.isNull(_cursorIndexOfAuthorId)) {
              _tmpAuthorId = null;
            } else {
              _tmpAuthorId = _cursor.getString(_cursorIndexOfAuthorId);
            }
            final String _tmpAuthorName;
            if (_cursor.isNull(_cursorIndexOfAuthorName)) {
              _tmpAuthorName = null;
            } else {
              _tmpAuthorName = _cursor.getString(_cursorIndexOfAuthorName);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final boolean _tmpIsFavorite;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_3 != 0;
            final boolean _tmpIsOffline;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsOffline);
            _tmpIsOffline = _tmp_4 != 0;
            _item = new Recipe(_tmpId,_tmpTitle,_tmpDescription,_tmpImageUrl,_tmpCalories,_tmpProtein,_tmpCarbs,_tmpFat,_tmpFiber,_tmpSugar,_tmpSodium,_tmpPrepTime,_tmpCookTime,_tmpServings,_tmpDifficulty,_tmpCategory,_tmpCuisine,_tmpDietaryTags,_tmpIngredients,_tmpInstructions,_tmpNutritionScore,_tmpAuthorId,_tmpAuthorName,_tmpCreatedAt,_tmpUpdatedAt,_tmpIsFavorite,_tmpIsOffline);
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
  public Flow<List<Recipe>> getRecipesByCategory(final String category) {
    final String _sql = "SELECT * FROM recipes WHERE category = ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"recipes"}, new Callable<List<Recipe>>() {
      @Override
      @NonNull
      public List<Recipe> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "protein");
          final int _cursorIndexOfCarbs = CursorUtil.getColumnIndexOrThrow(_cursor, "carbs");
          final int _cursorIndexOfFat = CursorUtil.getColumnIndexOrThrow(_cursor, "fat");
          final int _cursorIndexOfFiber = CursorUtil.getColumnIndexOrThrow(_cursor, "fiber");
          final int _cursorIndexOfSugar = CursorUtil.getColumnIndexOrThrow(_cursor, "sugar");
          final int _cursorIndexOfSodium = CursorUtil.getColumnIndexOrThrow(_cursor, "sodium");
          final int _cursorIndexOfPrepTime = CursorUtil.getColumnIndexOrThrow(_cursor, "prepTime");
          final int _cursorIndexOfCookTime = CursorUtil.getColumnIndexOrThrow(_cursor, "cookTime");
          final int _cursorIndexOfServings = CursorUtil.getColumnIndexOrThrow(_cursor, "servings");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfCuisine = CursorUtil.getColumnIndexOrThrow(_cursor, "cuisine");
          final int _cursorIndexOfDietaryTags = CursorUtil.getColumnIndexOrThrow(_cursor, "dietaryTags");
          final int _cursorIndexOfIngredients = CursorUtil.getColumnIndexOrThrow(_cursor, "ingredients");
          final int _cursorIndexOfInstructions = CursorUtil.getColumnIndexOrThrow(_cursor, "instructions");
          final int _cursorIndexOfNutritionScore = CursorUtil.getColumnIndexOrThrow(_cursor, "nutritionScore");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorName");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsOffline = CursorUtil.getColumnIndexOrThrow(_cursor, "isOffline");
          final List<Recipe> _result = new ArrayList<Recipe>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Recipe _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final int _tmpCalories;
            _tmpCalories = _cursor.getInt(_cursorIndexOfCalories);
            final double _tmpProtein;
            _tmpProtein = _cursor.getDouble(_cursorIndexOfProtein);
            final double _tmpCarbs;
            _tmpCarbs = _cursor.getDouble(_cursorIndexOfCarbs);
            final double _tmpFat;
            _tmpFat = _cursor.getDouble(_cursorIndexOfFat);
            final double _tmpFiber;
            _tmpFiber = _cursor.getDouble(_cursorIndexOfFiber);
            final double _tmpSugar;
            _tmpSugar = _cursor.getDouble(_cursorIndexOfSugar);
            final double _tmpSodium;
            _tmpSodium = _cursor.getDouble(_cursorIndexOfSodium);
            final int _tmpPrepTime;
            _tmpPrepTime = _cursor.getInt(_cursorIndexOfPrepTime);
            final int _tmpCookTime;
            _tmpCookTime = _cursor.getInt(_cursorIndexOfCookTime);
            final int _tmpServings;
            _tmpServings = _cursor.getInt(_cursorIndexOfServings);
            final String _tmpDifficulty;
            if (_cursor.isNull(_cursorIndexOfDifficulty)) {
              _tmpDifficulty = null;
            } else {
              _tmpDifficulty = _cursor.getString(_cursorIndexOfDifficulty);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpCuisine;
            if (_cursor.isNull(_cursorIndexOfCuisine)) {
              _tmpCuisine = null;
            } else {
              _tmpCuisine = _cursor.getString(_cursorIndexOfCuisine);
            }
            final List<String> _tmpDietaryTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDietaryTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDietaryTags);
            }
            _tmpDietaryTags = __listConverter.toStringList(_tmp);
            final List<Ingredient> _tmpIngredients;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfIngredients)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfIngredients);
            }
            _tmpIngredients = __listConverter.toIngredientList(_tmp_1);
            final List<String> _tmpInstructions;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfInstructions)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfInstructions);
            }
            _tmpInstructions = __listConverter.toStringList(_tmp_2);
            final double _tmpNutritionScore;
            _tmpNutritionScore = _cursor.getDouble(_cursorIndexOfNutritionScore);
            final String _tmpAuthorId;
            if (_cursor.isNull(_cursorIndexOfAuthorId)) {
              _tmpAuthorId = null;
            } else {
              _tmpAuthorId = _cursor.getString(_cursorIndexOfAuthorId);
            }
            final String _tmpAuthorName;
            if (_cursor.isNull(_cursorIndexOfAuthorName)) {
              _tmpAuthorName = null;
            } else {
              _tmpAuthorName = _cursor.getString(_cursorIndexOfAuthorName);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final boolean _tmpIsFavorite;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_3 != 0;
            final boolean _tmpIsOffline;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsOffline);
            _tmpIsOffline = _tmp_4 != 0;
            _item = new Recipe(_tmpId,_tmpTitle,_tmpDescription,_tmpImageUrl,_tmpCalories,_tmpProtein,_tmpCarbs,_tmpFat,_tmpFiber,_tmpSugar,_tmpSodium,_tmpPrepTime,_tmpCookTime,_tmpServings,_tmpDifficulty,_tmpCategory,_tmpCuisine,_tmpDietaryTags,_tmpIngredients,_tmpInstructions,_tmpNutritionScore,_tmpAuthorId,_tmpAuthorName,_tmpCreatedAt,_tmpUpdatedAt,_tmpIsFavorite,_tmpIsOffline);
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
  public Flow<List<Recipe>> getRecipesByCuisine(final String cuisine) {
    final String _sql = "SELECT * FROM recipes WHERE cuisine = ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (cuisine == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, cuisine);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"recipes"}, new Callable<List<Recipe>>() {
      @Override
      @NonNull
      public List<Recipe> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "protein");
          final int _cursorIndexOfCarbs = CursorUtil.getColumnIndexOrThrow(_cursor, "carbs");
          final int _cursorIndexOfFat = CursorUtil.getColumnIndexOrThrow(_cursor, "fat");
          final int _cursorIndexOfFiber = CursorUtil.getColumnIndexOrThrow(_cursor, "fiber");
          final int _cursorIndexOfSugar = CursorUtil.getColumnIndexOrThrow(_cursor, "sugar");
          final int _cursorIndexOfSodium = CursorUtil.getColumnIndexOrThrow(_cursor, "sodium");
          final int _cursorIndexOfPrepTime = CursorUtil.getColumnIndexOrThrow(_cursor, "prepTime");
          final int _cursorIndexOfCookTime = CursorUtil.getColumnIndexOrThrow(_cursor, "cookTime");
          final int _cursorIndexOfServings = CursorUtil.getColumnIndexOrThrow(_cursor, "servings");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfCuisine = CursorUtil.getColumnIndexOrThrow(_cursor, "cuisine");
          final int _cursorIndexOfDietaryTags = CursorUtil.getColumnIndexOrThrow(_cursor, "dietaryTags");
          final int _cursorIndexOfIngredients = CursorUtil.getColumnIndexOrThrow(_cursor, "ingredients");
          final int _cursorIndexOfInstructions = CursorUtil.getColumnIndexOrThrow(_cursor, "instructions");
          final int _cursorIndexOfNutritionScore = CursorUtil.getColumnIndexOrThrow(_cursor, "nutritionScore");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorName");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsOffline = CursorUtil.getColumnIndexOrThrow(_cursor, "isOffline");
          final List<Recipe> _result = new ArrayList<Recipe>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Recipe _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final int _tmpCalories;
            _tmpCalories = _cursor.getInt(_cursorIndexOfCalories);
            final double _tmpProtein;
            _tmpProtein = _cursor.getDouble(_cursorIndexOfProtein);
            final double _tmpCarbs;
            _tmpCarbs = _cursor.getDouble(_cursorIndexOfCarbs);
            final double _tmpFat;
            _tmpFat = _cursor.getDouble(_cursorIndexOfFat);
            final double _tmpFiber;
            _tmpFiber = _cursor.getDouble(_cursorIndexOfFiber);
            final double _tmpSugar;
            _tmpSugar = _cursor.getDouble(_cursorIndexOfSugar);
            final double _tmpSodium;
            _tmpSodium = _cursor.getDouble(_cursorIndexOfSodium);
            final int _tmpPrepTime;
            _tmpPrepTime = _cursor.getInt(_cursorIndexOfPrepTime);
            final int _tmpCookTime;
            _tmpCookTime = _cursor.getInt(_cursorIndexOfCookTime);
            final int _tmpServings;
            _tmpServings = _cursor.getInt(_cursorIndexOfServings);
            final String _tmpDifficulty;
            if (_cursor.isNull(_cursorIndexOfDifficulty)) {
              _tmpDifficulty = null;
            } else {
              _tmpDifficulty = _cursor.getString(_cursorIndexOfDifficulty);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpCuisine;
            if (_cursor.isNull(_cursorIndexOfCuisine)) {
              _tmpCuisine = null;
            } else {
              _tmpCuisine = _cursor.getString(_cursorIndexOfCuisine);
            }
            final List<String> _tmpDietaryTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDietaryTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDietaryTags);
            }
            _tmpDietaryTags = __listConverter.toStringList(_tmp);
            final List<Ingredient> _tmpIngredients;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfIngredients)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfIngredients);
            }
            _tmpIngredients = __listConverter.toIngredientList(_tmp_1);
            final List<String> _tmpInstructions;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfInstructions)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfInstructions);
            }
            _tmpInstructions = __listConverter.toStringList(_tmp_2);
            final double _tmpNutritionScore;
            _tmpNutritionScore = _cursor.getDouble(_cursorIndexOfNutritionScore);
            final String _tmpAuthorId;
            if (_cursor.isNull(_cursorIndexOfAuthorId)) {
              _tmpAuthorId = null;
            } else {
              _tmpAuthorId = _cursor.getString(_cursorIndexOfAuthorId);
            }
            final String _tmpAuthorName;
            if (_cursor.isNull(_cursorIndexOfAuthorName)) {
              _tmpAuthorName = null;
            } else {
              _tmpAuthorName = _cursor.getString(_cursorIndexOfAuthorName);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final boolean _tmpIsFavorite;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_3 != 0;
            final boolean _tmpIsOffline;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsOffline);
            _tmpIsOffline = _tmp_4 != 0;
            _item = new Recipe(_tmpId,_tmpTitle,_tmpDescription,_tmpImageUrl,_tmpCalories,_tmpProtein,_tmpCarbs,_tmpFat,_tmpFiber,_tmpSugar,_tmpSodium,_tmpPrepTime,_tmpCookTime,_tmpServings,_tmpDifficulty,_tmpCategory,_tmpCuisine,_tmpDietaryTags,_tmpIngredients,_tmpInstructions,_tmpNutritionScore,_tmpAuthorId,_tmpAuthorName,_tmpCreatedAt,_tmpUpdatedAt,_tmpIsFavorite,_tmpIsOffline);
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
  public Flow<List<Recipe>> getRecipesByDifficulty(final String difficulty) {
    final String _sql = "SELECT * FROM recipes WHERE difficulty = ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (difficulty == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, difficulty);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"recipes"}, new Callable<List<Recipe>>() {
      @Override
      @NonNull
      public List<Recipe> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "protein");
          final int _cursorIndexOfCarbs = CursorUtil.getColumnIndexOrThrow(_cursor, "carbs");
          final int _cursorIndexOfFat = CursorUtil.getColumnIndexOrThrow(_cursor, "fat");
          final int _cursorIndexOfFiber = CursorUtil.getColumnIndexOrThrow(_cursor, "fiber");
          final int _cursorIndexOfSugar = CursorUtil.getColumnIndexOrThrow(_cursor, "sugar");
          final int _cursorIndexOfSodium = CursorUtil.getColumnIndexOrThrow(_cursor, "sodium");
          final int _cursorIndexOfPrepTime = CursorUtil.getColumnIndexOrThrow(_cursor, "prepTime");
          final int _cursorIndexOfCookTime = CursorUtil.getColumnIndexOrThrow(_cursor, "cookTime");
          final int _cursorIndexOfServings = CursorUtil.getColumnIndexOrThrow(_cursor, "servings");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfCuisine = CursorUtil.getColumnIndexOrThrow(_cursor, "cuisine");
          final int _cursorIndexOfDietaryTags = CursorUtil.getColumnIndexOrThrow(_cursor, "dietaryTags");
          final int _cursorIndexOfIngredients = CursorUtil.getColumnIndexOrThrow(_cursor, "ingredients");
          final int _cursorIndexOfInstructions = CursorUtil.getColumnIndexOrThrow(_cursor, "instructions");
          final int _cursorIndexOfNutritionScore = CursorUtil.getColumnIndexOrThrow(_cursor, "nutritionScore");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorName");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsOffline = CursorUtil.getColumnIndexOrThrow(_cursor, "isOffline");
          final List<Recipe> _result = new ArrayList<Recipe>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Recipe _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final int _tmpCalories;
            _tmpCalories = _cursor.getInt(_cursorIndexOfCalories);
            final double _tmpProtein;
            _tmpProtein = _cursor.getDouble(_cursorIndexOfProtein);
            final double _tmpCarbs;
            _tmpCarbs = _cursor.getDouble(_cursorIndexOfCarbs);
            final double _tmpFat;
            _tmpFat = _cursor.getDouble(_cursorIndexOfFat);
            final double _tmpFiber;
            _tmpFiber = _cursor.getDouble(_cursorIndexOfFiber);
            final double _tmpSugar;
            _tmpSugar = _cursor.getDouble(_cursorIndexOfSugar);
            final double _tmpSodium;
            _tmpSodium = _cursor.getDouble(_cursorIndexOfSodium);
            final int _tmpPrepTime;
            _tmpPrepTime = _cursor.getInt(_cursorIndexOfPrepTime);
            final int _tmpCookTime;
            _tmpCookTime = _cursor.getInt(_cursorIndexOfCookTime);
            final int _tmpServings;
            _tmpServings = _cursor.getInt(_cursorIndexOfServings);
            final String _tmpDifficulty;
            if (_cursor.isNull(_cursorIndexOfDifficulty)) {
              _tmpDifficulty = null;
            } else {
              _tmpDifficulty = _cursor.getString(_cursorIndexOfDifficulty);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpCuisine;
            if (_cursor.isNull(_cursorIndexOfCuisine)) {
              _tmpCuisine = null;
            } else {
              _tmpCuisine = _cursor.getString(_cursorIndexOfCuisine);
            }
            final List<String> _tmpDietaryTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDietaryTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDietaryTags);
            }
            _tmpDietaryTags = __listConverter.toStringList(_tmp);
            final List<Ingredient> _tmpIngredients;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfIngredients)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfIngredients);
            }
            _tmpIngredients = __listConverter.toIngredientList(_tmp_1);
            final List<String> _tmpInstructions;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfInstructions)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfInstructions);
            }
            _tmpInstructions = __listConverter.toStringList(_tmp_2);
            final double _tmpNutritionScore;
            _tmpNutritionScore = _cursor.getDouble(_cursorIndexOfNutritionScore);
            final String _tmpAuthorId;
            if (_cursor.isNull(_cursorIndexOfAuthorId)) {
              _tmpAuthorId = null;
            } else {
              _tmpAuthorId = _cursor.getString(_cursorIndexOfAuthorId);
            }
            final String _tmpAuthorName;
            if (_cursor.isNull(_cursorIndexOfAuthorName)) {
              _tmpAuthorName = null;
            } else {
              _tmpAuthorName = _cursor.getString(_cursorIndexOfAuthorName);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final boolean _tmpIsFavorite;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_3 != 0;
            final boolean _tmpIsOffline;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsOffline);
            _tmpIsOffline = _tmp_4 != 0;
            _item = new Recipe(_tmpId,_tmpTitle,_tmpDescription,_tmpImageUrl,_tmpCalories,_tmpProtein,_tmpCarbs,_tmpFat,_tmpFiber,_tmpSugar,_tmpSodium,_tmpPrepTime,_tmpCookTime,_tmpServings,_tmpDifficulty,_tmpCategory,_tmpCuisine,_tmpDietaryTags,_tmpIngredients,_tmpInstructions,_tmpNutritionScore,_tmpAuthorId,_tmpAuthorName,_tmpCreatedAt,_tmpUpdatedAt,_tmpIsFavorite,_tmpIsOffline);
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
  public Flow<List<Recipe>> getRecipesByMaxCalories(final int maxCalories) {
    final String _sql = "SELECT * FROM recipes WHERE calories <= ? ORDER BY calories ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, maxCalories);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"recipes"}, new Callable<List<Recipe>>() {
      @Override
      @NonNull
      public List<Recipe> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "protein");
          final int _cursorIndexOfCarbs = CursorUtil.getColumnIndexOrThrow(_cursor, "carbs");
          final int _cursorIndexOfFat = CursorUtil.getColumnIndexOrThrow(_cursor, "fat");
          final int _cursorIndexOfFiber = CursorUtil.getColumnIndexOrThrow(_cursor, "fiber");
          final int _cursorIndexOfSugar = CursorUtil.getColumnIndexOrThrow(_cursor, "sugar");
          final int _cursorIndexOfSodium = CursorUtil.getColumnIndexOrThrow(_cursor, "sodium");
          final int _cursorIndexOfPrepTime = CursorUtil.getColumnIndexOrThrow(_cursor, "prepTime");
          final int _cursorIndexOfCookTime = CursorUtil.getColumnIndexOrThrow(_cursor, "cookTime");
          final int _cursorIndexOfServings = CursorUtil.getColumnIndexOrThrow(_cursor, "servings");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfCuisine = CursorUtil.getColumnIndexOrThrow(_cursor, "cuisine");
          final int _cursorIndexOfDietaryTags = CursorUtil.getColumnIndexOrThrow(_cursor, "dietaryTags");
          final int _cursorIndexOfIngredients = CursorUtil.getColumnIndexOrThrow(_cursor, "ingredients");
          final int _cursorIndexOfInstructions = CursorUtil.getColumnIndexOrThrow(_cursor, "instructions");
          final int _cursorIndexOfNutritionScore = CursorUtil.getColumnIndexOrThrow(_cursor, "nutritionScore");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorName");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsOffline = CursorUtil.getColumnIndexOrThrow(_cursor, "isOffline");
          final List<Recipe> _result = new ArrayList<Recipe>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Recipe _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final int _tmpCalories;
            _tmpCalories = _cursor.getInt(_cursorIndexOfCalories);
            final double _tmpProtein;
            _tmpProtein = _cursor.getDouble(_cursorIndexOfProtein);
            final double _tmpCarbs;
            _tmpCarbs = _cursor.getDouble(_cursorIndexOfCarbs);
            final double _tmpFat;
            _tmpFat = _cursor.getDouble(_cursorIndexOfFat);
            final double _tmpFiber;
            _tmpFiber = _cursor.getDouble(_cursorIndexOfFiber);
            final double _tmpSugar;
            _tmpSugar = _cursor.getDouble(_cursorIndexOfSugar);
            final double _tmpSodium;
            _tmpSodium = _cursor.getDouble(_cursorIndexOfSodium);
            final int _tmpPrepTime;
            _tmpPrepTime = _cursor.getInt(_cursorIndexOfPrepTime);
            final int _tmpCookTime;
            _tmpCookTime = _cursor.getInt(_cursorIndexOfCookTime);
            final int _tmpServings;
            _tmpServings = _cursor.getInt(_cursorIndexOfServings);
            final String _tmpDifficulty;
            if (_cursor.isNull(_cursorIndexOfDifficulty)) {
              _tmpDifficulty = null;
            } else {
              _tmpDifficulty = _cursor.getString(_cursorIndexOfDifficulty);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpCuisine;
            if (_cursor.isNull(_cursorIndexOfCuisine)) {
              _tmpCuisine = null;
            } else {
              _tmpCuisine = _cursor.getString(_cursorIndexOfCuisine);
            }
            final List<String> _tmpDietaryTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDietaryTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDietaryTags);
            }
            _tmpDietaryTags = __listConverter.toStringList(_tmp);
            final List<Ingredient> _tmpIngredients;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfIngredients)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfIngredients);
            }
            _tmpIngredients = __listConverter.toIngredientList(_tmp_1);
            final List<String> _tmpInstructions;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfInstructions)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfInstructions);
            }
            _tmpInstructions = __listConverter.toStringList(_tmp_2);
            final double _tmpNutritionScore;
            _tmpNutritionScore = _cursor.getDouble(_cursorIndexOfNutritionScore);
            final String _tmpAuthorId;
            if (_cursor.isNull(_cursorIndexOfAuthorId)) {
              _tmpAuthorId = null;
            } else {
              _tmpAuthorId = _cursor.getString(_cursorIndexOfAuthorId);
            }
            final String _tmpAuthorName;
            if (_cursor.isNull(_cursorIndexOfAuthorName)) {
              _tmpAuthorName = null;
            } else {
              _tmpAuthorName = _cursor.getString(_cursorIndexOfAuthorName);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final boolean _tmpIsFavorite;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_3 != 0;
            final boolean _tmpIsOffline;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsOffline);
            _tmpIsOffline = _tmp_4 != 0;
            _item = new Recipe(_tmpId,_tmpTitle,_tmpDescription,_tmpImageUrl,_tmpCalories,_tmpProtein,_tmpCarbs,_tmpFat,_tmpFiber,_tmpSugar,_tmpSodium,_tmpPrepTime,_tmpCookTime,_tmpServings,_tmpDifficulty,_tmpCategory,_tmpCuisine,_tmpDietaryTags,_tmpIngredients,_tmpInstructions,_tmpNutritionScore,_tmpAuthorId,_tmpAuthorName,_tmpCreatedAt,_tmpUpdatedAt,_tmpIsFavorite,_tmpIsOffline);
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
  public Flow<List<Recipe>> getRecipesByMinNutritionScore(final double minScore) {
    final String _sql = "SELECT * FROM recipes WHERE nutritionScore >= ? ORDER BY nutritionScore DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindDouble(_argIndex, minScore);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"recipes"}, new Callable<List<Recipe>>() {
      @Override
      @NonNull
      public List<Recipe> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "protein");
          final int _cursorIndexOfCarbs = CursorUtil.getColumnIndexOrThrow(_cursor, "carbs");
          final int _cursorIndexOfFat = CursorUtil.getColumnIndexOrThrow(_cursor, "fat");
          final int _cursorIndexOfFiber = CursorUtil.getColumnIndexOrThrow(_cursor, "fiber");
          final int _cursorIndexOfSugar = CursorUtil.getColumnIndexOrThrow(_cursor, "sugar");
          final int _cursorIndexOfSodium = CursorUtil.getColumnIndexOrThrow(_cursor, "sodium");
          final int _cursorIndexOfPrepTime = CursorUtil.getColumnIndexOrThrow(_cursor, "prepTime");
          final int _cursorIndexOfCookTime = CursorUtil.getColumnIndexOrThrow(_cursor, "cookTime");
          final int _cursorIndexOfServings = CursorUtil.getColumnIndexOrThrow(_cursor, "servings");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfCuisine = CursorUtil.getColumnIndexOrThrow(_cursor, "cuisine");
          final int _cursorIndexOfDietaryTags = CursorUtil.getColumnIndexOrThrow(_cursor, "dietaryTags");
          final int _cursorIndexOfIngredients = CursorUtil.getColumnIndexOrThrow(_cursor, "ingredients");
          final int _cursorIndexOfInstructions = CursorUtil.getColumnIndexOrThrow(_cursor, "instructions");
          final int _cursorIndexOfNutritionScore = CursorUtil.getColumnIndexOrThrow(_cursor, "nutritionScore");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorName");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsOffline = CursorUtil.getColumnIndexOrThrow(_cursor, "isOffline");
          final List<Recipe> _result = new ArrayList<Recipe>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Recipe _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final int _tmpCalories;
            _tmpCalories = _cursor.getInt(_cursorIndexOfCalories);
            final double _tmpProtein;
            _tmpProtein = _cursor.getDouble(_cursorIndexOfProtein);
            final double _tmpCarbs;
            _tmpCarbs = _cursor.getDouble(_cursorIndexOfCarbs);
            final double _tmpFat;
            _tmpFat = _cursor.getDouble(_cursorIndexOfFat);
            final double _tmpFiber;
            _tmpFiber = _cursor.getDouble(_cursorIndexOfFiber);
            final double _tmpSugar;
            _tmpSugar = _cursor.getDouble(_cursorIndexOfSugar);
            final double _tmpSodium;
            _tmpSodium = _cursor.getDouble(_cursorIndexOfSodium);
            final int _tmpPrepTime;
            _tmpPrepTime = _cursor.getInt(_cursorIndexOfPrepTime);
            final int _tmpCookTime;
            _tmpCookTime = _cursor.getInt(_cursorIndexOfCookTime);
            final int _tmpServings;
            _tmpServings = _cursor.getInt(_cursorIndexOfServings);
            final String _tmpDifficulty;
            if (_cursor.isNull(_cursorIndexOfDifficulty)) {
              _tmpDifficulty = null;
            } else {
              _tmpDifficulty = _cursor.getString(_cursorIndexOfDifficulty);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpCuisine;
            if (_cursor.isNull(_cursorIndexOfCuisine)) {
              _tmpCuisine = null;
            } else {
              _tmpCuisine = _cursor.getString(_cursorIndexOfCuisine);
            }
            final List<String> _tmpDietaryTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDietaryTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDietaryTags);
            }
            _tmpDietaryTags = __listConverter.toStringList(_tmp);
            final List<Ingredient> _tmpIngredients;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfIngredients)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfIngredients);
            }
            _tmpIngredients = __listConverter.toIngredientList(_tmp_1);
            final List<String> _tmpInstructions;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfInstructions)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfInstructions);
            }
            _tmpInstructions = __listConverter.toStringList(_tmp_2);
            final double _tmpNutritionScore;
            _tmpNutritionScore = _cursor.getDouble(_cursorIndexOfNutritionScore);
            final String _tmpAuthorId;
            if (_cursor.isNull(_cursorIndexOfAuthorId)) {
              _tmpAuthorId = null;
            } else {
              _tmpAuthorId = _cursor.getString(_cursorIndexOfAuthorId);
            }
            final String _tmpAuthorName;
            if (_cursor.isNull(_cursorIndexOfAuthorName)) {
              _tmpAuthorName = null;
            } else {
              _tmpAuthorName = _cursor.getString(_cursorIndexOfAuthorName);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final boolean _tmpIsFavorite;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_3 != 0;
            final boolean _tmpIsOffline;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsOffline);
            _tmpIsOffline = _tmp_4 != 0;
            _item = new Recipe(_tmpId,_tmpTitle,_tmpDescription,_tmpImageUrl,_tmpCalories,_tmpProtein,_tmpCarbs,_tmpFat,_tmpFiber,_tmpSugar,_tmpSodium,_tmpPrepTime,_tmpCookTime,_tmpServings,_tmpDifficulty,_tmpCategory,_tmpCuisine,_tmpDietaryTags,_tmpIngredients,_tmpInstructions,_tmpNutritionScore,_tmpAuthorId,_tmpAuthorName,_tmpCreatedAt,_tmpUpdatedAt,_tmpIsFavorite,_tmpIsOffline);
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
  public Flow<List<Recipe>> getFavoriteRecipes() {
    final String _sql = "SELECT * FROM recipes WHERE isFavorite = 1 ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"recipes"}, new Callable<List<Recipe>>() {
      @Override
      @NonNull
      public List<Recipe> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "protein");
          final int _cursorIndexOfCarbs = CursorUtil.getColumnIndexOrThrow(_cursor, "carbs");
          final int _cursorIndexOfFat = CursorUtil.getColumnIndexOrThrow(_cursor, "fat");
          final int _cursorIndexOfFiber = CursorUtil.getColumnIndexOrThrow(_cursor, "fiber");
          final int _cursorIndexOfSugar = CursorUtil.getColumnIndexOrThrow(_cursor, "sugar");
          final int _cursorIndexOfSodium = CursorUtil.getColumnIndexOrThrow(_cursor, "sodium");
          final int _cursorIndexOfPrepTime = CursorUtil.getColumnIndexOrThrow(_cursor, "prepTime");
          final int _cursorIndexOfCookTime = CursorUtil.getColumnIndexOrThrow(_cursor, "cookTime");
          final int _cursorIndexOfServings = CursorUtil.getColumnIndexOrThrow(_cursor, "servings");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfCuisine = CursorUtil.getColumnIndexOrThrow(_cursor, "cuisine");
          final int _cursorIndexOfDietaryTags = CursorUtil.getColumnIndexOrThrow(_cursor, "dietaryTags");
          final int _cursorIndexOfIngredients = CursorUtil.getColumnIndexOrThrow(_cursor, "ingredients");
          final int _cursorIndexOfInstructions = CursorUtil.getColumnIndexOrThrow(_cursor, "instructions");
          final int _cursorIndexOfNutritionScore = CursorUtil.getColumnIndexOrThrow(_cursor, "nutritionScore");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorName");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsOffline = CursorUtil.getColumnIndexOrThrow(_cursor, "isOffline");
          final List<Recipe> _result = new ArrayList<Recipe>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Recipe _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final int _tmpCalories;
            _tmpCalories = _cursor.getInt(_cursorIndexOfCalories);
            final double _tmpProtein;
            _tmpProtein = _cursor.getDouble(_cursorIndexOfProtein);
            final double _tmpCarbs;
            _tmpCarbs = _cursor.getDouble(_cursorIndexOfCarbs);
            final double _tmpFat;
            _tmpFat = _cursor.getDouble(_cursorIndexOfFat);
            final double _tmpFiber;
            _tmpFiber = _cursor.getDouble(_cursorIndexOfFiber);
            final double _tmpSugar;
            _tmpSugar = _cursor.getDouble(_cursorIndexOfSugar);
            final double _tmpSodium;
            _tmpSodium = _cursor.getDouble(_cursorIndexOfSodium);
            final int _tmpPrepTime;
            _tmpPrepTime = _cursor.getInt(_cursorIndexOfPrepTime);
            final int _tmpCookTime;
            _tmpCookTime = _cursor.getInt(_cursorIndexOfCookTime);
            final int _tmpServings;
            _tmpServings = _cursor.getInt(_cursorIndexOfServings);
            final String _tmpDifficulty;
            if (_cursor.isNull(_cursorIndexOfDifficulty)) {
              _tmpDifficulty = null;
            } else {
              _tmpDifficulty = _cursor.getString(_cursorIndexOfDifficulty);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpCuisine;
            if (_cursor.isNull(_cursorIndexOfCuisine)) {
              _tmpCuisine = null;
            } else {
              _tmpCuisine = _cursor.getString(_cursorIndexOfCuisine);
            }
            final List<String> _tmpDietaryTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDietaryTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDietaryTags);
            }
            _tmpDietaryTags = __listConverter.toStringList(_tmp);
            final List<Ingredient> _tmpIngredients;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfIngredients)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfIngredients);
            }
            _tmpIngredients = __listConverter.toIngredientList(_tmp_1);
            final List<String> _tmpInstructions;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfInstructions)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfInstructions);
            }
            _tmpInstructions = __listConverter.toStringList(_tmp_2);
            final double _tmpNutritionScore;
            _tmpNutritionScore = _cursor.getDouble(_cursorIndexOfNutritionScore);
            final String _tmpAuthorId;
            if (_cursor.isNull(_cursorIndexOfAuthorId)) {
              _tmpAuthorId = null;
            } else {
              _tmpAuthorId = _cursor.getString(_cursorIndexOfAuthorId);
            }
            final String _tmpAuthorName;
            if (_cursor.isNull(_cursorIndexOfAuthorName)) {
              _tmpAuthorName = null;
            } else {
              _tmpAuthorName = _cursor.getString(_cursorIndexOfAuthorName);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final boolean _tmpIsFavorite;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_3 != 0;
            final boolean _tmpIsOffline;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsOffline);
            _tmpIsOffline = _tmp_4 != 0;
            _item = new Recipe(_tmpId,_tmpTitle,_tmpDescription,_tmpImageUrl,_tmpCalories,_tmpProtein,_tmpCarbs,_tmpFat,_tmpFiber,_tmpSugar,_tmpSodium,_tmpPrepTime,_tmpCookTime,_tmpServings,_tmpDifficulty,_tmpCategory,_tmpCuisine,_tmpDietaryTags,_tmpIngredients,_tmpInstructions,_tmpNutritionScore,_tmpAuthorId,_tmpAuthorName,_tmpCreatedAt,_tmpUpdatedAt,_tmpIsFavorite,_tmpIsOffline);
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
  public Flow<List<Recipe>> getRecipesByAuthor(final String authorId) {
    final String _sql = "SELECT * FROM recipes WHERE authorId = ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (authorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, authorId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"recipes"}, new Callable<List<Recipe>>() {
      @Override
      @NonNull
      public List<Recipe> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "protein");
          final int _cursorIndexOfCarbs = CursorUtil.getColumnIndexOrThrow(_cursor, "carbs");
          final int _cursorIndexOfFat = CursorUtil.getColumnIndexOrThrow(_cursor, "fat");
          final int _cursorIndexOfFiber = CursorUtil.getColumnIndexOrThrow(_cursor, "fiber");
          final int _cursorIndexOfSugar = CursorUtil.getColumnIndexOrThrow(_cursor, "sugar");
          final int _cursorIndexOfSodium = CursorUtil.getColumnIndexOrThrow(_cursor, "sodium");
          final int _cursorIndexOfPrepTime = CursorUtil.getColumnIndexOrThrow(_cursor, "prepTime");
          final int _cursorIndexOfCookTime = CursorUtil.getColumnIndexOrThrow(_cursor, "cookTime");
          final int _cursorIndexOfServings = CursorUtil.getColumnIndexOrThrow(_cursor, "servings");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfCuisine = CursorUtil.getColumnIndexOrThrow(_cursor, "cuisine");
          final int _cursorIndexOfDietaryTags = CursorUtil.getColumnIndexOrThrow(_cursor, "dietaryTags");
          final int _cursorIndexOfIngredients = CursorUtil.getColumnIndexOrThrow(_cursor, "ingredients");
          final int _cursorIndexOfInstructions = CursorUtil.getColumnIndexOrThrow(_cursor, "instructions");
          final int _cursorIndexOfNutritionScore = CursorUtil.getColumnIndexOrThrow(_cursor, "nutritionScore");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorName");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsOffline = CursorUtil.getColumnIndexOrThrow(_cursor, "isOffline");
          final List<Recipe> _result = new ArrayList<Recipe>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Recipe _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final int _tmpCalories;
            _tmpCalories = _cursor.getInt(_cursorIndexOfCalories);
            final double _tmpProtein;
            _tmpProtein = _cursor.getDouble(_cursorIndexOfProtein);
            final double _tmpCarbs;
            _tmpCarbs = _cursor.getDouble(_cursorIndexOfCarbs);
            final double _tmpFat;
            _tmpFat = _cursor.getDouble(_cursorIndexOfFat);
            final double _tmpFiber;
            _tmpFiber = _cursor.getDouble(_cursorIndexOfFiber);
            final double _tmpSugar;
            _tmpSugar = _cursor.getDouble(_cursorIndexOfSugar);
            final double _tmpSodium;
            _tmpSodium = _cursor.getDouble(_cursorIndexOfSodium);
            final int _tmpPrepTime;
            _tmpPrepTime = _cursor.getInt(_cursorIndexOfPrepTime);
            final int _tmpCookTime;
            _tmpCookTime = _cursor.getInt(_cursorIndexOfCookTime);
            final int _tmpServings;
            _tmpServings = _cursor.getInt(_cursorIndexOfServings);
            final String _tmpDifficulty;
            if (_cursor.isNull(_cursorIndexOfDifficulty)) {
              _tmpDifficulty = null;
            } else {
              _tmpDifficulty = _cursor.getString(_cursorIndexOfDifficulty);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpCuisine;
            if (_cursor.isNull(_cursorIndexOfCuisine)) {
              _tmpCuisine = null;
            } else {
              _tmpCuisine = _cursor.getString(_cursorIndexOfCuisine);
            }
            final List<String> _tmpDietaryTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDietaryTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDietaryTags);
            }
            _tmpDietaryTags = __listConverter.toStringList(_tmp);
            final List<Ingredient> _tmpIngredients;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfIngredients)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfIngredients);
            }
            _tmpIngredients = __listConverter.toIngredientList(_tmp_1);
            final List<String> _tmpInstructions;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfInstructions)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfInstructions);
            }
            _tmpInstructions = __listConverter.toStringList(_tmp_2);
            final double _tmpNutritionScore;
            _tmpNutritionScore = _cursor.getDouble(_cursorIndexOfNutritionScore);
            final String _tmpAuthorId;
            if (_cursor.isNull(_cursorIndexOfAuthorId)) {
              _tmpAuthorId = null;
            } else {
              _tmpAuthorId = _cursor.getString(_cursorIndexOfAuthorId);
            }
            final String _tmpAuthorName;
            if (_cursor.isNull(_cursorIndexOfAuthorName)) {
              _tmpAuthorName = null;
            } else {
              _tmpAuthorName = _cursor.getString(_cursorIndexOfAuthorName);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final boolean _tmpIsFavorite;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_3 != 0;
            final boolean _tmpIsOffline;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsOffline);
            _tmpIsOffline = _tmp_4 != 0;
            _item = new Recipe(_tmpId,_tmpTitle,_tmpDescription,_tmpImageUrl,_tmpCalories,_tmpProtein,_tmpCarbs,_tmpFat,_tmpFiber,_tmpSugar,_tmpSodium,_tmpPrepTime,_tmpCookTime,_tmpServings,_tmpDifficulty,_tmpCategory,_tmpCuisine,_tmpDietaryTags,_tmpIngredients,_tmpInstructions,_tmpNutritionScore,_tmpAuthorId,_tmpAuthorName,_tmpCreatedAt,_tmpUpdatedAt,_tmpIsFavorite,_tmpIsOffline);
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
  public Flow<List<Recipe>> filterRecipes(final String query, final String category,
      final String cuisine, final String difficulty, final Integer maxCalories,
      final String sortBy) {
    final String _sql = "\n"
            + "        SELECT * FROM recipes \n"
            + "        WHERE (title LIKE '%' || ? || '%' OR description LIKE '%' || ? || '%')\n"
            + "        AND (? IS NULL OR category = ?)\n"
            + "        AND (? IS NULL OR cuisine = ?)\n"
            + "        AND (? IS NULL OR difficulty = ?)\n"
            + "        AND (? IS NULL OR calories <= ?)\n"
            + "        ORDER BY \n"
            + "            CASE WHEN ? = 'NEWEST' THEN createdAt END DESC,\n"
            + "            CASE WHEN ? = 'OLDEST' THEN createdAt END ASC,\n"
            + "            CASE WHEN ? = 'CALORIES_LOW' THEN calories END ASC,\n"
            + "            CASE WHEN ? = 'CALORIES_HIGH' THEN calories END DESC,\n"
            + "            CASE WHEN ? = 'NUTRITION_SCORE' THEN nutritionScore END DESC,\n"
            + "            CASE WHEN ? = 'PREP_TIME' THEN (prepTime + cookTime) END ASC\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 16);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 3;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    _argIndex = 4;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    _argIndex = 5;
    if (cuisine == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, cuisine);
    }
    _argIndex = 6;
    if (cuisine == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, cuisine);
    }
    _argIndex = 7;
    if (difficulty == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, difficulty);
    }
    _argIndex = 8;
    if (difficulty == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, difficulty);
    }
    _argIndex = 9;
    if (maxCalories == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, maxCalories);
    }
    _argIndex = 10;
    if (maxCalories == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, maxCalories);
    }
    _argIndex = 11;
    if (sortBy == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sortBy);
    }
    _argIndex = 12;
    if (sortBy == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sortBy);
    }
    _argIndex = 13;
    if (sortBy == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sortBy);
    }
    _argIndex = 14;
    if (sortBy == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sortBy);
    }
    _argIndex = 15;
    if (sortBy == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sortBy);
    }
    _argIndex = 16;
    if (sortBy == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sortBy);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"recipes"}, new Callable<List<Recipe>>() {
      @Override
      @NonNull
      public List<Recipe> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "protein");
          final int _cursorIndexOfCarbs = CursorUtil.getColumnIndexOrThrow(_cursor, "carbs");
          final int _cursorIndexOfFat = CursorUtil.getColumnIndexOrThrow(_cursor, "fat");
          final int _cursorIndexOfFiber = CursorUtil.getColumnIndexOrThrow(_cursor, "fiber");
          final int _cursorIndexOfSugar = CursorUtil.getColumnIndexOrThrow(_cursor, "sugar");
          final int _cursorIndexOfSodium = CursorUtil.getColumnIndexOrThrow(_cursor, "sodium");
          final int _cursorIndexOfPrepTime = CursorUtil.getColumnIndexOrThrow(_cursor, "prepTime");
          final int _cursorIndexOfCookTime = CursorUtil.getColumnIndexOrThrow(_cursor, "cookTime");
          final int _cursorIndexOfServings = CursorUtil.getColumnIndexOrThrow(_cursor, "servings");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfCuisine = CursorUtil.getColumnIndexOrThrow(_cursor, "cuisine");
          final int _cursorIndexOfDietaryTags = CursorUtil.getColumnIndexOrThrow(_cursor, "dietaryTags");
          final int _cursorIndexOfIngredients = CursorUtil.getColumnIndexOrThrow(_cursor, "ingredients");
          final int _cursorIndexOfInstructions = CursorUtil.getColumnIndexOrThrow(_cursor, "instructions");
          final int _cursorIndexOfNutritionScore = CursorUtil.getColumnIndexOrThrow(_cursor, "nutritionScore");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorName");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsOffline = CursorUtil.getColumnIndexOrThrow(_cursor, "isOffline");
          final List<Recipe> _result = new ArrayList<Recipe>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Recipe _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final int _tmpCalories;
            _tmpCalories = _cursor.getInt(_cursorIndexOfCalories);
            final double _tmpProtein;
            _tmpProtein = _cursor.getDouble(_cursorIndexOfProtein);
            final double _tmpCarbs;
            _tmpCarbs = _cursor.getDouble(_cursorIndexOfCarbs);
            final double _tmpFat;
            _tmpFat = _cursor.getDouble(_cursorIndexOfFat);
            final double _tmpFiber;
            _tmpFiber = _cursor.getDouble(_cursorIndexOfFiber);
            final double _tmpSugar;
            _tmpSugar = _cursor.getDouble(_cursorIndexOfSugar);
            final double _tmpSodium;
            _tmpSodium = _cursor.getDouble(_cursorIndexOfSodium);
            final int _tmpPrepTime;
            _tmpPrepTime = _cursor.getInt(_cursorIndexOfPrepTime);
            final int _tmpCookTime;
            _tmpCookTime = _cursor.getInt(_cursorIndexOfCookTime);
            final int _tmpServings;
            _tmpServings = _cursor.getInt(_cursorIndexOfServings);
            final String _tmpDifficulty;
            if (_cursor.isNull(_cursorIndexOfDifficulty)) {
              _tmpDifficulty = null;
            } else {
              _tmpDifficulty = _cursor.getString(_cursorIndexOfDifficulty);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpCuisine;
            if (_cursor.isNull(_cursorIndexOfCuisine)) {
              _tmpCuisine = null;
            } else {
              _tmpCuisine = _cursor.getString(_cursorIndexOfCuisine);
            }
            final List<String> _tmpDietaryTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDietaryTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDietaryTags);
            }
            _tmpDietaryTags = __listConverter.toStringList(_tmp);
            final List<Ingredient> _tmpIngredients;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfIngredients)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfIngredients);
            }
            _tmpIngredients = __listConverter.toIngredientList(_tmp_1);
            final List<String> _tmpInstructions;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfInstructions)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfInstructions);
            }
            _tmpInstructions = __listConverter.toStringList(_tmp_2);
            final double _tmpNutritionScore;
            _tmpNutritionScore = _cursor.getDouble(_cursorIndexOfNutritionScore);
            final String _tmpAuthorId;
            if (_cursor.isNull(_cursorIndexOfAuthorId)) {
              _tmpAuthorId = null;
            } else {
              _tmpAuthorId = _cursor.getString(_cursorIndexOfAuthorId);
            }
            final String _tmpAuthorName;
            if (_cursor.isNull(_cursorIndexOfAuthorName)) {
              _tmpAuthorName = null;
            } else {
              _tmpAuthorName = _cursor.getString(_cursorIndexOfAuthorName);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final boolean _tmpIsFavorite;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_3 != 0;
            final boolean _tmpIsOffline;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsOffline);
            _tmpIsOffline = _tmp_4 != 0;
            _item = new Recipe(_tmpId,_tmpTitle,_tmpDescription,_tmpImageUrl,_tmpCalories,_tmpProtein,_tmpCarbs,_tmpFat,_tmpFiber,_tmpSugar,_tmpSodium,_tmpPrepTime,_tmpCookTime,_tmpServings,_tmpDifficulty,_tmpCategory,_tmpCuisine,_tmpDietaryTags,_tmpIngredients,_tmpInstructions,_tmpNutritionScore,_tmpAuthorId,_tmpAuthorName,_tmpCreatedAt,_tmpUpdatedAt,_tmpIsFavorite,_tmpIsOffline);
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
  public Object getRecipeCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM recipes";
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
  public Object getRecipeCountByCategory(final String category,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM recipes WHERE category = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
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
  public Object getAverageCalories(final Continuation<? super Double> $completion) {
    final String _sql = "SELECT AVG(calories) FROM recipes";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Double>() {
      @Override
      @Nullable
      public Double call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Double _result;
          if (_cursor.moveToFirst()) {
            final Double _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getDouble(0);
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
  public Object getAverageNutritionScore(final Continuation<? super Double> $completion) {
    final String _sql = "SELECT AVG(nutritionScore) FROM recipes";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Double>() {
      @Override
      @Nullable
      public Double call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Double _result;
          if (_cursor.moveToFirst()) {
            final Double _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getDouble(0);
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
  public Object getOfflineRecipes(final Continuation<? super List<Recipe>> $completion) {
    final String _sql = "SELECT * FROM recipes WHERE isOffline = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Recipe>>() {
      @Override
      @NonNull
      public List<Recipe> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "protein");
          final int _cursorIndexOfCarbs = CursorUtil.getColumnIndexOrThrow(_cursor, "carbs");
          final int _cursorIndexOfFat = CursorUtil.getColumnIndexOrThrow(_cursor, "fat");
          final int _cursorIndexOfFiber = CursorUtil.getColumnIndexOrThrow(_cursor, "fiber");
          final int _cursorIndexOfSugar = CursorUtil.getColumnIndexOrThrow(_cursor, "sugar");
          final int _cursorIndexOfSodium = CursorUtil.getColumnIndexOrThrow(_cursor, "sodium");
          final int _cursorIndexOfPrepTime = CursorUtil.getColumnIndexOrThrow(_cursor, "prepTime");
          final int _cursorIndexOfCookTime = CursorUtil.getColumnIndexOrThrow(_cursor, "cookTime");
          final int _cursorIndexOfServings = CursorUtil.getColumnIndexOrThrow(_cursor, "servings");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfCuisine = CursorUtil.getColumnIndexOrThrow(_cursor, "cuisine");
          final int _cursorIndexOfDietaryTags = CursorUtil.getColumnIndexOrThrow(_cursor, "dietaryTags");
          final int _cursorIndexOfIngredients = CursorUtil.getColumnIndexOrThrow(_cursor, "ingredients");
          final int _cursorIndexOfInstructions = CursorUtil.getColumnIndexOrThrow(_cursor, "instructions");
          final int _cursorIndexOfNutritionScore = CursorUtil.getColumnIndexOrThrow(_cursor, "nutritionScore");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorName");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsOffline = CursorUtil.getColumnIndexOrThrow(_cursor, "isOffline");
          final List<Recipe> _result = new ArrayList<Recipe>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Recipe _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final int _tmpCalories;
            _tmpCalories = _cursor.getInt(_cursorIndexOfCalories);
            final double _tmpProtein;
            _tmpProtein = _cursor.getDouble(_cursorIndexOfProtein);
            final double _tmpCarbs;
            _tmpCarbs = _cursor.getDouble(_cursorIndexOfCarbs);
            final double _tmpFat;
            _tmpFat = _cursor.getDouble(_cursorIndexOfFat);
            final double _tmpFiber;
            _tmpFiber = _cursor.getDouble(_cursorIndexOfFiber);
            final double _tmpSugar;
            _tmpSugar = _cursor.getDouble(_cursorIndexOfSugar);
            final double _tmpSodium;
            _tmpSodium = _cursor.getDouble(_cursorIndexOfSodium);
            final int _tmpPrepTime;
            _tmpPrepTime = _cursor.getInt(_cursorIndexOfPrepTime);
            final int _tmpCookTime;
            _tmpCookTime = _cursor.getInt(_cursorIndexOfCookTime);
            final int _tmpServings;
            _tmpServings = _cursor.getInt(_cursorIndexOfServings);
            final String _tmpDifficulty;
            if (_cursor.isNull(_cursorIndexOfDifficulty)) {
              _tmpDifficulty = null;
            } else {
              _tmpDifficulty = _cursor.getString(_cursorIndexOfDifficulty);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpCuisine;
            if (_cursor.isNull(_cursorIndexOfCuisine)) {
              _tmpCuisine = null;
            } else {
              _tmpCuisine = _cursor.getString(_cursorIndexOfCuisine);
            }
            final List<String> _tmpDietaryTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDietaryTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDietaryTags);
            }
            _tmpDietaryTags = __listConverter.toStringList(_tmp);
            final List<Ingredient> _tmpIngredients;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfIngredients)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfIngredients);
            }
            _tmpIngredients = __listConverter.toIngredientList(_tmp_1);
            final List<String> _tmpInstructions;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfInstructions)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfInstructions);
            }
            _tmpInstructions = __listConverter.toStringList(_tmp_2);
            final double _tmpNutritionScore;
            _tmpNutritionScore = _cursor.getDouble(_cursorIndexOfNutritionScore);
            final String _tmpAuthorId;
            if (_cursor.isNull(_cursorIndexOfAuthorId)) {
              _tmpAuthorId = null;
            } else {
              _tmpAuthorId = _cursor.getString(_cursorIndexOfAuthorId);
            }
            final String _tmpAuthorName;
            if (_cursor.isNull(_cursorIndexOfAuthorName)) {
              _tmpAuthorName = null;
            } else {
              _tmpAuthorName = _cursor.getString(_cursorIndexOfAuthorName);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final boolean _tmpIsFavorite;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_3 != 0;
            final boolean _tmpIsOffline;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsOffline);
            _tmpIsOffline = _tmp_4 != 0;
            _item = new Recipe(_tmpId,_tmpTitle,_tmpDescription,_tmpImageUrl,_tmpCalories,_tmpProtein,_tmpCarbs,_tmpFat,_tmpFiber,_tmpSugar,_tmpSodium,_tmpPrepTime,_tmpCookTime,_tmpServings,_tmpDifficulty,_tmpCategory,_tmpCuisine,_tmpDietaryTags,_tmpIngredients,_tmpInstructions,_tmpNutritionScore,_tmpAuthorId,_tmpAuthorName,_tmpCreatedAt,_tmpUpdatedAt,_tmpIsFavorite,_tmpIsOffline);
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
  public Flow<List<Review>> getReviewsForRecipe(final String recipeId) {
    final String _sql = "SELECT * FROM reviews WHERE recipeId = ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (recipeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, recipeId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"reviews"}, new Callable<List<Review>>() {
      @Override
      @NonNull
      public List<Review> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfRecipeId = CursorUtil.getColumnIndexOrThrow(_cursor, "recipeId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "userName");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Review> _result = new ArrayList<Review>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Review _item;
            final String _tmpRecipeId;
            if (_cursor.isNull(_cursorIndexOfRecipeId)) {
              _tmpRecipeId = null;
            } else {
              _tmpRecipeId = _cursor.getString(_cursorIndexOfRecipeId);
            }
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final String _tmpUserName;
            if (_cursor.isNull(_cursorIndexOfUserName)) {
              _tmpUserName = null;
            } else {
              _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
            }
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final String _tmpComment;
            if (_cursor.isNull(_cursorIndexOfComment)) {
              _tmpComment = null;
            } else {
              _tmpComment = _cursor.getString(_cursorIndexOfComment);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new Review(_tmpRecipeId,_tmpUserId,_tmpUserName,_tmpRating,_tmpComment,_tmpCreatedAt);
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
  public Object getAverageRatingForRecipe(final String recipeId,
      final Continuation<? super Float> $completion) {
    final String _sql = "SELECT AVG(rating) FROM reviews WHERE recipeId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (recipeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, recipeId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Float>() {
      @Override
      @Nullable
      public Float call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Float _result;
          if (_cursor.moveToFirst()) {
            final Float _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getFloat(0);
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
  public Object getReviewCountForRecipe(final String recipeId,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM reviews WHERE recipeId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (recipeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, recipeId);
    }
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
