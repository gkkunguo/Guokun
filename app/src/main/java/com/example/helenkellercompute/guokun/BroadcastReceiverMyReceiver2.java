package com.example.helenkellercompute.guokun;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Helen keller compute on 2018/3/28.
 */

public class BroadcastReceiverMyReceiver2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"接收到了第二个",Toast.LENGTH_SHORT).show();

    }
}
