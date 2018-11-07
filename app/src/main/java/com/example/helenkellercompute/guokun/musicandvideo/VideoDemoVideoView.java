package com.example.helenkellercompute.guokun.musicandvideo;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.helenkellercompute.guokun.R;

/**
 * Created by Helen keller compute on 2018/4/16.
 */

public class VideoDemoVideoView extends Activity {
    public VideoView videoView;
    private static final int PERMISSION_REQUEST_CODE = 1; //权限请求码
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videodemo_videoview_layout);
        if (checkPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            //获取权限后的操作。读取文件
        }else {
            //请求权限
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST_CODE);
        }
        videoView = (VideoView)findViewById(R.id.videoviewId);
        videoView.setVideoURI(Uri.parse("http://flashmedia.eastday.com/newdate/news/2016-11/shznews1125-19.mp4"));
        //MediaController控制播放器的“进度条”、“暂停”、“快进”
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.requestFocus();//取得焦点
        try {
            videoView.start();
        }catch (Exception e){

        }
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(VideoDemoVideoView.this,"播放完成",Toast.LENGTH_SHORT).show();
            }
        });
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
}
