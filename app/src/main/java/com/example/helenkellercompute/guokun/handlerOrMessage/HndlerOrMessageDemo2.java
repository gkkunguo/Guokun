package com.example.helenkellercompute.guokun.handlerOrMessage;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.helenkellercompute.guokun.R;

/**
 * Created by Helen keller compute on 2018/4/1.
 */

public class HndlerOrMessageDemo2 extends Activity {
    private TextView textView;
    private LinearLayout layout;
    class myRunnalbe implements Runnable{

        @Override
        public void run() {

        }
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what ==0x001 ){
                textView.setText(msg.arg1 + "");
            }
        }
    };
    Thread thread = new Thread(){
        @Override
        public void run() {
            for(int i = 0;i<100;i++){
                Message message = new Message();
                message.what = 0x001;
                message.arg1 = i;
                handler.sendMessage(message);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hndler_or_message_layout2);
        textView = (TextView)findViewById(R.id.tvText);
        layout =(LinearLayout) findViewById(R.id.layout1);



    }
    public void test(View view){
        final Handler handler3 = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    handler3.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText("post");//更新UI
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
