package org.example;

public class Movie {

    private final String name;
    private float rating;
    private String comment;

    public Movie(String name,
                 float rating,
                 String comment) {
        this.name = name;
        this.rating = rating;
        this.comment = comment;
    }

    public Movie copy() {
        return new Movie(name, rating, comment);
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public float getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }
}
