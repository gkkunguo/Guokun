package com.example.helenkellercompute.guokun.spinner;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.helenkellercompute.guokun.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Helen keller compute on 2018/4/3.
 */

public class SpinnerDemo extends Activity {
    private Spinner spinner1,spinner11,spinner22;
    private String[] data ={
            "AAA",
            "BBB",
            "CCC",
            "DDD"
    };
    private List<String> courseList = new ArrayList<String>();
    private List<String> studentList = new ArrayList<String>();
    ArrayAdapter<String> spinner22Adapter;
    private Map<String,List<String>>  students = new HashMap<String, List<String>>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sppinnerdemo_layout);
        spinner1  = (Spinner) findViewById(R.id.spinner1);
        spinner11  = (Spinner) findViewById(R.id.spinner11);
        spinner22  = (Spinner) findViewById(R.id.spinner22);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                android.R.id.text1,
                data
        );
        spinner1.setAdapter(adapter1);
        fillData();


        ArrayAdapter<String> spinner11Adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                courseList
        );
        spinner11.setAdapter(spinner11Adapter);
        spinner11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                studentList.clear();//之前选中的给清空
                String selectGrade = courseList.get(position);
                studentList.addAll(students.get(selectGrade));
                spinner22Adapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

         spinner22Adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                studentList
        );
        spinner22.setAdapter(spinner22Adapter);
    }
    private void fillData() {
        courseList.add("Android班");
        courseList.add("JAVA班");

        //学生信息
        List<String> stuAndroid = new ArrayList<String>();
        stuAndroid.add("张三");
        stuAndroid.add("李四");
        stuAndroid.add("王五");

        List<String> stuJava = new ArrayList<String>();
        stuJava.add("郭坤");
        stuJava.add("赵利");
        stuJava.add("刘轩");

        students.put(courseList.get(0),stuAndroid);
        students.put(courseList.get(1),stuJava);

    }
}
