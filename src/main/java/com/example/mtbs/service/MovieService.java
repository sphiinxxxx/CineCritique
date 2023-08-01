package com.example.mtbs.service;

import com.example.mtbs.model.Movie;
import com.example.mtbs.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie getMovieById(Long movie_id) {
        return movieRepository.findById(movie_id).get();
    }

    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovieById(Long movie_id) {
        movieRepository.deleteById(movie_id);
    }
}
