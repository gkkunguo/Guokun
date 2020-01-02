package com.example.helenkellercompute.guokun.androidview.SwipeRefreshLayout_banner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class SwipeRefreshLayoutCustom extends SwipeRefreshLayout {
    // 分别记录上次滑动的坐标
    private int mLastX = 0;
    private int mLastY = 0;
    private int x= 0;
    private int y= 0;

    public SwipeRefreshLayoutCustom(@NonNull Context context) {
        super(context);
    }

    public SwipeRefreshLayoutCustom(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }



    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {

                x = (int) event.getX();
                y = (int) event.getY();
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                mLastX = (int)event.getX();
                mLastY = (int)event.getY();
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;
                if (Math.abs(deltaX) > Math.abs(deltaY)) {
                    return false;
                }

                break;
            }
            case MotionEvent.ACTION_UP: {
                break;
            }
            default:
                break;
        }

        return super.onInterceptTouchEvent(event);
    }
}
