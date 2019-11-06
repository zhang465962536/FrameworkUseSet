package com.example.general_software_framework.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

import com.example.general_software_framework.R;

public class SplashActivity extends Activity {
    RelativeLayout rl_splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        rl_splash = findViewById(R.id.rl_splash);
        StartAnimation();

       /* //也可以使用Hanlder 延迟发送消息
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        },3000);*/
    }

    private void StartAnimation() {

        AlphaAnimation alphaAnimation = new AlphaAnimation(0f,1f);
        alphaAnimation.setDuration(3000);
        rl_splash.startAnimation(alphaAnimation);

        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //动画结束之后跳转到 主界面
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });



    }
}
