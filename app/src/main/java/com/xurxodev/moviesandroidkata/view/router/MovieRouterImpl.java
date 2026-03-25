package com.xurxodev.moviesandroidkata.view.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.xurxodev.moviesandroidkata.domain.model.Movie;
import com.xurxodev.moviesandroidkata.view.detail.MovieDetailActivity;
import com.xurxodev.moviesandroidkata.view.movies.activity.MoviesActivity;

import javax.inject.Inject;

public class MovieRouterImpl implements MovieRouter{

    private final Context context;

    @Inject
    public MovieRouterImpl(Context context) {
        this.context = context;
    }

    @Override
    public void goToDetail(Movie movie) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra("title",movie.getTitle());
        intent.putExtra("image",movie.getImage());
        intent.putExtra("description",movie.getDescription());
        context.startActivity(intent);
    }

    @Override
    public void goToMovieList() {
        ((Activity)context).finish();
    }
}
