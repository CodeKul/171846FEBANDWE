package com.codekul.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {


    public static final String KEY_COLOR = "color";

    public static final ColorFragment getInstance(int color) {
        ColorFragment frag = new ColorFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ColorFragment.KEY_COLOR,color);
        frag.setArguments(bundle);
        return frag;
    }

    public ColorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_color, container, false);
        Bundle bundle = getArguments();
        rootView.setBackgroundColor(bundle.getInt(KEY_COLOR));
        return rootView;
    }

}
