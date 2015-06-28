package com.example.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by Mateusz on 2015-06-27.
 */
@Entity
@Table(name = "movie", schema = "public", catalog = "d8u6uelvine6d6")
public class MovieEntity {
    private int id;
    private String originalLanguage;
    private String originalTitle;
    private Date releaseDate;
    private Float popularity;
    private String title;
    private Float voteAverage;
    private Integer voteCount;
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
    @Column(name = "original_language", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    @Basic
    @Column(name = "original_title", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    @Basic
    @Column(name = "release_date", nullable = true, insertable = true, updatable = true)
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Basic
    @Column(name = "popularity", nullable = true, insertable = true, updatable = true, precision = 8)
    public Float getPopularity() {
        return popularity;
    }

    public void setPopularity(Float popularity) {
        this.popularity = popularity;
    }

    @Basic
    @Column(name = "title", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "vote_average", nullable = true, insertable = true, updatable = true, precision = 8)
    public Float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Float voteAverage) {
        this.voteAverage = voteAverage;
    }

    @Basic
    @Column(name = "vote_count", nullable = true, insertable = true, updatable = true)
    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieEntity that = (MovieEntity) o;

        if (id != that.id) return false;
        if (originalLanguage != null ? !originalLanguage.equals(that.originalLanguage) : that.originalLanguage != null)
            return false;
        if (originalTitle != null ? !originalTitle.equals(that.originalTitle) : that.originalTitle != null)
            return false;
        if (releaseDate != null ? !releaseDate.equals(that.releaseDate) : that.releaseDate != null) return false;
        if (popularity != null ? !popularity.equals(that.popularity) : that.popularity != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (voteAverage != null ? !voteAverage.equals(that.voteAverage) : that.voteAverage != null) return false;
        if (voteCount != null ? !voteCount.equals(that.voteCount) : that.voteCount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (originalLanguage != null ? originalLanguage.hashCode() : 0);
        result = 31 * result + (originalTitle != null ? originalTitle.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (popularity != null ? popularity.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (voteAverage != null ? voteAverage.hashCode() : 0);
        result = 31 * result + (voteCount != null ? voteCount.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "movieByMovieId")
    public Collection<MovieGenreEntity> getMovieGenresById() {
        return movieGenresById;
    }

    public void setMovieGenresById(Collection<MovieGenreEntity> movieGenresById) {
        this.movieGenresById = movieGenresById;
    }
}
