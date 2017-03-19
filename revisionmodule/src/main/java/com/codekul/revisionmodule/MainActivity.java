package com.codekul.revisionmodule;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viCode();
    }

    private void viCode() {

        MainActivity m = this;
        Context c = m;

        LinearLayout layout = new LinearLayout(this);
        layout.setLayoutParams(new LinearLayout.LayoutParams(500,500));

        Button btn = new Button(this);
        btn.setLayoutParams(new LinearLayout.LayoutParams(500,150));
        btn.setText("Android");
        layout.addView(btn);

        setContentView(layout);
    }

    private void viaXml() {
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btnOkay);
    }
}
