package com.example.helenkellercompute.guokun.image3cache;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.helenkellercompute.guokun.R;

import java.io.File;

public class MainActivity_ImageCache extends AppCompatActivity {
    private ImageView imageView;
    private String url = "https://www.3dmgame.com/UploadFiles/201212/Medium_20121217143424221.jpg";
    private static final int PERMISSION_REQUEST_CODE = 1; //权限请求码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__image_cache);

        permissions();

        imageView = findViewById(R.id.imageView);
        MyBitmapUtils myBitmapUtils = MyBitmapUtils.getInstance();
        myBitmapUtils.disPlay(imageView,url);
    }
    private void permissions(){
        if (checkPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) || checkPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            //获取权限后的操作。读取文件
        } else {
            //请求权限
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST_CODE);
        }
    }
    private boolean checkPermission(Context context, String permission) {
        return PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(context, permission);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //得到了授权
                    Toast.makeText(this, "授权成功", Toast.LENGTH_SHORT).show();
                } else {
                    //未授权
                    Toast.makeText(this, "授权失败", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
}
