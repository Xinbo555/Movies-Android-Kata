package com.xurxodev.moviesandroidkata.DI;

import android.app.Application;

import com.xurxodev.moviesandroidkata.data.parser.MovieParser;
import com.xurxodev.moviesandroidkata.data.repository.DiskMovieRepository;
import com.xurxodev.moviesandroidkata.data.source.MoviesLocalDataSource;
import com.xurxodev.moviesandroidkata.domain.repository.MovieRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class DataModule {
    @Binds
    @Singleton
    abstract MovieRepository bindModuleRepository(DiskMovieRepository impl);
}
