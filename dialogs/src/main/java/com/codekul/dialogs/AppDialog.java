package com.codekul.dialogs;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AppDialog extends DialogFragment {

    public static final String TAG_ALERT = "alert";
    public static final String TAG_DATE = "date";
    public static final String TAG_TIME = "time";
    public static final String TAG_PROGRESS = "progress";
    public static final String TAG_CUSTOM = "custom";

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = new Dialog(getActivity());

        if (getTag().equals(AppDialog.TAG_ALERT))
            dialog = alert();

        return dialog;
    }

    private AlertDialog alert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getResources().getString(R.string.title))
                .setIcon(R.mipmap.ic_launcher)
                .setMessage(getResources().getString(R.string.msg))
                .setPositiveButton(R.string.btnYes, (dialog, which) -> mt("Yes"))
                .setNegativeButton(R.string.btnNo, (dialog, which) -> mt("No"));
        return builder.create();
    }
    
    private void mt(String msg){
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
