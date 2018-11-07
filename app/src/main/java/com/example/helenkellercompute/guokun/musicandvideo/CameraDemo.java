package com.example.helenkellercompute.guokun.musicandvideo;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.helenkellercompute.guokun.R;

import java.io.File;

/**
 * Created by Helen keller compute on 2018/4/17.
 */

public class CameraDemo extends Activity {
    private ImageView imageView;
    private String fileName = null;
    private static final int PERMISSION_REQUEST_CODE = 1; //权限请求码
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_and_video_camera);
        imageView = (ImageView) findViewById(R.id.cameraImageView);
        if (checkPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            //获取权限后的操作。读取文件
        }else {
            //请求权限
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST_CODE);
        }
        if (checkPermission(this, Manifest.permission.CAMERA)) {
            //获取权限后的操作。读取文件
        }else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},
                    PERMISSION_REQUEST_CODE);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length >0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    //得到了授权
                    Toast.makeText(this, "授权成功", Toast.LENGTH_SHORT).show();
                }else {
                    //未授权
                    Toast.makeText(this, "授权失败", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
    private boolean checkPermission(Context context, String permission) {
        return PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(context,permission);
    }
    public void systemCamera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File dir = Environment.getExternalStorageDirectory();
        fileName ="gk"+ System.currentTimeMillis() +".jpg";
        File file = new File(dir,fileName);
        Uri fileUri = Uri.fromFile(file);
        intent.putExtra(MediaStore.EXTRA_OUTPUT,fileUri);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File dir = Environment.getExternalStorageDirectory();
        File file = new File(dir,fileName);
        imageView.setImageURI(Uri.fromFile(file));

    }

    public void customCamera(View view){
        Intent intent = new Intent(this,CameraDemo2.class);
        startActivity(intent);
    }
}
