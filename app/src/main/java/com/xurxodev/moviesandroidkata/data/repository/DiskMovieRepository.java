package com.xurxodev.moviesandroidkata.data.repository;

import com.google.gson.Gson;
import com.xurxodev.moviesandroidkata.data.parser.MovieParser;
import com.xurxodev.moviesandroidkata.domain.repository.MovieRepository;
import com.xurxodev.moviesandroidkata.domain.model.Movie;

import java.util.Arrays;
import java.util.List;

public class DiskMovieRepository implements MovieRepository {
    private final String jsonString;
    private final MovieParser movieParser;

    public DiskMovieRepository(String jsonString, MovieParser movieParser) {
        this.jsonString = jsonString;
        this.movieParser = movieParser;
    }

    @Override
    public List<Movie> getMovies() {
        simulateDelay();
        return movieParser.fromJson(jsonString);
    }

    private void simulateDelay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
