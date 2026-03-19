package com.xurxodev.moviesandroidkata.data.executor;

import android.os.Handler;
import android.os.Looper;

import com.xurxodev.moviesandroidkata.domain.executor.AsyncExecutor;

import javax.inject.Inject;

public class ThreadAsyncExecutor implements AsyncExecutor {
    @Inject
    public ThreadAsyncExecutor() {
    }

    @Override
    public void doInBackground(Runnable task) {
        new Thread(task).start();
    }

    @Override
    public void doOnMainThread(Runnable task) {
        new Handler(Looper.getMainLooper()).post(task);
    }
}
