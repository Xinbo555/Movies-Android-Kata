package com.xurxodev.moviesandroidkata.view.fragment;

import com.xurxodev.moviesandroidkata.domain.model.Movie;

import java.util.List;

public interface FragmentView {
    void startLoadMovies();

    void onMoviesLoaded(List<Movie> movies);


}
