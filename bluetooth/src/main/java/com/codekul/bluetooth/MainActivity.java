package com.codekul.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_ENABLE_BT = 1234;
    private BluetoothAdapter adapter;

    private BroadcastReceiver recever = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            BluetoothDevice remote = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            Log.i("@codekul", "Name "+remote.getName());
            Log.i("@codekul", "Address "+remote.getAddress());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = BluetoothAdapter.getDefaultAdapter();

        if(adapter == null) return;

        Log.i("@codekul", "Name "+adapter.getName());
        Log.i("@codekul", "Address "+adapter.getAddress());

        IntentFilter filter = new IntentFilter();
        filter.addAction(BluetoothDevice.ACTION_FOUND);
        registerReceiver(recever, filter);
    }

    public void enableBt(View view) {
        if (!adapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_ENABLE_BT) {
            if(resultCode == RESULT_OK) {

            }
        }
    }

    public void pairedDevices(View view) {

        Set<BluetoothDevice> pairedDevices = adapter.getBondedDevices();

        if (pairedDevices.size() > 0) {
            // There are paired devices. Get the name and address of each paired device.
            for (BluetoothDevice device : pairedDevices) {
                String deviceName = device.getName();
                String deviceHardwareAddress = device.getAddress(); // MAC address
                Log.i("@codekul", "Name - "+deviceName +" Address - "+deviceHardwareAddress);
            }
        }
    }

    public void discover(View view) {
        adapter.startDiscovery();
    }

    public void makeVisible(View view) {
        Intent discoverableIntent =
                new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 320);
        startActivity(discoverableIntent);
    }

    public void server(View view) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final BluetoothServerSocket bss = adapter.listenUsingRfcommWithServiceRecord("chat", UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"));
                    final BluetoothSocket socket = bss.accept();
                    final DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    dos.writeUTF("This is from server");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void client(View view) {
        final Handler handler = new Handler(Looper.getMainLooper());

        new Thread(new Runnable() {
            @Override
            public void run() {
                final BluetoothDevice device = adapter.getRemoteDevice("84:10:0D:A1:08:ED");
                try {
                    final BluetoothSocket socket = device.createRfcommSocketToServiceRecord(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"));
                    socket.connect();
                    final DataInputStream dis = new DataInputStream(socket.getInputStream());
                    final String data = dis.readUTF();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            ((TextView)findViewById(R.id.textView)).setText(data);
                        }
                    });
                    Log.i("@codekul", "Data from server is "+data);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
