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

public class Url {

    @SerializedName("urls")
    @Expose
    private List<Url_> urls = null;
}
