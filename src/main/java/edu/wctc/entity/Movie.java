package edu.wctc.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int movieId;

    @Column(name = "movie_nm")
    private String name;

    @Column(name = "overview")
    private String overview;

    @Column(name = "year")
    private int year;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinTable(name = "movie_featuredcrew",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "featuredcrew_id"))
    private List<FeaturedCrew> featuredCrewList;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinTable(name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

    public Movie() {
        //no-arg constructor
    }

    public Movie(String name, String overview, int year) {
        this.name = name;
        this.overview = overview;
        this.year = year;
    }

    public void add(FeaturedCrew tempFeaturedCrew) {
        if (featuredCrewList == null) {
            featuredCrewList = new ArrayList<>();
        }
        featuredCrewList.add(tempFeaturedCrew);
    }

    public List<FeaturedCrew> getFeaturedCrewList(){
        return featuredCrewList;
    }

    public void setFeaturedCrewLists(List<FeaturedCrew> featuredCrewList) {
        this.featuredCrewList = featuredCrewList;
    }

    public void add(Genre tempGenre) {
        if( genres == null ) {
            genres = new ArrayList<>();
        }
        genres.add(tempGenre);
    }

    public List<Genre> getGenres(){
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + movieId +
                ", name='" + name + '\'' +
                ", overview=" + overview + '\'' +
                ", year=" + year +
                '}';
    }
}
