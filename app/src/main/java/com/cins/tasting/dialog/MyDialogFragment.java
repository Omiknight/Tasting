package com.cins.tasting.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by jinjianping on 2017/10/7.
 */

public class MyDialogFragment extends DialogFragment {

  @NonNull @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setTitle("first alert");
    builder.setMessage("are you OK");
    builder.setPositiveButton("Sure", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        Toast.makeText(getContext(), "you click sure", Toast.LENGTH_LONG).show();
      }
    });
    builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        Toast.makeText(getContext(), "you click cancle", Toast.LENGTH_LONG).show();
      }
    });
    return builder.create();
  }
}