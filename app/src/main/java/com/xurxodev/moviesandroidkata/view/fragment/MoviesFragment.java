package com.xurxodev.moviesandroidkata.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;import androidx.recyclerview.widget.RecyclerView;

import com.xurxodev.moviesandroidkata.MyApp;
import com.xurxodev.moviesandroidkata.R;
import com.xurxodev.moviesandroidkata.domain.model.Movie;
import com.xurxodev.moviesandroidkata.domain.usecase.GetMoviesUseCase;
import com.xurxodev.moviesandroidkata.view.adapter.MoviesAdapter;

import java.util.List;

import javax.inject.Inject;

public class MoviesFragment extends Fragment {
    private MoviesAdapter adapter;
    private RecyclerView recyclerView;
    private View rootView;
    private TextView moviesCountTextView;
    private ImageButton refreshButton;

    @Inject
    GetMoviesUseCase getMoviesUseCase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_movies, container, false);

        ((MyApp)getActivity().getApplication()).getAppComponent().inject(this);

        initializeTitle();
        initializeRefreshButton();
        initializeAdapter();
        initializeRecyclerView();

        loadMovies();

        return rootView;
    }

    private void initializeTitle() {
        moviesCountTextView = (TextView) rootView.findViewById(
                R.id.movies_title_text_view);
    }

    private void initializeRefreshButton(){
        refreshButton = (ImageButton) rootView.findViewById(
                R.id.refresh_button);

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadMovies();
            }
        });
    }

    private void initializeAdapter() {
        adapter = new MoviesAdapter();
    }

    private void initializeRecyclerView() {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_movies);
        recyclerView.setAdapter(adapter);
    }

    private void loadMovies() {
        loadingMovies();

        getMoviesUseCase.execute(this::loadedMovies);
    }

    private void loadingMovies(){
        adapter.clearMovies();
        moviesCountTextView.setText(R.string.loading_movies_text);
    }

    private void loadedMovies(List<Movie> movies){
        adapter.setMovies(movies);
        refreshTitleWithMoviesCount(movies);
    }

    private void refreshTitleWithMoviesCount(List<Movie> movies) {
        String countText = getString(R.string.movies_count_text);

        moviesCountTextView.setText(String.format(countText, movies.size()));
    }
}
