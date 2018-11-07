package com.example.helenkellercompute.guokun.xml;

import android.app.Activity;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.helenkellercompute.guokun.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Helen keller compute on 2018/4/2.
 */

public class XmlDemo extends Activity {
    private TextView tv1;
    private static final int MSG_FINAL = 0X000;
    private Thread thread = new Thread() {
        @Override
        public void run() {
            //解析文件
            List<String> contans = getParserValue(getResources(), R.xml.work);
            Message message = new Message();
            message.what = MSG_FINAL;
            message.obj = contans;
            handler.sendMessage(message);
        }
    };
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_FINAL:
                    List<String> contRes = (List<String>) msg.obj;
                    for (String conRe : contRes) {
                        tv1.append(conRe + "\n");
                    }
                    break;

            }
        }
    };

    public List<String> getParserValue(Resources res, int id) {
        List<String> contains = null;
        XmlPullParser xmlPullParser = getResources().getXml(R.xml.work);
        String tagName;
        try {
            int evenType = xmlPullParser.getEventType();
            Log.i("TEST", "evenType:" + evenType);
            while (evenType != XmlPullParser.END_DOCUMENT) {//文档未结束
                switch (evenType) {
                    case XmlPullParser.START_DOCUMENT:
                        contains = new ArrayList<String>();
                        tagName = xmlPullParser.getName();
                        break;
                    case XmlPullParser.END_DOCUMENT:
                        tagName = xmlPullParser.getName();
                        break;
                    case XmlPullParser.START_TAG:
                        tagName = xmlPullParser.getName();
                        if (tagName.equals("work")) {
                            String strin1g = xmlPullParser.getAttributeValue(0);
                            String strin1g1 = xmlPullParser.getAttributeValue(1);
                            contains.add(strin1g);
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        tagName = xmlPullParser.getName();
                        break;
                }
                try {
                    evenType = xmlPullParser.next();//增加向下走一步
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return contains;


    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_layout);
        tv1 = (TextView) findViewById(R.id.textView);
    }

    public void parserXml(View view) {
        thread.start();
    }

}