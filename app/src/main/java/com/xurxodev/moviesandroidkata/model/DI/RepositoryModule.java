package com.xurxodev.moviesandroidkata.model.DI;

import com.xurxodev.moviesandroidkata.model.repository.DiskMovieRepository;
import com.xurxodev.moviesandroidkata.model.repository.MovieRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract MovieRepository bindModuleRepository(DiskMovieRepository impl);
}
