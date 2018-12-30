package com.cins.tasting.bottomsheets;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.cins.tasting.R;

/**
 * Created by jinjianping on 2017/10/8.
 */

public class MyBottomSheetsActivity extends AppCompatActivity {

  BottomSheetBehavior behavior;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.bottomsheet);

    View bottomSheet = findViewById(R.id.bottom_sheet);
    behavior = BottomSheetBehavior.from(bottomSheet);
    behavior.setHideable(false);
    behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
      @Override public void onStateChanged(@NonNull View bottomSheet, int newState) {
        //这里是bottomSheet状态的改变
      }

      @Override public void onSlide(@NonNull View bottomSheet, float slideOffset) {
        //这里是拖拽中的回调，根据slideOffset可以做一些动画
      }
    });
  }

  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.bt_bottomsheet:
        if (behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
          behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
          behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
        break;
      case R.id.bt_bottomsheetdialog:
        BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_bottom_sheet, null);
        mBottomSheetDialog.setContentView(view);
        mBottomSheetDialog.show();
        break;
      case R.id.bt_bottomsheetdialogfragment:
        new FullSheetDialogFragment().show(getSupportFragmentManager(), "dialog");
        break;
    }
  }

  /**
   * 要带 View 参数
   * @param view
   */
  public void openCustomeDialog(View view) {
    CustomDialog.newInstance(this, new CustomDialog.DialogCallback() {
      @Override public void onSuccess(String msg) {

      }
    }).show();
  }
}
