package com.xurxodev.moviesandroidkata.adapter.repository;

import com.xurxodev.moviesandroidkata.adapter.parser.MovieParser;
import com.xurxodev.moviesandroidkata.adapter.source.local.MoviesLocalDataSource;
import com.xurxodev.moviesandroidkata.domain.repository.MovieRepository;
import com.xurxodev.moviesandroidkata.domain.model.Movie;

import java.util.List;

import javax.inject.Inject;

public class DiskMovieRepository implements MovieRepository {
    private final MoviesLocalDataSource moviesLocalDataSource;
    private final MovieParser movieParser;


    @Inject
    public DiskMovieRepository(MoviesLocalDataSource moviesLocalDataSource, MovieParser movieParser) {
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
