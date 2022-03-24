package com.zerdasoftware.flagquiz.Models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context) {
        super(context, "flagquiz.sqlite",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `flags` (\n" +
                "\t`flag_id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`flag_name`\tTEXT,\n" +
                "\t`flag_image`\tTEXT\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS flags");
        onCreate(db);
    }
}
