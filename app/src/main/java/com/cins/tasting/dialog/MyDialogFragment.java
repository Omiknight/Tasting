package com.cins.tasting.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by jinjianping on 2017/10/7.
 */

public class MyDialogFragment extends DialogFragment {

  @NonNull @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
    //AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    //builder.setTitle("first alert");
    //builder.setMessage("are you OK");
    //builder.setPositiveButton("Sure", new DialogInterface.OnClickListener() {
    //  @Override
    //  public void onClick(DialogInterface dialog, int which) {
    //    Toast.makeText(getContext(), "you click sure", Toast.LENGTH_LONG).show();
    //  }
    //});
    //builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
    //  @Override
    //  public void onClick(DialogInterface dialog, int which) {
    //    Toast.makeText(getContext(), "you click cancle", Toast.LENGTH_LONG).show();
    //  }
    //});
    //return builder.create();

    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
    //点击外面不取消 Dialog
    alertDialog.setCanceledOnTouchOutside(false);
    //dialog 背景透明
    //alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    alertDialog.setTitle("另一种写法");
    alertDialog.setMessage("are you ok");
    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Three",
        new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int which) {
          }
        });
    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Cancle",
        new DialogInterface.OnClickListener() {
          @Override public void onClick(DialogInterface dialogInterface, int i) {

          }
        });
    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "OK",
        new DialogInterface.OnClickListener() {
          @Override public void onClick(DialogInterface dialogInterface, int i) {

          }
        });
    return alertDialog;
  }

  //@Override public void onStart() {
  //  super.onStart();
  //  Window window = getDialog().getWindow();
  //  WindowManager.LayoutParams windowParams = window.getAttributes();
  //  windowParams.dimAmount = 0.0f;
  //  window.setAttributes(windowParams);
  //}
}