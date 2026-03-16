package com.xurxodev.moviesandroidkata.data.datasource;

import android.content.Context;

import com.xurxodev.moviesandroidkata.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.inject.Inject;

public class MoviesLocalDataSource {

    private final Context context;

    @Inject
    public MoviesLocalDataSource(Context context) {
        this.context = context;
    }

    public String getMoviesJason() {
        InputStream is = context.getResources().openRawResource(R.raw.movies);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();
        try {
            while (br.ready()) {
                builder.append(br.readLine());
            }
        } catch (IOException e) {
            System.out.println(" ");
        }
        return builder.toString();
    }
}
