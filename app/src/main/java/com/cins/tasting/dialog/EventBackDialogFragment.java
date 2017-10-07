package com.cins.tasting.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * 在 activity 中处理按钮事件
 * Created by jinjianping on 2017/10/8.
 */

public class EventBackDialogFragment extends DialogFragment {

  public interface EventBackDialogListener {
    public void OnPositiveClick(DialogFragment dialogFragment);

    public void OnNegativeClick(DialogFragment dialogFragment);
  }

  EventBackDialogListener mListener;

  @NonNull @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
    builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
      @Override public void onClick(DialogInterface dialogInterface, int i) {
        mListener.OnNegativeClick(EventBackDialogFragment.this);
      }
    })
        .setPositiveButton("SURE", new DialogInterface.OnClickListener() {
          @Override public void onClick(DialogInterface dialogInterface, int i) {
            mListener.OnPositiveClick(EventBackDialogFragment.this);
          }
        });
    return builder.create();
  }

  @Override public void onAttach(Activity activity) {
    super.onAttach(activity);
    mListener = (EventBackDialogListener) activity;
  }
}
