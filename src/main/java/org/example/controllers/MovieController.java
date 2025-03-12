package org.example.controllers;

import org.example.Movie;
import org.example.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService, MovieService movieService1) {
        this.movieService = movieService1;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body("Фильм добавлен");
    }

    @PutMapping("/{id}/rating")
    public ResponseEntity<String> updateMovieRating(@PathVariable String id, @RequestParam float newRating) {
    }

    @DeleteMapping("/{id}/comment")
    public ResponseEntity<String> updateMovieComment(@PathVariable String id, @RequestParam String newComment) {
    }
}