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
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody Movie request) {
        try {
            movieService.addMovie(request);
            return ResponseEntity.status(HttpStatus.CREATED).body("Фильм добавлен");
        } catch  (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/{id}/rating")
    public ResponseEntity<String> updateMovieRating(@PathVariable int id, @RequestParam float newRating) {
        try {
            movieService.updateMovieRating(id, newRating);
            return ResponseEntity.status(HttpStatus.OK).body("Обновлено");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/{id}/comment")
    public ResponseEntity<String> updateMovieComment(@PathVariable int id, @RequestParam String newComment) {
        try {
            movieService.updateMovieComment(id, newComment);
            return ResponseEntity.status(HttpStatus.OK).body("Обновлено");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
