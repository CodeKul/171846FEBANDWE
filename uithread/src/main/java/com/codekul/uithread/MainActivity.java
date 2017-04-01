package com.codekul.uithread;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler(Looper.getMainLooper());
    }

    public void startCounter(View view) {
        handlerCounter();
    }

    private void counter() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ((TextView) findViewById(R.id.textCntr)).setText(String.valueOf(i));
        }
    }

    private void threadedCounter() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                counter();
            }
        }).start();
    }

    int i = 0;

    private void handlerCounter() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            ((TextView) findViewById(R.id.textCntr)).setText(String.valueOf(i));
                        }
                    });
                }
            }
        }).start();
    }
}
