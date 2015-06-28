package com.movieApp.service;

import com.movieApp.model.MovieEntity;
import com.movieApp.model.MovieSearch;


import java.util.List;

/**
 * Created by Mateusz on 2015-06-27.
 */
public interface MovieService{

    List getMovies();
    List getTopMovies();
    MovieEntity getMovieById(int id);
    List getMoviesByGenreAndRating(MovieSearch movieSearch);


}
