package com.xurxodev.moviesandroidkata.application.usecase;

import com.xurxodev.moviesandroidkata.domain.repository.MovieRepository;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GetMoviesUseCaseInteractor implements GetMoviesUseCaseInputPort{
    private final MovieRepository movieRepository;
    private final GetMoviesUseCaseOutputPort outputPort;
    @Inject
    public GetMoviesUseCaseInteractor(MovieRepository movieRepository, GetMoviesUseCaseOutputPort outputPort) {
        this.movieRepository = movieRepository;
        this.outputPort = outputPort;
    }

    @Override
    public void getMovies() {
        outputPort.startLoading();
        outputPort.onMoviesLoaded(movieRepository.getMovies());
    }
}
