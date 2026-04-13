package com.xurxodev.moviesandroidkata.presenter.movies;

import com.xurxodev.moviesandroidkata.model.data.Movie;
import com.xurxodev.moviesandroidkata.model.service.MovieListService;
import com.xurxodev.moviesandroidkata.view.movies.fragment.MoviesFragmentView;
import com.xurxodev.moviesandroidkata.presenter.router.MovieRouter;

import javax.inject.Inject;

public class MoviesFragmentPresenter {
    private MoviesFragmentView moviesFragmentView;
    private final MovieListService service;
    private final MovieRouter router;

    @Inject
    public MoviesFragmentPresenter(MovieListService service, MovieRouter router) {
        this.service = service;
        this.router = router;
    }
    public void setFragmentView(MoviesFragmentView view) {
        this.moviesFragmentView = view;
    }

    public void loadMovieList() {
        moviesFragmentView.startLoadMovies();
        service.getMovies(movieList -> {
            if (this.moviesFragmentView != null){
                moviesFragmentView.onMoviesLoaded(movieList);
            }
        });
    }

    public void onMovieClicked(Movie movie) {
        router.goToDetail(movie);
    }

}