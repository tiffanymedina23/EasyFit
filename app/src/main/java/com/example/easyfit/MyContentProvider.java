package com.example.easyfit;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {
    public final static String DBNAME = "UsersDatabase";
    public final static String TABLE_USERSTABLE = "userstable";
    public final static String COLUMN_USERNAME = "username";
    public final static String COLUMN_EMAIL = "email";
    public final static String COLUMN_PASSWORD = "password";
    public final static String COLUMN_AGE = "age";
    public final static String COLUMN_SEX = "sex";
    public final static String COLUMN_FEET = "feet";
    public final static String COLUMN_INCHES = "inches";
    public final static String COLUMN_WEIGHT = "weight";
    public final static String COLUMN_GOAL = "goal";
    private static final String SQL_CREATE_MAIN = "CREATE TABLE " +
            TABLE_USERSTABLE +
            "(" +
            " _ID INTEGER PRIMARY KEY, " +
            COLUMN_USERNAME +
            "TEXT," +
            COLUMN_EMAIL +
            "TEXT," +
            COLUMN_PASSWORD +
            "TEXT," +
            COLUMN_AGE +
            "TEXT," +
            COLUMN_SEX +
            "TEXT," +
            COLUMN_FEET +
            "TEXT," +
            COLUMN_INCHES +
            "TEXT," +
            COLUMN_WEIGHT +
            "TEXT," +
            COLUMN_GOAL +
            "TEXT)";
    public static final Uri CONTENT_URI = Uri.parse("content://com.example.easyfit.provider/" + TABLE_USERSTABLE);
    private MainDatabaseHelper mOpenHelper;

    @Override
    public boolean onCreate() {
        mOpenHelper = new MainDatabaseHelper(getContext());
        return true;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        /*
        String username = values.getAsString(COLUMN_USERNAME);
        String email = values.getAsString(COLUMN_EMAIL);
        String password = values.getAsString(COLUMN_PASSWORD);
        Integer age = values.getAsInteger(COLUMN_AGE);
        Integer sex = values.getAsInteger(COLUMN_SEX);
        Integer feet = values.getAsInteger(COLUMN_FEET);
        Integer inches = values.getAsInteger(COLUMN_INCHES);
        Integer weight = values.getAsInteger(COLUMN_WEIGHT);
        Integer goal = values.getAsInteger(COLUMN_GOAL);
         */
        long id = mOpenHelper.getWritableDatabase()
                .insert(TABLE_USERSTABLE, null, values);

        return Uri.withAppendedPath(CONTENT_URI, "" + id);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        return mOpenHelper.getWritableDatabase()
                .update(TABLE_USERSTABLE, values, selection, selectionArgs);

    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        return mOpenHelper.getWritableDatabase()
                .delete(TABLE_USERSTABLE, selection, selectionArgs);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        return mOpenHelper.getReadableDatabase().query(TABLE_USERSTABLE, projection, selection, selectionArgs,
                null, null, sortOrder);
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    protected static final class MainDatabaseHelper extends SQLiteOpenHelper {
        MainDatabaseHelper(Context context) {
            super(context, DBNAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_MAIN);
        }

        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        }
    }
}
