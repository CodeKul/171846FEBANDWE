package com.codekul.jsonparsing;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.codekul.jsonparsing.domain.CodeKul;
import com.codekul.jsonparsing.domain.Infra;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getCanonicalName();
    private AssetManager manager;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gson = new Gson();

        manager = getAssets();
    }

    private String json() {
        final StringBuilder builder = new StringBuilder();
        try {
            final InputStream is = manager.open("codekul.json");
            while (true) {
                int ch = is.read();
                if (ch == -1) break;
                else builder.append((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public void parse(View view) {
        usingGson();
    }

    private void usingGson() {
        CodeKul codekul = gson.fromJson(json(), CodeKul.class);
        Log.i(TAG, "Name - "+codekul.getName());
        Log.i(TAG, "Popularity - "+codekul.getPopularity());
        Log.i(TAG, "Rating - "+codekul.getRating());
        List<String> courses = codekul.getCourses();
        for (String course : courses) {
            Log.i(TAG, "Course - "+course);
        }
        Infra infra = codekul.getInfra();
        Log.i(TAG, "Chair - "+infra.getChair());
        Log.i(TAG, "Tables - "+infra.getTables());
    }

    private void usingJSONObject() {
        try {
            JSONObject root = new JSONObject(json());
            Log.i(TAG, "Name - " + root.getString("name"));
            Log.i(TAG, "Rating - " + root.getString("rating"));
            Log.i(TAG, "Popularity - " + root.getString("popularity"));

            JSONArray arr = root.getJSONArray("courses");
            for (int i = 0; i < arr.length(); i++) {
                Log.i(TAG, "" + arr.getString(i));
            }

            JSONObject inner = root.getJSONObject("infra");
            Boolean tables = inner.getBoolean("tables");
            Integer chair = inner.getInt("chair");
            Log.i(TAG, "Tables - " + tables);
            Log.i(TAG, "Chair - " + chair);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
