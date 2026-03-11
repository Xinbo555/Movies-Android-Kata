package com.xurxodev.moviesandroidkata.DI;

import com.xurxodev.moviesandroidkata.data.DiskMovieRepository;
import com.xurxodev.moviesandroidkata.domain.repository.MovieRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {

    @Provides
    @Singleton
    MovieRepository provideModuleRepository(String json) {
        return new DiskMovieRepository(json);
    }
}
