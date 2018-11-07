package com.example.helenkellercompute.guokun.musicandvideo;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

import com.example.helenkellercompute.guokun.R;

import java.io.IOException;

/**
 * Created by Helen keller compute on 2018/4/16.
 */

public class VideoDemoMedioPlayer2 extends Activity {
    public SurfaceView surfaceView;
    private MediaPlayer mediaPlayer;
    private static final int PERMISSION_REQUEST_CODE = 1; //权限请求码

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videodemo_medioplayer_layout);
        surfaceView = (SurfaceView) findViewById(R.id.surfaceViewId);
        mediaPlayer = new MediaPlayer();
        if (checkPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            //获取权限后的操作。读取文件
        }else {
            //请求权限
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST_CODE);
        }
    }
    public void play2(View view) throws IOException {
            mediaPlayer.reset();
            mediaPlayer.setDataSource("http://flashmedia.eastday.com/newdate/news/2016-11/shznews1125-19.mp4");
            mediaPlayer.setDisplay(surfaceView.getHolder());// 设置用SurfaceHolder来显示多媒体
            mediaPlayer.prepare();
            mediaPlayer.start();
    }
    public void pause2(View view){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length >0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    //得到了授权
                    Toast.makeText(this, "授权成功", Toast.LENGTH_SHORT).show();
                }else {
                    //未授权
                    Toast.makeText(this, "授权失败", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
    private boolean checkPermission(Context context, String permission) {
        return PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(context,permission);
    }
    public void stop2(View view){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
    }

    @Override
    protected void onDestroy() {
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();

    }
}
