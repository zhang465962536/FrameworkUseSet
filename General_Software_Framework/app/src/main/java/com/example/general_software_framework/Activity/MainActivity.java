package com.example.general_software_framework.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.general_software_framework.Base.BaseFragment;
import com.example.general_software_framework.Fragment.fragment1;
import com.example.general_software_framework.Fragment.fragment2;
import com.example.general_software_framework.Fragment.fragment3;
import com.example.general_software_framework.Fragment.fragment4;
import com.example.general_software_framework.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private RadioGroup rg_main;
    private List<BaseFragment> mBaseFragments;
    private int position;
    TextView title_name;
    //现在的fragment
    private Fragment nowFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化view
        initView();

        //初始化fragment
        initFragment();
        //设置RadioGroup的监听
        setListener();
    }

    private void setListener() {
        rg_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){

                    case R.id.rb_1:
                        position = 0;
                        title_name.setText("页面1");
                        break;

                    case R.id.rb_2:
                        position = 1;
                        title_name.setText("页面2");
                        break;

                    case R.id.rb_3:
                        position = 2;
                        title_name.setText("页面3");
                        break;

                    case R.id.rb_4:
                        title_name.setText("页面4");
                        position = 3;
                        break;
                }

                //根据position  切换相应的fragment
                BaseFragment toFragment = getFragment();
                //替换fragment
                switchFragment(nowFragment,toFragment);
            }
        });

        //设置默认选择页面1
        rg_main.check(R.id.rb_1);
    }

    /**
     *
     * @param fromFragment 现在显示的fragment 即将切换页面
     * @param toFragment  马上要切换的fragment 即将显示
     */
    private void switchFragment(Fragment fromFragment,Fragment toFragment){
        //不同页面才需要切换
        if(fromFragment != toFragment){
            nowFragment = toFragment;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //判断tofragment有没有被添加
            if(!toFragment.isAdded()){
                //如果没有被添加 就添加toFragment fromFragment 被隐藏

                if(fromFragment != null){
                    ft.hide(fromFragment);
                }
                if(toFragment != null){
                    ft.add(R.id.fl_content,toFragment).commit();
                }

            }else {
                //如果已经被添加 直接显示 toFragment fromFragment 被隐藏
                if(fromFragment != null){
                    ft.hide(fromFragment);
                }
                if(toFragment != null){
                    ft.show(toFragment).commit();
                }
            }
        }
    }

    //重复加载 fragment 这样不好  只需要加载一次就行 所以需要优化
   /* private void switchFragment(BaseFragment fragment) {
        //【1】获得 FragmentManager
        FragmentManager fm = getSupportFragmentManager();
        //【2】开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        //【3】替换fragment
        transaction.replace(R.id.fl_content,fragment);
        //【4】提交事务
        transaction.commit();
    }*/

    //一个位置 对应一个 fragment
    private BaseFragment getFragment() {
        BaseFragment fragment = mBaseFragments.get(position);
        return fragment;
    }

    private void initFragment() {
        mBaseFragments = new ArrayList<>();
        mBaseFragments.add(new fragment1());
        mBaseFragments.add(new fragment2());
        mBaseFragments.add(new fragment3());
        mBaseFragments.add(new fragment4());
    }

    private void initView() {
        rg_main = findViewById(R.id.rg_main);
        title_name = findViewById(R.id.title_name);

    }
}
