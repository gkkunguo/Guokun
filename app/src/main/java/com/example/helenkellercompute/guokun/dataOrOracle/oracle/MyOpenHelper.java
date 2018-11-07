package com.example.helenkellercompute.guokun.dataOrOracle.oracle;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Helen keller compute on 2018/4/6.
 */

public class MyOpenHelper extends SQLiteOpenHelper {
    public static final int VERSION= 6;
    public static final String CREACTE_TEXT = "create table table_test(_id integer primary key autoincrement,name,age,score)";


    /**
     * @param context   上下文
     * @param name       数据库文件名
     * @param version   版本号
     */

    public MyOpenHelper(Context context, String name, int version) {
        super(context, name, null, VERSION);
    }
    public MyOpenHelper(Context context, String name) {
        super(context, name, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREACTE_TEXT);
        db.execSQL("create table student(_id integer primary key autoincrement,name,age,score )");
        Log.i("TEST","onCreate:");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL(CREACTE_TEXT);
        Log.i("TEST","oldVersion:"+oldVersion+",newVersion:"+newVersion);
    }
}
