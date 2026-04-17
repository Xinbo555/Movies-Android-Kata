package com.xurxodev.moviesandroidkata.framework.DI;

import com.xurxodev.moviesandroidkata.adapter.repository.DiskMovieRepository;
import com.xurxodev.moviesandroidkata.domain.repository.MovieRepository;

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
