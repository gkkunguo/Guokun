package com.example.helenkellercompute.guokun.musicandvideo;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

import com.example.helenkellercompute.guokun.basis.Tools.Tools;

import java.io.IOException;

/**
 * Created by Helen keller compute on 2018/4/16.
 */

    public class MusicDemoService extends Service {
    private MediaPlayer mediaPlayer;
    private MusicReceiver musicReceiver;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;

        }
        super.onDestroy();
        unregisterReceiver(musicReceiver);
    }

    @Override
    public void onCreate() {
        mediaPlayer = new MediaPlayer();
        musicReceiver = new MusicReceiver();
        IntentFilter intentFilter = new IntentFilter("receiver_music");
        registerReceiver(musicReceiver,intentFilter);
        super.onCreate();
    }
    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        ready();
        return super.onStartCommand(intent, flags, startId);
    }

    private void ready(){
        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource("/sdcard/he.mp3");
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start(){
        mediaPlayer.start();
    }
    private void pause(){
        mediaPlayer.pause();
    }
    private void stop(){
        mediaPlayer.stop();
        ready();
    }

    //广播
    class MusicReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            int cmd = intent.getIntExtra("cmd",-1);
            switch (cmd){
                case Tools.START:
                    start();
                    break;
                case Tools.PAUSE:
                    pause();
                    break;
                case Tools.STOP:
                    stop();
                    break;

            }
        }
    }

}
