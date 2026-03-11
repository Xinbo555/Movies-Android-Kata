package com.xurxodev.moviesandroidkata.DI;

import android.app.Application;

import com.xurxodev.moviesandroidkata.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DataSourceModule {
    @Provides
    String provideMoviesJson(Application application) {
            InputStream is = application.getResources().openRawResource(R.raw.movies);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder builder = new StringBuilder();
        try {
            while (br.ready()) {
                builder.append(br.readLine());
            }
        }catch (IOException e){
            System.out.println(" ");
        }
        return builder.toString();
    }
}
