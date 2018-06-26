package com.cins.tasting.softkeboard;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.IBinder;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.cins.tasting.utils.DimenUtil;

public class SoftInputManager implements OnGlobalLayoutListener {

  private static final int SHOW_DALAY = 200;
  private static final int MIN_DELTA = 100;
  private InputMethodManager imm;
  private SoftInputListener softInputListener;
  private Window window;

  private int navigationBarHeight;

  public interface SoftInputListener {
    void onShow();

    void onHide();
  }

  private SoftInputManager(Context context) {
    imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
    navigationBarHeight = DimenUtil.getNavigationBarHeight(context);
  }

  public static SoftInputManager getInstance(Context context) {
    return new SoftInputManager(context);
  }

  public void setSoftInputListener(final Window window, final SoftInputListener softInputListener) {
    if (window != null && softInputListener != null) {
      this.window = window;
      this.softInputListener = softInputListener;
      window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
  }

  @Override public void onGlobalLayout() {
    if (window != null && softInputListener != null) {
      Rect rectgle = new Rect();
      View decorView = window.getDecorView();
      decorView.getWindowVisibleDisplayFrame(rectgle);
      int heightDiff;
      if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
        heightDiff = decorView.getRootView().getHeight() - (rectgle.bottom);
      } else {
        heightDiff = decorView.getRootView().getHeight() - (rectgle.bottom) - navigationBarHeight;
      }
      if (heightDiff > MIN_DELTA) {
        softInputListener.onShow();
      } else {
        softInputListener.onHide();
      }
    }
  }

  @SuppressWarnings("deprecation") public void removeSoftInputListener() {
    if (window != null) {
      View decorView = window.getDecorView();
      if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
        decorView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      } else {
        decorView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
    }
  }

  public void showSoftInput(final View focusedView) {
    if (focusedView == null) return;
    focusedView.postDelayed(new Runnable() {
      @Override public void run() {
        focusedView.requestFocus();
        imm.showSoftInput(focusedView, InputMethodManager.SHOW_IMPLICIT);
      }
    }, SHOW_DALAY);
  }

  public void hideSoftInput(View focusedView) {
    if (focusedView == null) return;
    focusedView.clearFocus();
    hideSoftInput(focusedView.getWindowToken());
  }

  public void hideSoftInput(IBinder viewWindowToken) {
    imm.hideSoftInputFromWindow(viewWindowToken, InputMethodManager.HIDE_NOT_ALWAYS);
  }

  public static void showSoftInput(Context context, View focusedView) {
    if (context == null) return;
    getInstance(context).showSoftInput(focusedView);
  }

  public static void hideSoftInput(Context context, View focusedView) {
    if (context == null) return;
    getInstance(context).hideSoftInput(focusedView);
  }

  public static void hideSoftInput(Context context, IBinder viewWindowToken) {
    if (context == null) return;
    getInstance(context).hideSoftInput(viewWindowToken);
  }

  public static void hideSoftInput(Activity activity) {
    if (activity == null) return;
    getInstance(activity).hideSoftInput(activity.getWindow().getDecorView().getWindowToken());
  }

  public static void hideSoftInput(Context context) {
    if (context instanceof Activity) {
      hideSoftInput((Activity) context);
    }
  }

  public static void hideSoftInput(Window window) {
    if (window == null) return;
    getInstance(window.getContext()).hideSoftInput(window.getDecorView().getWindowToken());
  }
}
