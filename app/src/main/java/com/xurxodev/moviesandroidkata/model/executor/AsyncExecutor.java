package com.xurxodev.moviesandroidkata.model.executor;

public interface AsyncExecutor {
    void doInBackground(Runnable task);

    void doOnMainThread(Runnable task);
}
