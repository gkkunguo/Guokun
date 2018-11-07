package com.example.helenkellercompute.guokun.musicandvideo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.helenkellercompute.guokun.R;

/**
 * Created by Helen keller compute on 2018/4/16.
 */

public class VideoDemoMedioPlayer extends Activity {
    public MySurfaceView mySurfaceView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.videodemo_medioplayer_layout);
        mySurfaceView = new MySurfaceView(this);
        setContentView(mySurfaceView);
    }
}
