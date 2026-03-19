package com.xurxodev.moviesandroidkata.domain.executor;

public interface AsyncExecutor {
    void doInBackground(Runnable task);

    void doOnMainThread(Runnable task);
}
