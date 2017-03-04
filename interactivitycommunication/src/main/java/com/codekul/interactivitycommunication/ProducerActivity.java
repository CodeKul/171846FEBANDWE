package com.codekul.interactivitycommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ProducerActivity extends AppCompatActivity {

    public static final String KEY_RES = "result";
    public static final String TAG = ProducerActivity.class.getCanonicalName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producer);

        Intent intentResponsible = getIntent();
        Bundle bundle = intentResponsible.getExtras();
        if (bundle != null) {
            String one = bundle.getString(MainActivity.KEY_ONE);
            String two = bundle.getString(MainActivity.KEY_TWO);
            Log.i(TAG,  "One - "+ one + " Two - "+two);

            ((RadioButton)findViewById(R.id.radOne)).setText(one);
            ((RadioButton)findViewById(R.id.radTwo)).setText(two);
        }

        findViewById(R.id.btnBack).setOnClickListener(this::onBack);
    }

    private void onBack(View view) {

        Intent intent = new Intent();

        /*Bundle bundle = new Bundle();
        bundle.putString(KEY_RES, getSelectedText());
        intent.putExtras(bundle);*/

        intent.putExtra(KEY_RES, getSelectedText());

        setResult( RESULT_OK, intent);
        finish();
    }

    private String getSelectedText() {
        int id = ((RadioGroup)findViewById(R.id.radioGrp)).getCheckedRadioButtonId();
        return ((RadioButton)findViewById(id)).getText().toString();
    }
}
