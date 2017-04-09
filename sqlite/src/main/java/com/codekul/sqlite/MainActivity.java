package com.codekul.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private DbHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new DbHelper(this, Db.DB_NAME, null, Db.DB_VERSION);
    }

    public void insert(View view) {
        SQLiteDatabase sqDb = helper.getWritableDatabase();

        sqDb.close();
    }

    public void update(View view) {
    }

    public void delete(View view) {
    }

    public void query(View view) {
    }
}
