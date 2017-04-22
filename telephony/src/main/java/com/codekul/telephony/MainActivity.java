package com.codekul.telephony;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getCanonicalName();

    private TelephonyManager manager;
    private SmsManager smsManager;
    private PendingIntent intentSent, intentDelivered;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals("com.codekul.sms.sent")) {
                Toast.makeText(context, "Msg Sent", Toast.LENGTH_SHORT).show();
            }
            else if(intent.getAction().equals("com.codekul.sms.delivered")) {
                Toast.makeText(context, "Msg Delivered", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        smsManager = SmsManager.getDefault();

        Intent sent = new Intent("com.codekul.sms.sent");
        intentSent = PendingIntent.getBroadcast(this, 1234, sent, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent delivered = new Intent("com.codekul.sms.delivered");
        intentDelivered = PendingIntent.getBroadcast(this, 4567, delivered, PendingIntent.FLAG_UPDATE_CURRENT);

        IntentFilter filter = new IntentFilter();
        filter.addAction("com.codekul.sms.sent");
        filter.addAction("com.codekul.sms.delivered");

        registerReceiver(receiver, filter);

        info();
    }

    private void info() {

        int dataActivity = manager.getDataActivity();
        int callState = manager.getCallState();
        String imei = manager.getDeviceId();
        Log.i(TAG, "Imei is " + imei);
        String num = manager.getLine1Number();
        Log.i(TAG, "Num is " + num);
        String simIso = manager.getSimCountryIso();
        Log.i(TAG, "Sim Iso " + simIso);
        Log.i(TAG, "Operator - " + manager.getSimOperator());
        Log.i(TAG, "Name Op - " + manager.getSimOperatorName());
    }

    public void sendSms(View view) {
        smsManager.sendTextMessage("+919762548833", null, "Hello, codekul", intentSent, intentDelivered);
    }
}
