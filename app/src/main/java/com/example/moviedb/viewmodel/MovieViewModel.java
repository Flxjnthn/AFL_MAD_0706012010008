package com.example.moviedb.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.moviedb.model.Movies;
import com.example.moviedb.model.NowPlaying;
import com.example.moviedb.model.UpComing;
import com.example.moviedb.repositories.MovieRepository;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {

    private MovieRepository repository;

    public MovieViewModel(@NonNull Application application){
        super(application);
        repository = MovieRepository.getInstance();
    }

    //==Begin of viewmodel get movie by id

    private MutableLiveData<Movies> resultGetMoviesById = new MutableLiveData<>();
    public void getMovieById(String movieId){
        resultGetMoviesById = repository.getMovieData(movieId);
    }

    public LiveData<Movies> getResultGetMoviesById(){
        return resultGetMoviesById;
    }
    //==End of viewmodel get movie by id


    //==Begin of viewmodel get now playing

    private MutableLiveData<NowPlaying> resultGetNowPlaying = new MutableLiveData<>();
    public void getNowPlaying(){
        resultGetNowPlaying = repository.getNowPlayingData();
    }
    public LiveData<NowPlaying> getResultNowPlaying(){
        return resultGetNowPlaying;
    }

    //==End of viewmodel get now playing


    //==Begin of viewmodel get details
    private MutableLiveData<Movies> resultGetDetails = new MutableLiveData<>();
    public void getDetails(){ resultGetDetails = repository.getDetailsData(); }
    public LiveData<Movies> getResultDetails(){
        return resultGetDetails;
    }
    //==End of viewmodel get details

    private MutableLiveData<List<UpComing.Results>> resultGetUpComing = new MutableLiveData<>();
    public void getUpComing(int page) {
        resultGetUpComing = repository.getUpcomingData(page);
    }
    public LiveData<List<UpComing.Results>> getResultUpComing() {
        return resultGetUpComing;
    }

}
