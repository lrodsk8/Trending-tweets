package luisrodriguez.trendingtweets.ViewModel;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import luisrodriguez.trendingtweets.Model.User;
import luisrodriguez.trendingtweets.PriorSearchesFragment;
import luisrodriguez.trendingtweets.R;
import luisrodriguez.trendingtweets.TweetAdapter;
import luisrodriguez.trendingtweets.Utils;
import luisrodriguez.trendingtweets.databinding.FragmentMaintweetBinding;

/**
 * This class handles the initial view of the App  displaying simple controls.
 * Created by Luis.Rodriguez on 3/14/2017.
 */
public class MainViewModel extends Fragment{
    private static final String TAG = MainViewModel.class.getSimpleName();
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentMaintweetBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_maintweet, container, false);
        View view = binding.getRoot();
        mRecyclerView = binding.listInfluentialPeople;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new TweetAdapter(getActivity(),getUsers()));


        binding.buttonSearch.setOnClickListener(v ->
                //TODO implement
                Toast.makeText(getActivity(), " SearchItem Clicked", Toast.LENGTH_LONG).show());

        binding.buttonPriorSearches.setOnClickListener(v ->
                ProceedToSearchesView());

        return view;
    }

    private void ProceedToSearchesView(){
        PriorSearchesFragment fragmentSignUpPrequalificationEmail = new PriorSearchesFragment();
        FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction mTransaction = mFragmentManager.beginTransaction();
        mTransaction.addToBackStack(Utils.PRIOR_SEARCHES_FRAGMENT).replace(R.id.fragment_container, fragmentSignUpPrequalificationEmail).commit();
    }

    //testing
    private List<User> getUsers(){
        List<User> data = new ArrayList<>();
        User user = new User("testUser", "testUser");
        data.add(user);
        return data;
    }
}
