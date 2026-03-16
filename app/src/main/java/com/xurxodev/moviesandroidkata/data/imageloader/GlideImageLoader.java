package com.xurxodev.moviesandroidkata.data.imageloader;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xurxodev.moviesandroidkata.domain.image.ImageLoader;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;

public class GlideImageLoader implements ImageLoader {
    @Override
    public void load(String imageUrl, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .transform(new GrayscaleTransformation(), new BlurTransformation(5, 2))
                .into(imageView);
    }
}
