package com.cins.tasting.bottomsheets;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.View;
import com.cins.tasting.R;

/**
 * Created by jinjianping on 2017/10/8.
 */

public class FullSheetDialogFragment extends BottomSheetDialogFragment {

  private BottomSheetBehavior behavior;

  @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
    BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
    View view = View.inflate(getContext(), R.layout.dialog_bottom_sheet, null);
    dialog.setContentView(view);
    behavior = BottomSheetBehavior.from((View) view.getParent());
    return dialog;
  }

  @Override public void onStart() {
    super.onStart();
    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);//全屏展开
  }

  public void onClick(View v) {
    behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
  }
}
