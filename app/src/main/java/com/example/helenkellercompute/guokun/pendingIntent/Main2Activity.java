package com.example.helenkellercompute.guokun.pendingIntent;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.helenkellercompute.guokun.R;

public class Main2Activity extends AppCompatActivity {
    private NotificationManager notificationManager;
    private int messageNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_pending);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        showUploadDialog();

        findViewById(R.id.lastMonth).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationTest();
            }
        });
    }

    private  void showUploadDialog(){
        AlertDialog dialog =  new AlertDialog.Builder(this)
                .setTitle("提示")
                .setMessage("是否现在上传缓存数据？")
                .setPositiveButton("上传",   new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        notificationTest();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();
        dialog.show();
    }

    private void notificationTest(){
    Intent intent = new Intent(Main2Activity.this,Main2Activity_penging.class);
    PendingIntent pendingIntent = PendingIntent.getActivity(Main2Activity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
    NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
            .setContentTitle("标题")
            .setContentText("内容")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .setNumber(++messageNumber);
    notificationManager.notify(0, builder.build());
    }
}
