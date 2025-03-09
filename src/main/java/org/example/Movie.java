package org.example;

public class Movie {

    private final int id;
    private final String title;
    private float rating;
    private String comment;

    public Movie(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Movie(int id, String title, float rating) {
        this.id = id;
        this.title = title;
        this.rating = rating;
    }

    public Movie(String comment, String title, int id) {
        this.comment = comment;
        this.title = title;
        this.id = id;
    }

    public Movie(String title, float rating, String comment, int id) {
        this.title = title;
        this.rating = rating;
        this.comment = comment;
        this.id = id;
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
