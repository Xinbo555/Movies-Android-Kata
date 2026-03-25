package com.xurxodev.moviesandroidkata.domain.model;

public class Movie {
    private final String image;
    private final String title;

    private final String description;

    public Movie(String image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
