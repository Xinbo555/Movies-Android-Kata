package com.xurxodev.moviesandroidkata.DI;

import android.content.Context;

import com.xurxodev.moviesandroidkata.view.router.MovieRouter;
import com.xurxodev.moviesandroidkata.view.router.MovieRouterImpl;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.qualifiers.ActivityContext;

@Module
@InstallIn(ActivityComponent.class)
public class NavigationModule {

    @Provides
    public MovieRouter provideMovieRouter(@ActivityContext Context context) {
        return new MovieRouterImpl(context);
    }
}
