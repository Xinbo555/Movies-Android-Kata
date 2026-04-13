package com.xurxodev.moviesandroidkata.view.movies.fragment;

import com.xurxodev.moviesandroidkata.model.data.Movie;

import java.util.List;

public interface MoviesFragmentView {
    void startLoadMovies();

    void onMoviesLoaded(List<Movie> movies);


}
