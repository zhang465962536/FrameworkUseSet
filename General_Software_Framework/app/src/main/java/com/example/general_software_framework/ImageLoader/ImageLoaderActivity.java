package com.example.general_software_framework.ImageLoader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.general_software_framework.ImageLoader.Activity.ImageloaderGridviewActivity;
import com.example.general_software_framework.ImageLoader.Activity.ImageloaderListviewActivity;
import com.example.general_software_framework.ImageLoader.Activity.ImageloaderViewpagerActivity;
import com.example.general_software_framework.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
@ContentView(R.layout.activity_image_loader)
public class ImageLoaderActivity extends AppCompatActivity {


    @ViewInject(R.id.title_name)
    TextView tvTitle;
    @ViewInject(R.id.bt_imageloader_listview)
    Button btImageloaderListview;
    @ViewInject(R.id.bt_imageloader_gridview)
    Button btImageloaderGridview;
    @ViewInject(R.id.bt_imageloader_viewpager)
    Button btImageloaderViewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_image_loader);
        x.view().inject(this);

        initData();
    }

    private void initData() {
        // 标题
        tvTitle.setText("Imageloader");
    }

    @Event(value = {R.id.bt_imageloader_listview,R.id.bt_imageloader_gridview,R.id.bt_imageloader_viewpager})
    private void getEvent(View view){
        switch (view.getId()){
            case R.id.bt_imageloader_listview:
                // 跳转到listview案例页面
              Intent intent = new Intent(ImageLoaderActivity.this, ImageloaderListviewActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_imageloader_gridview:
                // 跳转到gridview案例页面
                Intent intent1 = new Intent(ImageLoaderActivity.this, ImageloaderGridviewActivity.class);
                startActivity(intent1);
                break;

            case R.id.bt_imageloader_viewpager:
                // 跳转到viewpager案例页面
                Intent intent2 = new Intent(ImageLoaderActivity.this, ImageloaderViewpagerActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
