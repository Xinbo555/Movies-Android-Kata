package com.xurxodev.moviesandroidkata.view.imageloader;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;

public class GlideImageLoader implements ImageLoader {

    @Inject
    public GlideImageLoader() {
    }

    @Override
    public void load(String imageUrl, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .transform(new GrayscaleTransformation(), new BlurTransformation(5, 2))
                .into(imageView);
    }
}
