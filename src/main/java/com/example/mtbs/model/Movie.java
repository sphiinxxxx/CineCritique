package com.example.mtbs.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movie_id;
    @Column(name = "movie_name", nullable = false)
    private String movie_name;
    private String description;
    private double rating;
    private String cast;

    @ManyToMany
    @JoinTable(
            name = "movies_theatres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "theatre_id"))
    private Set<Theatre> movie_theatres;

//    @OneToMany(fetch = FetchType.EAGER,mappedBy="movie",cascade = CascadeType.ALL)
//    private List<Show> show;

    public Movie() {
    }

    public Movie(Long movie_id, String movie_name, String description, double rating, String cast, Set<Theatre> movie_theatres) {
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.description = description;
        this.rating = rating;
        this.cast = cast;
        this.movie_theatres = movie_theatres;
    }

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", movie_name='" + movie_name + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", cast='" + cast + '\'' +
                '}';
    }
}
