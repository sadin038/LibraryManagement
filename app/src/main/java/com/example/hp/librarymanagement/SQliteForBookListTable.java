package com.example.hp.librarymanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public
class SQliteForBookListTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = " bookitemlist.db ";
    private static final String TABLE_NAME = " booktable ";
    private static  final String COL1 = " BOOK_ID ";
    private static final String COL2 = " BOOkNAME ";
    private static final String COL3 = " WRITTER ";
    private static final String COL4 = "  DATE";



    public SQliteForBookListTable( Context context) {
        super (context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String quary;
        quary = " CREATE TABLE " + TABLE_NAME + " ( " + COL1 + " INTEGER PRIMARY KEY , " + COL2 + " TEXT, "
                + COL3 + " TEXT, " + COL4 + " TEXT "  + " ) ";
        db.execSQL (quary);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL (" DROP TABLE IF EXISTS " + TABLE_NAME );
        onCreate (db);

    }

    public boolean  addtotable(String id,String bname,String writter,String date)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase ();
        ContentValues contentValues = new ContentValues ();
        contentValues.put(COL1,id);
        contentValues.put (COL2,bname);
        contentValues.put (COL3,writter);
        contentValues.put (COL4,date);

        long checker = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if(checker==-1)
        {
            return false;
        }
        else
        {
            return  true;
        }
    }

    public
    Cursor display()
    {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase ();
        Cursor res ;
        res = sqLiteDatabase.rawQuery (" SELECT * FROM " + TABLE_NAME,null);
        return res;

    }
}
