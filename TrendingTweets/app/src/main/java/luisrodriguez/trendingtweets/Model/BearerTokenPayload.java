package luisrodriguez.trendingtweets.Model;

/**
 * Created by Luis Rodriguez on 3/13/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BearerTokenPayload {

    @SerializedName("token_type")
    @Expose
    public String tokenType;
    @SerializedName("access_token")
    @Expose
    public String accessToken;

}