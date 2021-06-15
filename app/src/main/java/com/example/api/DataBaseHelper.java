package com.example.api;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper  {

    private static final int DATABASE_VERSION = 1 ;
    private static final String DATABASE_NAME = "DC_DB";
    private static final String DICTONARY_TABLE = "note";
    private static final String DEF_ID = "id";
    private static final String DEFINITION = "def";

    private static final String[] COLUNAS = {DEF_ID, DICTONARY_TABLE, DATABASE_NAME};

    public DataBaseHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE note ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "def TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS note");
        this.onCreate(sqLiteDatabase);
    }


    public void addData(CustomerModel customerModel) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DEFINITION, customerModel.getDefinition());
        sqLiteDatabase.insert(DICTONARY_TABLE, null, values);
        sqLiteDatabase.close();
    }

    public List<CustomerModel> getEveryone(){
        List<CustomerModel> returnList = new ArrayList<>();

        String query = "SELECT * FROM " + DICTONARY_TABLE ;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                int customerID = cursor.getInt(0);
                String customerDef =  cursor.getString(1);

                CustomerModel newCustomer = new CustomerModel(customerID, customerDef);
                returnList.add(newCustomer);

            }while (cursor.moveToNext());
        }
        else{

        }
        cursor.close();
        db.close();
        return returnList;
    }

    public void deleteData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM note";
        db.execSQL(query);
    }
}



