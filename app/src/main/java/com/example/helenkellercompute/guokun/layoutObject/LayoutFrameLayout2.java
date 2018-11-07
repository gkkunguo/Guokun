package com.example.helenkellercompute.guokun.layoutObject;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.example.helenkellercompute.guokun.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Helen keller compute on 2018/3/30.
 */

public class LayoutFrameLayout2 extends Activity {
    FrameLayout frame;
    Handler handler     = new Handler(){
            int i=0;

        @Override
        public void handleMessage(Message msg) {
            if(msg.what== 0x123){
                i++;
                move( i % 8);
                }
            super.handleMessage(msg);
        }
    };
    void move(int i)
    {
        Drawable a = getResources().getDrawable(R.drawable.s_1);
        Drawable b = getResources().getDrawable(R.drawable.s_2);
        Drawable c = getResources().getDrawable(R.drawable.s_3);
        Drawable d = getResources().getDrawable(R.drawable.s_4);
        Drawable e = getResources().getDrawable(R.drawable.s_5);
        Drawable f = getResources().getDrawable(R.drawable.s_6);
        Drawable g = getResources().getDrawable(R.drawable.s_7);
        Drawable h = getResources().getDrawable(R.drawable.s_8);
        //通过setForeground来设置前景图像
        switch(i)
        {
            case 0:
                frame.setForeground(a);
                break;
            case 1:
                frame.setForeground(b);
                break;
            case 2:
                frame.setForeground(c);
                break;
            case 3:
                frame.setForeground(d);
                break;
            case 4:
                frame.setForeground(e);
                break;
            case 5:
                frame.setForeground(f);
                break;
            case 6:
                frame.setForeground(g);
                break;
            case 7:
                frame.setForeground(h);
                break;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_framelayout_layout2);
       frame = (FrameLayout) findViewById(R.id.mylayout);
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                //发送一条空信息来通知系统改变前景图片
                handler.sendEmptyMessage(0x123);
            }
        }, 0,170);

    }
}
