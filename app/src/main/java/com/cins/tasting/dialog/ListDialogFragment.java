package com.cins.tasting.dialog;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * 添加一个列表
 * Created by jinjianping on 2017/10/8.
 */

public class ListDialogFragment extends DialogFragment {

  @NonNull @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
    final String s[] = new String[]{"item1","item2","item3"};
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setTitle("List")
        .setItems(s, new DialogInterface.OnClickListener() {
          @TargetApi(Build.VERSION_CODES.M)
          @Override public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(getContext(),"you click" + s[i],Toast.LENGTH_LONG).show();
          }
        });
    return builder.show();
  }
}
