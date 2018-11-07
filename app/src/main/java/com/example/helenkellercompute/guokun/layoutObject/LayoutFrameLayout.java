package com.example.helenkellercompute.guokun.layoutObject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.example.helenkellercompute.guokun.R;

/**
 * Created by Helen keller compute on 2018/3/30.
 */

public class    LayoutFrameLayout extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_framelayout_layout);
        FrameLayout frameLayout =(FrameLayout)findViewById(R.id.mylayout);
        final MeziView mezi = new MeziView(LayoutFrameLayout.this);
        mezi.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mezi.bitmapX = event.getX() -150;
                mezi.bitmapY = event.getY() -150;
                mezi.invalidate();
                return true;
            }
        });
        frameLayout.addView(mezi);

    }
}
