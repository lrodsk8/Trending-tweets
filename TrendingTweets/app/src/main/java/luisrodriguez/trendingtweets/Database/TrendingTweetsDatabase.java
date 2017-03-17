package luisrodriguez.trendingtweets.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Luis.Rodriguez on 3/15/2017.
 * Database creation handling.
 */

public class TrendingTweetsDatabase extends SQLiteOpenHelper {

    private static final String TAG = TrendingTweetsDatabaseManager.class.getSimpleName();
    private static final int DATABASE_VERSION = 1;
    protected static final String DATABASE_NAME = "TrendingTweetsDatabase";
    protected static final String TRENDING_TWEETS_TABLE = "TrendingTweetsTable";
    protected static final String COL_SEARCH_ITEM= "SearchItem";
    protected static final String COL_SEARCH_RESULTS = "SearchResults";



    public TrendingTweetsDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS "
                + TRENDING_TWEETS_TABLE + " ( "
                + COL_SEARCH_ITEM + " TEXT NOT NULL , "
                + COL_SEARCH_RESULTS + " TEXT NOT NULL ) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "#onUpgrade, oldVersion = " + oldVersion + " newVersion = " + newVersion
                + " - dropping old tables");
        db.execSQL("DROP TABLE IF EXISTS " + TRENDING_TWEETS_TABLE);
        onCreate(db);
    }
}
