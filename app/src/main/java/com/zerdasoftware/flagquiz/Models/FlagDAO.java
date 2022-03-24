package com.zerdasoftware.flagquiz.Models;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class FlagDAO {

    //Get Random 5 Value
    public ArrayList<FlagModel> getRandom5(Database db){
        ArrayList<FlagModel> flagModelArrayList = new ArrayList<>();
        SQLiteDatabase SDB = db.getWritableDatabase();
        Cursor c = SDB.rawQuery("SELECT * FROM flags ORDER BY RANDOM() LIMIT 5",null);

        while (c.moveToNext()){
            @SuppressLint("Range") FlagModel flag = new FlagModel(
                    c.getInt(c.getColumnIndex("flag_id")),
                    c.getString(c.getColumnIndex("flag_name")),
                    c.getString(c.getColumnIndex("flag_image")));
            flagModelArrayList.add(flag);

        }
        return  flagModelArrayList;
    }

    //Get Random 3 Wrong Value
    public ArrayList<FlagModel> getRandom3Wrong(Database db,int flag_id){
        ArrayList<FlagModel> flagModelArrayList = new ArrayList<>();
        SQLiteDatabase SDB = db.getWritableDatabase();
        Cursor c = SDB.rawQuery("SELECT * FROM flags  WHERE flag_id != "+flag_id+"  ORDER BY RANDOM() LIMIT 3",null);

        while (c.moveToNext()){
            @SuppressLint("Range") FlagModel flag = new FlagModel(
                    c.getInt(c.getColumnIndex("flag_id")),
                    c.getString(c.getColumnIndex("flag_name")),
                    c.getString(c.getColumnIndex("flag_image")));
            flagModelArrayList.add(flag);

        }
        return  flagModelArrayList;
    }
}
