package com.example.helenkellercompute.guokun.ipc.binder;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.helenkellercompute.guokun.IHkAidlInterface;
import com.example.helenkellercompute.guokun.R;

public class AIDLActivity extends AppCompatActivity {
    private IHkAidlInterface iHkAidlInterface;
    private static final String TAG = "AIDLActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);
    }

    public void payment(View view) {

    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            IBinder iBinder = new HKAidlInterface();
            iHkAidlInterface = HKAidlInterface.asInterface(iBinder);
            try {
                Toast.makeText(AIDLActivity.this,((iHkAidlInterface.payment() == 0 ? "支付成功":"支付失败")),Toast.LENGTH_SHORT).show();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}
