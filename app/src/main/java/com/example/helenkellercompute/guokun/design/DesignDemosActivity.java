package com.example.helenkellercompute.guokun.design;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.helenkellercompute.guokun.R;
import com.example.helenkellercompute.guokun.design.MVC.View.BookActivity;
import com.example.helenkellercompute.guokun.design.MVP.View.StudentActivity;

/**
 * Created by Helen keller compute on 2018/5/8.
 */

public class DesignDemosActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.designdemos);
    }

    public void MvcOnclick(View view){
        Intent intent = new Intent(this,BookActivity.class);
        startActivity(intent);
    }
    public void MvpOnclick(View view){
        Intent intent = new Intent(this,StudentActivity.class);
        startActivity(intent);
    }

}
