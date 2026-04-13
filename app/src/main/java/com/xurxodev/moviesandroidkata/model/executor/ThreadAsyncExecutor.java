package com.xurxodev.moviesandroidkata.model.executor;

import android.os.Handler;

import java.util.concurrent.Executor;

import javax.inject.Inject;

public class ThreadAsyncExecutor implements AsyncExecutor {

    private final Executor executor;
    private final Handler mainHandler;

    @Inject
    public ThreadAsyncExecutor(Executor executor, Handler mainHandler) {
        this.executor = executor;
        this.mainHandler = mainHandler;
    }

    @Override
    public void doInBackground(Runnable task) {
        executor.execute(task);
    }

    @Override
    public void doOnMainThread(Runnable task) {
        mainHandler.post(task);
    }
}
