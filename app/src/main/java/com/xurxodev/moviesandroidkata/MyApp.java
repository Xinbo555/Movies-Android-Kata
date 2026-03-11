package com.xurxodev.moviesandroidkata;

import android.app.Application;

import com.xurxodev.moviesandroidkata.di.AppComponent;
import com.xurxodev.moviesandroidkata.di.AppModule;
import com.xurxodev.moviesandroidkata.di.DaggerAppComponent;
import com.xurxodev.moviesandroidkata.di.RepositoryModule;

public class MyApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .repositoryModule(new RepositoryModule())
                .build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
