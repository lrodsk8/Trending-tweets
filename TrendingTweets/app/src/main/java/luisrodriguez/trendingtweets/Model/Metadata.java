package luisrodriguez.trendingtweets.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by Luis Rodriguez on 3/13/2017.
 */

public class Metadata {

    @SerializedName("iso_language_code")
    @Expose
    public String isoLanguageCode;
    @SerializedName("result_type")
    @Expose
    public String resultType;
}
