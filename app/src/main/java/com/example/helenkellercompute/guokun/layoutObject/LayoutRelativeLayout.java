package com.example.helenkellercompute.guokun.layoutObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.helenkellercompute.guokun.R;

/**
 * Created by Helen keller compute on 2018/3/29.
 */

public class LayoutRelativeLayout extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_relativelayout_layout);
    }
    public void RelativeLayoutOnclicks(View view){
        Intent intent = new Intent(this,LayoutRelativeLayout2.class);
        startActivity(intent);
    }

}
