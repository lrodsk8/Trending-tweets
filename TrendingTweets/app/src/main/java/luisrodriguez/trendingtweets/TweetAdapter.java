package luisrodriguez.trendingtweets;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import luisrodriguez.trendingtweets.ViewModel.UserViewModel;
import java.util.List;
import luisrodriguez.trendingtweets.Model.User;
import luisrodriguez.trendingtweets.databinding.InfluentialTweetBinding;

/**
 *  This class will handle the popular users results manipulation and binding to its respective recyclerview.
 * Created by Luis.Rodriguez on 3/13/2017.
 */

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.UserViewHolder> {

    private List<User> mUserList;
    private Context mContext;

    public TweetAdapter(Context context, List userList) {
        this.mContext = context;
        this.mUserList = userList;

    }

    @Override public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        InfluentialTweetBinding influentialTweetBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.influential_tweet,
                        parent, false);
        return new UserViewHolder(influentialTweetBinding);
    }

    @Override public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.bindUser(mUserList.get(position));
    }

    @Override public int getItemCount() {
        return mUserList.size();
    }

    public void setUserList(List<User> userList) {
        this.mUserList = userList;
        notifyDataSetChanged();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        InfluentialTweetBinding mInfluentialTweetBinding;

        public UserViewHolder(InfluentialTweetBinding influentialTweetBinding) {
            super(influentialTweetBinding.getRoot());
            this.mInfluentialTweetBinding = influentialTweetBinding;
        }

        void bindUser(User user) {
            if (mInfluentialTweetBinding.getTweetSearchViewModel()== null) {
                mInfluentialTweetBinding.setTweetSearchViewModel(
                        new UserViewModel(user, itemView.getContext()));
            } else {
                mInfluentialTweetBinding.getTweetSearchViewModel().setUser(user);
            }
        }
    }
}
