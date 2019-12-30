package com.example.helenkellercompute.guokun.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.helenkellercompute.guokun.R;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    private static final String TAG = "Main3Activity";
    private ViewPager viewPager;
    private ViewAdapter viewAdapter;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Log.i(TAG, "onCreate: ");

        viewPager = findViewById(R.id.viewPager);
        fragments = new ArrayList<>();
        fragments.add(new FragmentTest());
        fragments.add(new FragmentTest());
        fragments.add(new FragmentTest());
        fragments.add(new FragmentTest());
        fragments.add(new FragmentTest());
        viewAdapter = new ViewAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(viewAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }
}
