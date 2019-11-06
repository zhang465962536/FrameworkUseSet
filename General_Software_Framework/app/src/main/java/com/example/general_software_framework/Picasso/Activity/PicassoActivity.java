package com.example.general_software_framework.Picasso.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.general_software_framework.R;
import com.squareup.picasso.Picasso;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
@ContentView(R.layout.activity_picasso)
public class PicassoActivity extends AppCompatActivity {
    @ViewInject(R.id.title_name)
    TextView tvTitle;
    @ViewInject(R.id.bt_picasso_base)
    Button btPicassoBase;
    @ViewInject(R.id.bt_picasso_listview)
    Button btPicassoListview;
    @ViewInject(R.id.bt_picasso_tranformations)
    Button btPicassoTranformations;
    @ViewInject(R.id.iv_picasso_result1)
    ImageView ivPicassoResult1;
    @ViewInject(R.id.iv_picasso_result2)
    ImageView ivPicassoResult2;
    @ViewInject(R.id.iv_picasso_result3)
    ImageView ivPicassoResult3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_picasso);
        x.view().inject(this);
        initData();
    }

    private void initData() {
        // 标题
        tvTitle.setText("Picasso");
    }


    @Event(value = {R.id.bt_picasso_base,R.id.bt_picasso_listview,R.id.bt_picasso_tranformations})
    private void click(View view){
        switch (view.getId()){
            case R.id.bt_picasso_base:
                // 基本用法

                // 普通加载图片
                Picasso.with(PicassoActivity.this)
                        .load("http://n.sinaimg.cn/translate/20160819/9BpA-fxvcsrn8627957.jpg")
                        .into(ivPicassoResult1);

                // 裁剪的方式加载图片
                Picasso.with(PicassoActivity.this)
                        .load("http://n.sinaimg.cn/translate/20160819/9BpA-fxvcsrn8627957.jpg")
                        .resize(100,100)
                        .into(ivPicassoResult2);

                // 选择180度
                Picasso.with(PicassoActivity.this)
                        .load("http://n.sinaimg.cn/translate/20160819/9BpA-fxvcsrn8627957.jpg")
                        .rotate(180)
                        .into(ivPicassoResult3);

                break;
            case R.id.bt_picasso_listview:
                // 跳转到listview页面
                Intent intent = new Intent(PicassoActivity.this, PicassoListviewActivity.class);

                startActivity(intent);
                break;
            case R.id.bt_picasso_tranformations:
                // 跳转到图片转换页面
                Intent intent1 = new Intent(PicassoActivity.this, PicassoTransfromationsActivity.class);
                startActivity(intent1);
                break;

        }
    }
}
