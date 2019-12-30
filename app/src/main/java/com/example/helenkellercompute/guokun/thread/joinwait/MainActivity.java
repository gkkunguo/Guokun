package com.example.helenkellercompute.guokun.thread.joinwait;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.helenkellercompute.guokun.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_thread);
        //wait()方法
//        testWait();
        //join()方法
        testJoin();
    }

    class ThreadTest extends Thread{
        int total;
        @Override
        public void run() {
           synchronized (this){
               for(int i =0;i<1000;i++){
                   total += i;
               }
               notify();
           }
        }
    }
    //ThreadA
    class BThread extends Thread {
        public BThread() {
            super("[BThread] Thread");
        };
        public void run() {
            String threadName = Thread.currentThread().getName();
            Log.i("THREAD",threadName + " --------------------分隔线-------------------.");
            Log.i("THREAD",threadName + " start.");
            try {
                for (int i = 0; i < 5; i++) {
                    Log.i("THREAD",threadName + " loop at " + i);
                    Thread.sleep(1000);
                }
                Log.i("THREAD",threadName + " end.");
            } catch (Exception e) {
                Log.i("THREAD",threadName + ".run");
            }
        }
    }
    class AThread extends Thread {
        public AThread() {
            super("[AThread] Thread");
        }
        public void run() {
            String threadName = Thread.currentThread().getName();
            Log.i("THREAD",threadName + " start.");
            try {
                Log.i("THREAD",threadName + " end.");
            } catch (Exception e) {
                Log.i("THREAD","Exception from " + threadName + ".run");
            }
        }
    }

    private void testJoin() {
        BThread bThread = new BThread();
        AThread aThread = new AThread();
        bThread.start();
        aThread.start();
//        try {
//            bThread.start();
//            bThread.join();
//            aThread.start();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
    private void testWait() {
        new Thread(){
            @Override
            public void run() {
                ThreadTest threadTest = new ThreadTest();
                threadTest.start();
                synchronized (threadTest){
                    try {
                        Log.i("THREAD","开始计算");
                        //等待threadTest运行完成再执行下面的内容；
                       threadTest.wait();
                        Log.i("THREAD","计算结果："+threadTest.total);
                        Log.i("THREAD","计算完成");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        IntentFilter intentFilter = new IntentFilter();
    }
}
