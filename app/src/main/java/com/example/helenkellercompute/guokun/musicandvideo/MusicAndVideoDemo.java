package com.example.helenkellercompute.guokun.musicandvideo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.helenkellercompute.guokun.R;

/**
 * Created by Helen keller compute on 2018/4/15.
 */

public class MusicAndVideoDemo extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_and_video_demo);
    }
    public void musicOnClick(View view){
        Intent intent = new Intent(this,MusicDemo.class);
        startActivity(intent);
    }
    public void videoOnClick(View view){
        Intent intent = new Intent(this,VideoDemo.class);
        startActivity(intent);
    }
    public void cameraOnClick(View view){
        Intent intent = new Intent(this,CameraDemo.class);
        startActivity(intent);
    }




}
