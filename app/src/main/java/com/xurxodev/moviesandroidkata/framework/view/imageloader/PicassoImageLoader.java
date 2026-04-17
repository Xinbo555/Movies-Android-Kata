package com.xurxodev.moviesandroidkata.framework.view.imageloader;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class PicassoImageLoader implements ImageLoader {

    @Inject
    public PicassoImageLoader() {
    }


    @Override
    public void load(String imageUrl, ImageView imageView) {
        Picasso.get().load(imageUrl).into(imageView);
    }
}
