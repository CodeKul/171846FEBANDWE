package com.codekul.interactivitycommunication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAndroid = (Button)findViewById(R.id.btnAndroid);
        btnAndroid.setOnClickListener(this::onAndroid);

        findViewById(R.id.btnMango).setOnClickListener(this::onMango);
    }

    private void onMango(View view) {

    }

    private void onAndroid(View view) {

    }
}
