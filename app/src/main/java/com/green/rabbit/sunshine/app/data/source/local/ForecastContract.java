package com.green.rabbit.sunshine.app.data.source.local;

import android.provider.BaseColumns;

/**
 * Created by Łukasz on 05.01.2018.
 */

public class ForecastContract {

    public static final String SQL_CREATE_FORECAST_TABLE = "CREATE TABLE " +
            ForecastEntry.TABLE_NAME + " (" +
            ForecastEntry._ID + " PRIMARY KEY AUTOINCREMENT, " +
            ForecastEntry.COLUMN_CITY + " TEXT NOT NULL, " +
            ForecastEntry.COLUMN_DATE + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
            ForecastEntry.COLUMN_TEMPERATURE + " INTEGER NOT NULL " +
            ");";

    public static final class ForecastEntry implements BaseColumns {
        public static final String TABLE_NAME = "forecast";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_CITY = "city";
        public static final String COLUMN_TEMPERATURE = "temp";
    }
}
