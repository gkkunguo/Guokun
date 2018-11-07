package com.example.helenkellercompute.guokun.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.helenkellercompute.guokun.R;

/**
 * Created by Helen keller compute on 2018/4/3.
 */

public class IntenDemo extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intendemo_layout);


    }
    public void intent2(View view){
        Intent intent = new Intent();
        intent.setAction("guokun_test_intent");
        startActivity(intent);
    }
    public void intent3(View view){
        Intent intent = new Intent(this,OneActivityIntentTwoActivity.class);
        startActivity(intent);
    }

}
