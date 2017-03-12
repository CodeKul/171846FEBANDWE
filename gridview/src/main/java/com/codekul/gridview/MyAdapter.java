package com.codekul.gridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by aniruddha on 12/3/17.
 */

public class MyAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<MyItem> dataSet;

    public MyAdapter(Context context, ArrayList<MyItem> dataSet) {
        this.context = context;
        this.dataSet = dataSet;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
