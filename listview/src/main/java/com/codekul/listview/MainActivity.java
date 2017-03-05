package com.codekul.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> dataSet = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSet.add("Android");
        dataSet.add("iOS");
        dataSet.add("Symbian");
        dataSet.add("Windows");
        dataSet.add("Bada");
        dataSet.add("Rim");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataSet);

        ((ListView)findViewById(R.id.listView)).setAdapter(adapter);
        ((ListView)findViewById(R.id.listView)).setOnItemClickListener(this::onItemClick);
        findViewById(R.id.btnOkay).setOnClickListener(this::onOkayClicked);
    }

    private void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
        String osAtPos = adapter.getItem(pos);
        ((EditText)findViewById(R.id.edtOs)).setText(osAtPos);
    }

    private void onOkayClicked(View view) {
        String os = ((EditText)findViewById(R.id.edtOs)).getText().toString();
        dataSet.add(os);
        adapter.notifyDataSetChanged();
    }
}
