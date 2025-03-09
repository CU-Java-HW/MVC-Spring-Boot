package org.example;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationsService {

    private final MovieService movieService;

    public RecommendationsService(MovieService movieService) {
        this.movieService = movieService;
    }

    public List<Movie> getBestMovies() {
    }
}