package com.xurxodev.moviesandroidkata.adapter.parser;

import com.google.gson.Gson;
import com.xurxodev.moviesandroidkata.domain.model.Movie;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class MovieParser {

    private final Gson gson;
    @Inject
    public MovieParser(Gson gson) {
        this.gson = gson;
    }

    public List<Movie> fromJson(String jsonString) {
        Movie[] movies = gson.fromJson(jsonString, Movie[].class);
        return Arrays.asList(movies);
    }

}
