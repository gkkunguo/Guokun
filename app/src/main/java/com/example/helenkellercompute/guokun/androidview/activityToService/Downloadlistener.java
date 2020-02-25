package com.example.helenkellercompute.guokun.androidview.activityToService;

public interface Downloadlistener {
    //下载成功
    void sucessListener(String s);
    //下载失败
    void errorLinstener(String s);
    //下载进度度
    void downloadProgress(int progress);
}
