package luisrodriguez.trendingtweets;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import luisrodriguez.trendingtweets.Model.User;
import luisrodriguez.trendingtweets.ViewModel.UserViewModel;
import luisrodriguez.trendingtweets.databinding.FragmentMaintweetBinding;

/**
 * Created by Luis.Rodriguez on 3/10/2017.
 */

public class MainViewModel extends Fragment{


    private static final String TAG = MainViewModel.class.getSimpleName();
    private RecyclerView mRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.i(TAG, "#onCreateView");
        FragmentMaintweetBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_maintweet, container, false);
        View view = binding.getRoot();
        mRecyclerView = binding.listInfluentialPeople;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new TweetAdapter(getActivity(),getUsers()));


        binding.buttonSearch.setOnClickListener(v ->
                Toast.makeText(getActivity(), " SearchItem Clicked", Toast.LENGTH_LONG).show());

        return view;

    }

//    public void testButtonClick(View view){
//        Toast.makeText(getActivity(), " SearchItem Clicked", Toast.LENGTH_LONG).show();
//    }
//
//    public View.OnClickListener onClickSearchItem() {
//        return new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), " SearchItem Clicked", Toast.LENGTH_LONG).show();
//            }
//        };
//    }

    private void initUserList(){

    }

    private List<User> getUsers(){
        List<User> data = new ArrayList<>();
        User user = new User("testUser", "testUser");
        //user.name = "testUser";
        data.add(user);
        return data;
    }

    private List<UserViewModel> getData(){
        List<UserViewModel> data = new ArrayList<>();
        User user = new User("testUser", "testUser");

        UserViewModel model = new UserViewModel( user, getActivity());
        data.add(model);
        return data;
    }
}
