package com.example.helenkellercompute.guokun.androidview.SwipeRefreshLayout_banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.youth.banner.Banner;

public class BannerCustom extends Banner {
    // 分别记录上次滑动的坐标
    private int mLastX = 0;
    private int mLastY = 0;
    public BannerCustom(Context context) {
        super(context);
    }

    public BannerCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BannerCustom(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                requestDisallowInterceptTouchEvent(true);//让控件的父控件不要调用onInterceptTouchEvent方法
//                让控件的父控件不要调用onInterceptTouchEvent方法,并且不要拦截事件,这样子控件就能拿到所有的事件,然后根据自己的逻辑进行处理）
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;
                if (Math.abs(deltaX) < Math.abs(deltaY)) {//y>x 调用你父控件onInterceptTouchEvent方法
                    requestDisallowInterceptTouchEvent(false);
                }
                break;
            }
            case MotionEvent.ACTION_UP: {
                break;
            }
            default:
                break;
        }

        mLastX = x;
        mLastY = y;
        return super.dispatchTouchEvent(event);
    }
}
