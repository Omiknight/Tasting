package com.cins.tasting.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.cins.tasting.R;

public class GreetingsDialog extends Dialog {

  private LinearLayout rootContainer;

  public GreetingsDialog(@NonNull Context context) {
    super(context);
    Window window = getWindow();
    window.getDecorView().setBackgroundColor(Color.GREEN);
    //window.getDecorView().setPadding(0,0,0,0);

    window.getAttributes().gravity = Gravity.BOTTOM;
    window.requestFeature(Window.FEATURE_NO_TITLE);
    //window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL, WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
    //window.setFlags(WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH, WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH);

    setContentView(R.layout.dialog_edit_greetings);

    //setCanceledOnTouchOutside(true);
    //全屏
    //window.setBackgroundDrawableResource(android.R.color.transparent);
    window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
    window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

    //Window window = getWindow();
    //window.setGravity(Gravity.BOTTOM);
    //WindowManager.LayoutParams lp = window.getAttributes();
    //lp.width = WindowManager.LayoutParams.MATCH_PARENT;
    //window.setAttributes(lp);
    //setContentView(R.layout.dialog_edit_greetings);
    //window.setBackgroundDrawableResource(android.R.color.transparent);
    //window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

  }

  //@Override protected void onCreate(Bundle savedInstanceState) {
  //  super.onCreate(savedInstanceState);
  //  Window window = getWindow();
  //  if (window != null) {
  //    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
  //      window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
  //      window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
  //    }
  //    window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
  //    //window.setBackgroundDrawable(
  //    //    new ColorDrawable(ContextCompat.getColor(getContext(), R.color.design_dialog_dim)));
  //    window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
  //    // add animations to dialogContainer if need
  //    window.setWindowAnimations(0);
  //  }
  //}
}
