package com.codekul.uithread;

import android.os.AsyncTask;
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
        new MyTask().execute(0,100/*params*/);
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

    private class MyTask extends AsyncTask<Integer/*prams*/, String/*progress*/, Boolean/*result*/> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Ui thread
        }

        @Override
        protected Boolean/*Result*/ doInBackground(Integer... params/*params*/) {
            // worker thread

            for (int i = params[0]; i < params[1];i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(String.valueOf(i));
            }

            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean/*result*/) {
            super.onPostExecute(aBoolean);

            //Ui thread
        }

        @Override
        protected void onProgressUpdate(String... values/*progress*/) {
            super.onProgressUpdate(values);
            //ui thread
            ((TextView) findViewById(R.id.textCntr)).setText(values[0]);
        }
    }
}
