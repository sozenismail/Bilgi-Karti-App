package com.ismailsozen.bilgilerenteresan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class SQliteHelper extends SQLiteOpenHelper {

    private static final int database_VERSION=1;
    private static final String database_NAME="bilgiDb";
    private static final String table_Bilgi="bilgiler";
    private static final String bilgi_id="id";
    private static final String bilgi_yazi="yazi";
    private static final String create_table_bilgi="CREATE TABLE "+table_Bilgi+" ("+bilgi_id+" INTEGER PRIMARY KEY AUTOINCREMENT, "+bilgi_yazi+" TEXT )";


    public SQliteHelper(Context context) {
        super(context, database_NAME, null, database_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(create_table_bilgi);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+table_Bilgi);
        this.onCreate(db);

    }

    public void BilgiEkle(Bilgi bilgi)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues degerler=new ContentValues();
        degerler.put(bilgi_yazi,bilgi.getBilgi_yazi());
        db.insert(table_Bilgi,null,degerler);
        db.close();

    }

    public List<Bilgi> BilgiGetir(){

        Bilgi bilgi=null;
        List<Bilgi> bilgiler=new ArrayList<>();
        String query="SELECT * FROM "+table_Bilgi;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);

        if (cursor.moveToFirst()){

            do {

                bilgi=new Bilgi();
                bilgi.setBilgi_id(Integer.parseInt(cursor.getString(0)));
                bilgi.setBilgi_yazi(cursor.getString(1));

                bilgiler.add(bilgi);

            }

            while (cursor.moveToNext());


        }

        return bilgiler;

    }



}
