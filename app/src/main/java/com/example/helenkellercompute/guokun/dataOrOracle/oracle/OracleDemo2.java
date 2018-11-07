package com.example.helenkellercompute.guokun.dataOrOracle.oracle;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helenkellercompute.guokun.R;
import com.example.helenkellercompute.guokun.dataOrOracle.OracleDemo;

/**
 * Created by Helen keller compute on 2018/4/6.
 */

public class OracleDemo2 extends Activity {
    private EditText name,score,age;
    private ListView listView;
    private Cursor cursorc;
    private MyOpenHelper helperc;
    private Dialog dialog;
    private String inputId = "-1";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oracledemo2_layout);
        name = (EditText) findViewById(R.id.name);
        score = (EditText) findViewById(R.id.score);
        age = (EditText) findViewById(R.id.age);
        listView = (ListView) findViewById(R.id.listViewId);
        queryAllStudent();
        helperc = new MyOpenHelper(this,"student.db");
        cursorc = helperc.getReadableDatabase().query("student",null,null,null,null,null,null);
    }
    public void oracleCreateOrUorIoOnclick(View view){
        MyOpenHelper myOpenHelper = new MyOpenHelper(this,"text.db");
        SQLiteDatabase database = myOpenHelper.getReadableDatabase();
        database.execSQL("insert into table_test(name) VALUES ('aaa')");
    }

    public void insertStu(View view){
        MyOpenHelper myOpenHelper = new MyOpenHelper(this,"student.db");
        SQLiteDatabase database = myOpenHelper.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name.getText().toString());
        contentValues.put("age",age.getText().toString());
        contentValues.put("score",score.getText().toString());
        int num   = (int) database.insert("student",null,contentValues);
        if(num  != -1){
            Toast.makeText(this,"插入成功："+num,Toast.LENGTH_SHORT).show();;
        }else {
            Toast.makeText(this,"插入失败！",Toast.LENGTH_SHORT).show();;
        }
        database.close();
        myOpenHelper.close();
        queryAllStudent();
    }
    public void queryAllStudent(){
        MyOpenHelper myOpenHelper = new MyOpenHelper(this,"student.db");
        SQLiteDatabase database = myOpenHelper.getReadableDatabase();
        Cursor cursor =  database.query("student",null,null,null,null,null,null);

//方法一：
//        CursorAdapter adapter = new CursorAdapter(this,cursor) {
//            @Override
//            public View newView(Context context, Cursor cursor, ViewGroup parent) {
//                View view1 = LayoutInflater.from(OracleDemo2.this).inflate(R.layout.oracledemo3_layout,null);
//                return view1;
//            }
//            @Override
//            public void bindView(View view, Context context, Cursor cursor1) {
//                TextView tvName = (TextView) view.findViewById(R.id.tvname);
//                TextView tvAge = (TextView) view.findViewById(R.id.tvage);
//                TextView tvScore = (TextView) view.findViewById(R.id.tvscore);
//
//                String name = cursor1.getString(cursor1.getColumnIndex("name"));
//                String age = cursor1.getString(cursor1.getColumnIndex("age"));
//                String score = cursor1.getString(cursor1.getColumnIndex("score"));
//                tvAge.setText(age);
//                tvName.setText(name);
//                tvScore.setText(score);
//            }
//        };
// 方法二：
        SimpleCursorAdapter simpleAdapter = new SimpleCursorAdapter(
                this,
                R.layout.oracledemo3_layout,
                cursor,
                new String[]{"age","name","score"},
                new int[]{R.id.tvage,R.id.tvname,R.id.tvscore}
        );
        listView.setAdapter(simpleAdapter);
    }
    public void findStudentById(){
        Cursor cursor1 = helperc.getReadableDatabase().query(
                "student",//表名称
                null,   //列名称 为null相当于 *  即为全部
                "_id=?",  //条件
                new String[]{inputId},//条件的值
                null,//group by
                null,//having
                null //order by
        );
        if(cursor1.moveToFirst()){
            String name1 = cursor1.getString(cursor1.getColumnIndex("name"));
            String age2 = cursor1.getString(cursor1.getColumnIndex("age"));
            String score2 = cursor1.getString(cursor1.getColumnIndex("score"));
            name.setText(name1);
            age.setText(age2);
            score.setText(score2);
        }else {
            Toast.makeText(this,"未查到该信息~",Toast.LENGTH_LONG).show();
        }
    }
    public void createDialog(){
        View view1 = LayoutInflater.from(this).inflate(R.layout.oracledemo4_layout,null);
        final EditText inputEditText = (EditText)view1.findViewById(R.id.tvInputId);
        dialog = new AlertDialog.Builder(this)
                .setView(view1)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                         inputId = inputEditText.getText().toString();
                        findStudentById();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        inputId="-1";
                        name.setText("");
                        age.setText("");
                        score.setText("");
                    }
                })
                .create();
    }
    public void queryStu(View view){
        createDialog();
        dialog.show();
    }
    //查询
    private void queryOnlyNo(Cursor cursor){
        String name1 = cursor.getString(cursor.getColumnIndex("name"));
        String age1 = cursor.getString(cursor.getColumnIndex("age"));
        String score1 = cursor.getString(cursor.getColumnIndex("score"));

        name.setText(name1);
        score.setText(score1);
        age.setText(age1);
    }

    public void insertFirst(View view){
        cursorc.moveToFirst();
        queryOnlyNo(cursorc);
        cursorc.close();


    }
    public void queryNext(View view){
        if(cursorc.moveToNext()){
            queryOnlyNo(cursorc);
        }
    }
    public void queryPre(View view){
        if(cursorc.moveToPrevious()){
            queryOnlyNo(cursorc);
        }
    }
    public void queryLast(View view){
        if(cursorc.moveToLast()){
            queryOnlyNo(cursorc);
        }
    }

    public void updateStu(View view){
        String id = cursorc.getString(cursorc.getColumnIndex("_id"));
        SQLiteDatabase database = helperc.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("age",age.getText().toString());
        contentValues.put("name",name.getText().toString());
        contentValues.put("score",score.getText().toString());
        database.update("student",contentValues,"_id = ?",new String[]{id});
        database.close();
        queryAllStudent();

    }
    public void deleteStu(View view){
        String id = cursorc.getString(cursorc.getColumnIndex("_id"));
        SQLiteDatabase database = helperc.getReadableDatabase();
        database.delete("student","_id=?",new String[]{id});
        database.close();
        queryAllStudent();

    }







}
