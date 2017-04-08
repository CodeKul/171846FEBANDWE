package com.codekul.externalstorage;

import android.os.Environment;
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

    // /storage/emulated/0/Android/data/com.codekul.externalstorage/files/my/my.txt
    public static final String TAG = MainActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePublic();

            }
        });

        findViewById(R.id.btnRead).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readPublic();
            }
        });

        findViewById(R.id.btnInfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = Environment.getExternalStoragePublicDirectory("");
                File []list = file.listFiles();
                for (File f : list) {
                    Log.i(TAG, f.isDirectory() ? "* "+f.getName() : "- "+f.getName());
                }
            }
        });
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    public void savePublic() {
        if (isExternalStorageWritable()) {

            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "my.txt");

            Log.i(TAG, "Path - " + file.getAbsolutePath());
            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write("External Storage, codekul.com".getBytes());
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readPublic() {

        if (isExternalStorageReadable()) {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "my.txt");
            try {
                FileInputStream fis = new FileInputStream(file);
                StringBuilder builder = new StringBuilder();
                while (true) {
                    int ch = fis.read();
                    if (ch == -1) break;
                    else builder.append((char) ch);
                }
                ((TextView) findViewById(R.id.txtData)).setText(builder.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void savePrivate() {

        if (isExternalStorageWritable()) {
            File file = new File(getExternalFilesDir("my"), "my.txt");
            Log.i(TAG, "Path - " + file.getAbsolutePath());
            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write("External Storage, codekul.com".getBytes());
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readPrivate() {

        if (isExternalStorageReadable()) {
            File file = new File(getExternalFilesDir("my"), "my.txt");
            try {
                FileInputStream fis = new FileInputStream(file);
                StringBuilder builder = new StringBuilder();
                while (true) {
                    int ch = fis.read();
                    if (ch == -1) break;
                    else builder.append((char) ch);
                }
                ((TextView) findViewById(R.id.txtData)).setText(builder.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
