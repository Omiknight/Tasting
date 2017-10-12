package com.cins.tasting.bottomsheets;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;
import android.view.WindowManager;
import com.cins.tasting.R;

/**
 * Created by jinjianping on 2017/10/11.
 */

public class CustomDialog extends BottomSheetDialog {

  private View cancle;
  private View confim;

  protected CustomDialog(@NonNull Context context,
      DialogCallback dialogCallback) {
    super(context);
    setContentView(R.layout.dialog_alipay_not_pwd_promotion);
    cancle = findViewById(R.id.action_cancel);
    confim = findViewById(R.id.action_open_alipay_sign);

    cancle.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        CustomDialog.this.dismiss();
      }
    });

    confim.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        //do something
      }
    });

    View bottomSheet = findViewById(R.id.design_bottom_sheet);
    BottomSheetBehavior.from(bottomSheet);

    // isAtLeastKitkat
    if (Build.VERSION.SDK_INT >= 19) {
      getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

  }

  public static CustomDialog newInstance(Context context,DialogCallback dialogCallback) {
    return new CustomDialog(context, dialogCallback);
  }
  public interface DialogCallback{
    void onSuccess(String msg);
  }
}
