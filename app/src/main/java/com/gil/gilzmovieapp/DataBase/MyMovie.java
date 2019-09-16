package com.gil.gilzmovieapp.DataBase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import java.util.List;

@Entity(tableName = "movies")
public class MyMovie implements Comparable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private long id;

    private String title;

    private String image;

    private double rating;

    private int releaseYear;

    @TypeConverters(GenreTypeConverter.class)
    List<Object> genre;

    @Ignore
    public MyMovie(String title, String image, double rating, int releaseYear, List<Object> genre) {
        this.title = title;
        this.image = image;
        this.rating = rating;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }

    public MyMovie(long id, String title, String image, double rating, int releaseYear, List<Object> genre) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.rating = rating;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }

    public List<Object> getGenre() {
        return genre;
    }

    public void setGenre(List<Object> genre) {
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public double getRating() {
        return rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public int compareTo(Object o) {
        MyMovie m = (MyMovie) o;
        if (releaseYear > ((MyMovie) o).releaseYear) {
            return -1;
        } else if (((MyMovie) o).releaseYear > releaseYear) {
            return 1;
        } else {
            return 0;
        }
    }

}
