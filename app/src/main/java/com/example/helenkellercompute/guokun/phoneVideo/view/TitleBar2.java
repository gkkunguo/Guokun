package com.example.helenkellercompute.guokun.phoneVideo.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.helenkellercompute.guokun.R;

/**
 * Created by Helen keller compute on 2018/4/21.
 */

public class TitleBar2 extends LinearLayout implements View.OnClickListener {
    private View tv_search,rl_search,iv_record;
    private Context context;
    public TitleBar2(Context context) {
        this(context,null);
    }

    public TitleBar2(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TitleBar2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    /**
     * 当布局文件调用完成时调用这个方法
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        //取得子类
        tv_search = getChildAt(1);
//        rl_search = getChildAt(2);
//        iv_record = getChildAt(3);

        //设置监听事件

        tv_search.setOnClickListener(this);
//        rl_search.setOnClickListener(this);
//        iv_record.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_search:
                Toast.makeText(context, "搜索", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rl_search:
                Toast.makeText(context, "游戏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_record:
                Toast.makeText(context, "记录", Toast.LENGTH_SHORT).show();
                break;

        }

    }
}
