package com.example.helenkellercompute.guokun.xml;

import android.app.Application;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;

/**
 * Created by Helen keller compute on 2018/5/23.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Beta.autoCheckUpgrade = false;//设置不自动检查

        Bugly.init(getApplicationContext(), "c57c3bcf0a", false);
    }
}
