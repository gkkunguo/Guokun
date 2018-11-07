package com.example.helenkellercompute.guokun.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.helenkellercompute.guokun.R;

/**
 * Created by Helen keller compute on 2018/4/3.
 */

public class BaseAdapterDemo extends Activity {
    private ListView listView;
    private ListView listView1;
    private int[] imageIds={
            R.mipmap.ic_t3,
            R.mipmap.ic_launcher,
            R.mipmap.ic_t4,
            R.mipmap.ic_t3,
            R.mipmap.ic_twok,
    };
    private String[] names={
            "one","two","three","four","five"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adpter_baseddapterdemo_layout);
        listView1 = (ListView)findViewById(R.id.listview);
        listView1.setAdapter(new MyAdapter());
    }
    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return names.length;
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
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = null;
            ViewHolder viewHolder = null;
            if(view == null){//提高效率1
                LayoutInflater inflater = LayoutInflater.from(BaseAdapterDemo.this);
                view1 = inflater.inflate(R.layout.adapter_baseapter_layout,viewGroup,false);
                viewHolder = new ViewHolder(view1);
                view1.setTag(viewHolder);
            }else {
                view1 = view;
                viewHolder = (ViewHolder)view1.getTag();
            }
            //提交效率二：
            //填充当前的数据不用每次都去查找这个findViewById。
            ImageView imageView = viewHolder.getImage();
            imageView.setImageResource(imageIds[i]);
            TextView textView =viewHolder.getTextView();
            textView.setText(names[i]);
            return view1;
        }
        class ViewHolder{
            private View view;
            private ImageView imageView;
            private TextView textView;

            public ViewHolder(View view) {
                this.view = view;
            }
            public ImageView getImage(){
                if(imageView == null){
                    imageView = (ImageView) view.findViewById(R.id.ivtp);
                }
                return imageView;
            }
            public  TextView getTextView(){
                if(textView == null){
                    textView = (TextView) view.findViewById(R.id.tvname);
                }
                return textView;
            }
        }
    }
}
