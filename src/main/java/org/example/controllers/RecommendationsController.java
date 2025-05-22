package org.example.controllers;

import org.example.Movie;
import org.example.services.RecommendationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationsController {

    private final RecommendationsService recommendationsService;

    @Autowired
    public RecommendationsController(RecommendationsService recommendationsService) {
        this.recommendationsService = recommendationsService;
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<Movie>> getSortedMovies() {
        return ResponseEntity.ok(recommendationsService.sortMoviesByRating());
    }

    @GetMapping("/best")
    public ResponseEntity<List<Movie>> getBestMovies() {
        return ResponseEntity.ok(recommendationsService.getBestMovies());
    }
}