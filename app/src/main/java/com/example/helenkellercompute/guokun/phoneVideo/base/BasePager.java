package com.example.helenkellercompute.guokun.phoneVideo.base;

import android.content.Context;
import android.view.View;

/**
 * Created by Helen keller compute on 2018/4/20.
 * VideoPager
 * AudioPager
 * NetVideoPager
 * NetAudioPager
 */

public abstract class BasePager {
    public final Context context;
    public View rootView;
    public boolean isInitData;



    public BasePager(Context context) {
        this.context = context;
        rootView = initView();
    }

    /**
     * 强制由子类实现
     * @return
     */
    public abstract View initView();

    /**
     * 当子页面初始化数据
     */
    public void initData(){
    }

}
