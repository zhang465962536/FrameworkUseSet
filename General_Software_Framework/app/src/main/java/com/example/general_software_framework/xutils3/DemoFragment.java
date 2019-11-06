package com.example.general_software_framework.xutils3;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.general_software_framework.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;


//直接显示布局

@ContentView(R.layout.fragment_demo)
public class DemoFragment extends Fragment {

    @ViewInject(R.id.btn_fragment)
    private Button btn_fragment;
    @ViewInject(R.id.tv_text)
    private TextView tv_text;

    private Context mContext;
    //当fragment被创建的时候 调用onCreate
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    //当fragment的视图被创建的时候 调用 onCreateView 方法
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);
        return x.view().inject(this,inflater,container);
    }

    //当activity被创建的时候 调用该 onActivityCreated
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
       super.onActivityCreated(savedInstanceState);

        btn_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext,"我是按钮，我在fragment中初始化，并且被点击了",Toast.LENGTH_SHORT).show();
            }
        });

        tv_text.setText("我在fragment被初始化了");

    }
}
