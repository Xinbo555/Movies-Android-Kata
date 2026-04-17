package com.xurxodev.moviesandroidkata.framework.DI;

import com.xurxodev.moviesandroidkata.adapter.presenter.GetMoviesPresenter;
import com.xurxodev.moviesandroidkata.application.usecase.GetMoviesUseCaseInputPort;
import com.xurxodev.moviesandroidkata.application.usecase.GetMoviesUseCaseInteractor;
import com.xurxodev.moviesandroidkata.application.usecase.GetMoviesUseCaseOutputPort;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class UsecaseModule {
    @Binds
    @Singleton
    abstract GetMoviesUseCaseInputPort bindInteractor(GetMoviesUseCaseInteractor impl);

    @Binds
    @Singleton
    abstract GetMoviesUseCaseOutputPort bindPresenter(GetMoviesPresenter impl);
}
