package com.hypercryptic.diabeticdiary.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sharukh Hasan on 8/15/16.
 * Copyright © 2016 HyperCryptic Solutions, LLC. All rights reserved.
 */
public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String NAME_DB = "diabetes_db";
    public static final int VERSION_DB = 1;

    public static final String CREATE_TABLE_GROUP =
            "CREATE TABLE IF NOT EXISTS "+ SampleDataTables.TABLE+" ( " +
                    SampleDataTables.ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , "+
                    SampleDataTables.GLYCAEMIA + " INTEGER NOT NULL, "+
                    SampleDataTables.INSULIN + " INTEGER DEFAULT 0, "+
                    SampleDataTables.PERIOD_TXT + " TEXT, "+
                    SampleDataTables.PERIOD_NUM + " INTEGER, "+
                    SampleDataTables.TIME+" TEXT NOT NULL, "+
                    SampleDataTables.DAY + " INTEGER, "+
                    SampleDataTables.MONTH + " INTEGER, "+
                    SampleDataTables.YEAR+" INTEGER "+" ) ; ";

    public static final String DROP_TABLE_GROUP = "DROP TABLE IF EXISTS "+ SampleDataTables.TABLE+" ;";

    public DatabaseHelper(Context context){
        super(context, NAME_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE_GROUP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_GROUP);
        onCreate(db);
    }
}
