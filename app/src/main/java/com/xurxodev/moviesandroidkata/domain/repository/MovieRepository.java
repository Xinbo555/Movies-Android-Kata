package com.xurxodev.moviesandroidkata.domain.repository;

import com.xurxodev.moviesandroidkata.domain.model.Movie;

import java.util.List;

public interface MovieRepository {
    public List<Movie> getMovies();
}
