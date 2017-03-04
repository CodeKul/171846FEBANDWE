package com.codekul.compoundviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAdd).setOnClickListener(this::onClick);

        /*final LayoutInflater inflater = getLayoutInflater();
        LinearLayout root = (LinearLayout) findViewById(R.id.layoutCompound);
        inflater.inflate(R.layout.compound_view, root, false);*/
    }

    private void onClick(View view) {

        //final LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        //final LayoutInflater inflater = LayoutInflater.from(this);
        final LayoutInflater inflater = getLayoutInflater();
        LinearLayout root = (LinearLayout) findViewById(R.id.layoutCompound);
        View compoundView = inflater.inflate(R.layout.compound_view, null, false);
        ((TextView)compoundView.findViewById(R.id.txtTym)).setText(""+new Date());
        root.addView(compoundView);
    }
}
