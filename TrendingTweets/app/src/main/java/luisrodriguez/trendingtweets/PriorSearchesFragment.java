package luisrodriguez.trendingtweets;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import luisrodriguez.trendingtweets.ViewModel.PriorSearchesViewModel;
import luisrodriguez.trendingtweets.databinding.FragmentPriorSearchesBinding;

/**
 * This class will manipulate the Prior searches view displaying its recyclerview
 * Created by Luis.Rodriguez on 3/15/2017.
 */
public class PriorSearchesFragment extends Fragment {

    private static final String TAG = PriorSearchesViewModel.class.getSimpleName();
    private RecyclerView mRecyclerView;

    public PriorSearchesFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.i(TAG, "#onCreateView");
        FragmentPriorSearchesBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_prior_searches, container, false);
        View v = binding.getRoot();


        return v;
    }
}
