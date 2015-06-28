package com.movieApp.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Mateusz on 2015-06-27.
 */
@Entity
@Table(name = "genre", schema = "public", catalog = "d8u6uelvine6d6")
public class GenreEntity {
    private int id;
    private String name;
    private Collection<MovieGenreEntity> movieGenresById;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenreEntity that = (GenreEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "genreByGenreId")
    public Collection<MovieGenreEntity> getMovieGenresById() {
        return movieGenresById;
    }

    public void setMovieGenresById(Collection<MovieGenreEntity> movieGenresById) {
        this.movieGenresById = movieGenresById;
    }
}
