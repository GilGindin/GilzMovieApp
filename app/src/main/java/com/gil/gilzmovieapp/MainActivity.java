package com.gil.gilzmovieapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.gil.gilzmovieapp.Adapter.MyCustomAdapter;
import com.gil.gilzmovieapp.DataBase.MyMovie;
import com.gil.gilzmovieapp.Netowrk.EndPointClass;
import com.gil.gilzmovieapp.Netowrk.RetrofitInstance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private MoviesViewModel mMoviesViewModel;
    private RecyclerView mRecyclerView;
    private MyMovie myMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fetchMovies();
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
      //  mRecyclerView.setItemViewCacheSize(20);


        mMoviesViewModel = ViewModelProviders.of(this).get(MoviesViewModel.class);
        mMoviesViewModel.getAllMovies().observe(this, new Observer<List<MyMovie>>() {
            @Override
            public void onChanged(@Nullable List<MyMovie> myMovies) {

                MyCustomAdapter myCustomAdapter = new MyCustomAdapter(MainActivity.this, myMovies);
             //   myCustomAdapter.setHasStableIds(true);
                mRecyclerView.setAdapter(myCustomAdapter);
                myCustomAdapter.notifyDataSetChanged();

                myCustomAdapter.setOnItemClickListener(new MyCustomAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(MyMovie myMovie) {
                        Intent intent = new Intent(MainActivity.this, MovieDetailActivity.class);
                        intent.putExtra(MovieDetailActivity.EXTRA_ID, myMovie.getId());
                        intent.putExtra(MovieDetailActivity.EXTRA_TITLE, myMovie.getTitle());
                        intent.putExtra(MovieDetailActivity.EXTRA_RATING, myMovie.getRating());
                        intent.putExtra(MovieDetailActivity.EXTRA_RELEASE_YEAR, myMovie.getReleaseYear());
                        intent.putExtra(MovieDetailActivity.EXTRA_PHOTO, myMovie.getImage());
                        intent.putExtra(MovieDetailActivity.EXTRA_GENRE, (Serializable) myMovie.getGenre());
                        startActivity(intent);
                    }
                });
            }
        });
    }

    private void fetchMovies() {

        EndPointClass endPointClass = RetrofitInstance.getRetrofitInstance().create(EndPointClass.class);
        Call<List<Model>> call = endPointClass.getMovies();

        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if (response.isSuccessful()) {
                    if (response != null) {
                        List<Model> moviesModelList = response.body();

                        for (int i = 0; i < moviesModelList.size(); i++) {
                            String title = moviesModelList.get(i).getTitle();
                            String image = moviesModelList.get(i).getImage();
                            double rating = moviesModelList.get(i).getRating();
                            int releaseYear = moviesModelList.get(i).getReleaseYear();
                            ArrayList<Object> genre = moviesModelList.get(i).getGenre();

                            myMovie = new MyMovie(title, image, rating, releaseYear, genre);
                            mMoviesViewModel.insert(myMovie);


                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("", "onFailure:------------------- " + t.getMessage());
            }
        });
    }

}
