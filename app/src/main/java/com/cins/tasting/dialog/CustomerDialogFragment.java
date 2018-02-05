package com.cins.tasting.dialog;

import android.annotation.TargetApi;
import android.app.Dialog;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import butterknife.OnClick;
import com.cins.tasting.R;
import com.cins.tasting.R2;

/**
 * 自定义视图
 * Created by jinjianping on 2017/10/8.
 */

public class CustomerDialogFragment extends DialogFragment {
  PopuConfimListener popuConfimListener;
  @TargetApi(Build.VERSION_CODES.M)
  @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
    builder.setView(R.layout.bk_required_food_popup);
    return builder.create();
  }

  @OnClick(R2.id.btn_action)
  public void onAction() {
    popuConfimListener.onConfimPopup();
  }

  public interface PopuConfimListener {
    void onConfimPopup();
  }
}
