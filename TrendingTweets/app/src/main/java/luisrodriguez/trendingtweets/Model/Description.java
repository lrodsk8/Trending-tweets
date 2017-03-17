package luisrodriguez.trendingtweets.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * Created by Luis Rodriguez on 3/13/2017.
 */
public class Description {

    @SerializedName("urls")
    @Expose
    public List<Object> urls = null;
}
