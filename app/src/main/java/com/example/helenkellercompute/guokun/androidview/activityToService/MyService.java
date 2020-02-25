package com.example.helenkellercompute.guokun.androidview.activityToService;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {
    public static final int PROGRESS_LEN = 100;
    public int progress = 0;
    private Downloadlistener downloadlistener;

    public Downloadlistener getDownloadlistener() {
        return downloadlistener;
    }

    public void setDownloadlistener(Downloadlistener downloadlistener) {
        this.downloadlistener = downloadlistener;
    }

    public int getProgress() {
        return progress;
    }


    public void startDownload(){
        new Thread(){
            @Override
            public void run() {

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if(progress < 100){
                            progress += 5;
                            if(downloadlistener != null){
                                downloadlistener.downloadProgress(progress);
                            }
                        }else {
                            if (downloadlistener != null){
                                downloadlistener.sucessListener("文件下载成功！");
                            }
                        }

                    }
                },1000,1000);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    public class MyBinder extends Binder{
        public MyService getService(){
            return MyService.this;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
