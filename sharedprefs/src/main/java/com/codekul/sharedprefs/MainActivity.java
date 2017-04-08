package com.codekul.sharedprefs;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //SharedPreferences prefs = getPreferences(MODE_APPEND);
                SharedPreferences prefs = getSharedPreferences("myPrefs", MODE_APPEND);
                SharedPreferences.Editor edit = prefs.edit();
                edit.putBoolean("bool", true);
                edit.putInt("_int", 12);
                edit.putString("_string", "codekul.com");
                edit.apply();
            }
        });

        findViewById(R.id.btnRead).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs = getSharedPreferences("myPrefs", MODE_APPEND);
                boolean bool = prefs.getBoolean("bool", false);
                int _int = prefs.getInt("_int", -1);
                String _string = prefs.getString("_string", "none");

                ((TextView)findViewById(R.id.txtData))
                        .setText("\n Boolean "+bool +" \n Int "+_int +"\n String "+_string);
            }
        });
    }
}
