package org.example;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie getMovieByTitle(String title) {
        if (title == null) return null;

        for (Movie movie : movies) {
            if (movie.getTitle() == title) {
                return movie;
            }
        }

        return null;
    }

    public void updateMovieRating(String title, float newRating) {
        if (title == null) return;

        for (Movie movie : movies) {
            if (movie.getTitle() == title) {
                movie.setRating(newRating);
            }
        }
    }

    public void updateMovieComment(String title, String newComment) {
        if (title == null) return;

        for (Movie movie : movies) {
            if (movie.getTitle() == title) {
                movie.setComment(newComment);
            }
        }
    }
}