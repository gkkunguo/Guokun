package com.example.helenkellercompute.guokun;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Helen keller compute on 2018/3/28.
 */

public class StartServiceDemo1 extends Service {
    private String serviceStyle="";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return MyBind();
    }

    private IBinder MyBind() {
        Log.i("TEST","MyBind");
        serviceStyle += "、"+"MyBind";
        return null;
    }
    public String  MyBindReturl(){
        return serviceStyle;

    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.i("TEST","onStart");
        serviceStyle += "、"+"onStart";
        super.onStart(intent, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        serviceStyle += ""+"onCreate";
        Log.i("TEST","onCreate");
    }

    @Override
    public void onDestroy() {
        serviceStyle += "、"+"onDestroy";
        Log.i("TEST","onDestroy");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {
        Log.i("TEST","onStartCommand");
        serviceStyle += "、"+"onStartCommand";
        return super.onStartCommand(intent, flags, startId);
    }



}
