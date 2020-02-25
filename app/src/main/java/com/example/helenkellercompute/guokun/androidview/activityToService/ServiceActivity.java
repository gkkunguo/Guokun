package com.example.helenkellercompute.guokun.androidview.activityToService;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.helenkellercompute.guokun.R;

import java.util.Timer;
import java.util.TimerTask;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private ProgressBar mProgressBar;
    private Button mButton;
    private MyService myService;
    private static final int SUCCESS = 1000;
    private static final int ERROR = 2000;



    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case SUCCESS:
                    Toast.makeText(ServiceActivity.this,"下载成功！",Toast.LENGTH_SHORT).show();
                    break;
                case ERROR:
                    Toast.makeText(ServiceActivity.this,"下载失败！",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        mProgressBar = findViewById(R.id.mProgressBar);
        mButton = findViewById(R.id.mStartButton);
        mButton.setOnClickListener(this);

    }


    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Toast.makeText(ServiceActivity.this,"连接成功！",Toast.LENGTH_SHORT).show();
            myService = ((MyService.MyBinder) service).getService();
            myService.startDownload();
            myService.setDownloadlistener(new Downloadlistener() {
                @Override
                public void sucessListener(String s) {
                    mHandler.sendEmptyMessage(SUCCESS);
                }

                @Override
                public void errorLinstener(String s) {
                    mHandler.sendEmptyMessage(ERROR);
                }

                @Override
                public void downloadProgress(int progress) {
                    mProgressBar.setProgress(progress);
                }
            });
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Toast.makeText(ServiceActivity.this,"断开连接！",Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mStartButton:
                Intent intent = new Intent(this,MyService.class);
                bindService(intent, serviceConnection, Service.BIND_AUTO_CREATE);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        unbindService(serviceConnection);
        super.onDestroy();
    }
}
