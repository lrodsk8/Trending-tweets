package luisrodriguez.trendingtweets.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import luisrodriguez.trendingtweets.Model.SearchItem;
import luisrodriguez.trendingtweets.Model.User;
import luisrodriguez.trendingtweets.R;
import luisrodriguez.trendingtweets.databinding.FragmentPriorSearchesBinding;

/**
 * This Class will handle the SearchItem manipulation (The Search string entered by the user.).
 * Created by Luis.Rodriguez on 3/13/2017.
 */
public class PriorSearchesViewModel extends BaseObservable{

    private Context mContext;
    private SearchItem mSearchItem;

    public PriorSearchesViewModel(SearchItem searchItem, Context context) {
        this.mSearchItem = searchItem;
        this.mContext = context;
    }

    public String getSearchItemName(){
        return mSearchItem.searchName;
    }

    public List<User> getSearchResults(){
        return mSearchItem.searchResults;
    }

    public void setSearchItem(SearchItem item) {
        this.mSearchItem = item;
        notifyChange();
    }


}
