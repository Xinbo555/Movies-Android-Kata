package com.xurxodev.moviesandroidkata.view.fragment;

import com.xurxodev.moviesandroidkata.domain.usecase.GetMoviesUseCase;

import javax.inject.Inject;

public class FragmentPresenter {
    private FragmentView fragmentView;
    private final GetMoviesUseCase getMoviesUseCase;

    @Inject
    public FragmentPresenter(GetMoviesUseCase getMoviesUseCase) {
        this.getMoviesUseCase = getMoviesUseCase;
    }
    public void setFragmentView(FragmentView view) {
        this.fragmentView = view;
    }

    void loadMovieList() {
        fragmentView.startLoadMovies();
        getMoviesUseCase.getMovies(movieList -> {
            if (this.fragmentView != null){
                fragmentView.onMoviesLoaded(movieList);
            }
        });
    }

}
