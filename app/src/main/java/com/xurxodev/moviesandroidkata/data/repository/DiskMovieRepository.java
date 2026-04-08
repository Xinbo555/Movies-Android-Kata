package com.xurxodev.moviesandroidkata.data.repository;

import com.xurxodev.moviesandroidkata.data.parser.MovieParser;
import com.xurxodev.moviesandroidkata.data.source.MoviesLocalDataSource;
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
        return movieParser.fromJson(moviesLocalDataSource.getMoviesJson());
    }
}
