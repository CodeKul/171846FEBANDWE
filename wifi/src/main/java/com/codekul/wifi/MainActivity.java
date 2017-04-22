package com.codekul.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getCanonicalName();
    private WifiManager manager;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            List<ScanResult> results = manager.getScanResults();
            for (ScanResult result : results) {
                Log.i(TAG, "Name - "+result.SSID);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        connectedDevices();

        IntentFilter filter = new IntentFilter();
        filter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);

        registerReceiver(receiver, filter);
    }

    private void connectedDevices() {

        List<WifiConfiguration> configs = manager.getConfiguredNetworks();
        for (WifiConfiguration config : configs) {
            Log.i(TAG, "Name - " + config.SSID);
            Log.i(TAG, "BSSID - " + config.BSSID);
        }
    }

    public void scan(View view) {
        //manager.startScan();

        connect();
    }

    private void connect() {
        WifiConfiguration wifiConfig = new WifiConfiguration();
        wifiConfig.SSID = String.format("\"%s\"", "YourCodekul");
        wifiConfig.preSharedKey = String.format("\"%s\"", "#code.KUL123#");

        int netId = manager.addNetwork(wifiConfig);
        manager.disconnect();
        manager.enableNetwork(netId, true);
        manager.reconnect();
    }
}
