package com.example.helenkellercompute.guokun.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.helenkellercompute.guokun.R;

public class OneActivityIntentTwoActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_intent_two);
        textView = (TextView)findViewById(R.id.tv2);
    }
        public void secondActivity(View view){
        Intent intent   = new Intent();
        intent.setClass(this,SecondActivity.class);
        intent.putExtra("hello","你好！");
        startActivity(intent);
    }
    public void systemActivity(View view){
        Log.i("TEST","222222222222");
        Intent intent   = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("content://contacts/people/2"));
        startActivity(intent);
    }
    public void thirdActivity(View view){
        Intent intent   = new Intent();
        intent.setClass(this,ThirdActivity.class);
        intent.putExtra("hello","你好！");
        //传值
        intent.putExtra("bumber1",10);
        intent.putExtra("bumber2",20);
        //启动并接收返回的结果
        startActivityForResult(intent,0x001);//请求码0x001，是需要有东西返回 来的
//        startActivity(intent);
    }
    /***
     *当有返回值自动调用
     */


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==0x001 && resultCode == 0x002){
            int result = data.getIntExtra("result",-1);
            textView.setText(result + "");

        }

    }
}
