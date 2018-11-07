package com.example.helenkellercompute.guokun.handlerOrMessage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.helenkellercompute.guokun.R;

/**
 * Created by Helen keller compute on 2018/4/1.
 */

public class HandlerOrMessage1 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hndler_or_message_demo_layout);
    }
    public void handlerOrMessageDemoOnclick(View view){
        Intent intent = new Intent(this,HndlerOrMessageDemo.class);
        startActivity(intent);
    }
    public void handlerOrMessageDemoOnclick2(View view){
        Intent intent = new Intent(this,HndlerOrMessageDemo2.class);
        startActivity(intent);
    }
}
