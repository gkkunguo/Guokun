package com.example.helenkellercompute.guokun.thread.handlerthread;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.helenkellercompute.guokun.R;

/**
 * Created by Helen keller compute on 2018/4/30.
 */

public class ThreadActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thread_activity);
    }
    public void handlerThreadOnclick(View view){
        Intent intent = new Intent(this,HandlerThreadActivity.class);
        startActivity(intent);
    }
}
