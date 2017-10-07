package com.cins.tasting.dialog;

import android.annotation.TargetApi;
import android.app.Dialog;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import com.cins.tasting.R;

/**
 * 自定义视图
 * Created by jinjianping on 2017/10/8.
 */

public class CustomerDialogFragment extends DialogFragment {
  @TargetApi(Build.VERSION_CODES.M)
  @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
    builder.setView(R.layout.fragment_dialog_customer);
    return builder.create();
  }
}
