package com.xurxodev.moviesandroidkata.view.detail;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.xurxodev.moviesandroidkata.R;
import com.xurxodev.moviesandroidkata.model.data.Movie;
import com.xurxodev.moviesandroidkata.presenter.detail.MovieDetailPresenter;
import com.xurxodev.moviesandroidkata.view.imageloader.ImageLoader;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MovieDetailActivity extends AppCompatActivity implements MovieDetailView{

    private ImageView ivMovie;
    private TextView tvTitle;
    private TextView tvDescription;

    @Inject
    MovieDetailPresenter presenter;

    @Inject
    ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        initUI();
        configureActionBar();

        presenter.setView(this);
        presenter.displayMovie(getMovieFromIntent());
    }

    private void initUI() {
        initializeTitle();
        initializeDescription();
        initializeImage();
    }

    private void configureActionBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initializeImage() {
        this.ivMovie = findViewById(R.id.iv_movie);
    }

    private void initializeTitle() {
        this.tvTitle = findViewById(R.id.tv_title);
    }

    private void initializeDescription() {
        this.tvDescription = findViewById(R.id.tv_description);
    }

    private Movie getMovieFromIntent() {
        String title = getIntent().getStringExtra("title");
        String image = getIntent().getStringExtra("image");
        String description = getIntent().getStringExtra("description");
        return new Movie(image,title,description);
    }

    @Override
    public void loadMovie(Movie movie) {
        imageLoader.load(movie.getImage(),this.ivMovie);
        this.tvTitle.setText(movie.getTitle());
        this.tvDescription.setText(movie.getDescription());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            presenter.onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}