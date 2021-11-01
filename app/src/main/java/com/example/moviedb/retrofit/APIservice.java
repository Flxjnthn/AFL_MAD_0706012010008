package com.example.moviedb.retrofit;

import com.example.moviedb.R;
import com.example.moviedb.helper.Const;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIservice {

    private static Retrofit retrofit;

    public static ApiEndPoint endPoint(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiEndPoint.class);
    }

}
