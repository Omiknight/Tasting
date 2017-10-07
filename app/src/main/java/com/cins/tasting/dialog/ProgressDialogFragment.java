package com.cins.tasting.dialog;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * progressDialog 进度条
 * Created by jinjianping on 2017/10/8.
 */

public class ProgressDialogFragment extends DialogFragment {
  @TargetApi(Build.VERSION_CODES.M)
  @NonNull
  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    ProgressDialog progressDialog = new ProgressDialog(getContext());
    return progressDialog;
  }
}
