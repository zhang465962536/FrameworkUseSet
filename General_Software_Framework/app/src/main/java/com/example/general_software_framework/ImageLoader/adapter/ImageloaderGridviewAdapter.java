package com.example.general_software_framework.ImageLoader.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.general_software_framework.ImageLoader.Constants;
import com.example.general_software_framework.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class ImageloaderGridviewAdapter extends BaseAdapter {
    private Context mContext;
    private final ImageLoader imageLoader;
    private DisplayImageOptions options = new DisplayImageOptions.Builder()
            .showStubImage(R.drawable.ic_launcher_background)          // 设置图片下载期间显示的图片
            .showImageForEmptyUri(R.drawable.ic_launcher_background)  // 设置图片Uri为空或是错误的时候显示的图片
            .showImageOnFail(R.drawable.ic_launcher_background)       // 设置图片加载或解码过程中发生错误显示的图片
            .cacheInMemory(true)                        // 设置下载的图片是否缓存在内存中
            .cacheOnDisk(true)                          // 设置下载的图片是否缓存在SD卡中
            .bitmapConfig(Bitmap.Config.RGB_565)        // 设置图片的解码类型
            .build();                                   // 创建配置过得DisplayImageOption对象;

    public ImageloaderGridviewAdapter(Context context) {
        mContext = context;

        // 初始化imageloader
        imageLoader = ImageLoader.getInstance();
    }

    @Override
    public int getCount() {
        return Constants.IMAGES.length;
    }

    @Override
    public Object getItem(int position) {
        return Constants.IMAGES[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_imageloader_gridview, null);

            holder = new ViewHolder();
            holder.iv = convertView.findViewById(R.id.iv_imageloader_gridview);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        // 显示图片
        imageLoader.displayImage(Constants.IMAGES[position],holder.iv,options);

        return convertView;
    }

    class ViewHolder{

        ImageView iv;

    }
}
