package com.cins.tasting.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * 添加一列多选按钮
 * Created by jinjianping on 2017/10/8.
 */

public class MultipChoiceDialogFragment extends DialogFragment {

  @NonNull @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
    final String s[] = { "item1", "item2", "item3" };
    final boolean s2[] = { true, false, false };
    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
    builder.setMultiChoiceItems(s, s2, new DialogInterface.OnMultiChoiceClickListener() {
      @Override public void onClick(DialogInterface dialogInterface, int i, boolean b) {
        Toast.makeText(getContext(), s[i] + " isChecked is " + b, Toast.LENGTH_LONG).show();
      }
    });
    return builder.create();
  }
}
