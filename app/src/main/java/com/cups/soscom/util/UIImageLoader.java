package com.cups.soscom.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * Created by ekobudiarto on 6/6/17.
 */

public class UIImageLoader {

    Context mContext;
    DisplayImageOptions opt;
    ImageLoader imageLoader;

    public UIImageLoader(Context context)
    {
        this.mContext = context;
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(mContext)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .discCacheFileNameGenerator(new Md5FileNameGenerator())
                .threadPoolSize(5)
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .build();
        ImageLoader.getInstance().init(config);


        opt = new DisplayImageOptions.Builder()
                .cacheInMemory(false)
                .cacheOnDisc(true)
                .considerExifParams(true)
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();

        imageLoader = ImageLoader.getInstance();
    }

    public void showImage(String path, ImageAware imageAware)
    {
        imageLoader.displayImage(path, imageAware, opt);
    }

    public void showImage(String path, ImageAware imageAware, ImageLoadingListener listener)
    {
        imageLoader.displayImage(path, imageAware, opt, listener);
    }

    public void showImage(String path, ImageView imageView)
    {
        imageLoader.displayImage(path, imageView, opt);
    }

    public void showImage(String path, ImageView imageView, ImageLoadingListener listener)
    {
        imageLoader.displayImage(path, imageView, opt, listener);
    }
}
