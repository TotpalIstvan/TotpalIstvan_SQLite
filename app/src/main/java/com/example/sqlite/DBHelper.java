package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "tanulok.db";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "tanulok";
    private static final String COL_ID = "id";
    private static final String COL_VEZNEV= "vezeteknev";
    private static final String COL_KERNEV = "keresztnev";
    private static final String COL_JEGY = "jegy";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " +TABLE_NAME +" (" +
                        COL_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                        COL_VEZNEV + "TEXT NOT NULL," +
                        COL_KERNEV + "TEXT NOT NULL," +
                        COL_JEGY + "INTEGER NOT NULL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
            onCreate(db);
    }


    public boolean rogzites(String vezeteknev, String keresztnev, int jegy) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues  values  = new ContentValues();
        values.put(COL_VEZNEV, vezeteknev);
        values.put(COL_KERNEV, keresztnev);
        values.put(COL_JEGY, jegy);
        return db.insert(TABLE_NAME, null, values) != -1;
    }

    public Cursor listaz() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_NAME, new String[]{COL_ID,COL_VEZNEV,COL_KERNEV,COL_JEGY},
                null, null, null, null,null);
        //db.rawQuery(" SELECT * FROM " +TABLE_NAME + " WHERE " +COL_VEZNEV+" = ? AND "+COL_KERNEV + " =?", new String[]{"Gipsz", "Jakab"});
    }
}
