package com.example.helenkellercompute.guokun;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Helen keller compute on 2018/3/28.
 */

public class BroadcastStartServiceDemo extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return  null;
    }

    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {
        double math = intent.getDoubleExtra("math",0);
        double english = intent.getDoubleExtra("english",0);
        double chines = intent.getDoubleExtra("chines",0);
        double all = callAll(math,english,chines);
        Intent intent1 = new Intent("guokun_1");//广播
        intent1.putExtra("result",all);
        sendBroadcast(intent1);
        return super.onStartCommand(intent, flags, startId);
    }

        public double callAll (Double...scores){
            double all =0 ;
            for (double s:scores){
                all += s;
            }
            return  all;

    }
}
