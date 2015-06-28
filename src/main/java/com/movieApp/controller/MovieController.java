package com.movieApp.controller;


import com.movieApp.model.MovieSearch;
import com.movieApp.service.MovieGenreService;
import com.movieApp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/app/")
public class MovieController {

    @Autowired
    MovieService movieService;
@Autowired
    MovieGenreService movieGenreService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView topMovies() {
        return new ModelAndView("movieTop", "movies", movieService.getTopMovies());
    }

    @RequestMapping(value = "movie/{Id}/", method = RequestMethod.GET)
    public ModelAndView details(@PathVariable("Id") Integer movieId) {
        ModelAndView modelAndView = new ModelAndView("detailedMovie");
        modelAndView.addObject("movie", movieService.getMovieById(movieId));
        modelAndView.addObject("genres", movieGenreService.getGenres(movieId));

        return modelAndView;
    }
    @RequestMapping(value = "search/", method = RequestMethod.GET)
    public ModelAndView details() {
        ModelAndView modelAndView = new ModelAndView("search");
modelAndView.addObject("movieSearch", new MovieSearch());

        return modelAndView;
    }
    @RequestMapping(value = "search/", method = RequestMethod.POST)
    public ModelAndView get(@ModelAttribute("movieSearch") MovieSearch movieSearch) {

        ModelAndView modelAndView = new ModelAndView("search", "movies", movieService.getMoviesByGenreAndRating(movieSearch));
        return modelAndView;
    }
    @RequestMapping(value = "topGenres/", method = RequestMethod.GET)
    public ModelAndView genres() {

        ModelAndView modelAndView = new ModelAndView("topGenres");
        modelAndView.addObject("genresCount", movieGenreService.getGenresCount());
        return modelAndView;
    }
}
