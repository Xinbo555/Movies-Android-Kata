package com.xurxodev.moviesandroidkata.adapter.presenter;

import android.os.Handler;

import com.xurxodev.moviesandroidkata.application.usecase.GetMoviesUseCaseOutputPort;
import com.xurxodev.moviesandroidkata.domain.model.Movie;

import java.util.List;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GetMoviesPresenter implements GetMoviesUseCaseOutputPort {
    private Consumer<List<Movie>> onMoviesReadyListener;
    private Runnable onLoading;

    @Inject
    Handler mainHandler;

    @Inject
    public GetMoviesPresenter() {
    }

    public void setOnMoviesReadyListener(Consumer<List<Movie>> onMoviesReadyListener) {
        this.onMoviesReadyListener = onMoviesReadyListener;
    }

    public void setOnLoading(Runnable onLoading) {
        this.onLoading = onLoading;
    }

    @Override
    public void startLoading() {
        mainHandler.post(() -> onLoading.run());
    }

    @Override
    public void onMoviesLoaded(List<Movie> movies) {
        mainHandler.post(() -> onMoviesReadyListener.accept(movies));
    }
}
