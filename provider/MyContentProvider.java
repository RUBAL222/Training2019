package com.example.rubal.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.example.rubal.model.Util;

public class MyContentProvider extends ContentProvider {
    DBHelper dbhelper;
    SQLiteDatabase sqLiteDatabase;
     public MyContentProvider(){

     }

    @Override
    public boolean onCreate() {
         dbhelper=new DBHelper(getContext(),Util.DB_NAME,null,Util.DB_VERSION );
         sqLiteDatabase=dbhelper.getWritableDatabase();

         return false;
    }


    @Override
    public Cursor query( Uri uri,  String[] projection, String selection,  String[] selectionArgs,  String sortOrder)
    {
        String tabName=uri.getLastPathSegment();
        Cursor cursor=sqLiteDatabase.query(tabName,projection,null,null,null,null,null);

        return cursor;
    }


    @Override
    public String getType(Uri uri) {
         throw  new UnsupportedOperationException("NOT YET IMPLEMENTED");
     }


    @Override
    public Uri insert( Uri uri,  ContentValues values) {
         String tabName=uri.getLastPathSegment();
         long id=sqLiteDatabase.insert(tabName,null,values);
         Uri dummyUri=Uri.parse("dummy://someuri/"+id);

        return dummyUri;
    }

    @Override
    public int delete( Uri uri, String selection,  String[] selectionArgs)
    {
        String tabName=uri.getLastPathSegment();
        int i=sqLiteDatabase.delete(tabName,selection,null);
        return i;
    }

    @Override
    public int update( Uri uri,  ContentValues values,  String selection , String[] selectionArgs) {
        String tabName=uri.getLastPathSegment();
        int i=sqLiteDatabase.update(tabName,values,selection,null);
         return 0;

    }
}



