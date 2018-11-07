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

public class LayoutObjectDemo extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_object_layout);
    }
    public void LinearLayout(View view){
        Intent intent  = new Intent(this,LayoutLinearLayout.class);
        startActivity(intent);
    }
    public void RelativeLayout(View view){
        Intent intent  = new Intent(this,LayoutRelativeLayout.class);
        startActivity(intent);
    }
    public void TableLayout(View view){
        Intent intent  = new Intent(this,LayoutTableLayout.class);
        startActivity(intent);
    }
    public void FrameLayout(View view){
        Intent intent  = new Intent(this,LayoutFrameLayout.class);
        startActivity(intent);
    }
    public void FrameLayout2(View view){
        Intent intent  = new Intent(this,LayoutFrameLayout2.class);
        startActivity(intent);
    }
    public void GridLayout(View view){
        Intent intent  = new Intent(this,LayoutGridLayout.class);
        startActivity(intent);
    }
    //drawerLayoutOnClick
    public void drawerLayoutOnClick(View view){
        Intent intent  = new Intent(this,DrawerLayout.class);
        startActivity(intent);
    }
    //HorizontalScrollViewLayout
    public void horizontalScrollViewLayoutOnClick(View view){
        Intent intent  = new Intent(this,HorizontalScrollViewLayout.class);
        startActivity(intent);
    }
    public void scrollViewLayoutOnClick(View view){
        Intent intent  = new Intent(this,ScrollViewLayout.class);
        startActivity(intent);
    }
}
