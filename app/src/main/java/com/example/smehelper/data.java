package com.example.smehelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class data extends SQLiteOpenHelper {
    public data(@Nullable Context context){
        super(context,"userData.db",null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
DB.execSQL("Create Table Userdetails(name TEXT,contact TEXT primary key,amount TEXT,paymentdate)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
DB.execSQL("drop Table if exists Userdetails");
    }
    public boolean insertuserdata(String name,String amount,String contact,String paymentdate)
    {
SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("amount",amount);
        contentValues.put("contact",contact);
        contentValues.put("paymentdate",paymentdate);
        long result=DB.insert("Userdetails",null,contentValues);
        if (result==-1){
            return false;
        }
        else {
            return false;
        }
    }
    public boolean updateuserdata(String name,String amount,String contact,String paymentdate)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("amount",amount);
        contentValues.put("paymentdate",paymentdate);
        Cursor cursor=DB.rawQuery("Select * from Userdetails where contact=?",new String[]{contact});
        long result=DB.update("Userdetails",contentValues,"contact=?",new String[]{contact});
        if (result==-1){
            return false;
        }
        else {
            return false;
        }
    }
    public boolean deletedata(String contact)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("Select * from Userdetails where contact=?",new String[]{contact});
        long result=DB.delete("Userdetails","contact=?",new String[]{contact});
        if (result==-1){
            return false;
        }
        else {
            return false;
        }
    }
    public Cursor getdata()
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("Select * from Userdetails ",null);
       return cursor;
    }
}
