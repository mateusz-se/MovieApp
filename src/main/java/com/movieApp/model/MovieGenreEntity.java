package com.movieApp.model;

import javax.persistence.*;

/**
 * Created by Mateusz on 2015-06-27.
 */
@Entity
@Table(name = "movie_genre", schema = "public", catalog = "d8u6uelvine6d6")
public class MovieGenreEntity {
    private int id;

    private GenreEntity genreByGenreId;
    private MovieEntity movieByMovieId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieGenreEntity that = (MovieGenreEntity) o;

        if (id != that.id) return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = id;

        return result;
    }

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id", nullable = false)
    public GenreEntity getGenreByGenreId() {
        return genreByGenreId;
    }

    public void setGenreByGenreId(GenreEntity genreByGenreId) {
        this.genreByGenreId = genreByGenreId;
    }

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    public MovieEntity getMovieByMovieId() {
        return movieByMovieId;
    }

    public void setMovieByMovieId(MovieEntity movieByMovieId) {
        this.movieByMovieId = movieByMovieId;
    }
}
