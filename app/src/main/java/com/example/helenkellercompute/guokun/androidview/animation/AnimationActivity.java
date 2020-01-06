package com.example.helenkellercompute.guokun.androidview.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.helenkellercompute.guokun.R;

import java.util.ArrayList;
import java.util.LinkedList;

public class AnimationActivity extends AppCompatActivity {
    Button tween_start;
    private LinkedList arrayList;
    private static final String TAG = "AnimationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        final ImageView tween_image = findViewById(R.id.tween_image);
        tween_start = findViewById(R.id.tween_start);

        // 加载动画资源
        final Animation anim = AnimationUtils.loadAnimation(this,R.anim.tween_anim);
        //设置动画结束后保留结束状态
        anim.setFillAfter(true);

        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        tween_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tween_image.startAnimation(anim);
            }
        });

        px();
    }
    private void px(){
        int[] ns = new int[]{20,1,8,2,9,92,3};
        for(int i = 0 ; i < ns.length-1;i++){
            for(int j = 0; j < ns.length - 1; j++){
                int fi = ns[j];
                int temp = fi;
                int li = ns[j+1];
                if(fi>li){
                    ns[j] = ns[j+1];
                    ns[j+1] = temp;
                }
            }
        }
        for(int g = 0;g <ns.length;g++){
            Log.i(TAG, "px: "+ns[g]);
        }
    }
}
