package com.example.rubal.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;

import com.example.rubal.model.Util;

class DBHelper extends SQLiteOpenHelper {
    public SQLiteDatabase getWritableDatabase;

    public DBHelper(Context context, String dbName,SQLiteDatabase.CursorFactory factory, int dbVersion) {
        super(context,dbName,factory,dbVersion);
    }

    public SQLiteDatabase getWritableDatabase() {

        return null;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(Util.CREATE_TAB_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
