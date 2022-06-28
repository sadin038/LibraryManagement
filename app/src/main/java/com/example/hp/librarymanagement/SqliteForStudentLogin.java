package com.example.hp.librarymanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class SqliteForStudentLogin extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = " studentlogin.db ";
    private static final String TABLE_NAME = " mytable ";
    private static  final String COL1 = "ROLL";
    private static final String COL2 = " STUDENTNAME ";
    private static final String COL3 = "DEPARTMENT ";
    private static final String COL4 = "  EMAIL";
    private static final String COL5 = " USERNAME";
    private static final String COL6 = " PASSWORD";




    public SqliteForStudentLogin(Context context) {
        super (context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String quary;
        quary = " CREATE TABLE " + TABLE_NAME + " ( " + COL1 + " INTEGER PRIMARY KEY, " + COL2 + " TEXT, "
                + COL3 + " TEXT, " + COL4 + " TEXT, " + COL5 + " TEXT, " + COL6 + " TEXT " + " ) ";
        db.execSQL (quary);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL (" DROP TABLE IF EXISTS " + TABLE_NAME );
        onCreate (db);

    }

    public boolean  addtotable(String roll,String name,String dep,String email,String username,String password)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase ();
        ContentValues contentValues = new ContentValues ();
        contentValues.put(COL1,roll);
        contentValues.put (COL2,name);
        contentValues.put (COL3,dep);
        contentValues.put (COL4,email);
        contentValues.put (COL5,username);
        contentValues.put (COL6,password);
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

    public boolean checkLogin(String username,String password)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase ();
        Cursor cursor = sqLiteDatabase.rawQuery ("SELECT * FROM "+ TABLE_NAME,null);
        boolean result = false;

        if(cursor.getCount ()!=0)
        {
           while(cursor.moveToNext ())
           {
               String uname = cursor.getString (4);
               String pass = cursor.getString (5);

               if(uname.equals (username) && pass.equals (password))
               {
                   result = true;
                   break;
               }
           }
        }


        return result;

    }

    public Cursor display()
    {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase ();
        Cursor res ;
        res = sqLiteDatabase.rawQuery (" SELECT * FROM " + TABLE_NAME,null);
        return res;

    }

    public int  delete(String roll)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase ();
        int res = sqLiteDatabase.delete (TABLE_NAME," ROLL = ?",new String[]{ roll });
        return res;

    }


}
