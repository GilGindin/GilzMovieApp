package com.gil.gilzmovieapp.Netowrk;

import com.gil.gilzmovieapp.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndPointClass {

    //function to make end call from the server
    @GET("json/movies.json")
    Call<List<Model>> getMovies();
}
