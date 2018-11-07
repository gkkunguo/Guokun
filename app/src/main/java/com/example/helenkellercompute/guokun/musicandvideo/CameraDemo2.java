package com.example.helenkellercompute.guokun.musicandvideo;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.helenkellercompute.guokun.R;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Helen keller compute on 2018/4/17.
 */

public class CameraDemo2 extends Activity {
    private Camera camera;
    private SurfaceHolder surfaceHolder;
    private SurfaceView surfaceView;
    private static final int PERMISSION_REQUEST_CODE = 1; //权限请求码
    private ImageView imageView;
    private BufferedOutputStream bos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_and_video_camera2);
        surfaceView = (SurfaceView) findViewById(R.id.surface2ViewId);
        surfaceHolder = surfaceView.getHolder();
        imageView = (ImageView) findViewById(R.id.camera2ImageViewId);
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                camera = getCamera();
                if(camera != null){
                    try {
                        camera.setPreviewDisplay(surfaceHolder);
                        camera.startPreview();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                releaseCamera();

            }
        });
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        camera = getCamera();
        if(camera != null){
            try {
                camera.setPreviewDisplay(surfaceHolder);
                camera.startPreview();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
    public Camera getCamera(){
       if (camera == null){
           try {
               camera = Camera.open();
               return camera;
           }catch (Exception e){
               return null;
           }
       }
       return camera;
    }

    public void releaseCamera(){
        camera.release();
        camera = null;
    }

    @Override
    protected void onDestroy() {
        releaseCamera();
        super.onDestroy();
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
    public void camera2OnClick(View view){
        camera.takePicture(null, null, new Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] data, Camera camera) {
                //预览
                Bitmap bitmap = BitmapFactory.decodeByteArray(data,0,data.length);
                imageView.setImageBitmap(bitmap);
                //保存

                try {
                    String fileNmae = "hey"+System.currentTimeMillis()+".jpg";
                    File file = new File(Environment.getExternalStorageDirectory(),fileNmae);
                    FileOutputStream fileOutputStream = null;
                    fileOutputStream = new FileOutputStream(file);
                    bos = new BufferedOutputStream(fileOutputStream);
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,bos);//文件类型，比例，文件路径
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}
