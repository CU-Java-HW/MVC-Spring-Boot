package org.example;

public class Movie {

    private final String title;
    private float rating;
    private String comment;

    public Movie(String title) {
        this.title = title;
    }

    public Movie(String title, float rating) {
        this.title = title;
        this.rating = rating;
    }

    public Movie(String comment, String title) {
        this.comment = comment;
        this.title = title;
    }

    public Movie(String title, float rating, String comment) {
        this.title = title;
        this.rating = rating;
        this.comment = comment;
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

    public String getTitle() {
        return title;
    }
}
