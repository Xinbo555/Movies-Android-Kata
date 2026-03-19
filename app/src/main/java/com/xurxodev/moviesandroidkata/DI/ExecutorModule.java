package com.xurxodev.moviesandroidkata.DI;

import com.xurxodev.moviesandroidkata.data.executor.ThreadAsyncExecutor;
import com.xurxodev.moviesandroidkata.domain.executor.AsyncExecutor;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class ExecutorModule {

    @Binds
    @Singleton
    abstract AsyncExecutor bindAsyncExecutor(ThreadAsyncExecutor impl);
}
