package com.codekul.locationservices;

import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Geocoder

    public static final String TAG = MainActivity.class.getCanonicalName();
    private Geocoder geocoder;
    private LocationManager manager;

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
            Log.i(TAG, "Provider - "+provider);
        }
    }

    private void bestProvider() {

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(true);
        criteria.setCostAllowed(true);
        criteria.setSpeedRequired(true);

        String bestProvider = manager.getBestProvider(criteria, false);
        Log.i(TAG, "Best Provider "+bestProvider);
    }

    public void onGeoCode(View view) {
        placeToLatLng();
    }

    private void latLngToPlace() {
        try {
            List<Address> addresses = geocoder.getFromLocation(18.5204, 73.8567, 5);
            for (Address address : addresses) {
                Log.i(TAG, "Country - "+address.getCountryName());
                Log.i(TAG, "Country Code - "+address.getCountryCode());
                Log.i(TAG, "Address Line - "+address.getAddressLine(0));
                Log.i(TAG, "Admin Area - "+address.getAdminArea());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void placeToLatLng() {
        try {
            List<Address> addresses = geocoder.getFromLocationName("CodeKul", 5);
            for (Address address : addresses) {
                Log.i(TAG, "Country - "+address.getCountryName());
                Log.i(TAG, "Country Code - "+address.getCountryCode());
                Log.i(TAG, "Address Line - "+address.getAddressLine(0));
                Log.i(TAG, "Admin Area - "+address.getAdminArea());
                Log.i(TAG, "Lat - "+address.getLatitude());
                Log.i(TAG, "Lng - "+address.getLongitude());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void providers(View view) {
        locationProviders();
        bestProvider();
    }

    private void currentLocation() {

    }
}
