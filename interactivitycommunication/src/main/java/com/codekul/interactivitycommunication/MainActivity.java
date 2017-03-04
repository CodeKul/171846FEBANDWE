package com.codekul.interactivitycommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_ONE="keyOne";
    public static final String KEY_TWO="keyTwo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAndroid = (Button) findViewById(R.id.btnAndroid);
        btnAndroid.setOnClickListener(this::onAndroid);
        findViewById(R.id.btnMango).setOnClickListener(this::onMango);
    }

    private void onMango(View view) {
        Class cls = ProducerActivity.class;
        Intent intent = new Intent(this, cls);

        Bundle bundle = new Bundle();
        bundle.putString(KEY_ONE, "Mango1" );
        bundle.putString(KEY_TWO, "Mango2" );

        intent.putExtras(bundle);

        startActivityForResult(intent, 4589);
    }

    private void onAndroid(View view) {
        Class cls = ProducerActivity.class;
        Intent intent = new Intent(this, cls);

        Bundle bundle = new Bundle();
        bundle.putString(KEY_ONE, "android1");
        bundle.putString(KEY_TWO, "android2");
        intent.putExtras(bundle);

        startActivityForResult(intent, 4589);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode  == 4589) {
            if(resultCode == RESULT_OK) {

                ((TextView)findViewById(R.id.txtRes)).setText(data.getStringExtra(ProducerActivity.KEY_RES));
              /*  Bundle bundle = data.getExtras();
                if(bundle != null)
                    ((TextView)findViewById(R.id.txtRes)).setText(bundle.getString(ProducerActivity.KEY_RES));*/
            }
        }
    }
}
