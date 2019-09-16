package com.gil.gilzmovieapp.DataBase;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MyMovie myMovie);

    @Update
    void update(MyMovie myMovie);

    @Query("SELECT * FROM movies ORDER BY releaseYear DESC")
    LiveData<List<MyMovie>> getAllNMovies();
}
