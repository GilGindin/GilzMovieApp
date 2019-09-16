package com.gil.gilzmovieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends AppCompatActivity {

    public static final String EXTRA_ID = "com.gil.gilzmovieapp.EXTRA_ID";
    public static final String EXTRA_TITLE = "com.gil.gilzmovieapp.EXTRA_TITLE";
    public static final String EXTRA_RATING = "com.gil.gilzmovieapp.EXTRA_RATING";
    public static final String EXTRA_RELEASE_YEAR = "com.gil.gilzmovieapp.EXTRA_RELEASE_YEAR";
    public static final String EXTRA_PHOTO = "com.gil.gilzmovieapp.EXTRA_PHOTO";
    public static final String EXTRA_GENRE = "com.gil.gilzmovieapp.EXTRA_GENRE";

    private TextView tv_detail , text_view_realse_year , tv_rating;
    private ImageView image_view_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        image_view_detail = findViewById(R.id.image_view_detail);
        tv_detail = findViewById(R.id.tv_detail);
        tv_rating = findViewById(R.id.tv_rating);
        text_view_realse_year = findViewById(R.id.tv_release_year);

        Intent intent = getIntent();
        String title = intent.getStringExtra(EXTRA_TITLE);
        String photo = intent.getStringExtra(EXTRA_PHOTO);
        int year = (int) intent.getIntExtra(EXTRA_RELEASE_YEAR , 1);
        double rating = intent.getDoubleExtra(EXTRA_RATING,1);

        Picasso.with(this).load(photo).into(image_view_detail);
        tv_detail.setText(title);
        text_view_realse_year.setText("Release Year : "+year);
        tv_rating.setText("Movie Rating : "+rating);


    }
}
