package luisrodriguez.trendingtweets.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by Luis Rodriguez on 3/13/2017.
 */

public class Status {

    @SerializedName("coordinates")
    @Expose
    public Object coordinates;
    @SerializedName("favorited")
    @Expose
    public Boolean favorited;
    @SerializedName("truncated")
    @Expose
    public Boolean truncated;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("id_str")
    @Expose
    public String idStr;
    @SerializedName("entities")
    @Expose
    public Entities entities;
    @SerializedName("in_reply_to_user_id_str")
    @Expose
    public Object inReplyToUserIdStr;
    @SerializedName("contributors")
    @Expose
    public Object contributors;
    @SerializedName("text")
    @Expose
    public String text;
    @SerializedName("metadata")
    @Expose
    public Metadata metadata;
    @SerializedName("retweet_count")
    @Expose
    public Integer retweetCount;
    @SerializedName("in_reply_to_status_id_str")
    @Expose
    public Object inReplyToStatusIdStr;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("geo")
    @Expose
    public Object geo;
    @SerializedName("retweeted")
    @Expose
    public Boolean retweeted;
    @SerializedName("in_reply_to_user_id")
    @Expose
    public Object inReplyToUserId;
    @SerializedName("place")
    @Expose
    public Object place;
    @SerializedName("user")
    @Expose
    public User user;
    @SerializedName("in_reply_to_screen_name")
    @Expose
    public Object inReplyToScreenName;
    @SerializedName("source")
    @Expose
    public String source;
    @SerializedName("in_reply_to_status_id")
    @Expose
    public Object inReplyToStatusId;
}
