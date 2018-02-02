package com.green.rabbit.sunshine.app.data.source.local;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static com.green.rabbit.sunshine.app.data.source.local.ForecastContract.AUTHORITY;
import static com.green.rabbit.sunshine.app.data.source.local.ForecastContract.ForecastEntry.CONTENT_URI;
import static com.green.rabbit.sunshine.app.data.source.local.ForecastContract.ForecastEntry.TABLE_NAME;
import static com.green.rabbit.sunshine.app.data.source.local.ForecastContract.PATH_FORECAST;

/**
 * Created by Łukasz on 29.01.2018.
 */
//TODO implement
//TODO clear
//TODO handle it with loaders or sth else
public class ForecastContentProvider extends ContentProvider {

    //TODO provide more relevant matches
    public static final int FORECAST = 100;
    public static final int FORECAST_WITH_ID = 101;

    private static final UriMatcher sUriMatcher = buildUriMatcher();

    public static UriMatcher buildUriMatcher() {
        UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        matcher.addURI(AUTHORITY, ForecastContract.PATH_FORECAST, FORECAST);
        matcher.addURI(AUTHORITY, ForecastContract.PATH_FORECAST + "/#", FORECAST_WITH_ID);
        return matcher;
    }

    private SunshineDBHelper dbHelper;

    @Override
    public boolean onCreate() {
        dbHelper = new SunshineDBHelper(getContext(), null);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection,
                        @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        final SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor;
        switch (sUriMatcher.match(uri)) {
            case FORECAST:
                cursor = db.query(TABLE_NAME, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;
            case FORECAST_WITH_ID:
                cursor = db.query(TABLE_NAME,
                        projection,
                        BaseColumns._ID + "=?",
                        new String[]{uri.getPathSegments().get(1)},
                        null,
                        null,
                        sortOrder);
                break;
            default:
                throw new UnsupportedOperationException();
        }
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case FORECAST:
                // directory
                return "vnd.android.cursor.dir" + "/" + AUTHORITY + "/" + PATH_FORECAST;
            case FORECAST_WITH_ID:
                // single item type
                return "vnd.android.cursor.item" + "/" + AUTHORITY + "/" + PATH_FORECAST;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        final SQLiteDatabase db = dbHelper.getWritableDatabase();
        Uri returnUri;
        if (sUriMatcher.match(uri) == FORECAST) {
            long id = db.insert(TABLE_NAME, null, values);
            if (id > 0) {
                returnUri = ContentUris.withAppendedId(CONTENT_URI, id);
            } else {
                throw new SQLException("Faile insert a row for uri: " + uri);
            }
        } else {
            throw new UnsupportedOperationException();
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return returnUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        final SQLiteDatabase db = dbHelper.getWritableDatabase();
        int numOfRows;
        if (sUriMatcher.match(uri) == FORECAST) {
            numOfRows = db.delete(TABLE_NAME, selection, selectionArgs);
        } else {
            throw new UnsupportedOperationException();
        }
        if (numOfRows > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return numOfRows;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        final SQLiteDatabase db = dbHelper.getWritableDatabase();
        int numOfRows;
        if (sUriMatcher.match(uri) == FORECAST) {
            numOfRows = db.update(TABLE_NAME, values, selection, selectionArgs);
        } else {
            throw new UnsupportedOperationException();
        }
        if (numOfRows > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return numOfRows;
    }

    @Override
    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] values) {
        final SQLiteDatabase db = dbHelper.getWritableDatabase();
        int rowsInserted = 0;
        if (sUriMatcher.match(uri) == FORECAST) {
            db.beginTransaction();
            for (ContentValues value : values) {
                long id = db.insert(TABLE_NAME, null, value);
                if (id != -1) {
                    ++rowsInserted;
                }
            }
            db.endTransaction();
        } else {
            return super.bulkInsert(uri, values);
        }
        if (rowsInserted > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return rowsInserted;
    }
}
