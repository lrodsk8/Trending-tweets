package luisrodriguez.trendingtweets.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by Luis Rodriguez on 3/13/2017.
 */

public class SearchMetadata {

    @SerializedName("max_id")
    @Expose
    public Integer maxId;
    @SerializedName("since_id")
    @Expose
    public Integer sinceId;
    @SerializedName("refresh_url")
    @Expose
    public String refreshUrl;
    @SerializedName("next_results")
    @Expose
    public String nextResults;
    @SerializedName("count")
    @Expose
    public Integer count;
    @SerializedName("completed_in")
    @Expose
    public Double completedIn;
    @SerializedName("since_id_str")
    @Expose
    public String sinceIdStr;
    @SerializedName("query")
    @Expose
    public String query;
    @SerializedName("max_id_str")
    @Expose
    public String maxIdStr;
}
