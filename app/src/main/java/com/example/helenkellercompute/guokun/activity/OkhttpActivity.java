package com.example.helenkellercompute.guokun.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.helenkellercompute.guokun.R;
import com.example.helenkellercompute.guokun.utils.Constants;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkhttpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        new Thread(new Runnable() {
            @Override
            public void run() {
                okhttpTest();
                retrofitTest();
            }
        }).start();
    }

    private void retrofitTest() {

    }

    private void okhttpTest(){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.baidu.com/")
                .get()
                .build();

        client.newCall(request)
                .enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i(Constants.TAG_GUOKUN,"onFailure"+call);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i(Constants.TAG_GUOKUN,"onResponse"+call);
            }
        });
    }
}
