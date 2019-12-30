package com.example.helenkellercompute.guokun.test;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.helenkellercompute.guokun.R;

public class Main2Activity extends AppCompatActivity {
    private TextView textView;
    private static final String TAG = "Main2Activity";
    private static final int MESSAGE_1 = 1;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MESSAGE_1:
                    showData();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.textView);
        Log.i(TAG, "onCreate: "+Thread.currentThread().getName());
        loadData();
    }
    private void loadData(){
        new Thread(){
            @Override
            public void run() {
                Log.i(TAG, "run: "+Thread.currentThread().getName());
                Message message = new Message();
                message.what = MESSAGE_1;
                handler.sendMessage(message);
            }
        }.start();
    }
    private void showData(){
        textView.append("子线程更新数据");
        textView.append("子线程更新数据");
        textView.append("子线程更新数据");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        textView.append("子线程更新数据");
        textView.append("子线程更新数据");
        textView.append("子线程更新数据");
        textView.append("子线程更新数据");
        textView.append("子线程更新数据");
        textView.append("子线程更新数据");
        textView.append("子线程更新数据");
        textView.append("子线程更新数据");
        textView.append("子线程更新数据");
        textView.append("子线程更新数据");
        textView.append("子线程更新数据");
        textView.append("子线程更新数据");
        textView.append("子线程更新数据");
        textView.append("子线程更新数据");
        textView.append("子线程更新数据");
        textView.append("子线程更新数据");
        textView.append("子线程更新数据");
    }
}
