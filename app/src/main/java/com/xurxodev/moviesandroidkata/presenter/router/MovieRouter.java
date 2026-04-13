package com.xurxodev.moviesandroidkata.presenter.router;

import com.xurxodev.moviesandroidkata.model.data.Movie;

public interface MovieRouter {
    void goToDetail(Movie movie);

    void goToMovieList();
}
