package com.xurxodev.moviesandroidkata.view.movies.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.xurxodev.moviesandroidkata.R;
import com.xurxodev.moviesandroidkata.model.data.Movie;
import com.xurxodev.moviesandroidkata.presenter.movies.MoviesFragmentPresenter;
import com.xurxodev.moviesandroidkata.view.imageloader.ImageLoader;
import com.xurxodev.moviesandroidkata.view.movies.adapter.MoviesAdapter;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MoviesFragment extends Fragment implements MoviesFragmentView {

    private MoviesAdapter adapter;
    private RecyclerView recyclerView;
    private View rootView;
    private TextView moviesCountTextView;
    private ImageButton refreshButton;

    @Inject
    ImageLoader imageLoader;

    @Inject
    MoviesFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_movies, container, false);


        initializeTitle();
        initializeRefreshButton();
        initializeAdapter();
        initializeRecyclerView();

        presenter.setFragmentView(this);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter.loadMovieList();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.setFragmentView(null);
    }

    private void initializeTitle() {
        moviesCountTextView = rootView.findViewById(
                R.id.movies_title_text_view);
    }

    private void initializeRefreshButton() {
        refreshButton = rootView.findViewById(
                R.id.refresh_button);

        refreshButton.setOnClickListener(view -> presenter.loadMovieList());
    }

    private void initializeAdapter() {
        adapter = new MoviesAdapter(imageLoader,movie -> presenter.onMovieClicked(movie));
    }

    private void initializeRecyclerView() {
        recyclerView = rootView.findViewById(R.id.recyclerview_movies);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void startLoadMovies() {
        adapter.clearMovies();
        moviesCountTextView.setText(R.string.loading_movies_text);
    }

    @Override
    public void onMoviesLoaded(List<Movie> movies) {
        String countText = getString(R.string.movies_count_text,movies.size());
        moviesCountTextView.setText(countText);
        adapter.setMovies(movies);
    }
}
