package com.example.general_software_framework.xutils3.annotation;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import com.example.general_software_framework.R;
import com.example.general_software_framework.xutils3.DemoFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_xutils3_fragment)
public class FragmentXutils3Activity extends android.support.v4.app.FragmentActivity {

    @ViewInject(R.id.title_name)
    private TextView title_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_xutils3_fragment);
        x.view().inject(this);

        title_name.setText("在fragment使用注解");

        //1 得到fragmentManger
        FragmentManager fm = getSupportFragmentManager();
        // 2 开启事务
        FragmentTransaction tt = fm.beginTransaction();
        // 3 替换fragment
        tt.replace(R.id.fl_content,new DemoFragment());
        // 4 提交事务
        tt.commit();
    }


}
