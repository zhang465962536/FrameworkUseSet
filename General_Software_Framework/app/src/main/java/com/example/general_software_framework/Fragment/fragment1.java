package com.example.general_software_framework.Fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/*import com.example.general_software_framework.Activity.OKHttpActivity;*/
import com.example.general_software_framework.EventBus.EvenBusActivity;
import com.example.general_software_framework.ImageLoader.ImageLoaderActivity;
import com.example.general_software_framework.Json.activity.FastJsonActivity;
import com.example.general_software_framework.Json.activity.GsonActivity;
import com.example.general_software_framework.Json.activity.NativeJsonParseActivity;
import com.example.general_software_framework.Adapter.fragment1Adapter;
import com.example.general_software_framework.Base.BaseFragment;
import com.example.general_software_framework.Picasso.Activity.PicassoActivity;
import com.example.general_software_framework.PullToRefresh.PullToRefreshMainActivity;
import com.example.general_software_framework.R;
import com.example.general_software_framework.RecyclerView.RecyclerViewActivity;
import com.example.general_software_framework.VideoView.JieCaoVideoPlayerActivity;
import com.example.general_software_framework.VideoView.UniversalVideoViewActivity;
import com.example.general_software_framework.butterknife.ButterKnifeActivity;
import com.example.general_software_framework.xutils3.Xutils3Activity;

public class fragment1 extends BaseFragment {

    private ListView mListView;

    private String[] datas;

    private fragment1Adapter adapter;


    private static final String TAG = fragment1.class.getSimpleName();//"CommonFrameFragment"

    @Override
    protected View initView() {
        Log.e(TAG,"常用框架Fragment页面被初始化了...");
        View view = View.inflate(mContext, R.layout.fragment1,null);
        mListView =  view.findViewById(R.id.lv_fragment1);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data =  datas[position];
                if(data.toLowerCase().equals("okhttp")){
                    /*Intent intent = new Intent(mContext, OKHttpActivity.class);
                    mContext.startActivity(intent);*/
                }else if(data.toLowerCase().equals("nativejsonparse")){
                    //点击条目跳转到手动JSON解析界面
                    Intent intent = new Intent(mContext, NativeJsonParseActivity.class);
                    mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("gson")){
                    //点击条目跳转到GSON解析界面
                    Intent intent = new Intent(mContext, GsonActivity.class);
                    mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("fastjson")){
                    //点击条目跳转到FastJSON解析界面
                    Intent intent = new Intent(mContext, FastJsonActivity.class);
                    mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("xutils3")){
                    //点击条目跳转到xUtils3界面
                    Intent intent = new Intent(mContext, Xutils3Activity.class);
                    mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("evenbus")){
                    //点击条目跳转到evenBus界面
                    Intent intent = new Intent(mContext, EvenBusActivity.class);
                    mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("butterknife")){
                    //点击条目跳转到ButterKnife界面
                    Intent intent = new Intent(mContext, ButterKnifeActivity.class);
                    mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("imageloader")){
                    //点击条目跳转到ImageLoader界面
                    Intent intent = new Intent(mContext, ImageLoaderActivity.class);
                    mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("picasso")){
                    //点击条目跳转到ImageLoader界面
                    Intent intent = new Intent(mContext, PicassoActivity.class);
                    mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("recyclerview")){
                    //点击条目跳转到recyclerview界面
                    Intent intent = new Intent(mContext, RecyclerViewActivity.class);
                    mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("androidpulltorefresh")){
                    //点击条目跳转到Android-PullToRefresh 界面
                    Intent intent = new Intent(mContext, PullToRefreshMainActivity.class);
                    mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("universalvideoview")){
                    //点击条目跳转到universalvideoview 界面
                    Intent intent = new Intent(mContext, UniversalVideoViewActivity.class);
                    mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("jiecaovideoplayer")){
                    //点击条目跳转到JieCaoVideoPlayer界面
                    Intent intent = new Intent(mContext, JieCaoVideoPlayerActivity.class);
                    mContext.startActivity(intent);
                }
                Toast.makeText(mContext, "data=="+data, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "常用框架Fragment数据被初始化了...");
        //准备数据
        datas = new String[]{"OKHttp", "xUtils3","Retrofit2","AndroidPullToRefresh","Glide","ImageLoader","picasso","RecyclerView","RxJava","volley","nativeJsonParse","Gson","FastJson","evenBus","jcvideoplayer","pulltorefresh","Expandablelistview","UniversalVideoView","JieCaoVideoPlayer","ButterKnife"};
        //设置适配器
        adapter = new fragment1Adapter(mContext,datas);
        mListView.setAdapter(adapter);
    }
}