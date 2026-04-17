package com.xurxodev.moviesandroidkata.adapter.persistence;

import com.xurxodev.moviesandroidkata.adapter.persistence.parser.MovieParser;
import com.xurxodev.moviesandroidkata.adapter.persistence.source.local.MoviesLocalDataSource;
import com.xurxodev.moviesandroidkata.domain.repository.MovieRepository;
import com.xurxodev.moviesandroidkata.domain.model.Movie;

import java.util.List;

import javax.inject.Inject;

public class MovieRepositoryImpl implements MovieRepository {
    private final MoviesLocalDataSource moviesLocalDataSource;
    private final MovieParser movieParser;


    @Inject
    public MovieRepositoryImpl(MoviesLocalDataSource moviesLocalDataSource, MovieParser movieParser) {
        this.moviesLocalDataSource = moviesLocalDataSource;
        this.movieParser = movieParser;
    }

    @Override
    public List<Movie> getMovies() {
        simulateDelay();
        return movieParser.fromJson(moviesLocalDataSource.getMoviesJson());
    }

    private void simulateDelay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
