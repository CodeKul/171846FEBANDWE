package com.codekul.internalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToFile();
            }
        });

        findViewById(R.id.btnRead).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readFromFile();
            }
        });

        findViewById(R.id.btnInfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // /data/user/0/com.codekul.internalstorage/files/myName.txt
                // /data/user/0/com.codekul.internalstorage/shared_prefs
                // /data/user/0/com.codekul.internalstorage/database

                info();
            }
        });
    }

    private void saveToFile() {

        try {
            final FileOutputStream fos = openFileOutput("myFile.txt", MODE_APPEND);
            fos.write("Hello, welcome to codekul.com ".getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFromFile() {

        try {
            final FileInputStream fis = openFileInput("myFile.txt");
            StringBuilder builder = new StringBuilder();
            while(true) {
                int ch = fis.read();
                if(ch == -1) break;
                else builder.append((char)ch);
            }
            ((TextView)findViewById(R.id.txtData)).setText(builder.toString());
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void info() {
        File fileRoot = new File(getFilesDir(), "myName.txt");
        Log.i(TAG, "Path - "+fileRoot.getAbsolutePath());

        String []files = fileList();
        for (String file : files) {
            Log.i(TAG, " Name - "+file);
        }
    }
}
