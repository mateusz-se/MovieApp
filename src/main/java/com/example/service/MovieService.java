package com.example.service;

import com.example.model.MovieEntity;
import com.example.model.MovieSearch;


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
