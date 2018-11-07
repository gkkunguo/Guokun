package com.example.helenkellercompute.guokun.musicandvideo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Helen keller compute on 2018/4/16.
 */

public class MySurfaceView extends SurfaceView {
    private SurfaceHolder surfaceHolder;
    private Paint paint;
    public MySurfaceView(Context context) {
        super(context);
        init();
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public void init(){
        paint  = new Paint();
        paint.setColor(Color.BLUE);
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                //surface被创建

            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                //surface被改变
                draw();

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                //surface被销毁

            }
        });
    }
    public void draw(){
        Canvas canvas = surfaceHolder.lockCanvas();
        if(canvas != null){
            canvas.drawCircle(100,100,50,paint);
            surfaceHolder.unlockCanvasAndPost(canvas);
        }

    }
}
