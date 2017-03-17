package luisrodriguez.trendingtweets.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import luisrodriguez.trendingtweets.Model.User;

/**
 * This class will handle the Twitter results back from the search.
 * Created by Luis.Rodriguez on 3/12/2017.
 */

public class UserViewModel extends BaseObservable {

    private static final String TAG = UserViewModel.class.getSimpleName();
    private Context mContext;
    private User mUser;

    public UserViewModel(User user, Context context) {
        this.mUser = user;
        this.mContext = context;
    }


    public String getUserImage(){
        return mUser.profileImageUrl;
    }

    public String getName(){
        return mUser.name;
    }

    public void setUser(User user) {
        this.mUser = user;
        notifyChange();
    }
}
