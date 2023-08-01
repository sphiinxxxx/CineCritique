package com.example.mtbs.controller;

import com.example.mtbs.model.Movie;
import com.example.mtbs.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

//    @GetMapping("/movies")
//    public String getMovies(Model model) {
//        model.addAttribute("movies", movieService.getAllMovies());
//        return "movies";
//    }

    @GetMapping("/movies")
    public ResponseEntity<Object> getMovies() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/movies/view/{movie_id}")
    public String viewMovie(@PathVariable Long movie_id, Model model) {
        model.addAttribute("movie", movieService.getMovieById(movie_id));
        return "viewMovie";
    }

    @GetMapping("/admin/movies")
    public String getAdminMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "adminMovies";
    }

    @GetMapping("/admin/movies/view/{movie_id}")
    public String viewAdminMovie(@PathVariable Long movie_id, Model model) {
        model.addAttribute("movie", movieService.getMovieById(movie_id));
        return "viewAdminMovie";
    }

    @GetMapping("/admin/movies/new")
    public String addMovieForm(Model model) {
        Movie movie = new Movie();
        model.addAttribute("movie", movie);
        return "addMovie";
    }

//    @PostMapping("/admin/movies/new")
//    public String addMovie(@ModelAttribute("movie") Movie movie) {
//        movieService.addMovie(movie);
//        return "redirect:/admin/movies";
//    }

    @PostMapping("/admin/movies/new")
    public ResponseEntity<Object> addMovie(@ModelAttribute("movie") Movie movie) {
        movieService.addMovie(movie);
        return new ResponseEntity<>(movieService.getAllMovies().toArray(), HttpStatus.OK);
    }

    @GetMapping("/admin/movies/update/{movie_id}")
    public String updateMovieForm(@PathVariable Long movie_id, Model model) {
        model.addAttribute("movie", movieService.getMovieById(movie_id));
        return "updateMovie";
    }

    @PostMapping("/admin/movies/update/{movie_id}")
    public String updateMovie(@PathVariable Long movie_id, @ModelAttribute("movie") Movie movie) {
        Movie existingMovie = movieService.getMovieById(movie_id);
        existingMovie.setMovie_id(movie_id);
        existingMovie.setMovie_name(movie.getMovie_name());
        existingMovie.setDescription(movie.getDescription());
        existingMovie.setRating(movie.getRating());
        existingMovie.setCast(movie.getCast());
        movieService.updateMovie(existingMovie);
        return "redirect:/admin/movies";
    }

    @GetMapping("admin/movies/delete/{movie_id}")
    public String deleteMovie(@PathVariable Long movie_id) {
        movieService.deleteMovieById(movie_id);
        return "redirect:/admin/movies";
    }
}
