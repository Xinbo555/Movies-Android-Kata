package com.xurxodev.moviesandroidkata.DI;

import android.os.Handler;
import android.os.Looper;

import com.xurxodev.moviesandroidkata.data.executor.ThreadAsyncExecutor;
import com.xurxodev.moviesandroidkata.domain.executor.AsyncExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class ConcurrencyModule {
    @Provides
    @Singleton
    public static Executor provideThread(){
        return Executors.newCachedThreadPool();
    }

    @Provides
    @Singleton
    public static Handler provideHandler() {
        return new Handler(Looper.getMainLooper());
    }

    @Binds
    @Singleton
    abstract AsyncExecutor bindAsyncExecutor(ThreadAsyncExecutor impl);

}
