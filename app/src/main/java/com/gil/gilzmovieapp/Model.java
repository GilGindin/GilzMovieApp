package com.gil.gilzmovieapp;

import java.util.ArrayList;

public class Model {

    private long id;

    private String title;

    private String image;

    private double rating;

    private int releaseYear;

    ArrayList< Object > genre = new ArrayList < Object > ();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public ArrayList<Object> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<Object> genre) {
        this.genre = genre;
    }
}
