package com.example.helenkellercompute.guokun.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by Helen keller compute on 2018/1/1.
 */

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String hello = intent.getStringExtra("hello");
        TextView textView = new TextView(this);
        textView.setText(hello);
        setContentView(textView);
    }
}
