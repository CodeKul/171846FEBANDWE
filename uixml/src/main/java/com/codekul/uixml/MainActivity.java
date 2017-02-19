package com.codekul.uixml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtAnyName = (EditText) findViewById(R.id.edtAnyName);

        Button btnOkay = (Button) findViewById(R.id.btnOkay);
    }
}
