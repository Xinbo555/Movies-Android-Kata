package com.xurxodev.moviesandroidkata.view.movies.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.xurxodev.moviesandroidkata.R;
import com.xurxodev.moviesandroidkata.view.movies.fragment.MoviesMoviesFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MoviesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        initializeToolBar();

        if (savedInstanceState == null) {
            showDetailFragment();
        }
    }

    private void showDetailFragment() {
        MoviesMoviesFragment fragment = new MoviesMoviesFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.movies_list_container, fragment)
                .commit();
    }

    private void initializeToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
