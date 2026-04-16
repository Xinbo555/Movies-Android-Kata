package com.xurxodev.moviesandroidkata.model.DI;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class SerializationModule {

    @Provides
    @Singleton
    Gson provideGson() {
        return new Gson();
    }
}
