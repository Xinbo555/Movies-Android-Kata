package com.xurxodev.moviesandroidkata.DI;

import com.xurxodev.moviesandroidkata.view.imageloader.GlideImageLoader;
import com.xurxodev.moviesandroidkata.view.imageloader.PicassoImageLoader;
import com.xurxodev.moviesandroidkata.view.imageloader.ImageLoader;

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
    abstract ImageLoader bindImageProvider(GlideImageLoader impl);
}
