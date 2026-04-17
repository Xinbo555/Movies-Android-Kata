package com.xurxodev.moviesandroidkata.framework.DI;

import android.os.Handler;
import android.os.Looper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class ThreadModule {

    @Provides
    @Singleton
    public Handler provideMainHandler(){
        return new Handler(Looper.getMainLooper());
    }
}
