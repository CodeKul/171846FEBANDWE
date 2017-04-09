package com.codekul.sqlite;

import android.content.ContentValues;
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
        SQLiteDatabase sqDb = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Db.TabMyInfo.COL_NAME, ((EditText)findViewById(R.id.edtName)).getText().toString());
        values.put(Db.TabMyInfo.COL_CARD_NUM, ((EditText)findViewById(R.id.edtNumber)).getText().toString());

        long rowId = sqDb.insert(Db.TabMyInfo.TAB_NAME, null, values);
        Log.i(TAG, "RowId - "+rowId);
        sqDb.close();
    }

    public void update(View view) {
    }

    public void delete(View view) {
    }

    public void query(View view) {
    }
}
