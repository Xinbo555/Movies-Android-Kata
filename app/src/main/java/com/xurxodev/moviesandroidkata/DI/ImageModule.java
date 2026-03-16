package com.xurxodev.moviesandroidkata.DI;

import com.xurxodev.moviesandroidkata.data.imageloader.PicassoImageLoader;
import com.xurxodev.moviesandroidkata.domain.image.ImageLoader;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class ImageModule {

    @Provides
    ImageLoader provideImageProvider() {
        return new PicassoImageLoader();
    }
}
