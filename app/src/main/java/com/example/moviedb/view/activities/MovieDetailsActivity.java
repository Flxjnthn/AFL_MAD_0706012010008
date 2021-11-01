package com.example.moviedb.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviedb.R;
import com.example.moviedb.viewmodel.MovieViewModel;

public class MovieDetailsActivity extends AppCompatActivity {

    private TextView lbl_text, lbl_details_title, lbl_details_overview, lbl_details_releasedate,
                        lbl_details_rate, lbl_details_language, lbl_details_votecount, lbl_details_popular;
    private String movie_id, movie_title, movie_overview, movie_releasedate, movie_img, movie_rate,
                        movie_language, movie_votecount, movie_popular = "";
    private ImageView img_poster_details, lbl_detail_img;
    private MovieViewModel view_model;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        Intent intent = getIntent();
        movie_id = intent.getStringExtra("movie_id");
        movie_title = intent.getStringExtra("movie_title");
        movie_overview = intent.getStringExtra("movie_overview");
        movie_releasedate = intent.getStringExtra("movie_releasedate");
        movie_rate = intent.getStringExtra("movie_rate");
        movie_img = intent.getStringExtra("movie_img");
        movie_language = intent.getStringExtra("movie_language");
        movie_votecount = intent.getStringExtra("movie_votecount");
        movie_popular = intent.getStringExtra("movie_popular");

        lbl_text = findViewById(R.id.lbl_details_id);
        lbl_details_title = findViewById(R.id.lbl_details_title);
        lbl_details_overview = findViewById(R.id.lbl_details_overview);
        lbl_details_releasedate = findViewById(R.id.lbl_details_releasedate);
        lbl_detail_img = findViewById(R.id.img_poster_details);
        lbl_details_rate = findViewById(R.id.lbl_details_rate);
        lbl_details_language = findViewById(R.id.lbl_details_language);
        lbl_details_votecount = findViewById(R.id.lbl_details_votecount);
        lbl_details_popular = findViewById(R.id.lbl_details_popularity);

        toolbar = findViewById(R.id.toolbar_main_menu);
        setSupportActionBar(toolbar);

        lbl_text.setText(movie_id);
        lbl_details_title.setText(movie_title);
        lbl_details_overview.setText(movie_overview);
        lbl_details_releasedate.setText(movie_releasedate);
        lbl_detail_img.setImageURI(Uri.parse(movie_img));
        lbl_details_rate.setText(movie_rate);
        lbl_details_language.setText(movie_language);
        lbl_details_votecount.setText(movie_votecount);
        lbl_details_popular.setText(movie_popular);

        view_model = new ViewModelProvider(MovieDetailsActivity.this).get(MovieViewModel.class);
        view_model.getDetails();
    }

    @Override
    public void onBackPressed() {
        finish();
    }


}