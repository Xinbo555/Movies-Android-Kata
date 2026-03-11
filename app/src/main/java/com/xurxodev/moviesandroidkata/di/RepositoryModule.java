package com.xurxodev.moviesandroidkata.di;

import com.xurxodev.moviesandroidkata.data.DiskMovieRepository;
import com.xurxodev.moviesandroidkata.domain.repository.MovieRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    @Singleton
    @Provides
    MovieRepository provideMovieRepository(String json) {
        return new DiskMovieRepository(json);
    }
}
