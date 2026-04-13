package com.xurxodev.moviesandroidkata.model.service;

import com.xurxodev.moviesandroidkata.model.executor.AsyncExecutor;
import com.xurxodev.moviesandroidkata.model.repository.MovieRepository;
import com.xurxodev.moviesandroidkata.model.data.Movie;

import java.util.List;
import java.util.function.Consumer;

import javax.inject.Inject;

public class MovieListService {
    private final MovieRepository movieRepository;
    private final AsyncExecutor asyncExecutor;
    @Inject
    public MovieListService(MovieRepository movieRepository, AsyncExecutor asyncExecutor) {
        this.movieRepository = movieRepository;
        this.asyncExecutor = asyncExecutor;
    }

    public void getMovies(Consumer<List<Movie>> onMoviesLoaded) {
        asyncExecutor.doInBackground(() -> {
            List<Movie> movies = movieRepository.getMovies();
            asyncExecutor.doOnMainThread(() -> onMoviesLoaded.accept(movies));
        });
    }
}
