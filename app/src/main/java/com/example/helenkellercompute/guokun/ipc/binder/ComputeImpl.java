package com.example.helenkellercompute.guokun.ipc.binder;

import android.os.RemoteException;

import com.example.helenkellercompute.guokun.ICompute;

public class ComputeImpl extends ICompute.Stub {
    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}
