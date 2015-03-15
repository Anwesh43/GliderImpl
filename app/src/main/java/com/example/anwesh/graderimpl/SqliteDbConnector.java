package com.example.anwesh.graderimpl;

/**
 * Created by Anwesh on 14-03-2015.
 */
import android.content.*;
import android.database.*;
import android.database.sqlite.SQLiteDatabase;
import java.util.*;
public class SqliteDbConnector {
    SqlHelper sqlHelper;
    SQLiteDatabase db;
    public SqliteDbConnector(Context context) {
        sqlHelper = new SqlHelper(context);
    }
    public void open() {
        db = sqlHelper.getWritableDatabase();
    }
    public void close() {
        db.close();
    }
    public int fetchHighestScore() {
        Cursor cursor = db.query(sqlHelper.tableName,new String[]{"score"},null,null,null,null,null);
        int score = -1;
        ArrayList<Integer> scores = new ArrayList<Integer>();
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            scores.add(cursor.getInt(0));
            cursor.moveToNext();
        }
        if(scores.size()!=0) {
            score = scores.get(0);
        }
        return score;
    }
    public void insert(int score) {
        ContentValues cv = new ContentValues();
        cv.put("score",score);
        db.insert(sqlHelper.tableName,null,cv);
    }
    public void update(int score) {
        ContentValues cv = new ContentValues();
        cv.put("score",score);
        db.update(sqlHelper.tableName,cv,null,null);
    }
}
