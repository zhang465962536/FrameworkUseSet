package com.example.general_software_framework.xutils3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.general_software_framework.R;
import com.example.general_software_framework.xutils3.annotation.FragmentXutils3Activity;
import com.example.general_software_framework.xutils3.net.XutilsNetActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_xutils3)
public class Xutils3Activity extends AppCompatActivity {

    @ViewInject(R.id.title_name)
    private TextView title_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_xutils3);
        x.view().inject(this);

        //设置标题
        title_name.setText("Xutils3的使用");
    }

    @Event(value = {R.id.btn_annotation,R.id.btn_net,R.id.btn_image,R.id.btn_image_list})
    private void getEvent(View view){
        switch (view.getId()){
            case R.id.btn_annotation:
//               Toast.makeText(XUtils3MainActivity.this, "注解模块被点击了", Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(Xutils3Activity.this, FragmentXutils3Activity.class);
                startActivity(intent);
                break;
            case R.id.btn_net:
                Toast.makeText(Xutils3Activity.this, "网络模块被点击了", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(Xutils3Activity.this, XutilsNetActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_image:
                Toast.makeText(Xutils3Activity.this, "加载单张图片被点击了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_image_list:
                Toast.makeText(Xutils3Activity.this, "加载列表图片被点击了", Toast.LENGTH_SHORT).show();
                break;
        }



    }
}
