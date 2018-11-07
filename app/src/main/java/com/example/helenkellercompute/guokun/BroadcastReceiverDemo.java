package com.example.helenkellercompute.guokun;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.helenkellercompute.guokun.BroadcastReceiver.BroadcastReceiverSystem;
import com.example.helenkellercompute.guokun.BroadcastStartServiceDemo;

/**
 * Created by Helen keller compute on 2018/3/28.
 */

public class BroadcastReceiverDemo extends Activity {
    private Button myReceiverButton,buttonBs;
    private BroadcastReceiverMyReceiver2 broadcastReceiverMyReceiver2;
    private MyReceiver myReceiver;
    private EditText mathE,englisE,chinesE,etNumber,etContent;
    private SendSmsSuccessReceiver sendSmsSuccessReceiver;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast_receiver_layout);
        myReceiverButton = (Button) findViewById(R.id.broadcastReceireId);
        etContent = (EditText) findViewById(R.id.messageIdB);
        etNumber = (EditText) findViewById(R.id.phoneIdB);

        //动态注册广播
//        sendSmsSuccessReceiver = new SendSmsSuccessReceiver();
//        IntentFilter intentFilter2 = new IntentFilter("guokun_2");
//        registerReceiver(sendSmsSuccessReceiver,intentFilter2);

        mathE = (EditText) findViewById(R.id.mathIdB);
        englisE = (EditText) findViewById(R.id.englishIdB);
        chinesE = (EditText) findViewById(R.id.chinesIdB);
        buttonBs = (Button) findViewById(R.id.buttonBs);

        myReceiver = new MyReceiver();
        IntentFilter intentFilter1 = new IntentFilter("guokun_1");
        registerReceiver(myReceiver,intentFilter1);


        broadcastReceiverMyReceiver2 = new BroadcastReceiverMyReceiver2();
        IntentFilter intentFilter = new IntentFilter("guokun_broadcastreceiver2");

        registerReceiver(broadcastReceiverMyReceiver2,intentFilter);
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(broadcastReceiverMyReceiver2);
        unregisterReceiver(myReceiver);
        unregisterReceiver(sendSmsSuccessReceiver);
        super.onDestroy();
    }
    public void broadcastOnClickSystem1(View view){
        SmsManager smsManager = SmsManager.getDefault();
        String destionAddress = etNumber.getText().toString().trim();
        String text = etContent.getText().toString().trim();
        Intent intent = new Intent("guokun_2");
        PendingIntent sentIntent = PendingIntent.getBroadcast(this,0,intent,0);
        smsManager.sendTextMessage(destionAddress,"",text,sentIntent,null);// 1:目标地址 2：手机地址 3：内容  4：成功做什么
    }
    public  static  class SendSmsSuccessReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"发送成功",Toast.LENGTH_SHORT).show();
        }
    }

    public void broadcastReceiverOnclick(View view){
        Intent  intent = new Intent("guokun_broadcastreceiver");
        sendBroadcast(intent);
    }
    public void broadcastReceiverOnclick2(View view){
        Intent  intent = new Intent("guokun_broadcastreceiver2");
        sendBroadcast(intent);
    }
    public void broadcastOnClickSystem(View view){
        Intent intent =  new Intent(this, BroadcastReceiverSystem.class);
        startActivity(intent);
    }
    public void broadcastReceiverByValuesOnclick(View view){
        Intent intent = new Intent(this,BroadcastStartServiceDemo.class);
        intent.putExtra("math",Double.parseDouble(mathE.getText().toString()));
        intent.putExtra("english",Double.parseDouble(englisE.getText().toString()));
        intent.putExtra("chines",Double.parseDouble(chinesE.getText().toString()));
        startService(intent);
    }
    public   class MyReceiver extends BroadcastReceiver{

        public MyReceiver() {
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            double result = intent.getDoubleExtra("result",0);
            buttonBs = (Button) findViewById(R.id.buttonBs);
            buttonBs.setText(buttonBs.getText()+(result+""));
        }
    }

}
