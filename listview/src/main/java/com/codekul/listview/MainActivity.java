package com.codekul.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> dataSet = new ArrayList<>();
        dataSet.add("Android");
        dataSet.add("iOS");
        dataSet.add("Symbian");
        dataSet.add("Windows");
        dataSet.add("Bada");
        dataSet.add("Rim");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataSet);

        ((ListView)findViewById(R.id.listView)).setAdapter(adapter);
    }
}
