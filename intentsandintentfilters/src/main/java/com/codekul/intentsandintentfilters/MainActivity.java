package com.codekul.intentsandintentfilters;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void workWithIntents(View view) {
        web();
    }

    private void our() {
        Intent intent = new Intent();
        intent.setAction("com.codekul.action.COMMON");
        intent.setData(Uri.parse("tel://q39uaoisfjf"));
        startActivity(intent);
    }

    private void dial() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }

    private void call() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel://9762548833"));
        startActivity(intent);
    }

    private void web() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://codekul.com"));
        startActivity(intent);
    }

    private void route() {
        String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?saddr=%f,%f(%s)&daddr=%f,%f (%s)", 18.5204, 73.8567, "Home Sweet Home", 19.0760, 72.8777, "Where the party is at");
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}
