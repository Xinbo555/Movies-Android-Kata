package com.xurxodev.moviesandroidkata.data.source;

import android.content.Context;

import com.xurxodev.moviesandroidkata.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.inject.Inject;

import dagger.hilt.android.qualifiers.ApplicationContext;

public class MoviesLocalDataSource {

    private final Context context;

    @Inject
    public MoviesLocalDataSource(@ApplicationContext Context context) {
        this.context = context;
    }

    public String getMoviesJson() {
        InputStream is = context.getResources().openRawResource(R.raw.movies);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();
        try {
            while (br.ready()) {
                builder.append(br.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return builder.toString();
    }
}
