package com.xurxodev.moviesandroidkata.view.detail;

import com.xurxodev.moviesandroidkata.domain.model.Movie;
import com.xurxodev.moviesandroidkata.view.router.MovieRouter;

import javax.inject.Inject;

public class MovieDetailPresenter {
    private final MovieRouter router;

    private MovieDetailView view;

    @Inject
    public MovieDetailPresenter(MovieRouter router) {
        this.router = router;
    }

    public void setView(MovieDetailView view){
        this.view = view;
    }

    public void displayMovie(Movie movie) {
        view.loadMovie(movie);
    }

    public void onBackPressed() {
        router.goToMovieList();
    }
}
