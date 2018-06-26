package com.cins.tasting.softkeboard;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import com.cins.tasting.R;

public class KeyboardPanel extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.keyboard);
    AndroidBug5497Workaround.assistActivity(this);

    /**
     * 监听键盘弹起、收起
     */
    SoftKeyBoardListener.setListener(this, new SoftKeyBoardListener.OnSoftKeyBoardChangeListener() {
      @Override public void keyBoardShow(int height) {
        Toast.makeText(getApplicationContext(), "open", Toast.LENGTH_SHORT).show();
      }

      @Override public void keyBoardHide(int height) {
        Toast.makeText(getApplicationContext(), "close", Toast.LENGTH_SHORT).show();
      }
    });
  }

  /**
   * 空白收起键盘
   */

  @Override
  public boolean dispatchTouchEvent(MotionEvent ev) {
    if (ev.getAction() == MotionEvent.ACTION_DOWN) {
      View v = getCurrentFocus();
      if (isShouldHideKeyboard(v, ev)) {
        InputMethodManager imm =
            (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(),
            InputMethodManager.HIDE_NOT_ALWAYS
        );
      }
    }
    return super.dispatchTouchEvent(ev);
  }

  // Return whether touch the view.
  private boolean isShouldHideKeyboard(View v, MotionEvent event) {
    if (v != null && (v instanceof EditText)) {
      int[] l = { 0, 0 };
      v.getLocationInWindow(l);
      int left = l[0],
          top = l[1],
          bottom = top + v.getHeight(),
          right = left + v.getWidth();
      return !(event.getX() > left && event.getX() < right
          && event.getY() > top && event.getY() < bottom);
    }
    return false;
  }

  /**
   * 打开键盘.
   *
   * @param context the context
   */
  public static void showSoftInput(Context context) {
    InputMethodManager inputMethodManager = (InputMethodManager) context
        .getSystemService(Context.INPUT_METHOD_SERVICE);
    inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
  }

  /**
   * 关闭键盘事件.
   *
   * @param context the context
   */
  public static void closeSoftInput(Context context) {
    InputMethodManager imm =
        (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
    if (imm != null && ((Activity) context).getCurrentFocus() != null) {
      imm.hideSoftInputFromWindow(((Activity) context).getCurrentFocus()
          .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }
  }

  private void setTouchListener(final Activity context) {
    context.getWindow().getDecorView().setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View v, MotionEvent event) {

        InputMethodManager imm =
            (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (context.getCurrentFocus() != null) {
          imm.hideSoftInputFromWindow(context.getCurrentFocus().getWindowToken(), 0);
        } else {
          imm.hideSoftInputFromWindow((context.findViewById(android.R.id.content)).getWindowToken(),
              0);
        }

        return false;
      }
    });
  }

  public static void collapseSoftInputMethod(Context context, View v) {
    if (v != null) {
      InputMethodManager imm =
          (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
      imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
  }

  @Override public boolean onTouchEvent(MotionEvent event) {
    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
    return imm.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
  }
}
