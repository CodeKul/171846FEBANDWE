package com.codekul.interactivitycommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

public class ProducerActivity extends AppCompatActivity {

    public static final String TAG = ProducerActivity.class.getCanonicalName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producer);

        Intent intentResponsible = getIntent();
        Bundle bundle = intentResponsible.getExtras();
        if (bundle != null) {
            String one = bundle.getString("keyOne");
            String two = bundle.getString("keyTwo");
            Log.i(TAG,  "One - "+ one + " Two - "+two);

            ((RadioButton)findViewById(R.id.radOne)).setText(one);
            ((RadioButton)findViewById(R.id.radTwo)).setText(two);
        }

        findViewById(R.id.btnBack).setOnClickListener(this::onBack);
    }

    private void onBack(View view) {
    }
}
