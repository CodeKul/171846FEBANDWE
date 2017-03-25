package com.codekul.dialogs;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void alert(View view) {
        show(AppDialog.TAG_ALERT);
    }

    public void datePicker(View view) {
        show(AppDialog.TAG_DATE);
    }

    public void timePicker(View view) {
        show(AppDialog.TAG_TIME);
    }

    public void progress(View view) {
        show(AppDialog.TAG_PROGRESS);
    }

    public void custom(View view) {
        show(AppDialog.TAG_CUSTOM);
    }

    private void show(String tag) {
        AppDialog dialog = new AppDialog();
        dialog.show(getSupportFragmentManager(), tag);
    }
}
