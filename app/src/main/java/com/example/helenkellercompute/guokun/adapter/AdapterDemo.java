package com.example.helenkellercompute.guokun.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.helenkellercompute.guokun.R;

/**
 * Created by Helen keller compute on 2018/4/3.
 */

public class AdapterDemo extends Activity {
    private String[] data={"北京","上海","天津"};
    private ListView listView,listView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapterdemo_layout);
        listView = (ListView)findViewById(R.id.listview1);
        listView2 = (ListView)findViewById(R.id.listview2);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {//设置点击事件
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(AdapterDemo.this,data[position],Toast.LENGTH_SHORT).show();

            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.adapterdemo_adapter_layout,
                R.id.text,
                data
        );
        listView.setAdapter(adapter);


        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(AdapterDemo.this,data[position],Toast.LENGTH_SHORT).show();
            }
        });
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                data
        );

        listView2.setAdapter(adapter1);
    }

    public void baseAdapteOnclick(View view){
        Intent intent = new Intent(this,BaseAdapterDemo.class);
        startActivity(intent);
    }

}
