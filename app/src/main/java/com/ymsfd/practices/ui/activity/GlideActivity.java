package com.ymsfd.practices.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.ymsfd.practices.R;

/**
 * Created by WoodenTea.
 * Date: 2015/12/9
 * Time: 17:01
 */
public class GlideActivity extends BaseActivity {
    ImageView imageView;

    @Override
    protected boolean _onCreate(Bundle savedInstanceState) {
        if (!super._onCreate(savedInstanceState)) {
            return false;
        }

        setContentView(R.layout.actvt_glide);
        imageView = (ImageView) findViewById(R.id.imageView);
        Glide.with(this)
                .load("http://testecshop2.magicwe.com/" +
                        "images/201509/source_img/793_G_1441785900196.jpg")
                .asBitmap()
                .listener(new RequestListener<String, Bitmap>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<Bitmap> target,
                                               boolean isFirstResource) {
                        e.printStackTrace();
                        Intent intent = new Intent(GlideActivity.this, TestActivity.class);
                        startActivity(intent);
                        return true;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap>
                            target, boolean isFromMemoryCache, boolean isFirstResource) {
                        return false;
                    }
                })
                .error(R.drawable.cartoon)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap>
                            glideAnimation) {
                        D("Ready");
                        D("Size->" + resource.getByteCount());
                    }

                    @Override
                    public void onLoadFailed(Exception e, final Drawable errorDrawable) {
                        D("Failed");
                        e.printStackTrace();
                        new AsyncTask<Void, Void, Void>() {
                            @Override
                            protected Void doInBackground(Void... voids) {
                                return null;
                            }

                            @Override
                            protected void onPostExecute(Void aVoid) {
                                super.onPostExecute(aVoid);
//                                imageView.setImageResource(R.drawable.cartoon);
//                                imageView.setImageDrawable(errorDrawable);
//                                Intent intent = new Intent(GlideActivity.this, TestActivity.class);
//                                startActivity(intent);
                            }
                        }.execute();

                    }
                })
        ;

//        Glide.with(this)
//                .load("http://5.26923" +
//                        ".com/download/pic/000/263/ff5bc9a1c0386778a0ba1a783fd0fa2c.jpg")
//                .downloadOnly(new SimpleTarget<File>() {
//                    @Override
//                    public void onResourceReady(File resource, GlideAnimation<? super File>
//                            glideAnimation) {
//                        D("Path->" + resource.getPath() + " " + resource.exists());
//                    }
//                })
//        ;

//        Glide.with(this).load("http://5.26923" +
//                ".com/download/pic/000/263/ff5bc9a1c0386778a0ba1a783fd0fa2c.jpg").asBitmap()
//                .listener(new RequestListener<String, Bitmap>() {
//                    @Override
//                    public boolean onException(Exception e, String model, Target<Bitmap> target,
//                                               boolean isFirstResource) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap>
//                            target, boolean isFromMemoryCache, boolean isFirstResource) {
//                        D("ResourceReady");
//                        return false;
//                    }
//                })
//                .centerCrop()
//                .into(new BitmapImageViewTarget(imageView) {
//                    @Override
//                    protected void setResource(Bitmap resource) {
//                        RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create
//                                (getResources(), resource);
//                        drawable.setCornerRadius(20.0f);
//                        drawable.setCircular(true);
//                        drawable.setAntiAlias(true);
//                        view.setImageDrawable(drawable);
//                    }
//                });

        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        GlideDrawableImageViewTarget target = new GlideDrawableImageViewTarget(imageView2);
        Glide.with(this).load("http://pic.joke01.com/uppic/13-05/30/30215236.gif").placeholder(R
                .drawable.cartoon).error(R.drawable.border_circle).into(target);

        return true;
    }
}
