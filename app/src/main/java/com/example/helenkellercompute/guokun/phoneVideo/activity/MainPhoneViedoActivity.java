package com.example.helenkellercompute.guokun.phoneVideo.activity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.helenkellercompute.guokun.R;
import com.example.helenkellercompute.guokun.phoneVideo.base.BasePager;
import com.example.helenkellercompute.guokun.phoneVideo.base.Permission;
import com.example.helenkellercompute.guokun.phoneVideo.fragment.ReplaceFragment;
import com.example.helenkellercompute.guokun.phoneVideo.page.AudioPager;
import com.example.helenkellercompute.guokun.phoneVideo.page.NetAudioPager;
import com.example.helenkellercompute.guokun.phoneVideo.page.NetVideoPager;
import com.example.helenkellercompute.guokun.phoneVideo.page.VideoPager;

import java.util.ArrayList;

/**
 * Created by Helen keller compute on 2018/4/18.
 */

public class MainPhoneViedoActivity extends FragmentActivity {
    private FrameLayout fl_content_main;
    private RadioGroup rb_button_tag;
    private static final int PERMISSION_REQUEST_CODE = 1; //权限请求码
    /**
     * 页面的集合
     */
    private ArrayList<BasePager> arrayList;

    private int postion;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainphoneviedo_layout);
        fl_content_main = (FrameLayout) findViewById(R.id.fl_content_main);
        rb_button_tag = (RadioGroup) findViewById(R.id.rb_button_tag);
        arrayList = new ArrayList<>();


        NetVideoPager netVideoPager = new NetVideoPager(this);
        arrayList.add(netVideoPager);//视频     2
        arrayList.add(new AudioPager(this));//音频        1
        arrayList.add(new VideoPager(this));//网上视频    0
        arrayList.add(new NetAudioPager(this));//网上音频 3


        //设置按钮的监听
        rb_button_tag.setOnCheckedChangeListener(new CheckedChangeListener());
        //默认选中
        rb_button_tag.check(R.id.rb_video);
        Permission.isGrantExternal(MainPhoneViedoActivity.this);

    }

    /**
     * 根据位置得到对应的页面
     *
     * @return
     */
    private BasePager getBasePage() {
        BasePager basePage = arrayList.get(postion);
        if (basePage != null && !basePage.isInitData) {
            basePage.initData();
            basePage.isInitData = true;
        }
        return basePage;
    }

    class CheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                default:
                    postion = 2;
                    break;
                case R.id.rb_2:
                    postion = 1;
                    break;
                case R.id.rb_3:
                    postion = 0;
                    break;
                case R.id.rb_4:
                    postion = 3;
                    break;
            }
            setFragment();
        }
    }

    /**
     * 把页面增加到fragment中
     */

    private void setFragment() {
        //1.得到FragmentManager
        FragmentManager fm = getSupportFragmentManager();
        //2.开启事务
        FragmentTransaction ft = fm.beginTransaction();
        //3.替换
        ft.replace(R.id.fl_content_main, new ReplaceFragment(getBasePage()));
        //4.提交事务
        ft.commit();
    }

}
