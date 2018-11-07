package com.example.helenkellercompute.guokun.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.view.View;

/**
 * Created by Helen keller compute on 2018/4/24.
 */

public class MIntentService extends IntentService {
    public MIntentService(){
        super("MIntentService");
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MIntentService(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        Log.e("TEST",  "onCreate");
        Log.e("TEST", "thread="+Thread.currentThread().getName()  );
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("TEST", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.e("TEST", Thread.currentThread().getName() + "--" + intent.getStringExtra("info") );
        for(int i = 0; i < 100; i++){ //耗时操作
            Log.i("TEST",  i + "--" + Thread.currentThread().getName());
        }
    }

    @Override
    public void onDestroy() {
        Log.e("TEST", "onDestroy");
        super.onDestroy();
    }

}
