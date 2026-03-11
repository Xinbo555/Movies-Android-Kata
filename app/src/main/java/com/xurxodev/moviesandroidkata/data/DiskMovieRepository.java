package com.xurxodev.moviesandroidkata.data;

import com.google.gson.Gson;
import com.xurxodev.moviesandroidkata.domain.repository.MovieRepository;
import com.xurxodev.moviesandroidkata.domain.model.Movie;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class DiskMovieRepository implements MovieRepository {
    private final String jsonString;

    public DiskMovieRepository(String jsonString) {
        this.jsonString = jsonString;
    }

    @Override
    public List<Movie> getMovies() {

        Gson gson = new Gson();
        Movie[] movies = gson.fromJson(jsonString, Movie[].class);

        simulateDelay();

        return Arrays.asList(movies);
    }

    private void simulateDelay(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
