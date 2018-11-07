package com.example.helenkellercompute.guokun;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Helen keller compute on 2018/3/28.
 */

public class StartServiceDemo extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return   new AllGrad();
    }
    public class AllGrad extends Binder {
        public double callAll (Double...scores){
            double all =0 ;
            for (double s:scores){
                all += s;
            }
            return  all;
        }

    }
}
