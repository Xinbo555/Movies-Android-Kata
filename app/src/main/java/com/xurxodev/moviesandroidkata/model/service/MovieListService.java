package com.xurxodev.moviesandroidkata.model.service;

import android.os.AsyncTask;

import com.xurxodev.moviesandroidkata.model.repository.MovieRepository;
import com.xurxodev.moviesandroidkata.model.movie.Movie;

import java.util.List;
import java.util.function.Consumer;

import javax.inject.Inject;

public class MovieListService {
    private final MovieRepository movieRepository;
    @Inject
    public MovieListService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void getMovies(Consumer<List<Movie>> onMoviesLoaded) {
        AsyncTask<Void, Void, List<Movie>> moviesAsyncTask =
                new AsyncTask<Void, Void, List<Movie>>() {
                    @Override
                    protected List<Movie> doInBackground(Void... params) {
                        return movieRepository.getMovies();
                    }

                    @Override
                    protected void onPostExecute(List<Movie> movies) {
                        onMoviesLoaded.accept(movies);
                    }
                };

        moviesAsyncTask.execute();
    }
}
