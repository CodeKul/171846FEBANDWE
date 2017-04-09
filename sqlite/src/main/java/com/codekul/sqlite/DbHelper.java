package com.codekul.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by aniruddha on 9/4/17.
 */

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Db.TabMyInfo.TAB_NAME + " ( " + Db.TabMyInfo.COL_NAME + " text, " + Db.TabMyInfo.COL_CARD_NUM + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
