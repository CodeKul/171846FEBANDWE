package com.codekul.statusbar;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final int NOTIFICATION_SAMPLE = 1235;
    private NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

    }

    public void fire(View view) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setContentInfo("Content Info")
                .setContentText("Content Text")
                .setContentTitle("Content Title")
                .setDefaults(Notification.DEFAULT_ALL)
                .setOngoing(true)
                .setSmallIcon(R.mipmap.ic_launcher);

        Notification notification = builder.build();
        manager.notify(NOTIFICATION_SAMPLE, notification);
    }
}
