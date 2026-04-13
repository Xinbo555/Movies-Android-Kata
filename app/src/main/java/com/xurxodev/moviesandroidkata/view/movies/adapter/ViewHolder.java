package com.xurxodev.moviesandroidkata.view.movies.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.xurxodev.moviesandroidkata.R;
import com.xurxodev.moviesandroidkata.model.data.Movie;

public class ViewHolder extends RecyclerView.ViewHolder {
    public final ImageView movieImageView;
    public final TextView titleTextView;

    public Movie movieItem;

    public ViewHolder(View view) {
        super(view);

        movieImageView = view.findViewById(R.id.item_movie_poster);
        titleTextView = view.findViewById(R.id.item_movie_title);
    }
}
