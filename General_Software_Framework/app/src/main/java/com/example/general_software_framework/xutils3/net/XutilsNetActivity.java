package com.example.general_software_framework.xutils3.net;

import android.app.Activity;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.general_software_framework.R;

import org.xutils.common.Callback;
import org.xutils.common.task.PriorityExecutor;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;

@ContentView(R.layout.activity_xutils_net)
public class XutilsNetActivity extends Activity {

    @ViewInject(R.id.tv_result)
    private TextView tv_result;

    @ViewInject(R.id.title_name)
    private TextView title_name;

    @ViewInject(R.id.download_progressbar)
    private ProgressBar download_progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_xutils_net);
        x.view().inject(this);

        title_name.setText("Xutils的网络模块");
    }

    @Event(value = {R.id.btn_get_post,R.id.btn_downloadfile,R.id.btn_uploadfile})
    private void getEvent(View view){
        switch (view.getId()){
            case R.id.btn_get_post:
                getAndPostNet();
               Toast.makeText(XutilsNetActivity.this, "Get和Post请求", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_downloadfile:
                downloadFile();
               Toast.makeText(XutilsNetActivity.this, "文件下载", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_uploadfile:
                //uploadFile();
               Toast.makeText(XutilsNetActivity.this, "文件上传", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    private void getAndPostNet() {
        // Get请求
        RequestParams params = new RequestParams("http://api.m.mtime.cn/PageSubArea/TrailerList.api");
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("TAG", "xUtis3联网请求成功==" + result);
//                textView.setText("Get请求的结果——————" + result);
                tv_result.setText("Post请求的结果——————" + result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("TAG", "xUtis3联网请求失败==" + ex.getMessage());
                tv_result.setText("xUtis3联网请求失败==" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("TAG", "onCancelled==" + cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e("TAG","onFinished==");
            }
        });
    }


    private void downloadFile() {
        RequestParams params = new RequestParams("http://vfx.mtime.cn/Video/2016/09/15/mp4/160915092608935956_480.mp4");
        //设置保存数据
        params.setSaveFilePath(Environment.getExternalStorageDirectory() + "/heihei/480.mp4");
        //设置是否可以立即取消下载
        params.setCancelFast(true);
        //设置是否自动根据头信息命名
        params.setAutoRename(false);
        //设置断点续传
        params.setAutoResume(true);

        params.setExecutor(new PriorityExecutor(3, true));//自定义线程池,有效的值范围[1, 3], 设置为3时, 可能阻塞图片加载.


        x.http().get(params, new Callback.ProgressCallback<File>() {
            /**
             * 当下载成功的时候回调这个方法，并且把下载到哪个路径回传过来
             * @param file
             */
            @Override
            public void onSuccess(File file) {
                Log.e("TAG","onSuccess=="+file.toString());
                Toast.makeText(XutilsNetActivity.this, "onSuccess=="+file.toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("TAG","onError=="+ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("TAG","onCancelled=="+cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e("TAG","onFinished==");
            }

            @Override
            public void onWaiting() {
                Log.e("TAG","onWaiting==");
            }

            @Override
            public void onStarted() {
                Log.e("TAG","onStarted==");
            }

            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
                download_progressbar.setMax((int) total);
                download_progressbar.setProgress((int) current);
                Log.e("TAG", "onLoading=="+current+"/"+total+",isDownloading=="+isDownloading);

            }
        });
    }
}
