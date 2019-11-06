package com.example.general_software_framework.ImageLoader.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.general_software_framework.ImageLoader.adapter.ImageloaderListviewAdapter;
import com.example.general_software_framework.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class ImageloaderListviewActivity extends AppCompatActivity {
    @ViewInject(R.id.title_name)
    TextView tvTitle;
    @ViewInject(R.id.lv_imageloader)
    ListView lvImageloader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageloader_listview);
        x.view().inject(this);
        initData();
    }

    private void initData() {
        // 初始化标题
        tvTitle.setText("Imageloader应用在Listview中");

        ImageloaderListviewAdapter imageloaderListviewAdapter = new ImageloaderListviewAdapter(this);

        lvImageloader.setAdapter(imageloaderListviewAdapter);
    }
}