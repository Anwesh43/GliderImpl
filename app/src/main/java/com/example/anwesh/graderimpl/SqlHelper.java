package com.example.anwesh.graderimpl;

/**
 * Created by Anwesh on 14-03-2015.
 */
import android.database.sqlite.*;
import android.content.*;
public class SqlHelper extends SQLiteOpenHelper{
    static final String tableName = "scoreTable1";
    private static final String dbName = "anweshGameDatabase1";
    private static final int version = 1;
    public SqlHelper(Context context) {
        super(context,dbName,null,version);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+tableName+"(score integer primary key)");
    }
    public void onUpgrade(SQLiteDatabase db,int newVersion,int oldVersion) {
        db.execSQL("drop table if exists "+tableName);
        onCreate(db);
    }
}
