package com.example.helenkellercompute.guokun;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Helen keller compute on 2018/3/27.
 */

public class OnTouch extends Activity {
    private View view;
    private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ontouch_layout);
        textView = (TextView) findViewById(R.id.textView);
        view = (View)findViewById(R.id.view);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        textView.setText("按下");
                        break;
                    case MotionEvent.ACTION_UP:
                        textView.setText("弹起");
                        break;
                }
                return true;
            }
        });
    }
}
