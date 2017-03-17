package luisrodriguez.trendingtweets.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Luis.Rodriguez on 3/15/2017.
 * This will handle the object to be saved locally.
 */

public class SearchItem {

    @SerializedName("search_name")
    @Expose
    public String searchName;
    @SerializedName("search_results")
    @Expose
    public List<User> searchResults;

    @Override
    public String toString() {
        return "SearchItem{" +
                "searchName='" + searchName + '\'' +
                ", searchResults=" + searchResults +
                '}';
    }

    public SearchItem(String name, List<User> results){
        this.searchName = name;
        this.searchResults = results;
    }
}
