package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME="myDBA";
    public DBHelper(@Nullable Context context) {
        super(context, "myDBA", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
myDB.execSQL("create Table abonnes(cin TEXT primary key,username TEXT,password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
myDB.execSQL("drop Table if exists abonnes");
    }
    public boolean insertDataAB(String cin,String username,String password){
        SQLiteDatabase myDB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("cin",cin);
        contentValues.put("username",username);
        contentValues.put("password",password);
      long result= myDB.insert("abonnes",null,contentValues);
        if(result==-1) {
            return false;
        }
        else {
            return true;
        }
    }
    public boolean checkusernameAB(String username){
        SQLiteDatabase myDB=this.getWritableDatabase();
        Cursor cursor=myDB.rawQuery("Select * from abonnes where username= ?",new String[]{username});
       if (cursor.getCount()>0){

           return true;
       }
       else{
           return false;
       }
    }
    public Boolean checkusernamepasswordAB(String username,String password){
        SQLiteDatabase myDB=this.getWritableDatabase();
        Cursor cursor=myDB.rawQuery("Select * from abonnes where username= ? and password= ?",new String[]{username,password});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }
}
