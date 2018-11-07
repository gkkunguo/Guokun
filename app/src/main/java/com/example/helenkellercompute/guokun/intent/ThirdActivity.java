package com.example.helenkellercompute.guokun.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.helenkellercompute.guokun.R;

/**
 * Created by Helen keller compute on 2018/1/1.
 */

public class ThirdActivity extends Activity {
    private Button back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        final Intent intent = getIntent();
        final int number1 = intent.getIntExtra("bumber1",-1);
        final int number2 = intent.getIntExtra("bumber2",-1);

        back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int result =  calc(number1,number2);
                intent.putExtra("result",result);
                setResult(0x002,intent);
                finish();
            }
        });

    }
    private int calc(int num1,int num2){
        return  num1 + num2;
    }
}
