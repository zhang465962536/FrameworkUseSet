package com.example.general_software_framework.Fragment;

import android.util.Log;
import android.view.View;

import com.example.general_software_framework.Base.BaseFragment;
import com.example.general_software_framework.R;

public class fragment3 extends BaseFragment {
    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment2,null);
        return view;
    }

    @Override
    protected void initData() {

        Log.e("fragment3","fragment3 初始化了");
    }
}
