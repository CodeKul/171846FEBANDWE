package com.codekul.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<MyItem> dataSet = new ArrayList<>();
        dataSet.add(new MyItem(R.mipmap.ic_launcher, "Launcher"));
        dataSet.add(new MyItem(R.mipmap.ic_launcher, "Settings"));
        dataSet.add(new MyItem(R.mipmap.ic_launcher, "Internet"));
        dataSet.add(new MyItem(R.mipmap.ic_launcher, "Location"));

        MyAdapter adapter = new MyAdapter(this, dataSet);
    }
}
