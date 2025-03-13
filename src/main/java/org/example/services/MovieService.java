package org.example.services;

import org.example.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final Map<Integer, Movie> movies = new HashMap<>();
    private int nextId = 1;

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie isMovieWithTitleExists(String title) {
        if (title == null) throw new IllegalArgumentException("blank title");

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