package org.example.services;

import org.example.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieService {

    private final Map<Integer, Movie> movies = new HashMap<>();
    private int nextId = 1;

    public void addMovie(Movie movie) throws IllegalArgumentException {
        if (!isMovieWithTitleExists(movie.getName())) {
            movies.put(nextId++, movie);
        } else {
            throw new IllegalArgumentException("title already exists");
        }
    }

    public List<Movie> getAllMovies() {
        List<Movie> copyList = new ArrayList<>();
        for (Movie movie : movies.values()) {
            copyList.add(movie.copy());
        }
        return copyList;
    }

    public boolean isMovieWithTitleExists(String title) throws IllegalArgumentException {
        if (title == null) throw new IllegalArgumentException("blank title");

        for (Movie movie : getAllMovies()) {
            if (movie.getName().equals(title)) {
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

    public Movie getMovieById(int id) throws IllegalArgumentException {
        if (isMovieWithIdExists(id)) {
            return movies.get(id);
        }
        throw new IllegalArgumentException("id not found");
    }

    public void updateMovieRating(int id, float newRating) throws IllegalArgumentException {
        if (isMovieWithIdExists(id)) {
            movies.get(id).setRating(newRating);
        } else {
            throw new IllegalArgumentException("id not found");
        }
    }

    public void updateMovieComment(int id, String newComment) throws IllegalArgumentException {
        if (isMovieWithIdExists(id)) {
            movies.get(id).setComment(newComment);
        } else {
            throw new IllegalArgumentException("id not found");
        }
    }
}
