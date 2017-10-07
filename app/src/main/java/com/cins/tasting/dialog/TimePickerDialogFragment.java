package com.cins.tasting.dialog;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by jinjianping on 2017/10/8.
 */

public class TimePickerDialogFragment extends DialogFragment {
  @TargetApi(Build.VERSION_CODES.M)
  @NonNull
  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    TimePickerDialog timePickerDialog =
        new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
          @Override
          public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Toast.makeText(getContext(), "you choice" + hourOfDay + ":" + minute, Toast.LENGTH_LONG)
                .show();
          }
        }, 12, 12, true);
    timePickerDialog.show();
    return timePickerDialog;
  }
}
