package com.example.helenkellercompute.guokun.phoneVideo.base;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

/**
 * Created by Helen keller compute on 2018/4/22.
 */

public class Permission {
    public static boolean isGrantExternal(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && activity.checkSelfPermission(
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            activity.requestPermissions(new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, 1);
            Log.i("TEST","Permissionfalse");
            return false;
        }
        return true;
    }
}
