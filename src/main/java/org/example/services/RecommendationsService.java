package org.example.services;

import org.example.Movie;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationsService {

    private final MovieService movieService;

    public RecommendationsService(MovieService movieService) {
        this.movieService = movieService;
    }

    public List<Movie> sortMoviesByRating() {
        return movieService.getAllMovies().stream().sorted(Comparator.comparing(Movie::getRating).reversed()).collect(Collectors.toList());
    }

    public List<Movie> getBestMovies() {
        return movieService.getAllMovies().stream().sorted(Comparator.comparing(Movie::getRating).reversed()).limit(5).collect(Collectors.toList());
    }
}