package com.example.helenkellercompute.guokun.androidview.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.helenkellercompute.guokun.R;

public class ViewActivity extends AppCompatActivity {
    private Button buttonId;
    private static final String TAG = "GUOKUN";

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        buttonId = findViewById(R.id.buttonId);

        buttonId.post(new Runnable() {
            @Override
            public void run() {

                Log.i(TAG, "getRight()): "+px2dip(ViewActivity.this,buttonId.getRight()));
                Log.i(TAG, "getLeft()): "+px2dip(ViewActivity.this,buttonId.getLeft()));
                Log.i(TAG, "getX()): "+px2dip(ViewActivity.this,buttonId.getX()));
                Log.i(TAG, "getY()): "+px2dip(ViewActivity.this,buttonId.getY()));
                Log.i(TAG, "getTop()): "+px2dip(ViewActivity.this,buttonId.getTop()));
                Log.i(TAG, "getBottom()): "+px2dip(ViewActivity.this,buttonId.getBottom()));
                Log.i(TAG, "getTranslationX()): "+px2dip(ViewActivity.this,buttonId.getTranslationX()));
                Log.i(TAG, "getTranslationY()): "+px2dip(ViewActivity.this,buttonId.getTranslationY()));

                Log.i(TAG, "width:"+px2dip(ViewActivity.this,buttonId.getRight()-buttonId.getLeft()));
                Log.i(TAG, "height:"+px2dip(ViewActivity.this,buttonId.getBottom()-buttonId.getTop()));

            }
        });

    }

    public  int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
    public int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }



}
