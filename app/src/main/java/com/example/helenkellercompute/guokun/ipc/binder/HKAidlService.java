package com.example.helenkellercompute.guokun.ipc.binder;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class HKAidlService extends Service {
    private HKAidlInterface hkAidlInterface;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        hkAidlInterface = new HKAidlInterface();
        return hkAidlInterface;
    }
}
