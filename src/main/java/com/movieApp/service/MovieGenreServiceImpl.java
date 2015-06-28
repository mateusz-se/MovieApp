package com.movieApp.service;

import com.movieApp.model.GenreChart;
import com.movieApp.model.GenreEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Mateusz on 2015-06-27.
 */
@Service
public class MovieGenreServiceImpl implements MovieGenreService {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List getGenres(int id) {
        TypedQuery<GenreEntity> query =
                entityManager.createQuery("SELECT gm.genreByGenreId FROM MovieGenreEntity gm  WHERE gm.movieByMovieId.id = " +id , GenreEntity.class);
        return query.getResultList();
    }
    @Override
    public List getGenresCount() {
        TypedQuery<GenreChart> query;
        query = entityManager.createQuery("SELECT DISTINCT new com.movieApp.model.GenreChart " +
                        "(gm.genreByGenreId.name, count(gm.genreByGenreId.name)) FROM MovieGenreEntity gm group by gm.genreByGenreId.name"
                , GenreChart.class);
        return query.getResultList();
    }
}
