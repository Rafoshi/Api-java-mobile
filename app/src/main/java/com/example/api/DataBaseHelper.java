package com.example.api;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper  {
    public static final String CUSTOMER_TABLE = "CUSTOMER_DICTIONARY";
    public static final String COLUMN_ID = "CUSTOMER_ID";
    public static final String COLUMN_WORD = "CUSTOMER_ID";
    public static final String COLUMN_DEFINITION = "CUSTOMER_ID";
    public static final String COLUMN_PERMALINK = "CUSTOMER_ID";
    public static final String COLUMN_EXAMPLE = "CUSTOMER_ID";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "api.db", null, 1);
    }
    //    word
    //    definition
    //    permalink
    //    example
    //    DEFID
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatement = "CREATE TABLE " + CUSTOMER_TABLE +
                " ("+ COLUMN_ID +" INTEGER PRIMARY KEY,"
                + COLUMN_WORD + " TEXT, "
                + COLUMN_DEFINITION + " TEXT, "
                + COLUMN_PERMALINK +" TEXT,"
                +COLUMN_EXAMPLE+" TEXT)";
        sqLiteDatabase.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
