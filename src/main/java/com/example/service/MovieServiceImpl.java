package com.example.service;

import com.example.model.GenreEntity;
import com.example.model.MovieEntity;

import com.example.model.MovieSearch;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by Mateusz on 2015-06-27.
 */
@Service
public class MovieServiceImpl implements MovieService{

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public List getMovies() {
        CriteriaQuery<MovieEntity> c = entityManager.getCriteriaBuilder().createQuery(MovieEntity.class);
        c.from(MovieEntity.class);
        return entityManager.createQuery(c).getResultList();
    }
    @Transactional
    public List getTopMovies() {

        TypedQuery<MovieEntity> query =
                entityManager.createQuery("SELECT m FROM MovieEntity m ORDER BY m.voteAverage desc, m.releaseDate asc ", MovieEntity.class);
        List<MovieEntity> results = query.setMaxResults(20).getResultList();

        return results;
    }
    @Transactional
    public MovieEntity getMovieById(int id){
        TypedQuery<MovieEntity> query =
                entityManager.createQuery("SELECT m FROM MovieEntity m WHERE m.id = " +id , MovieEntity.class);
        return query.getSingleResult();

    }
    @Transactional
    public List getMoviesByGenreAndRating(MovieSearch movieSearch){
        TypedQuery<MovieEntity> query =
                entityManager.createQuery("SELECT gm.movieByMovieId FROM MovieGenreEntity gm  WHERE  gm.genreByGenreId.name = '" + movieSearch.getGenre() +
                        "' and gm.movieByMovieId.voteAverage >= "+ movieSearch.getMinRating(), MovieEntity.class);
        return query.getResultList();
    }
}
