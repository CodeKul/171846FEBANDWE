package com.codekul.intentsandintentfilters;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void workWithIntents(View view) {
        Intent intent = new Intent();
        intent.setAction("com.codekul.action.COMMON");
        intent.setData(Uri.parse("tel://q39uaoisfjf"));
        startActivity(intent);
    }
}
