package com.xurxodev.moviesandroidkata.domain.usecase;

import android.os.AsyncTask;

import com.xurxodev.moviesandroidkata.domain.Callback;
import com.xurxodev.moviesandroidkata.domain.repository.MovieRepository;
import com.xurxodev.moviesandroidkata.domain.model.Movie;

import java.util.List;

public class GetMoviesUseCase {
    private final MovieRepository movieRepository;

    public GetMoviesUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void execute(Callback<List<Movie>> callback){
        new AsyncTask<Void, Void, List<Movie>>() {
            @Override
            protected List<Movie> doInBackground(Void... params) {
                return movieRepository.getMovies();
            }

            @Override
            protected void onPostExecute(List<Movie> movies) {
                callback.onResult(movies);
            }
        }.execute();
    }
}
