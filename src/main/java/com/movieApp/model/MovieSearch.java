package com.movieApp.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Mateusz on 2015-06-28.
 */
public class MovieSearch {
    @NotEmpty(message = "Genre can't be empty")
    private String genre;
    @NotNull @Min(0) @Max(10)
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
