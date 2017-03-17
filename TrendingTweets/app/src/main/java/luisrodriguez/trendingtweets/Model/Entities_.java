package luisrodriguez.trendingtweets.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import retrofit2.http.Url;

/**
 * Created by Luis Rodriguez on 3/12/2017.
 */

public class Entities_ {

    @SerializedName("url")
    @Expose
    private Url url;
    @SerializedName("description")
    @Expose
    private Description description;

//    public Url getUrl() {
//        return url;
//    }
//
//    public void setUrl(Url url) {
//        this.url = url;
//    }
//
//    public Description getDescription() {
//        return description;
//    }
//
//    public void setDescription(Description description) {
//        this.description = description;
//    }
//
//    @Override
//    public String toString() {
//        return ToStringBuilder.reflectionToString(this);
//    }
//
//    @Override
//    public int hashCode() {
//        return new HashCodeBuilder().append(url).append(description).toHashCode();
//    }
//
//    @Override
//    public boolean equals(Object other) {
//        if (other == this) {
//            return true;
//        }
//        if ((other instanceof Entities_) == false) {
//            return false;
//        }
//        Entities_ rhs = ((Entities_) other);
//        return new EqualsBuilder().append(url, rhs.url).append(description, rhs.description).isEquals();
//    }

}
