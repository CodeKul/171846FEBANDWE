package com.codekul.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getCanonicalName();

    private DbHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new DbHelper(this, Db.DB_NAME, null, Db.DB_VERSION);
    }

    public void insert(View view) {
        rawInsert();
    }

    public void update(View view) {

        String table = Db.TabMyInfo.TAB_NAME;
        ContentValues values = new ContentValues();
        values.put(Db.TabMyInfo.COL_NAME, ((EditText)findViewById(R.id.edtName)).getText().toString());

        String whereClause = Db.TabMyInfo.COL_CARD_NUM + " = ?";
        String[] whereArgs = {((EditText) findViewById(R.id.edtNumber)).getText().toString()};

        SQLiteDatabase sqDb = helper.getWritableDatabase();
        int affected = sqDb.update(table, values, whereClause, whereArgs);

        sqDb.close();
    }

    public void delete(View view) {
        String table = Db.TabMyInfo.TAB_NAME;
        String whereClause = Db.TabMyInfo.COL_CARD_NUM + " = ?";
        String[] whereArgs ={((EditText) findViewById(R.id.edtNumber)).getText().toString()};

        SQLiteDatabase sqDb = helper.getWritableDatabase();
        sqDb.delete(table, whereClause, whereArgs);
        sqDb.close();
    }

    public void query(View view) {
        selectOne();
    }

    private void selectOne() {
        String table = Db.TabMyInfo.TAB_NAME;
        String[] columns = {Db.TabMyInfo.COL_NAME};
        String selection = Db.TabMyInfo.COL_CARD_NUM + " = ? ";
        String[] selectionArgs = {((EditText) findViewById(R.id.edtNumber)).getText().toString()};
        String groupBy = null;
        String having = null;
        String orderBy = null;

        SQLiteDatabase sqDb = helper.getReadableDatabase();
        Cursor cursor = sqDb.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
        if (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(Db.TabMyInfo.COL_NAME));
            ((EditText)findViewById(R.id.edtName)).setText(name);
            Log.i(TAG, "Name - " + name );
        }
        sqDb.close();
    }

    private void selectAll() {
        String table = Db.TabMyInfo.TAB_NAME;
        String[] columns = null;
        String selection = null;
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;

        SQLiteDatabase sqDb = helper.getReadableDatabase();
        Cursor cursor = sqDb.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(Db.TabMyInfo.COL_NAME));
            String cardNum = cursor.getString(cursor.getColumnIndex(Db.TabMyInfo.COL_CARD_NUM));
            Log.i(TAG, "Name - " + name + " Card - " + cardNum);
        }
        sqDb.close();
    }

    private void simpleInsert() {
        SQLiteDatabase sqDb = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Db.TabMyInfo.COL_NAME, ((EditText) findViewById(R.id.edtName)).getText().toString());
        values.put(Db.TabMyInfo.COL_CARD_NUM, ((EditText) findViewById(R.id.edtNumber)).getText().toString());

        long rowId = sqDb.insert(Db.TabMyInfo.TAB_NAME, null, values);
        Log.i(TAG, "RowId - " + rowId);
        sqDb.close();
    }
    private void rawInsert() {
        SQLiteDatabase sqDb = helper.getWritableDatabase();
        sqDb.execSQL("insert into "+Db.TabMyInfo.TAB_NAME + " values ('Apple','11')");
        sqDb.close();
    }
}
