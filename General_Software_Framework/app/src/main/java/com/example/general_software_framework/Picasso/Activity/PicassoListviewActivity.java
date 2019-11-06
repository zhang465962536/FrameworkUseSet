package com.example.general_software_framework.Picasso.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.general_software_framework.Picasso.Activity.adapter.PicassoListviewAdapter;
import com.example.general_software_framework.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_picasso_listview)
public class PicassoListviewActivity extends AppCompatActivity {

    @ViewInject(R.id.title_name)
    private TextView title_name;

    @ViewInject(R.id.lv_picasso)
    private ListView lv_picasso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        initData();
    }

    private void initData() {
        title_name.setText("Picasso在listview中使用");


        // 初始化listview
        PicassoListviewAdapter picassoListviewAdapter = new PicassoListviewAdapter(this);

        lv_picasso.setAdapter(picassoListviewAdapter);
    }
}
