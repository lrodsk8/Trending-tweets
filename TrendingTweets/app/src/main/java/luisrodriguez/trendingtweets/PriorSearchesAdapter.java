package luisrodriguez.trendingtweets;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import luisrodriguez.trendingtweets.Model.SearchItem;
import luisrodriguez.trendingtweets.ViewModel.PriorSearchesViewModel;
import luisrodriguez.trendingtweets.databinding.SearchItemBinding;

/**
 * This class will handle SearchItem manipulation and binding to its respective recyclerview.
 * Created by Luis.Rodriguez on 3/15/2017.
 */

public class PriorSearchesAdapter extends RecyclerView.Adapter<PriorSearchesAdapter.PriorSearchesViewHolder>  {

    private List<SearchItem> mSearchList;
    private Context mContext;

    public PriorSearchesAdapter(Context context, List searchItemList) {
        this.mContext = context;
        this.mSearchList = searchItemList;

    }
    @Override
    public PriorSearchesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SearchItemBinding binding =  DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.search_item,
                parent, false);
        return new PriorSearchesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(PriorSearchesViewHolder  holder, int position) {
        holder.bindSearch(mSearchList.get(position));
    }

    @Override
    public int getItemCount() {
        return mSearchList.size();
    }

    public void setmSearchList(List<SearchItem> searchItems) {
        this.mSearchList = searchItems;
        notifyDataSetChanged();
    }

    public static class PriorSearchesViewHolder extends RecyclerView.ViewHolder {

        SearchItemBinding mSearchItemBinding;

        public PriorSearchesViewHolder(SearchItemBinding searchItemBinding) {
            super(searchItemBinding.getRoot());
            this.mSearchItemBinding = searchItemBinding;
        }

        void bindSearch(SearchItem searchItem) {
            if (mSearchItemBinding.getPriorSearchesViewModel()== null) {
                mSearchItemBinding.setPriorSearchesViewModel(
                        new PriorSearchesViewModel(searchItem, itemView.getContext()));
            } else {
                mSearchItemBinding.getPriorSearchesViewModel().setSearchItem(searchItem);
            }
        }
    }
}
