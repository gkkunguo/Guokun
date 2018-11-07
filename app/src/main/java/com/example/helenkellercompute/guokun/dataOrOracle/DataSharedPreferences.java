package com.example.helenkellercompute.guokun.dataOrOracle;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.helenkellercompute.guokun.R;

/**
 * Created by Helen keller compute on 2018/4/4.
 */

public class DataSharedPreferences extends Activity {
    private EditText etData;
    private SharedPreferences preferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_sharedpreferences_layout);
        initDate();
    }
    public void  dataSharedPreferences1OnClick(View view){
        String etDataTest = etData.getText().toString();
        //获取编辑器
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("test",etDataTest);
        editor.commit();
        Toast.makeText(DataSharedPreferences.this,"提交成功",Toast.LENGTH_SHORT).show();
    }
    public void  dataSharedPreferencesReadOnClick(View view){
        //读取信息
        String read = preferences.getString("test","");
        etData.setText(read);
        Toast.makeText(DataSharedPreferences.this,"读取成功",Toast.LENGTH_SHORT).show();
    }

    public void  initDate(){
        etData  = (EditText) findViewById(R.id.etData);
        /**
         * 一、取得SharedPreferences
         * 二、参数一：是存储文件的名称；参数二：进入模式，只有当前程序自身使用
         * */
        preferences = getSharedPreferences("test", Context.MODE_PRIVATE);

    }
}
