package luisrodriguez.trendingtweets.Remote;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This class handles the http legwork and returns it.
 * Created by Luis Rodriguez on 3/13/2017.
 */
public class RetrofitHelper {

    /**
     * returns the service to get the popular users back.
     * @return   The TwitterService to make the searches
     */
    public static TwitterService getTwitterSearch() {
        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(TwitterService.SEARCH_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return restAdapter.create(TwitterService.class);
    }

    /**
     * Returns the service to get the bearer token.
     * @return   The bearerTokenService
     */
    public static BearerTokenService getBearerToken() {
        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(BearerTokenService.BEARER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return restAdapter.create(BearerTokenService.class);
    }
}
