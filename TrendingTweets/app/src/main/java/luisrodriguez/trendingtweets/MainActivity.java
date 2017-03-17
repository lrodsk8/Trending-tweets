package luisrodriguez.trendingtweets;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import luisrodriguez.trendingtweets.Remote.BearerTokenService;
import luisrodriguez.trendingtweets.Remote.RetrofitHelper;
import luisrodriguez.trendingtweets.ViewModel.MainViewModel;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 *
 * This is the initial class that loads, handling the bearer token call to the Twitter API.
 * Created by Luis.Rodriguez on 3/14/2017.
 */
public class MainActivity extends FragmentActivity {

    private final String TAG = MainActivity.class.getSimpleName();
    private BearerTokenService mBearerTokenService;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadTwitterBearerToken();
        addSearchTweetFragment();
    }

    /**
     * Fragment addition.
     */
    private void addSearchTweetFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new MainViewModel())
                .commit();
    }


    /**
     * Handles the initial Bearer token call to the Twitter API.
     */
    private void loadTwitterBearerToken() {
        SharedPreferences prefs = getSharedPreferences(Utils.PREFS_APP_NAME, MODE_PRIVATE);
        String bearerToken = prefs.getString(Utils.BEARER_TOKEN, null);
        if (bearerToken == null) {
            mBearerTokenService = RetrofitHelper.getBearerToken();
            mBearerTokenService.getBearerToken(TwitterTokens.getEncodedKeys(), BearerTokenService.CONTENT_TYPE,
                    BearerTokenService.CLIENT_CREDENTIALS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(payload -> {
                        saveToken(payload.accessToken);
                        //loadTwitterBearerToken();
                    });
        }
    }

    /**
     * Save the Token to be used to call on every search
     *
     * @param token
     */
    private void saveToken(String token) {
        SharedPreferences.Editor editor = getSharedPreferences(Utils.PREFS_APP_NAME, MODE_PRIVATE).edit();
        editor.putString(Utils.BEARER_TOKEN, token);
        editor.apply();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
