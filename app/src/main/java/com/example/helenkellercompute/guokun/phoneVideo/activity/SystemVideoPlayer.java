package com.example.helenkellercompute.guokun.phoneVideo.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.helenkellercompute.guokun.R;
import com.example.helenkellercompute.guokun.utils.UtilTime;


/**
 * Created by Helen keller compute on 2018/4/22.
 */

public class SystemVideoPlayer extends Activity implements View.OnClickListener {
    private VideoView videoView;
    private Uri uri;
    private static final int PERMISSION_REQUEST_CODE = 1; //权限请求码
    private LinearLayout llTop;
    private TextView tvVideoNameStatus;
    private TextView systemTime;
    private LinearLayout llVoiceId;
    private Button btnVoice;
    private SeekBar sbVideo;
    private Button btnSwichPlayer;
    private LinearLayout llBottom;
    private TextView tvTime;
    private SeekBar sbCuor;
    private TextView tvDulation;
    private LinearLayout llButtomId;
    private Button btnExit;
    private Button btnVideoPre;
    private Button btnStop;
    private Button btnVodeoStartPause;
    private Button btnVodeo;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2018-05-01 21:01:32 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        llTop = (LinearLayout)findViewById( R.id.ll_top );
        tvVideoNameStatus = (TextView)findViewById( R.id.tv_video_name_status );
        systemTime = (TextView)findViewById( R.id.system_time );
        llVoiceId = (LinearLayout)findViewById( R.id.ll_voice_id );
        btnVoice = (Button)findViewById( R.id.btn_voice );
        sbVideo = (SeekBar)findViewById( R.id.sb_video );
        btnSwichPlayer = (Button)findViewById( R.id.btn_swich_player );
        llBottom = (LinearLayout)findViewById( R.id.ll_bottom );
        tvTime = (TextView)findViewById( R.id.tv_time );
        sbCuor = (SeekBar)findViewById( R.id.sb_cuor );
        tvDulation = (TextView)findViewById( R.id.tv_dulation );
        llButtomId = (LinearLayout)findViewById( R.id.ll_buttom_id );
        btnExit = (Button)findViewById( R.id.btn_exit );
        btnVideoPre = (Button)findViewById( R.id.btn_video_pre );
        btnStop = (Button)findViewById( R.id.btn_stop );
        btnVodeoStartPause = (Button)findViewById( R.id.btn_vodeo_start_pause );
        btnVodeo = (Button)findViewById( R.id.btn_vodeo_ );

        btnVoice.setOnClickListener( this );
        btnSwichPlayer.setOnClickListener( this );
        btnExit.setOnClickListener( this );
        btnVideoPre.setOnClickListener( this );
        btnStop.setOnClickListener( this );
        btnVodeoStartPause.setOnClickListener( this );
        btnVodeo.setOnClickListener( this );
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2018-05-01 21:01:32 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == btnVoice ) {
            // Handle clicks for btnVoice
        } else if ( v == btnSwichPlayer ) {
            // Handle clicks for btnSwichPlayer
        } else if ( v == btnExit ) {
            // Handle clicks for btnExit
        } else if ( v == btnVideoPre ) {
            // Handle clicks for btnVideoPre
        } else if ( v == btnStop ) {
            // Handle clicks for btnStop
            if(videoView.isPlaying()){
                videoView.pause();
                btnStop.setBackgroundResource(R.drawable.stop);
            }else {
                videoView.start();
                btnStop.setBackgroundResource(R.drawable.start);
            }
        } else if ( v == btnVodeoStartPause ) {
            // Handle clicks for btnVodeoStartPause

        } else if ( v == btnVodeo ) {
            // Handle clicks for btnVodeo
        }
    }

    private static final int PROGRESSS = 1;
    private  Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case PROGRESSS:
                    int currentPostion = videoView.getCurrentPosition();//得到当前的播放进程
                    sbCuor.setProgress(currentPostion);
                    tvTime.setText(new UtilTime().formatTime(currentPostion+1000));

                    //把消息移除掉
                    handler.removeMessages(PROGRESSS);
                    handler.sendEmptyMessageDelayed(PROGRESSS,1000);

                    break;

            }        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_video_player);
        videoView = (VideoView) findViewById(R.id.videoViewPlayer);
        findViews();


//        准备好的监听
        MyOnPreparedListener myOnPreparedListener =new MyOnPreparedListener();
        videoView.setOnPreparedListener(myOnPreparedListener);


        MyOnErrorListener myOnErrorListener = new MyOnErrorListener();
//        r播放出错的监听
        videoView.setOnErrorListener(myOnErrorListener);

        MyOnCompletionListener myOnCompletionListener= new MyOnCompletionListener();

//        播放完成的监听
        videoView.setOnCompletionListener(myOnCompletionListener);

        //得到播放地址
        uri = getIntent().getData();
        Log.i("TEST","uri="+uri);
        if (uri != null) {
            videoView.setVideoURI(uri);
        }
        videoView.setMediaController(new MediaController(this));
    }
    class MyOnPreparedListener implements MediaPlayer.OnPreparedListener {
        @Override
        public void onPrepared(MediaPlayer mp) {
            Log.i("TEST","准备完成");
            videoView.start();
            int duration =mp.getDuration();//获取总时长
            sbCuor.setMax(duration);
//            tvDulation.setText(duration+"");
            UtilTime uitl = new UtilTime();
            tvDulation.setText(uitl.formatTime(duration));
            //发消息
            handler.sendEmptyMessage(PROGRESSS);
        }
    }
    class  MyOnErrorListener implements MediaPlayer.OnErrorListener {
        @Override
        public boolean onError(MediaPlayer mp, int what, int extra) {
            Toast.makeText(SystemVideoPlayer.this, "播放出错了...", Toast.LENGTH_SHORT).show();
            Log.i("TEST","播放出错了");
            return false;
        }
    }
    class MyOnCompletionListener implements MediaPlayer.OnCompletionListener{
        @Override
        public void onCompletion(MediaPlayer mp) {
            Toast.makeText(SystemVideoPlayer.this, "播放完成了...", Toast.LENGTH_SHORT).show();
            Log.i("TEST","播放完成了");
        }
    }
}
