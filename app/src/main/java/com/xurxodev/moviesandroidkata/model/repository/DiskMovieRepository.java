package com.xurxodev.moviesandroidkata.model.repository;

import com.xurxodev.moviesandroidkata.model.parser.MovieParser;
import com.xurxodev.moviesandroidkata.model.source.local.MoviesLocalDataSource;
import com.xurxodev.moviesandroidkata.model.data.Movie;

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
