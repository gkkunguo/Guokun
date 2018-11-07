package com.example.helenkellercompute.guokun.musicandvideo;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.VideoView;

import com.example.helenkellercompute.guokun.R;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Helen keller compute on 2018/4/15.
 */

public class VideoDemo extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_and_video_video_demo);

    }
    public void viedoViewOnclick(View view){
        startActivity(new Intent(this,VideoDemoVideoView.class));
    }
    public void medioPlayerOnclick(View view){
        startActivity(new Intent(this,VideoDemoMedioPlayer.class));
    }
    public void medioPlayerOnclick2(View view){
        startActivity(new Intent(this,VideoDemoMedioPlayer2.class));
    }




}
