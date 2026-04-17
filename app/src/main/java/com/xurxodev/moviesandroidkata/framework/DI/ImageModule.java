package com.xurxodev.moviesandroidkata.framework.DI;

import com.xurxodev.moviesandroidkata.framework.view.imageloader.PicassoImageLoader;
import com.xurxodev.moviesandroidkata.framework.view.imageloader.ImageLoader;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class ImageModule {

    @Binds
    @Singleton
    abstract ImageLoader bindImageProvider(PicassoImageLoader impl);
}
