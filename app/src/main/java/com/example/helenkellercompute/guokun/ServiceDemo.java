package com.example.helenkellercompute.guokun;

import android.app.Activity;
import android.bluetooth.BluetoothClass;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.helenkellercompute.guokun.service.MIntentService;
import com.example.helenkellercompute.guokun.service.MService;

/**
 * Created by Helen keller compute on 2018/3/28.
 */

public class ServiceDemo extends Activity {
    private Button startServieButton;
    private EditText mathEdit;
    private EditText englishEdit;
    private EditText chineseEdit;
    private StartServiceDemo.AllGrad startserviceDemo;
    private Button button,button2;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            startserviceDemo= (StartServiceDemo.AllGrad) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("TEST","onServiceDisconnected");
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_layout);
        mathEdit = (EditText) findViewById(R.id.mathId);
        englishEdit = (EditText) findViewById(R.id.englishId);
        chineseEdit = (EditText) findViewById(R.id.chinesId);
        button =(Button) findViewById(R.id.jg);
        button2 =(Button) findViewById(R.id.jg1);

        Intent intent = new Intent(this,StartServiceDemo.class);
        bindService(intent,serviceConnection, BIND_AUTO_CREATE);


    }
    public  void startServiOnClick(View view){
        double math=Double.parseDouble(mathEdit.getText().toString());
        double english=Double.parseDouble(englishEdit.getText().toString());
        double chinese=Double.parseDouble(chineseEdit.getText().toString());

        double all = startserviceDemo.callAll(math,english,chinese);
        button.setText(button.getText()+(all+""));

    }
    public void startServiceOnClick(View view){
        Intent intent =new Intent(this,StartServiceDemo1.class);
        startService(intent);
        stopService(intent);
        StartServiceDemo1 a = new StartServiceDemo1();
        String str = a.MyBindReturl();
        button.setText(button.getText()+("onCreate、onBind、onUnbind、onDestroy"));
        button2.setText(button2.getText()+("onCreate、onStartCommand、onStart、onDestroy "));

    }
    public void intentClick(View v){
        Intent intent = new Intent(this, MIntentService.class);
        intent.putExtra("info", "good good study");
        startService(intent);
    }
    public void serviceClick(View v){
        Intent intent = new Intent(this, MService.class);
        intent.putExtra("info", "good good study");
        startService(intent);
    }


}
