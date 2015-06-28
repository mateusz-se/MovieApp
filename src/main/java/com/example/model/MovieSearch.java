package com.example.model;

/**
 * Created by Mateusz on 2015-06-28.
 */
public class MovieSearch {
    private String genre;
    private Float minRating;

    public Float getMinRating() {
        return minRating;
    }

    public void setMinRating(Float minRating) {
        this.minRating = minRating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
