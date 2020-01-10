package com.example.helenkellercompute.guokun.ipc.binder;

import android.os.RemoteException;
import android.util.Log;

import com.example.helenkellercompute.guokun.IHkAidlInterface;

public class HKAidlInterface extends IHkAidlInterface.Stub {
    private static final String TAG = "HKAidlInterface";
    /**
     * @return 0则为支付成功，返回1则支付失败
     * @throws RemoteException
     */
    @Override
    public int payment() throws RemoteException {
        int ri ;
        int i = (int) (Math.random() * 10); //取出0~9的数
        Log.i(TAG, "payment: "+i);
        //偶数为成功，奇数为失败
        if(i%2 == 0){
            ri = 0;
        }else {
            ri = 1;
        }
        return ri;
    }
}
