package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context ;
    private static final String DATABASE_NAME = "EventClub.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE1_NAME = "Events";
    private static final String TABLE2_NAME = "ChoosenEvents";
    private static final String COLUMN1_ID = "_id";
    private static final String COLUMN2_ID = "_id1";
    private static final String COLUMN1_DATE = "Event_Date";
    private static final String COLUMN2_DATE = "Event_Date1";
    private static final String COLUMN1_TITLE = "Event_Title";
    private static final String COLUMN2_TITLE = "Event_Title1";
    private static final String COLUMN1_DUREE = "Event_Duree";
    private static final String COLUMN2_DUREE = "Event_Duree1";


    MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query1 = "CREATE TABLE " + TABLE1_NAME +
                " (" +COLUMN1_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COLUMN1_TITLE +" TEXT," +
                COLUMN1_DATE + " TEXT, " +
                COLUMN1_DUREE + " TEXT);";

        db.execSQL(query1);
        String query2 = "CREATE TABLE " + TABLE2_NAME +
                " (" +COLUMN2_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "+
                COLUMN2_TITLE +" TEXT," +
                COLUMN2_DATE + " TEXT, " +
                COLUMN2_DUREE + " TEXT);";

        db.execSQL(query2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE1_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE2_NAME);
        onCreate(db);

    }

    void addEvent1(String title, String duree, String date){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN1_TITLE, title);
        cv.put(COLUMN1_DATE, date);
        cv.put(COLUMN1_DUREE, duree);
        long result = db.insert(TABLE1_NAME, null, cv);
        if (result == -1){
            Toast.makeText(context, "failed", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(context, "success", Toast.LENGTH_LONG).show();
        }

    }
    void addEvent2(String title, String duree, String date){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN2_TITLE, title);
        cv.put(COLUMN2_DATE, date);
        cv.put(COLUMN2_DUREE, duree);
        long result = db.insert(TABLE2_NAME, null, cv);
        if (result == -1){
            Toast.makeText(context, "failed", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(context, "success", Toast.LENGTH_LONG).show();
        }

    }


    Cursor readAllData1(){

        String query = "SELECT * FROM " + TABLE1_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
    Cursor readAllData2(){

        String query = "SELECT * FROM " + TABLE2_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData1(String row_id , String title, String date, String duree){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put(COLUMN1_TITLE, title);
        cv.put(COLUMN1_DATE, date);
        cv.put(COLUMN1_DUREE, duree);

        long result = db.update(TABLE1_NAME, cv, "_id=?", new String[]{row_id});
        if (result == -1){
            Toast.makeText(context, "Failed to update", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context, "Successfully updated", Toast.LENGTH_LONG).show();
        }

    }
    void updateData2(String row_id , String title, String date, String duree){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put(COLUMN2_TITLE, title);
        cv.put(COLUMN2_DATE, date);
        cv.put(COLUMN2_DUREE, duree);

        long result = db.update(TABLE2_NAME, cv, "_id=?", new String[]{row_id});
        if (result == -1){
            Toast.makeText(context, "Failed to update", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context, "Successfully updated", Toast.LENGTH_LONG).show();
        }

    }

    void deleteOneRow1(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE1_NAME, "_id=?", new String[]{row_id});
        if (result == -1){
            Toast.makeText(context, "Failed to delete", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context, "Successfully deleted", Toast.LENGTH_LONG).show();
        }

    }

    void deleteAllData1(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE1_NAME);
    }
}
