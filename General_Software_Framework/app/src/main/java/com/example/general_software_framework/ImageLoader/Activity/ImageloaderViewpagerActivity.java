package com.example.general_software_framework.ImageLoader.Activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.general_software_framework.ImageLoader.adapter.ImageloaderListviewAdapter;
import com.example.general_software_framework.ImageLoader.adapter.ImageloaderViewpagerAdapter;
import com.example.general_software_framework.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_imageloader_viewpager)
public class ImageloaderViewpagerActivity extends AppCompatActivity {

    @ViewInject(R.id.title_name)
    TextView tvTitle;
    @ViewInject(R.id.vp_imageloader_viewpager)
    ViewPager vpImageloaderViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_imageloader_viewpager);
        x.view().inject(this);
        initData();
    }

    private void initData() {
        // 标题
        tvTitle.setText("Imageloader应用在viewpager中");

        // 初始化viewpager
        ImageloaderViewpagerAdapter imageloaderViewpagerAdapter = new ImageloaderViewpagerAdapter(this);

        vpImageloaderViewpager.setAdapter(imageloaderViewpagerAdapter);

        // 显示第一个条目
        vpImageloaderViewpager.setCurrentItem(1);
    }
}
