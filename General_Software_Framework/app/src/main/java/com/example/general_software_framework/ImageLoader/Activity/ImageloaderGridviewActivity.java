package com.example.general_software_framework.ImageLoader.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import com.example.general_software_framework.ImageLoader.adapter.ImageloaderGridviewAdapter;
import com.example.general_software_framework.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_imageloader_gridview)
public class ImageloaderGridviewActivity extends AppCompatActivity {
    @ViewInject(R.id.title_name)
    TextView tvTitle;
    @ViewInject(R.id.gv_imageloader_gridview)
    GridView gvImageloaderGridview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_imageloader_gridview);
        x.view().inject(this);
        initData();
    }

    private void initData() {
        // 标题
        tvTitle.setText("Imageloader应用在Gridview中");

        // 初始化Gridview
        ImageloaderGridviewAdapter imageloaderGridviewAdapter = new ImageloaderGridviewAdapter(this);

        gvImageloaderGridview.setAdapter(imageloaderGridviewAdapter);
    }
}