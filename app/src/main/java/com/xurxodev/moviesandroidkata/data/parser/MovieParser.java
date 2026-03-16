package com.xurxodev.moviesandroidkata.data.parser;

import com.google.gson.Gson;
import com.xurxodev.moviesandroidkata.domain.model.Movie;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class MovieParser {
    @Inject
    public MovieParser() {
    }

    public List<Movie> fromJson(String jsonString) {
        Gson gson = new Gson();
        Movie[] movies = gson.fromJson(jsonString, Movie[].class);
        return Arrays.asList(movies);
    }

}
