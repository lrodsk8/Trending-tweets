package luisrodriguez.trendingtweets.Remote;

import luisrodriguez.trendingtweets.Model.BearerTokenPayload;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

/**
 * This interface handles the initial Bearer token creation to be used in subsequent calls.
 * Created by Luis Rodriguez on 3/13/2017.
 */

public interface BearerTokenService {

    String BEARER_URL = "https://api.twitter.com/oauth2/";
    String CONTENT_TYPE = "application/x-www-form-urlencoded;charset=UTF-8";
    String CLIENT_CREDENTIALS = "grant_type=client_credentials";

    @POST("token/")
    Observable<BearerTokenPayload> getBearerToken(@Header("Authorization") String authorization,
                                              @Header("Content-Type") String content_type,
                                              @Body String clientCredentials);


}
