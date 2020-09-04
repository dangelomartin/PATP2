package com.example.pa_tp2.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pa_tp2.Interfaces.Entity;

public class DatabaseManager extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "G1_TP2.db";

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + ContactsTable.Entry.TABLE_NAME + " ("
                + ContactsTable.Entry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ContactsTable.Entry.NAME + " TEXT NOT NULL,"
                + ContactsTable.Entry.LAST_NAME + " TEXT NOT NULL,"
                + ContactsTable.Entry.EMAIL + " TEXT NOT NULL,"
                + ContactsTable.Entry.EMAIL_TYPE + " TEXT NOT NULL,"
                + ContactsTable.Entry.PHONE + " INTEGER NOT NULL,"
                + ContactsTable.Entry.PHONE_TYPE + " TEXT NOT NULL,"
                + ContactsTable.Entry.ADDRESS + " TEXT NOT NULL,"
                + ContactsTable.Entry.STUDY + " INTEGER NOT NULL,"
                + ContactsTable.Entry.RECEIVE_INFORMATION + " INTEGER NOT NULL,"
                + ContactsTable.Entry.BORN_DATE + " TEXT NOT NULL,"
                + "UNIQUE (" + ContactsTable.Entry._ID + "))");

        sqLiteDatabase.execSQL("CREATE TABLE " + InterestsContactTable.Entry.TABLE_NAME + " ("
                + InterestsContactTable.Entry.CONTACT_ID + " INTEGER,"
                + InterestsContactTable.Entry.INTEREST_ID + " INTEGER," +
                " PRIMARY KEY(contact_id, interest_id), " +
                " FOREIGN KEY (contact_id) REFERENCES contacts(_id) " +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public long save(String tableName, Entity entity) {
        return this.getWritableDatabase().insert(
                tableName,
                null,
                entity.toContentValues());
    }

    public Cursor find(String query) {
        return this.getReadableDatabase().rawQuery(query, null);
    }
}
