package com.example.helenkellercompute.guokun.layoutObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.helenkellercompute.guokun.R;

/**
 * Created by Helen keller compute on 2018/3/30.
 */

public class LayoutGridLayout extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_gridlayout_layout);
    }
    public void layoutGridlayouLayouOnclick1(View view){
        Intent intent = new Intent(this,LayoutGridLayout1.class);
        startActivity(intent);
    }
    public void layoutGridlayouLayouOnclick2(View view){
        Intent intent = new Intent(this,LayoutGridLayout2.class);
        startActivity(intent);
    }
}
