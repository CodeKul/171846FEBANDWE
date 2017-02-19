package com.codekul.weekendapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainActivity m = this;

        LinearLayout.LayoutParams paramsRoot =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(paramsRoot);

        LinearLayout.LayoutParams paramsEdt = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        EditText edtUserName = new EditText(m /*activity is a context*/);
        edtUserName.setLayoutParams(paramsEdt);
        layout.addView(edtUserName);

        LinearLayout.LayoutParams paramsBtn = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        Button btnOkay = new Button(this);
        btnOkay.setText("Okay");
        btnOkay.setLayoutParams(paramsBtn);
        layout.addView(btnOkay);

        setContentView(layout);
    }
}
