package com.xurxodev.moviesandroidkata.adapter.controller;

import com.xurxodev.moviesandroidkata.application.usecase.GetMoviesUseCaseInputPort;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GetMoviesController {
    private final GetMoviesUseCaseInputPort inputPort;

    @Inject
    public GetMoviesController(GetMoviesUseCaseInputPort inputPort) {
        this.inputPort = inputPort;
    }

    public void loadMovies() {
        new Thread(() -> inputPort.getMovies()).start();
    }
}
