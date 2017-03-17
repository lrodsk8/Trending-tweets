package luisrodriguez.trendingtweets.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * Created by Luis Rodriguez on 3/13/2017.
 */

public class Entities {

    @SerializedName("urls")
    @Expose
    public List<Object> urls = null;
    @SerializedName("hashtags")
    @Expose
    public List<Hashtag> hashtags = null;
    @SerializedName("user_mentions")
    @Expose
    public List<Object> userMentions = null;
}
