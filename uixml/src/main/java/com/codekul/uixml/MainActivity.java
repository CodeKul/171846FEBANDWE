package com.codekul.uixml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOkay = (Button) findViewById(R.id.btnOkay);
        //btnOkay.setOnClickListener(new Click());
        /*btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText edtAnyName = (EditText) findViewById(R.id.edtAnyName);
                String data = edtAnyName.getText().toString();
                edtAnyName.setText(data.toUpperCase());
            }
        });*/

      /*  btnOkay.setOnClickListener( view -> {
            makeUpperCase(view);
        });*/

        btnOkay.setOnClickListener(this::makeUpperCase); // method reference
    }


    private void makeUpperCase(View view) {
        EditText edtAnyName = (EditText) findViewById(R.id.edtAnyName);
        String data = edtAnyName.getText().toString();
        edtAnyName.setText(data.toUpperCase());
    }

    private class Click implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            EditText edtAnyName = (EditText) findViewById(R.id.edtAnyName);
            String data = edtAnyName.getText().toString();
            edtAnyName.setText(data.toUpperCase());

            Log.i(TAG, data);
        }
    }
}
