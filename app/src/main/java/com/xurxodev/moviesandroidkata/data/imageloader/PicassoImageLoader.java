package com.xurxodev.moviesandroidkata.data.imageloader;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.xurxodev.moviesandroidkata.domain.image.ImageLoader;

public class PicassoImageLoader implements ImageLoader {
    @Override
    public void load(String imageUrl, ImageView imageView) {
        Picasso.get().load(imageUrl).into(imageView);
    }
}
