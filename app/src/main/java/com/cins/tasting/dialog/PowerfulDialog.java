package com.cins.tasting.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntDef;
import android.support.v4.content.ContextCompat;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cins.tasting.R;

public class PowerfulDialog extends Dialog {
  public static final int ORIENTATION_HORIZONTAL = 0;
  public static final int ORIENTATION_VERTICAL = 1;

  private static final int NONE_COLOR = Color.TRANSPARENT;
  private static final int NONE_RES = -1;

  @IntDef({ ORIENTATION_HORIZONTAL, ORIENTATION_VERTICAL })
  public @interface Orientation {
  }

  private TextView titleView;
  private TextView contentView;
  private TextView tipsView;
  private TextView negativeBtn;
  private TextView positiveBtn;
  private ImageView closeBtn;
  private RelativeLayout rootContainer;
  private LinearLayout dialogContainer;
  private FrameLayout customContainer;
  private LinearLayout btnContainer;

  private PowerfulDialog(Builder builder) {
    super(builder.context);
    init(builder);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Window window = getWindow();
    if (window != null) {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
      }
      window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
      window.setBackgroundDrawable(
          new ColorDrawable(ContextCompat.getColor(getContext(), R.color.design_dialog_dim)));

      window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

      window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
      // add animations to dialogContainer if need
      window.setWindowAnimations(0);
    }
  }

  private void init(final Builder builder) {
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.design_dialog_eleme);
    titleView = findViewById(R.id.title);
    contentView = findViewById(R.id.content);
    tipsView = findViewById(R.id.tips);
    negativeBtn = findViewById(R.id.negative_btn);
    positiveBtn = findViewById(R.id.positive_btn);
    closeBtn = findViewById(R.id.close_btn);
    rootContainer = findViewById(R.id.root_container);
    dialogContainer = findViewById(R.id.dialog_container);
    customContainer = findViewById(R.id.custom_container);
    btnContainer = findViewById(R.id.btn_container);

    titleView.setText(builder.title);
    if (builder.titleColor != NONE_COLOR) {
      titleView.setTextColor(builder.titleColor);
    }

    contentView.setText(builder.content);
    contentView.setMovementMethod(LinkMovementMethod.getInstance());
    if (builder.contentColor != NONE_COLOR) {
      contentView.setTextColor(builder.contentColor);
    }

    if (builder.tips != null) {
      tipsView.setVisibility(View.VISIBLE);
      tipsView.setText(builder.tips);
      tipsView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    if (builder.negativeText != null) {
      negativeBtn.setText(builder.negativeText);
      if (builder.negativeColor != NONE_COLOR) {
        negativeBtn.setTextColor(builder.negativeColor);
      }
      if (builder.negativeBg != NONE_RES) {
        negativeBtn.setBackgroundResource(builder.negativeBg);
      }
      negativeBtn.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
          if (builder.negativeClickListener != null) {
            builder.negativeClickListener.onClick(PowerfulDialog.this);
          } else {
            dismiss();
          }
        }
      });
    } else {
      negativeBtn.setVisibility(View.GONE);
    }

    if (builder.positiveText != null) {
      positiveBtn.setText(builder.positiveText);
      if (builder.positiveColor != NONE_COLOR) {
        positiveBtn.setTextColor(builder.positiveColor);
      }
      if (builder.positiveBg != NONE_RES) {
        positiveBtn.setBackgroundResource(builder.positiveBg);
      }
      positiveBtn.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
          if (builder.positiveClickListener != null) {
            builder.positiveClickListener.onClick(PowerfulDialog.this);
          } else {
            dismiss();
          }
        }
      });
    } else {
      positiveBtn.setVisibility(View.GONE);
    }

    if (builder.buttonOrientation == ORIENTATION_VERTICAL) {
      btnContainer.setOrientation(LinearLayout.VERTICAL);

      LinearLayout.LayoutParams layoutParams;
      layoutParams = (LinearLayout.LayoutParams) negativeBtn.getLayoutParams();
      layoutParams.weight = 0;
      layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT;
      negativeBtn.setLayoutParams(layoutParams);

      layoutParams = (LinearLayout.LayoutParams) positiveBtn.getLayoutParams();
      layoutParams.weight = 0;
      layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT;
      positiveBtn.setLayoutParams(layoutParams);

      btnContainer.bringChildToFront(negativeBtn);
    }

    if (builder.customView != null) {
      customContainer.addView(builder.customView);
    } else {
      customContainer.setVisibility(View.GONE);
    }

    if (builder.customViewOnly) {
      View contentContainer = findViewById(R.id.content_container);
      contentContainer.setVisibility(View.GONE);
      contentView.setVisibility(View.GONE);
    }

    if (builder.closeBtnEnable) {
      closeBtn.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
          if (builder.closeClickListener != null) {
            builder.closeClickListener.onClick(PowerfulDialog.this);
            return;
          }
          dismiss();
        }
      });
    } else {
      closeBtn.setVisibility(View.GONE);
    }

    if (builder.canceledOnTouchOutside) {
      rootContainer.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
          dismiss();
        }
      });
      dialogContainer.setClickable(true);
    }
    setCanceledOnTouchOutside(builder.canceledOnTouchOutside);
    setCancelable(builder.cancelable);
  }

  public static Builder builder(Context context) {
    return new Builder(context);
  }

  public static class Builder {

    private Context context;

    private CharSequence title;
    private int titleColor = NONE_COLOR;

    private CharSequence content;
    private int contentColor = NONE_COLOR;

    private CharSequence tips;

    private CharSequence negativeText;
    private int negativeColor = NONE_COLOR;
    private int negativeBg = NONE_RES;
    private OnClickListener negativeClickListener;

    private CharSequence positiveText;
    private int positiveColor = NONE_COLOR;
    private int positiveBg = NONE_RES;
    private OnClickListener positiveClickListener;

    private int buttonOrientation = ORIENTATION_HORIZONTAL;

    private View customView;
    private boolean customViewOnly = false;

    private boolean closeBtnEnable = true;
    private boolean cancelable = true;
    private boolean canceledOnTouchOutside = true;
    private OnClickListener closeClickListener;

    private Builder(Context context) {
      this.context = context;
    }

    public Builder title(CharSequence title) {
      this.title = title;
      return this;
    }

    public Builder titleColor(@ColorInt int color) {
      this.titleColor = color;
      return this;
    }

    public Builder content(CharSequence content) {
      this.content = content;
      return this;
    }

    public Builder contentColor(@ColorInt int color) {
      this.contentColor = color;
      return this;
    }

    public Builder tips(CharSequence tips) {
      this.tips = tips;
      return this;
    }

    public Builder negativeText(CharSequence text) {
      this.negativeText = text;
      return this;
    }

    public Builder negativeColor(@ColorInt int color) {
      this.negativeColor = color;
      return this;
    }

    public Builder negativeBg(@DrawableRes int res) {
      this.negativeBg = res;
      return this;
    }

    public Builder onNegative(OnClickListener listener) {
      this.negativeClickListener = listener;
      return this;
    }

    public Builder positiveText(CharSequence text) {
      this.positiveText = text;
      return this;
    }

    public Builder positiveColor(@ColorInt int color) {
      this.positiveColor = color;
      return this;
    }

    public Builder positiveBg(@DrawableRes int res) {
      this.positiveBg = res;
      return this;
    }

    public Builder onPositive(OnClickListener listener) {
      this.positiveClickListener = listener;
      return this;
    }

    public Builder buttonOrientation(@Orientation int orientation) {
      this.buttonOrientation = orientation;
      return this;
    }

    public Builder customView(View view) {
      this.customView = view;
      return this;
    }

    public Builder customViewOnly() {
      this.customViewOnly = true;
      return this;
    }

    public Builder closeBtnEnable(boolean enable) {
      this.closeBtnEnable = enable;
      return this;
    }

    public Builder onCloseClick(OnClickListener listener) {
      this.closeClickListener = listener;
      return this;
    }

    public Builder cancelable(boolean cancel) {
      this.cancelable = cancel;
      return this;
    }

    public Builder canceledOnTouchOutside(boolean cancel) {
      this.canceledOnTouchOutside = cancel;
      return this;
    }

    public PowerfulDialog build() {
      return new PowerfulDialog(this);
    }

    public void show() {
      build().show();
    }
  }

  public interface OnClickListener {
    void onClick(PowerfulDialog v);
  }
}
