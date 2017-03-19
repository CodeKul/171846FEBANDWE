package com.codekul.simplevalueresources;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String txtNm = getResources().getString(R.string.txtNm);
        //int color = getColor(R.color.perfectBlack);
        int color = getResources().getColor(R.color.perfectBlack);
        color = ContextCompat.getColor(this, R.color.perfectBlack);

        String cities[] = getResources().getStringArray(R.array.cities);
    }
}

