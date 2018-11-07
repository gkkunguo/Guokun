package com.example.helenkellercompute.guokun.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Helen keller compute on 2018/4/24.
 */

public class MService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;

    }

    @Override
    public void onCreate() {
        Log.i("TEST","onBind");
        Log.i("TEST","thread="+Thread.currentThread().getName());
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        Log.i("TEST","onStartCommand");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.i("TEST","onStart");
        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("TEST","onDestroy");
        Log.i("TEST",    "--" + Thread.currentThread().getName());
        super.onDestroy();
    }
}
