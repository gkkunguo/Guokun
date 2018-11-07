package com.example.helenkellercompute.guokun.alertdialog;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.helenkellercompute.guokun.R;

public class AlertDialogDemo extends AppCompatActivity {
    private AlertDialog dialog;
    private AlertDialog dialog2;
    private ProgressDialog progressDialog;
    private final static int MSG_PROGRESS = 0X0001;
    private final static int MSG_FINSH = 0X0002;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MSG_PROGRESS:
                    int progress = msg.arg1;
                    progressDialog.setProgress(progress);
                    break;
                case MSG_FINSH:
                    //关闭对话框
                    progressDialog.dismiss();
                    break;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alertdialog_layout);
        createDialog();
        creacteDialogMuli();
        //进度条
        progressDialog = new ProgressDialog(this);//创建一个进度条
        progressDialog.setIcon(R.mipmap.ic_launcher);
        progressDialog.setTitle("进度条");
        progressDialog.setMessage("这是一个进度条");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);//这是设置进度条的方向

    }
    public void creacteDialogMuli(){
        String[] items = {"AAA","BBB","CCC","DDD"};
        dialog2 = new AlertDialog.Builder(this)
                .setTitle("多选框")
                .setIcon(R.mipmap.ic_launcher)
                .setMultiChoiceItems(items, new boolean[]{false, false, true, false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                    }
                })
                .setPositiveButton("确定",null)
                .create();

    }
    public void radioDialogMuli(View view){
        dialog2.show();

    }
    public void createDialog(){
        final String[] items = {"AAA","BBB","CCC","DDD"};
        dialog=  new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("单选对话框")
                .setSingleChoiceItems(items,0,null)//单选按钮集合   默认选中项  监听
                .setPositiveButton("确定",null)//按钮
                .create();
    }

        public void radioDialogOnclickS(View view){
               dialog.show();
    }
    //-----------
    public void listDialogOnclick(View view){
        final String[] items = {"AAA","BBB","CCC","DDD"};
        new AlertDialog.Builder(this).setIcon(R.mipmap.ic_launcher)
                .setTitle("列表圣诞框")
                .setItems(items, new DialogInterface.OnClickListener() {
                    /***
                     * i 是代表列表项的索引，从0 开始
                     *
                     */
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialogDemo.this,items[i],Toast.LENGTH_LONG).show();
                    }
                })
                .show();
    }
//-------------
    public void radioDialogOnclick(View view){
        final String[] items = {"AAA","BBB","CCC","DDD"};
        new AlertDialog.Builder(this).setIcon(R.mipmap.ic_launcher)
                .setTitle("单选对话框")
                .setSingleChoiceItems(items,0,null)//单选按钮集合   默认选中项  监听
                .setPositiveButton("确定",null)//按钮
                .show();
    }
    //---------
    /**进度条对话框
     * */
    public void displayProgressDialog(View view){
        progressDialog.show();
        new Thread(){
            @Override
            public void run() {
                for (int i = 0;i<100;i++){
                    Message message= handler.obtainMessage();
                    message.what = MSG_PROGRESS;
                    message.arg1 = i;
                    handler.sendMessage(message);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                handler.sendEmptyMessage(MSG_FINSH);
            }
        }.start();

    }
}
