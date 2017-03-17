package luisrodriguez.trendingtweets;

import android.app.Application;
import android.content.Context;

import luisrodriguez.trendingtweets.Database.TrendingTweetsDatabase;
import luisrodriguez.trendingtweets.Database.TrendingTweetsDatabaseManager;

/**
 * Handles the Application instance & Database creation.
 * Created by Luis.Rodriguez on 3/14/2017.
 */
public class TrendingTweetsApplication extends Application {

    private static final String TAG = TrendingTweetsApplication.class.getSimpleName();
    private static Context sContext;
    private static TrendingTweetsApplication sInstance;

    public TrendingTweetsApplication() {
    }

    public static Context getAppContext() {
        return sContext;
    }

    private static void setContext(Context context) {
        TrendingTweetsApplication.sContext = context;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        TrendingTweetsApplication.setContext(getApplicationContext());
        //TODO Uncomment, test the Database creation and integrity
       // TrendingTweetsDatabaseManager.initializeInstance(new TrendingTweetsDatabase(sContext));
        sInstance = this;
    }

}