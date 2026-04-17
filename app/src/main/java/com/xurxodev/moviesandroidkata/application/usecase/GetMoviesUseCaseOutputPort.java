package com.xurxodev.moviesandroidkata.application.usecase;

import com.xurxodev.moviesandroidkata.domain.model.Movie;

import java.util.List;

public interface GetMoviesUseCaseOutputPort {
    void startLoading();
    void onMoviesLoaded(List<Movie> movies);
}
