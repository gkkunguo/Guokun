package com.example.helenkellercompute.guokun.json;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.helenkellercompute.guokun.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Helen keller compute on 2018/4/2.
 */

public class JsonDemo extends Activity {
    private TextView textView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_layout);
        textView = (TextView)findViewById(R.id.textView);
    }
    public  void jsonJX(View view){
        parseJson();

    }
    private  void parseJson(){
        try {
            String  data = getContent(getResources(),R.raw.jsongktest);
            String threawStr;
            JSONObject object = new JSONObject(data);
            String firstname = object.getString("firstname");
            String lastNmae = object.getString("lastNmae");
            String age = object.getString("age");

            textView.append(firstname+"\n"+lastNmae+"\n"+age+"\n");
            threawStr = firstname+"\n"+lastNmae+"\n"+age+"\n";


            JSONObject address = object.getJSONObject("address");//因为json中地址是一个对象，所以要通过getJSONObject来取。
            String streetAddress = (String) address.get("streetAddress");
            String city = (String) address.get("city");
            String state = (String) address.get("state");
            String posttalCode = (String) address.get("posttalCode");
            textView.append(streetAddress+"\n"+city+"\n"+state+"\n"+posttalCode+"\n");


            //数组，就有多个，循环   ===[ ]
            JSONArray phoneNumber = object.getJSONArray("phoneNumber");
            for(int i =0;i<=phoneNumber.length();i++){
                //去取得object
                JSONObject phoneObject = phoneNumber.getJSONObject(i);
                String type = phoneObject.getString("type");
                String number = phoneObject.getString("number");
                textView.append(type+"\n"+number+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private String getContent(Resources res,int id) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputStream is = res.openRawResource(id);
        byte[] buffer = new byte[1024];
        try {
            int len = is.read(buffer,0,1024);
            while (len != -1){
                String s = new String(buffer,0,len);
                sb.append(s);
                len = is.read(buffer,0,1024);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is != null){
                is.close();
            }
        }
        return  sb.toString();
    }
    }