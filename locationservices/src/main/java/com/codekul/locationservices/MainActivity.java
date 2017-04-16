package com.codekul.locationservices;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Geocoder

    public static final String TAG = MainActivity.class.getCanonicalName();
    private static final int LOC_PER_REQ1 = 1234;
    private static final int LOC_PER_REQ2 = 5679;
    private Geocoder geocoder;
    private LocationManager manager;

    private LocationListener listener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {

            ((TextView) findViewById(R.id.txtInfo)).setText("Lat - " + location.getLatitude() + " Lng - " + location.getLongitude());
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        geocoder = new Geocoder(this);

        manager = (LocationManager) getSystemService(LOCATION_SERVICE);
    }

    private void locationProviders() {

        List<String> providers = manager.getAllProviders();
        for (String provider : providers) {
            Log.i(TAG, "Provider - " + provider);
        }
    }

    private void bestProvider() {

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(true);
        criteria.setCostAllowed(true);
        criteria.setSpeedRequired(true);

        String bestProvider = manager.getBestProvider(criteria, false);
        Log.i(TAG, "Best Provider " + bestProvider);
    }

    public void onGeoCode(View view) {
        placeToLatLng();
    }

    private void latLngToPlace() {
        try {
            List<Address> addresses = geocoder.getFromLocation(18.5204, 73.8567, 5);
            for (Address address : addresses) {
                Log.i(TAG, "Country - " + address.getCountryName());
                Log.i(TAG, "Country Code - " + address.getCountryCode());
                Log.i(TAG, "Address Line - " + address.getAddressLine(0));
                Log.i(TAG, "Admin Area - " + address.getAdminArea());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void placeToLatLng() {
        try {
            List<Address> addresses = geocoder.getFromLocationName("CodeKul", 5);
            for (Address address : addresses) {
                Log.i(TAG, "Country - " + address.getCountryName());
                Log.i(TAG, "Country Code - " + address.getCountryCode());
                Log.i(TAG, "Address Line - " + address.getAddressLine(0));
                Log.i(TAG, "Admin Area - " + address.getAdminArea());
                Log.i(TAG, "Lat - " + address.getLatitude());
                Log.i(TAG, "Lng - " + address.getLongitude());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void providers(View view) {
        locationProviders();
        bestProvider();
    }

    private void currentLocation1() {

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Location")
                        .setMessage("Need Location Permission :)")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                ActivityCompat.requestPermissions(MainActivity.this,
                                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                                        LOC_PER_REQ1);
                            }
                        });
                builder.create().show();
            }
        } else {
            Location location = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (location != null) {
                Log.i(TAG, "Lat - " + location.getLatitude());
                Log.i(TAG, "Lng - " + location.getLongitude());
            }
        }
    }

    private void currentLocation2() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Location")
                        .setMessage("Need Location Permission :)")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                ActivityCompat.requestPermissions(MainActivity.this,
                                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                                        LOC_PER_REQ2);
                            }
                        });
                builder.create().show();
            }
        } else {
            manager.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER, 1000l, 0.1f, listener);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == LOC_PER_REQ1) {

            if (grantResults.length > 0) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    currentLocation1();
                }
            }
        }
        if (requestCode == LOC_PER_REQ2) {

            if (grantResults.length > 0) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    currentLocation2();
                }
            }
        }
    }

    public void current(View view) {

        currentLocation2();
    }
}
