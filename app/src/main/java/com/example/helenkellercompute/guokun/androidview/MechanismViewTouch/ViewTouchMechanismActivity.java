package com.example.helenkellercompute.guokun.androidview.MechanismViewTouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.helenkellercompute.guokun.R;

public class ViewTouchMechanismActivity extends AppCompatActivity {
    private Button buttonId;
    private static final String TAG = "GUOKUN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_touch_mechanism);

        buttonId = findViewById(R.id.buttonId);
        
        buttonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: ");
            }
        });
        buttonId.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i(TAG, "onTouch: "+event.getAction());
                return false;
            }
        });
    }
}
