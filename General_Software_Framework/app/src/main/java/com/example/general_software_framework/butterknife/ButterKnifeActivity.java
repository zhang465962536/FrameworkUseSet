package com.example.general_software_framework.butterknife;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.general_software_framework.R;

/*import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;*/

public class ButterKnifeActivity extends AppCompatActivity {

  /*  @Bind(R.id.title_name)
    TextView titleName;
    @Bind(R.id.tv_butterknife)
    TextView tvButterknife;
    @Bind(R.id.cb_butterknife)
    CheckBox cbButterknife;
    @Bind(R.id.bt_butterknife)
    Button btButterknife;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_knife);
        //ButterKnife.bind(this);
       // initData();
    }

   /* private void initData() {
        // 初始化标题
        titleName.setText("Butterknife");

        tvButterknife.setText("我好喜欢butterknife");
    }

    @OnClick(R.id.cb_butterknife)
    void cbButterknife(View view){
        Toast.makeText(ButterKnifeActivity.this, "点击了checkbox", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.bt_butterknife)
    void btButterknife(View view){
        Toast.makeText(ButterKnifeActivity.this, "点击了button", Toast.LENGTH_SHORT).show();
    }*/
}
