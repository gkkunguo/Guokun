package com.example.helenkellercompute.guokun.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


/**
 * Created by Helen keller compute on 2018/3/29.
 */

public class BroadcastReceiverSystem extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"接收到一个短信息",Toast.LENGTH_SHORT).show();

    }
}
