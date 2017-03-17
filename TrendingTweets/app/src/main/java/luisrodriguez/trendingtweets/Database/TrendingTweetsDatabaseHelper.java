package luisrodriguez.trendingtweets.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import luisrodriguez.trendingtweets.Model.SearchItem;
import luisrodriguez.trendingtweets.Model.User;
import luisrodriguez.trendingtweets.databinding.SearchItemBinding;

import static luisrodriguez.trendingtweets.Database.TrendingTweetsDatabase.COL_SEARCH_ITEM;
import static luisrodriguez.trendingtweets.Database.TrendingTweetsDatabase.COL_SEARCH_RESULTS;
import static luisrodriguez.trendingtweets.Database.TrendingTweetsDatabase.TRENDING_TWEETS_TABLE;

/**
 * Created by Luis.Rodriguez on 3/15/2017.
 * Database method implementation.
 */
public class TrendingTweetsDatabaseHelper {

    private static final String TAG =  TrendingTweetsDatabaseHelper.class.getSimpleName();
    private static final String[] ALL_COLUMNS = new String[]{COL_SEARCH_ITEM, COL_SEARCH_RESULTS};

    private static final String SELECT_COUNT_FROM = "SELECT count(*) FROM ";
    private static final String SELECT_ALL_FROM = "SELECT * FROM ";


    /**
     * Simplified insertion implementation to database.
     * @param searchItem   the search Item
     * @return a long value.
     */
    public static long insertSearchItem(SearchItem searchItem) {
        try {
            Log.v(TAG, "#insert: " + searchItem.toString());

            ContentValues cv = new ContentValues();
            cv.put(COL_SEARCH_ITEM, searchItem.searchName);

            Gson gson = new Gson();
            if(searchItem.searchResults != null){
                String searchResultsJson = gson.toJson(searchItem.searchResults);
                cv.put(COL_SEARCH_RESULTS, searchResultsJson);
            }

            return TrendingTweetsDatabaseManager
                    .getInstance()
                    .openDatabase()
                    .insertWithOnConflict(TRENDING_TWEETS_TABLE, null, cv,
                            SQLiteDatabase.CONFLICT_REPLACE);

        } catch (SQLException | NullPointerException | IllegalStateException e) {
            Log.e(TAG, "Caught: " + e.getMessage(), e);
            return -1;
        } finally {
            TrendingTweetsDatabaseManager.getInstance().closeDatabase();
        }
    }

    /**
     * Helper method that simplifies removal.
     * @return an int number
     */
    public static int removeAllSearchItems() {
        int rows = 0;
        try {
            rows = TrendingTweetsDatabaseManager.getInstance().openDatabase()
                    .delete(TRENDING_TWEETS_TABLE, "1", null);
        } catch (SQLException | NullPointerException | IllegalStateException e) {
            Log.e(TAG, "Caught: " + e.getMessage(), e);
        } finally {
            TrendingTweetsDatabaseManager.getInstance().closeDatabase();
        }
        Log.v(TAG, "#deleteAll() - deleted " + rows + " rows.");
        return rows;
    }

    /**
     * Helper method to simplify testing
     * @return true if is empty, false otherwise.
     */
    public static boolean isTrendingTweetsDatabaseEmpty() {
        boolean empty;

        Cursor cursor = null;
        try {
            cursor = TrendingTweetsDatabaseManager.getInstance().openDatabase()
                    .rawQuery(SELECT_COUNT_FROM + TRENDING_TWEETS_TABLE, null);

            empty = !(cursor != null && cursor.moveToFirst()) || cursor.getInt(0) == 0;

        } catch (SQLException | NullPointerException | IllegalStateException e) {
            Log.e(TAG, "Caught: " + e.getMessage(), e);
            empty = true;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            TrendingTweetsDatabaseManager.getInstance().closeDatabase();
        }
        Log.v(TAG, "isEmpty returning " + empty);
        return empty;
    }

    /**
     * Helper method to get every searchItem from the database.
     * @return a list of search items.
     */
    public static List<SearchItem> getAllSearchItems() {

        List<SearchItem> currentOperations = new ArrayList<>();
        Cursor cursor = null;

        try {
            cursor = TrendingTweetsDatabaseManager.getInstance().openDatabase()
                    .query(TRENDING_TWEETS_TABLE, ALL_COLUMNS, null, null, null, null, null);

            if (cursor != null && cursor.moveToFirst()) {

                do {
                    SearchItem operation = extractFromCursor(cursor);
                    if (operation != null) {
                        currentOperations.add(operation);
                    }
                } while (cursor.moveToNext());
            }

        } catch (SQLException | NullPointerException | IllegalStateException e) {
            Log.e(TAG, "Caught: " + e.getMessage(), e);
        } finally {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e) {
                    // Ignore close exceptions
                }
            }
            TrendingTweetsDatabaseManager.getInstance().closeDatabase();
        }
        return currentOperations;
    }

    /**
     * Helper method that uses the Cursor for database editing.
     * @param c the Cursor.
     * @return the SearchItem
     */
    private static SearchItem extractFromCursor(Cursor c) {

        if (c == null) {
            Log.e(TAG, "extractFromCursor - cursor is null.");
            return null;
        }

        String name = c.getString(c.getColumnIndexOrThrow(COL_SEARCH_ITEM));
        String resultsJson = c.getString(c.getColumnIndexOrThrow(COL_SEARCH_RESULTS));

        Gson gson = new Gson();
        List<User> users = gson.fromJson(resultsJson, ArrayList.class);
        return new SearchItem(name, users);
    }
}
