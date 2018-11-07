package com.example.helenkellercompute.guokun.gridview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helenkellercompute.guokun.R;

/**
 * Created by Helen keller compute on 2018/4/4.
 */

public class GridViewDemo extends Activity {
    private static final String[] data={"北京","上海","天津","四川","湖南","湖北"};
    private GridView gridView;
    private GridView gridView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridviewdemo_layout);
        gridView = (GridView)findViewById(R.id.gvId);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                data
        );
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridViewDemo.this,data[i],Toast.LENGTH_SHORT).show();
            }
        });
        gridView2 = (GridView)findViewById(R.id.gridView2 );
        gridView2.setAdapter(new MyAdapter());
    }
    class MyAdapter extends BaseAdapter {
        private int[] imageIds={
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher2,
                R.mipmap.ic_launcher3,
                R.mipmap.ic_launcher4
        };
        private String[] imagesNames={
                "image1",
                "image2",
                "image3",
                "image4"
        };

        @Override
        public int getCount() {
            return imagesNames.length;
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View converView, ViewGroup viewGroup) {
            View view;
            ViewHolder holder;
            if(converView == null){
                view = LayoutInflater.from(GridViewDemo.this).inflate(R.layout.gridview_layout,null);//取得这个布局
                holder = new ViewHolder();
//                holder.image=(ImageView) findViewById(R.id.img);  //注：这样获取将会失败
                holder.image= (ImageView) view.findViewById(R.id.img);
//                holder.tv=(TextView) findViewById(R.id.text1);  //注：这样获取将会失败
                holder.tv=(TextView) view.findViewById(R.id.text1);

                view.setTag(holder);
            }else {
                view  =converView ;
                holder =(ViewHolder)view.getTag();
            }
            ImageView imageViewHolder = holder.image;
            TextView textViewHolder = holder.tv;
            imageViewHolder.setImageResource(imageIds[i]);
            textViewHolder.setText(imagesNames[i]);
            return view;
        }
    }
    //持有者
    class ViewHolder{
        ImageView image;
        TextView tv;


    }
    public  void gridViewAddOnClick(View view){
        Intent intent = new Intent(this,GridViewDemo2.class);
        startActivity(intent);
    }
}
