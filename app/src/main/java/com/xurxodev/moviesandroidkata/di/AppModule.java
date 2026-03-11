package com.xurxodev.moviesandroidkata.di;

import android.app.Application;

import com.xurxodev.moviesandroidkata.R;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    Application myApplication;

    public AppModule(Application myApplication) {
        this.myApplication = myApplication;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return myApplication;
    }

    @Provides
    @Singleton
    String provideMoviesJson() {
        try {
            InputStream inputStream = myApplication.getResources().openRawResource(R.raw.movies);
            byte[] b = new byte[inputStream.available()];
            inputStream.read(b);
            return new String(b);
        } catch (IOException e) {
            return "";
        }
    }
}
