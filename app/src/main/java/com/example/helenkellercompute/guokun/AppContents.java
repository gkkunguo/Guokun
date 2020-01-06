package com.example.helenkellercompute.guokun;
import com.example.helenkellercompute.guokun.BroadcastReceiver.BroadcastReceiverBootUp;
import com.example.helenkellercompute.guokun.activity.OkhttpActivity;
import com.example.helenkellercompute.guokun.activity.RetrofitActivity;
import com.example.helenkellercompute.guokun.adapter.AdapterDemo;
import com.example.helenkellercompute.guokun.alertdialog.AlertDialogDemo;
import com.example.helenkellercompute.guokun.androidview.animation.AnimationActivity;
import com.example.helenkellercompute.guokun.androidview.videobarrage.MainActivity;
import com.example.helenkellercompute.guokun.dataOrOracle.OracleDemo;
import com.example.helenkellercompute.guokun.design.DesignDemosActivity;
import com.example.helenkellercompute.guokun.gridview.GridViewDemo;
import com.example.helenkellercompute.guokun.handlerOrMessage.HandlerOrMessage1;
import com.example.helenkellercompute.guokun.intent.IntenDemo;
import com.example.helenkellercompute.guokun.ipc.binder.BinderPoolActivity;
import com.example.helenkellercompute.guokun.json.JsonDemo;
import com.example.helenkellercompute.guokun.layoutObject.LayoutObjectDemo;
import com.example.helenkellercompute.guokun.musicandvideo.MusicAndVideoDemo;
import com.example.helenkellercompute.guokun.spinner.SpinnerDemo;
import com.example.helenkellercompute.guokun.thread.handlerthread.ThreadActivity;
import com.example.helenkellercompute.guokun.webview.MainActivity_Webview;
import com.example.helenkellercompute.guokun.xml.XmlDemo;

public class AppContents {
    //触屏
    private OnTouch onTouch;

    //Service
    private ServiceDemo serviceDemo;

    //广播
    private BroadcastReceiverDemo broadcastReceiverDemo;

    //布局文件
    private LayoutObjectDemo layoutObjectDemo;

    //Handler
    private HandlerOrMessage1 handlerOrMessage1;

    //解析文件
    private XmlDemo xmlDemo;
    private JsonDemo jsonDemo;


    //设计模式
    private DesignDemosActivity designDemosActivity;

    //音频与视频与拍照
    private MusicAndVideoDemo musicAndVideoDemo;

    //数据存储
    private OracleDemo oracleDemo;

    //Thread
    private ThreadActivity threadActivity;

    //gridView
    private GridViewDemo gridViewDemo;

    //IntenDemo
    private IntenDemo intenDemo;

    //AlertDialog解析
    private AlertDialogDemo alertDialogDemo;

    //适配器
    private AdapterDemo adapterDemo;

    //级联
    private SpinnerDemo spinnerDemo;

    //okhttp
    private OkhttpActivity okh;
    //Retrofit
    private RetrofitActivity retrofitActivity;
    //弹幕
    MainActivity mainActivity;
    //开机广播、关机广播
    BroadcastReceiverBootUp broadcastReceiverBootUp;
    //动画
    AnimationActivity animationActivity;
    //webview与android源码交互、
    MainActivity_Webview mainActivity_webview;
    //ipc binder机制
    BinderPoolActivity binderPoolActivity;
}
