package com.example.helenkellercompute.guokun.dataOrOracle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.helenkellercompute.guokun.R;
import com.example.helenkellercompute.guokun.dataOrOracle.oracle.OracleDemo2;

/**
 * Created by Helen keller compute on 2018/4/4.
 */

public class OracleDemo extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oracledemo_layout);
    }
    public void dataSharedPreferencesOnClick(View view){
        Intent intent = new Intent(this,DataSharedPreferences.class);
        startActivity(intent);
    }
    public void dataFileOnClick(View view){
        Intent intent = new Intent(this,DataFile.class);
        startActivity(intent);
    }
    public void dataOracleOnClick(View view){
        Intent intent = new Intent(this,OracleDemo2.class);
        startActivity(intent);
    }





}
