package com.example.helenkellercompute.guokun.phoneVideo.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

import com.example.helenkellercompute.guokun.R;

/**
 * Created by Helen keller compute on 2018/4/18.
 */

public class SplashActivity extends Activity {
    private Handler handler = new Handler();
    private boolean isStartMain = false;
    private boolean permisson;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phoneviedo_layout);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    /**
                     * 2秒后跳转到主页面
                     */
                    startMainActivity();
                }
            }, 1000);


    }

    private void startMainActivity() {
        if (!isStartMain) {
            isStartMain = true;
            Intent intent = new Intent(this, MainPhoneViedoActivity.class);
            //关闭当前页面
            startActivity(intent);
            finish();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        startMainActivity();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        Log.e("TEST", "我到这里了");
            finish();
        super.onDestroy();
    }

}
