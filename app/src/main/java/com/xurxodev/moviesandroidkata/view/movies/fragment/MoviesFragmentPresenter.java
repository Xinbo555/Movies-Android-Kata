package com.xurxodev.moviesandroidkata.view.movies.fragment;

import com.xurxodev.moviesandroidkata.domain.model.Movie;
import com.xurxodev.moviesandroidkata.domain.usecase.GetMoviesUseCase;
import com.xurxodev.moviesandroidkata.view.imageloader.ImageLoader;
import com.xurxodev.moviesandroidkata.view.movies.adapter.MoviesAdapter;
import com.xurxodev.moviesandroidkata.view.router.MovieRouter;

import javax.inject.Inject;

public class MoviesFragmentPresenter {
    private MoviesFragmentView moviesFragmentView;
    private final GetMoviesUseCase getMoviesUseCase;
    private final MovieRouter router;
    private final ImageLoader imageLoader;

    @Inject
    public MoviesFragmentPresenter(GetMoviesUseCase getMoviesUseCase, MovieRouter router, ImageLoader imageLoader) {
        this.getMoviesUseCase = getMoviesUseCase;
        this.router = router;
        this.imageLoader = imageLoader;
    }
    public void setFragmentView(MoviesFragmentView view) {
        this.moviesFragmentView = view;
    }

    void loadMovieList() {
        moviesFragmentView.startLoadMovies();
        getMoviesUseCase.getMovies(movieList -> {
            if (this.moviesFragmentView != null){
                moviesFragmentView.onMoviesLoaded(movieList);
            }
        });
    }

    public MoviesAdapter createAdapter() {
        return new MoviesAdapter(imageLoader,movie -> onMovieClicked(movie));
    }

    public void onMovieClicked(Movie movie) {
        router.goToDetail(movie);
    }

}