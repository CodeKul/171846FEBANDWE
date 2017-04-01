package com.codekul.uithread;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler(Looper.getMainLooper());
    }

    public void startCounter(View view) {
       // new MyTask().execute(0,100/*params*/);

        counterObservable()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext( num -> ((TextView) findViewById(R.id.textCntr)).setText(String.valueOf(num)) )
                .doOnComplete( () -> {})
                .subscribe();
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

        private ProgressDialog pd;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Ui thread

            pd = ProgressDialog.show(MainActivity.this,"Counter","Counting");
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
            pd.dismiss();
            //Ui thread
        }

        @Override
        protected void onProgressUpdate(String... values/*progress*/) {
            super.onProgressUpdate(values);
            //ui thread
            ((TextView) findViewById(R.id.textCntr)).setText(values[0]);
        }
    }

    private Observable<String> counterObservable() {
       return Observable.create(sub -> {
            for(int i = 0 ;i < 100 ; i++){
                Thread.sleep(500);
                sub.onNext(String.valueOf(i));
            }
            sub.onComplete();
       });
    }
}
