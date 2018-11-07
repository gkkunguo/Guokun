package com.example.helenkellercompute.guokun.dataOrOracle;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.helenkellercompute.guokun.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by Helen keller compute on 2018/4/5.
 */

public class DataFile extends Activity {
    private EditText etData;
    private static final int PERMISSION_REQUEST_CODE = 1; //权限请求码


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_file_layout);
        etData = (EditText) findViewById(R.id.etData);

        if (checkPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            //获取权限后的操作。读取文件
        } else {
            //请求权限
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST_CODE);
        }
    }

    //GK
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

    //GK
    public void dataFileCommiteOnClick(View view) {
        String str = etData.getText().toString();
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileOutputStream = openFileOutput("guokun.txt", Context.MODE_PRIVATE);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(str);
            bufferedWriter.flush();
            Toast.makeText(this, "写入完成...", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void dataFileReadOnClick(View view) {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            fileInputStream = openFileInput("guokun.txt");
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String content = bufferedReader.readLine();
            if (content != null) {
                stringBuilder.append(content);
            }
            etData.setText(stringBuilder.toString());
            Toast.makeText(this, "读取完成...", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public void dataFileReadRawOnClick(View view) {
        InputStream inputStream = getResources().openRawResource(R.raw.rawtest);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        StringBuffer stringBuffer = new StringBuffer();

        if (bufferedReader != null) {
            try {
                String str = bufferedReader.readLine();
                stringBuffer.append(str);
                etData.setText(stringBuffer.toString());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                try {
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void inputOrOutputCdOnclick(View view) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        switch (view.getId()) {
            case R.id.inputCd:
                File dir2 = Environment.getExternalStorageDirectory();
                File file2 = new File(dir2, "guokunfile.txt");
                try {
                    fis = new FileInputStream(file2);
                    read(fis);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (fis != null) {
                            fis.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.outputCd:
                File dir = Environment.getExternalStorageDirectory();
                File file = new File(dir, "guokunfile.txt");
                try {
                    fos = new FileOutputStream(file);
                    write(fos);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (fos != null) {
                            fos.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    public void write(FileOutputStream fos) {
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        try {
            bw.write(etData.getText().toString());
            Toast.makeText(this, "写入CA卡完成...", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void read(FileInputStream fis) {
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer();
        try {
            if (sb != null) {
                sb.append(br.readLine());
            }
            etData.setText(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
