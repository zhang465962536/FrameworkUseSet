package com.example.general_software_framework.ImageLoader.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.general_software_framework.ImageLoader.Constants;
import com.example.general_software_framework.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

public class ImageloaderViewpagerAdapter  extends PagerAdapter {

    private Context mContext;
    private final ImageLoader imageLoader;
    private DisplayImageOptions options = new DisplayImageOptions.Builder()
            .showImageForEmptyUri(R.drawable.ic_launcher_background)  // 设置图片Uri为空或是错误的时候显示的图片
            .showImageOnFail(R.drawable.ic_launcher_background)       // 设置图片加载或解码过程中发生错误显示的图片
            .resetViewBeforeLoading(true)               // 设置图片在下载前是否重置，复位
            .cacheOnDisc(true)                          // 设置下载的图片是否缓存在SD卡中
            .imageScaleType(ImageScaleType.EXACTLY)     // 设置图片以如何的编码方式显示
            .bitmapConfig(Bitmap.Config.RGB_565)        // 设置图片的解码类型
            .displayer(new FadeInBitmapDisplayer(300))  // 设置图片渐变显示
            .build();
    ;

    public ImageloaderViewpagerAdapter(Context context) {
        mContext = context;

        // 初始化Imageloader
        imageLoader = ImageLoader.getInstance();
    }

    @Override
    public int getCount() {
        return Constants.IMAGES.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // 添加布局文件
        View view = View.inflate(mContext, R.layout.item_imageloader_viewpager, null);

        // 获取控件对象
        ImageView iv = (ImageView) view.findViewById(R.id.iv_imageloader_viewpager);

        // 显示图片
        imageLoader.displayImage(Constants.IMAGES[position], iv, options);

        ((ViewPager) container).addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }
}
