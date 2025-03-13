package org.example.services;

import org.example.Movie;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieService {

    private final Map<Integer, Movie> movies = new HashMap<>();
    private int nextId = 1;

    public void addMovie(String title, float rating, String comment) {
        Movie movie = new Movie(title, rating, comment, nextId);
        movies.put(nextId++, movie);
    }

    public List<Movie> getAllMovies() {
        return (List<Movie>) movies.values();
    }

    public boolean isMovieWithTitleExists(String title) {
        if (title == null) throw new IllegalArgumentException("blank title");

        for (Movie movie : getAllMovies()) {
            if (movie.getTitle() == title) {
                return true;
            }
        }

        return false;
    }

    public boolean isMovieWithIdExists(int id) {
        if (movies.containsKey(id)) {
            return true;
        }
        return false;
    }

    public Movie getMovieById(int id) {
        if (isMovieWithIdExists(id)) {
            return Movie
        }
        for (Movie movie : getAllMovies()) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public void updateMovieRating(int id, float newRating) {
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                movie.setRating(newRating);
                return;
            }
        }
    }

    public void updateMovieComment(int id, String newComment) {
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                movie.setComment(newComment);
                return;
            }
        }
    }
}
