package com.xurxodev.moviesandroidkata.presenter.detail;

import com.xurxodev.moviesandroidkata.model.movie.Movie;
import com.xurxodev.moviesandroidkata.view.detail.MovieDetailView;
import com.xurxodev.moviesandroidkata.presenter.router.MovieRouter;

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
