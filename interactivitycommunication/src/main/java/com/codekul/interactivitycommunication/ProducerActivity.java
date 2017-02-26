package com.codekul.interactivitycommunication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ProducerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producer);

        findViewById(R.id.btnBack).setOnClickListener(this::onBack);
    }

    private void onBack(View view) {
    }
}
