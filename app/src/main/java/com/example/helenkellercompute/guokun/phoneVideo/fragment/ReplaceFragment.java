package com.example.helenkellercompute.guokun.phoneVideo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helenkellercompute.guokun.phoneVideo.base.BasePager;

/**
 * Created by Helen keller compute on 2018/4/20.
 */

public class ReplaceFragment extends Fragment {
    private BasePager currPager;

    public ReplaceFragment(BasePager pager) {
        this.currPager=pager;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return currPager.rootView;
    }
}
