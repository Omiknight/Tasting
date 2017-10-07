package com.cins.tasting.dialog;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

/**
 * 日期选择
 * Created by jinjianping on 2017/10/8.
 */

public class DatePickerDialogFragment extends DialogFragment{
  @TargetApi(Build.VERSION_CODES.M)
  @NonNull
  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    DatePickerDialog datePickerDialog =
        new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
          @Override
          public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

          }
        }, 2016, 10, 12);
    return datePickerDialog;
  }
}
