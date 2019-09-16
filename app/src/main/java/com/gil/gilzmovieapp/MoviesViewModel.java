package com.gil.gilzmovieapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.gil.gilzmovieapp.DataBase.MoviesRepository;
import com.gil.gilzmovieapp.DataBase.MyMovie;

import java.util.List;

public class MoviesViewModel extends AndroidViewModel {

    private MoviesRepository mMoviesRepository;
    private LiveData<List<MyMovie>> allMovies;

    public MoviesViewModel(@NonNull Application application) {
        super(application);
        mMoviesRepository = new MoviesRepository(application);
        allMovies = mMoviesRepository.getAllMovies();
    }

    public LiveData<List<MyMovie>> getAllMovies() {
        return allMovies;
    }

    public void insert(MyMovie myMovie) {
        mMoviesRepository.insert(myMovie);
    }

    public void update(MyMovie myMovie) {
        mMoviesRepository.update(myMovie);
    }





}
