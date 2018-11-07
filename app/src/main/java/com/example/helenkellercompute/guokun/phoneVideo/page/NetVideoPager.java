package com.example.helenkellercompute.guokun.phoneVideo.page;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.helenkellercompute.guokun.phoneVideo.base.BasePager;

/**
 * Created by Helen keller compute on 2018/4/20.
 */

public class NetVideoPager extends BasePager {
    private TextView textView;

    /**
     * @param context 上下文
     */
    public NetVideoPager(Context context) {
        super(context);
    }
    @Override
    public View initView() {
        textView = new TextView(context);
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        textView.setText("网络视频页面");
        Log.i("TEST","本地音乐页面");
    }
}
