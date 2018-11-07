package com.example.helenkellercompute.guokun.musicandvideo;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;

import com.example.helenkellercompute.guokun.R;
import com.example.helenkellercompute.guokun.basis.Tools.Tools;

import java.io.File;
import java.io.IOException;

/**
 * Created by Helen keller compute on 2018/4/15.
 */

public class MusicDemo extends Activity {
        private MediaPlayer mediaPlayer;
    private static final int PERMISSION_REQUEST_CODE = 1; //权限请求码
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_and_video_music_demo);
        if (checkPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            //获取权限后的操作。读取文件
        }else {
            //请求权限
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST_CODE);
        }
        Intent intent = new Intent(this,MusicDemoService.class);
        startService(intent);
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
    public void play(View view){
        if(mediaPlayer == null){
            ready();
        }
        mediaPlayer.start();
        Toast.makeText(this, "播放成功", Toast.LENGTH_SHORT).show();

    }
    public void pause(View view){
        if(mediaPlayer !=null && mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
        Toast.makeText(this, "暂停成功", Toast.LENGTH_SHORT).show();

    }
    public void stop(View view){
        if(mediaPlayer !=null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        Toast.makeText(this, "停止成功", Toast.LENGTH_SHORT).show();
    }
    public void ready(){
        if(mediaPlayer == null){
            mediaPlayer = new MediaPlayer();
//            File file = new File(Environment.getExternalStorageDirectory(),"he.mp3");
//            Uri uri = Uri.fromFile(file);
            try {
//                mediaPlayer.setDataSource(this,uri);
                mediaPlayer.setDataSource("/sdcard/he.mp3");
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public void play2(View view){
        Intent intent1 = new Intent("receiver_music");
        intent1.putExtra("cmd", Tools.START);
        sendBroadcast(intent1);

    }
    public void pause2(View view){
        Intent intent1 = new Intent("receiver_music");
        intent1.putExtra("cmd", Tools.PAUSE);
        sendBroadcast(intent1);

    }
    public void stop2(View view){
        Intent intent1 = new Intent("receiver_music");
        intent1.putExtra("cmd", Tools.STOP);
        sendBroadcast(intent1);

    }




}
