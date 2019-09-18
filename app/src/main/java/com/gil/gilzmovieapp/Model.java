package com.gil.gilzmovieapp;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Model {

    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("image")
    private String image;

    @SerializedName("rating")
    private double rating;

    @SerializedName("releaseYear")
    private int releaseYear;

    @SerializedName("genre")
    private ArrayList<Object> genre = new ArrayList<Object>();

    public Model(String title, String image, double rating, int releaseYear, ArrayList<Object> genre) {
        this.title = title;
        this.image = image;
        this.rating = rating;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
