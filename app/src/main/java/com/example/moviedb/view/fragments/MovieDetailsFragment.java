package com.example.moviedb.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moviedb.R;
import com.example.moviedb.adapter.ProductionCompaniesAdapter;
import com.example.moviedb.helper.Const;
import com.example.moviedb.model.Movies;
import com.example.moviedb.model.NowPlaying;
import com.example.moviedb.model.UpComing;
import com.example.moviedb.viewmodel.MovieViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MovieDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MovieDetailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private MovieViewModel viewModel;
    private ImageView img_moviedetails_fragment;
    private TextView title_movie_details_fragment, years_movie_details_fragment, rate_movie_details_fragment,
            synopsis_movie_details_fragment, lbl_movie_id;
    private RecyclerView company_movie_details_fragment_rv;


    public MovieDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MovieDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MovieDetailsFragment newInstance(String param1, String param2) {
        MovieDetailsFragment fragment = new MovieDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

//    private TextView lbl_movie_id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_details, container, false);
        lbl_movie_id = view.findViewById(R.id.lbl_movie_id);

        String movieId = getArguments().getString("movieId");
        lbl_movie_id.setText(movieId);

//        NowPlaying.Results moviedetails = getArguments().getParcelable("movie");
//        UpComing.Results upcoming = getArguments().getParcelable("upcoming");
//
//        if (moviedetails != null) {
//            Glide.with(getActivity().getApplicationContext()).load(Const.IMG_URL + moviedetails.getBackdrop_path()).into(img_moviedetails_fragment);
//            title_movie_details_fragment.setText(moviedetails.getTitle());
//            years_movie_details_fragment.setText(moviedetails.getRelease_date());
//            rate_movie_details_fragment.setText(String.valueOf(moviedetails.getVote_average()));
//            synopsis_movie_details_fragment.setText(moviedetails.getOverview());
//
//            viewModel.getMovieById(String.valueOf(moviedetails.getId()));
//            viewModel.getResultGetMoviesById().observe(getViewLifecycleOwner(), new Observer<Movies>() {
//
//                @Override
//                public void onChanged(Movies movies) {
//
//                    company_movie_details_fragment_rv.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
//                    ProductionCompaniesAdapter adapter = new ProductionCompaniesAdapter(getActivity().getApplicationContext());
//                    adapter.setListProductionCompanies(movies.getProduction_companies());
//                    company_movie_details_fragment_rv.setAdapter(adapter);
//                }
//            });
//
//        }else {
//            Glide.with(getActivity().getApplicationContext()).load(Const.IMG_URL + upcoming.getBackdrop_path()).into(img_moviedetails_fragment);
//            title_movie_details_fragment.setText(upcoming.getTitle());
//            years_movie_details_fragment.setText(upcoming.getRelease_date());
//            rate_movie_details_fragment.setText(String.valueOf(upcoming.getVote_average()));
//            synopsis_movie_details_fragment.setText(upcoming.getOverview());
//
//            viewModel.getMovieById(String.valueOf(upcoming.getId()));
//            viewModel.getResultGetMoviesById().observe(getViewLifecycleOwner(), new Observer<Movies>() {
//
//                @Override
//                public void onChanged(Movies movies) {
//
//                    company_movie_details_fragment_rv.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
//                    ProductionCompaniesAdapter adapter = new ProductionCompaniesAdapter(getActivity().getApplicationContext());
//                    adapter.setListProductionCompanies(movies.getProduction_companies());
//                    company_movie_details_fragment_rv.setAdapter(adapter);
//                }
//            });
//        }
//
//        return view;
//    }
//    private void initComponent(View view) {
//        img_moviedetails_fragment = view.findViewById(R.id.img_movie_details_fragment);
//        title_movie_details_fragment = view.findViewById(R.id.title_movie_details_fragment);
//        years_movie_details_fragment = view.findViewById(R.id.years_movie_details_fragment);
//        rate_movie_details_fragment = view.findViewById(R.id.rate_movie_details_fragment);
//        synopsis_movie_details_fragment = view.findViewById(R.id.synopsis_movie_details_fragment);
//        company_movie_details_fragment_rv = view.findViewById(R.id.company_movie_details_fragment_rv);
//        viewModel = new ViewModelProvider(this).get(MovieViewModel.class);
//    }

        return view;
    }
}


