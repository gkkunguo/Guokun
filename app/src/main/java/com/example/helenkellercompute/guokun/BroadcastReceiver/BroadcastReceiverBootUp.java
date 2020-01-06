package com.example.helenkellercompute.guokun.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BroadcastReceiverBootUp extends BroadcastReceiver {
    private static final String TAG = "GUOKUN";
    //开机广播
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"用户开机啦！",Toast.LENGTH_LONG).show();
//        Log.i(TAG, "onReceive: "+"用户开机啦");
}
}
