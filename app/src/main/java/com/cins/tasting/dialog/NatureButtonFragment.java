package com.cins.tasting.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * 再添加一个按钮
 * Created by jinjianping on 2017/10/7.
 */

public class NatureButtonFragment extends DialogFragment {

  @NonNull @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setTitle("more button")
        .setMessage("more button")
        //确认按钮
        .setNegativeButton("SURE", new DialogInterface.OnClickListener() {
          @Override public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(getContext(),"you click sure",Toast.LENGTH_LONG).show();
          }
        })
        //取消按钮
        .setPositiveButton("CANCLE", new DialogInterface.OnClickListener() {
          @Override public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(getContext(),"you click cancle",Toast.LENGTH_SHORT).show();
          }
        })
        //第三个按钮
        .setNeutralButton("REMAIND ME LATER", new DialogInterface.OnClickListener() {
          @Override public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(getContext(),"you click later",Toast.LENGTH_LONG).show();
          }
        });
    return builder.create();
  }
}
