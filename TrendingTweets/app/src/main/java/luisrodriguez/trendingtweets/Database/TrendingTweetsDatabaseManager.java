package luisrodriguez.trendingtweets.Database;

import android.database.sqlite.SQLiteDatabase;

/**
 * Singleton Instance of the database.
 * Created by Luis.Rodriguez on 3/15/2017.
 */
public class TrendingTweetsDatabaseManager {

    private static TrendingTweetsDatabaseManager sInstance;
    private static TrendingTweetsDatabase sTrendingTweetsHelper;
    private SQLiteDatabase mDatabase;
    private int mOpenCounter;

    public static synchronized TrendingTweetsDatabaseManager getInstance()
            throws IllegalStateException {

        if (sInstance == null) {
            throw new IllegalStateException(TrendingTweetsDatabaseManager.class.getSimpleName()
                    + " is not initialized, call initializeInstance(..) method first.");
        }
        return sInstance;
    }

    /**
     * Initializes the db instance.
     * @param helper the TrendingTweetsDatabase
     */
    public static synchronized void initializeInstance(TrendingTweetsDatabase helper) {
        if (sInstance == null) {
            sInstance = new TrendingTweetsDatabaseManager();
            sTrendingTweetsHelper = helper;
        }
    }

    /**
     * Helper method to close database.
     */
    public synchronized void closeDatabase() {

        mOpenCounter--;
        if (mOpenCounter == 0) {
            // Closing database
            mDatabase.close();
        }
    }

    /**
     * Helper method to open database
     * @return
     */
    public synchronized SQLiteDatabase openDatabase() {
        mOpenCounter++;
        if (mOpenCounter == 1) {
            mDatabase = sTrendingTweetsHelper.getWritableDatabase();
        }
        return mDatabase;
    }
}
