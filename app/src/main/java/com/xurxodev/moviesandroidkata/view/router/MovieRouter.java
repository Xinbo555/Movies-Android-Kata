package com.xurxodev.moviesandroidkata.view.router;

import com.xurxodev.moviesandroidkata.domain.model.Movie;

public interface MovieRouter {
    void goToDetail(Movie movie);

    void goToMovieList();
}
