package com.xurxodev.moviesandroidkata.domain.model;

public class Movie {
    private final String image;
    private final String title;

    public Movie(String image, String title) {
        this.image = image;
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
}
