package com.example.helenkellercompute.guokun.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.helenkellercompute.guokun.R;
import com.example.helenkellercompute.guokun.entity.Translation;
import com.example.helenkellercompute.guokun.entity.Translation1;
import com.example.helenkellercompute.guokun.i.GetRequest_Interface;
import com.example.helenkellercompute.guokun.i.PostRequest_Interface;
import com.example.helenkellercompute.guokun.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
//        request();
        request1();
    }

    public void request() {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fanyi.youdao.com/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build();

        retrofit.create(PostRequest_Interface.class)
                .getCall("I love you")
                .enqueue(new Callback<Translation1>() {
                    //请求成功时回调
                    @Override
                    public void onResponse(Call<Translation1> call, Response<Translation1> response) {
                        // 请求处理,输出结果
                        // 输出翻译的内容
                        if (response.isSuccessful()) {
                            Log.v(Constants.TAG_GUOKUN, "翻译是：" + response.body().getTranslateResult().get(0).get(0).getTgt());
                        }
                    }

                    //请求失败时回调
                    @Override
                    public void onFailure(Call<Translation1> call, Throwable throwable) {
                        Log.v(Constants.TAG_GUOKUN, "请求失败");
                        System.out.println(throwable.getMessage());
                    }
                });
    }

    public void request1() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build();
        retrofit.create(GetRequest_Interface.class)
                .getCall().enqueue(new Callback<Translation>() {
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                if (response.isSuccessful()){
                    Translation.TranslationEntity content = response.body().content;
                    Log.i(Constants.TAG_GUOKUN,"重新调整了数据实体"+content.word_mean.get(0).toString());
                }
            }

            @Override
            public void onFailure(Call<Translation> call, Throwable throwable) {
                System.out.println("连接失败");
            }
        });
    }
}
