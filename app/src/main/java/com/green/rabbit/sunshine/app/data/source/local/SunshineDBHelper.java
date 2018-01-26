package com.green.rabbit.sunshine.app.data.source.local;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Łukasz on 05.01.2018.
 */

public class SunshineDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "sunshine.db";
    private static final int DATABASE_VERSION = 1;

    public SunshineDBHelper(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    public SunshineDBHelper(Context context, SQLiteDatabase.CursorFactory factory,
                            DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ForecastContract.SQL_CREATE_FORECAST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ForecastContract.ForecastEntry.TABLE_NAME);
        onCreate(db);
    }
}
