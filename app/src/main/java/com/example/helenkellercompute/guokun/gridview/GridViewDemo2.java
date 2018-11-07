package com.example.helenkellercompute.guokun.gridview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import com.example.helenkellercompute.guokun.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Helen keller compute on 2017/12/31.
 */

public class GridViewDemo2 extends Activity implements View.OnClickListener {
    private Button button;
    private EditText editText;
    private GridView gridView;
    //数据源
    List<String> studenNames= new ArrayList<String>();
    //适配器
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridvied_add_layout);
        //关联控件
        initControl();
        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                studenNames
        );
        gridView.setAdapter(adapter);
    }

    private void initControl() {
        button = (Button) findViewById(R.id.button1);
        editText = (EditText) findViewById(R.id.editeText2);
        gridView = (GridView) findViewById(R.id.gridView3);

        button.setOnClickListener(this);

    }
//增加学生
    @Override
    public void onClick(View view) {
        String student = editText.getText().toString().trim();
        studenNames.add(student);
        adapter.notifyDataSetChanged();


    }
}
