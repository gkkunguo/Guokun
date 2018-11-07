package com.example.helenkellercompute.guokun.layoutObject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.example.helenkellercompute.guokun.R;

/**
 * Created by Helen keller compute on 2018/3/30.
 */

public class MeziView extends View {
    Bitmap bitmap;
    public float bitmapX;
    public float bitmapY;

    public MeziView(Context context) {
        super(context);
        bitmapX= 0;
        bitmapY = 200;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        bitmap =  BitmapFactory.decodeResource(this.getResources(), R.mipmap.s_jump);
        canvas.drawBitmap(bitmap,bitmapX,bitmapY,paint);
        //判断图片是否回收,木有回收的话强制收回图片
        if(bitmap.isRecycled())
        {
            bitmap.recycle();
        }
    }
}
