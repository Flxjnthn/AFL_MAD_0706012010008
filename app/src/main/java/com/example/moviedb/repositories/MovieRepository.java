package com.example.moviedb.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.moviedb.helper.Const;
import com.example.moviedb.model.Movies;
import com.example.moviedb.model.NowPlaying;
import com.example.moviedb.model.UpComing;
import com.example.moviedb.retrofit.APIservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private static MovieRepository repository;

    private MovieRepository(){}

    public static MovieRepository getInstance(){
        if (repository == null){
            repository = new MovieRepository();
        }
        return repository;
    }

    public MutableLiveData<Movies>getMovieData(String movieId){
        final MutableLiveData<Movies> result = new MutableLiveData<>();

        APIservice.endPoint().getMovieById(movieId, Const.API_KEY).enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                result.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {

            }
        });

        return result;


    }

    public MutableLiveData<NowPlaying>getNowPlayingData(){
        final MutableLiveData<NowPlaying> result = new MutableLiveData<>();

        APIservice.endPoint().getNowPlaying(Const.API_KEY).enqueue(new Callback<NowPlaying>() {
            @Override
            public void onResponse(Call<NowPlaying> call, Response<NowPlaying> response) {
                result.setValue(response.body());
            }

            @Override
            public void onFailure(Call<NowPlaying> call, Throwable t) {

            }
        });

        return result;


    }


    public MutableLiveData<Movies> getDetailsData() {
        final MutableLiveData<Movies> result = new MutableLiveData<>();

        APIservice.endPoint().getDetails(Const.API_KEY).enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                result.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {

            }
        });

        return result;
    }

    private List<UpComing.Results> upComingList = new ArrayList<>();

    public MutableLiveData<List<UpComing.Results>> getUpcomingData(int page) {
        final MutableLiveData<List<UpComing.Results>> result = new MutableLiveData<>();

        APIservice.endPoint().getUpComing(page, Const.API_KEY).enqueue(new Callback<UpComing>() {
            @Override
            public void onResponse(Call<UpComing> call, Response<UpComing> response) {
                upComingList.addAll(response.body().getResults());
                result.setValue(upComingList);
            }

            @Override
            public void onFailure(Call<UpComing> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return result;
    }


//    private List<UpComing.Results> upComingList = new ArrayList<>();
//
//    public MutableLiveData<List<UpComing.Results>> getUpcomingData(int page) {
//        final MutableLiveData<List<UpComing.Results>> result = new MutableLiveData<>();
//
//        APIservice.endPoint().getUpComing(Const.API_KEY).enqueue(new Callback<UpComing>() {
//            @Override
//            public void onResponse(Call<UpComing> call, Response<UpComing> response) {
//                upComingList.addAll(response.body().getResults());
//                result.setValue(upComingList);
//            }
//
//            @Override
//            public void onFailure(Call<UpComing> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });
//
//        return result;
//    }
}























































