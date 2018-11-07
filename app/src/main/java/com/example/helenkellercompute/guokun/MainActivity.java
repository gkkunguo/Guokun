package com.example.helenkellercompute.guokun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helenkellercompute.guokun.adapter.AdapterDemo;
import com.example.helenkellercompute.guokun.alertdialog.AlertDialogDemo;
import com.example.helenkellercompute.guokun.dataOrOracle.OracleDemo;
import com.example.helenkellercompute.guokun.design.DesignDemosActivity;
import com.example.helenkellercompute.guokun.gridview.GridViewDemo;
import com.example.helenkellercompute.guokun.handlerOrMessage.HandlerOrMessage1;
import com.example.helenkellercompute.guokun.intent.IntenDemo;
import com.example.helenkellercompute.guokun.json.JsonDemo;
import com.example.helenkellercompute.guokun.layoutObject.LayoutObjectDemo;
import com.example.helenkellercompute.guokun.musicandvideo.MusicAndVideoDemo;
import com.example.helenkellercompute.guokun.phoneVideo.activity.SplashActivity;
import com.example.helenkellercompute.guokun.spinner.SpinnerDemo;
import com.example.helenkellercompute.guokun.thread.handlerthread.ThreadActivity;
import com.example.helenkellercompute.guokun.xml.XmlDemo;
import com.tencent.bugly.beta.Beta;

public class MainActivity extends AppCompatActivity {
    private Button onTouchListnener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String a = BuildConfig.VERSION_NAME;

    }
    public void onTouchListnenergk(View view){
//        onTouchListnener = (Button)findViewById(R.id.onTouchListnener);
        Intent intent  = new Intent();
        intent.setClass(this,OnTouch.class);
        startActivity(intent);
    }
    //service学习
    public void serviceOnclick(View view){
        Intent intent = new Intent(this,ServiceDemo.class);
//        intent.setClass();
        startActivity(intent);
    }
    //广播
    public void broadcastOnClick(View view){
        Intent intent = new Intent(this,BroadcastReceiverDemo.class);
        startActivity(intent);
    }
    //布局文件
    public void layoutObjectOnClick(View view){
        Intent intent = new Intent(this, LayoutObjectDemo.class);
        startActivity(intent);
    }

    public void handlerOrMessageOnClick(View view){
        Intent intent = new Intent(this, HandlerOrMessage1.class);
        startActivity(intent);
    }
    public void xmlOnClick(View view){
        Intent intent = new Intent(this, XmlDemo.class);
        startActivity(intent);
    }
    public void jsonOnClick(View view){
        Intent intent = new Intent(this, JsonDemo.class);
        startActivity(intent);
    }
    public void alertdialogOnClick(View view){
        Intent intent = new Intent(this, AlertDialogDemo.class);
        startActivity(intent);
    }

    public void adapterOnClick(View view){
        Intent intent = new Intent(this, AdapterDemo.class);
        startActivity(intent);
    }
    public void spinnerOnClick(View view){
        Intent intent = new Intent(this, SpinnerDemo.class);
        startActivity(intent);
    }
    public void intentOnClick(View view){
        Intent intent = new Intent(this, IntenDemo.class);
        startActivity(intent);
    }
    public void gridViewDemoOnClick(View view){
        Intent intent = new Intent(this, GridViewDemo.class);
        startActivity(intent);
    }
    public void oracleDemoOnClick(View view){
        Intent intent = new Intent(this, OracleDemo.class);
        startActivity(intent);
    }
    public void musicAndVideoDemoOnClick(View view){
        Intent intent = new Intent(this, MusicAndVideoDemo.class);
        startActivity(intent);
    }
    public void phoneViedoDemoOnClick(View view){
        Intent intent = new Intent(this, SplashActivity.class);
        startActivity(intent);
    }
    public void ThreadOnClick(View view){
            Intent intent = new Intent(this, ThreadActivity.class);
            startActivity(intent);
    }
    public void DesignClick(View view){
            Intent intent = new Intent(this, DesignDemosActivity.class);
            startActivity(intent);
    }
    public void appRe(View view){
        Beta.checkUpgrade();
    }












}
