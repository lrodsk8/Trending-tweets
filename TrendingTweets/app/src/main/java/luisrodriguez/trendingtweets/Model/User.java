package luisrodriguez.trendingtweets.Model;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * Created by Luis Rodriguez on 3/13/2017.
 */

public class User {


    @SerializedName("profile_sidebar_fill_color")
    @Expose
    public String profileSidebarFillColor;
    @SerializedName("profile_sidebar_border_color")
    @Expose
    public String profileSidebarBorderColor;
    @SerializedName("profile_background_tile")
    @Expose
    public Boolean profileBackgroundTile;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("profile_image_url")
    @Expose
    public String profileImageUrl;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("location")
    @Expose
    public String location;
    @SerializedName("follow_request_sent")
    @Expose
    public Object followRequestSent;
    @SerializedName("profile_link_color")
    @Expose
    public String profileLinkColor;
    @SerializedName("is_translator")
    @Expose
    public Boolean isTranslator;
    @SerializedName("id_str")
    @Expose
    public String idStr;
    @SerializedName("entities")
    @Expose
    public Entities_ entities;
    @SerializedName("default_profile")
    @Expose
    public Boolean defaultProfile;
    @SerializedName("contributors_enabled")
    @Expose
    public Boolean contributorsEnabled;
    @SerializedName("favourites_count")
    @Expose
    public Integer favouritesCount;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("profile_image_url_https")
    @Expose
    public String profileImageUrlHttps;
    @SerializedName("utc_offset")
    @Expose
    public Integer utcOffset;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("profile_use_background_image")
    @Expose
    public Boolean profileUseBackgroundImage;
    @SerializedName("listed_count")
    @Expose
    public Integer listedCount;
    @SerializedName("profile_text_color")
    @Expose
    public String profileTextColor;
    @SerializedName("lang")
    @Expose
    public String lang;
    @SerializedName("followers_count")
    @Expose
    public Integer followersCount;
    @SerializedName("protected")
    @Expose
    public Boolean _protected;
    @SerializedName("notifications")
    @Expose
    public Object notifications;
    @SerializedName("profile_background_image_url_https")
    @Expose
    public String profileBackgroundImageUrlHttps;
    @SerializedName("profile_background_color")
    @Expose
    public String profileBackgroundColor;
    @SerializedName("verified")
    @Expose
    public Boolean verified;
    @SerializedName("geo_enabled")
    @Expose
    public Boolean geoEnabled;
    @SerializedName("time_zone")
    @Expose
    public String timeZone;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("default_profile_image")
    @Expose
    public Boolean defaultProfileImage;
    @SerializedName("profile_background_image_url")
    @Expose
    public String profileBackgroundImageUrl;
    @SerializedName("statuses_count")
    @Expose
    public Integer statusesCount;
    @SerializedName("friends_count")
    @Expose
    public Integer friendsCount;
    @SerializedName("following")
    @Expose
    public Object following;
    @SerializedName("show_all_inline_media")
    @Expose
    public Boolean showAllInlineMedia;
    @SerializedName("screen_name")
    @Expose
    public String screenName;

    public User(String name, String imageUrl){
        this.profileImageUrl = imageUrl;
        this.name = name;
    }
}
