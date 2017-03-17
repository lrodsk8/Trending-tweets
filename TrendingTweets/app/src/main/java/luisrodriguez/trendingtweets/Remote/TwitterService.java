package luisrodriguez.trendingtweets.Remote;


import luisrodriguez.trendingtweets.Model.ResponseStructure;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * This class handles the subsequent calls to the Twitter API once we have the Bearer token.
 * Created by Luis Rodriguez on 3/14/2017.
 */
public interface TwitterService {

    String SEARCH_URL = "https://api.twitter.com/1.1/search/tweets.json";

    // ?q=%23 + "whateverUserTyped" + "&count=10&result_type=popular"
    @GET("?q=%23{search}")
    Observable<ResponseStructure> searchHashTag(@Path("search") String hashtag,
                                                      @Query("count") int count,
                                                      @Query("result_type") String result_type);
}

