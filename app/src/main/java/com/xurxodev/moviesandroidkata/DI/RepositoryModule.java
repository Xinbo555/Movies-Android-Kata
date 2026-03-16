package com.xurxodev.moviesandroidkata.DI;

import com.xurxodev.moviesandroidkata.data.datasource.MoviesLocalDataSource;
import com.xurxodev.moviesandroidkata.data.parser.MovieParser;
import com.xurxodev.moviesandroidkata.data.repository.DiskMovieRepository;
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
    MovieRepository provideModuleRepository(MoviesLocalDataSource dataSource, MovieParser movieParser) {
        String json = dataSource.getMoviesJason();
        return new DiskMovieRepository(json, movieParser);
    }
}
