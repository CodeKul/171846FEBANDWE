package com.codekul.webservices;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

/**
 * Created by aniruddha on 15/4/17.
 */

public class App extends Application {

    private Gson gson;

    private RequestQueue queue;

    public Gson gson() {
        return gson == null ? gson = new Gson() : gson;
    }

    public RequestQueue q() {
        return queue == null ? queue = Volley.newRequestQueue(this) : queue;
    }
}
