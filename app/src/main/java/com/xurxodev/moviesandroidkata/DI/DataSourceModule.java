package com.xurxodev.moviesandroidkata.DI;

import android.app.Application;
import android.content.Context;

import com.xurxodev.moviesandroidkata.R;
import com.xurxodev.moviesandroidkata.data.datasource.MoviesLocalDataSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DataSourceModule {
    @Provides
    MoviesLocalDataSource provideMoviesLocalDataSource(Application application) {
        return new MoviesLocalDataSource(application);
    }
}
