package com.xurxodev.moviesandroidkata.domain.usecase;

import com.xurxodev.moviesandroidkata.domain.executor.AsyncExecutor;
import com.xurxodev.moviesandroidkata.domain.repository.MovieRepository;
import com.xurxodev.moviesandroidkata.domain.model.Movie;

import java.util.List;

import javax.inject.Inject;

public class GetMoviesUseCase {
    private final MovieRepository movieRepository;
    private final AsyncExecutor asyncExecutor;
    @Inject
    public GetMoviesUseCase(MovieRepository movieRepository, AsyncExecutor asyncExecutor) {
        this.movieRepository = movieRepository;
        this.asyncExecutor = asyncExecutor;
    }

    public void getMovies(Callback callback) {
        asyncExecutor.doInBackground(() -> {
            List<Movie> movies = movieRepository.getMovies();
            asyncExecutor.doOnMainThread(() -> callback.onResult(movies));
        });
    }

    public interface Callback {
        void onResult(List<Movie> result);
    }
}
