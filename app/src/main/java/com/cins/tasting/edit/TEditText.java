package com.cins.tasting.edit;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import com.cins.tasting.R;
import java.lang.reflect.Field;

public class TEditText extends Activity {

  @BindView(R.id.edit) protected EditText editText;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.edit_activity);

    editText.setEnabled(false);
    //editText.getParent().requestDisallowInterceptTouchEvent(false);
    //editText.setText(s);
    //editText.setTextColor(Color.BLACK);
    //editText.getBackground().setAlpha(0);

    //editText.setCursorVisible(false);
    //过略掉数字之外的字符
    //editText.setInputType(TYPE_CLASS_PHONE);
    //限制数字输入
    editText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    //editText.setFilters(new InputFilter[] {});

    //失去焦点
    //editText.clearFocus();
    //获取焦点
    //editText.requestFocus();

    //editText.setInputType(EditorInfo.TYPE_CLASS_TEXT);
    //editText.setMaxLines(1);

    //不可编辑可点击
    //editText.setFocusable(false);
    //editText.setKeyListener(null);
    //editText.setKeyListener(new DialerKeyListener());
    //editText.setEnabled(false);


    //editText.setCursorVisible(false);
    //editText.setFocusableInTouchMode(false);

    //editText.setClickable(false);
    //editText.setPressed(false);
    //editText.setLongClickable(false);

    //去除分隔手机号中间的空格
    final String phone = editText.getText().toString().trim().replace(" ", "");

    editText.setImeOptions(EditorInfo.IME_ACTION_DONE);
    editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
      @Override public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
          // TODO: 2018/5/22 校验  失焦 收起键盘
          return true;
        }

        return false;
      }
    });

    editText.addTextChangedListener(new TextWatcher() {
      @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override public void onTextChanged(CharSequence s, int start, int before, int count) {

      }

      @Override public void afterTextChanged(Editable s) {

        if (s.length() > 5) {
          s.delete(6, s.length());
          Toast.makeText(getApplicationContext(), "ddddd", Toast.LENGTH_SHORT).show();
        }
      }
    });

    //焦点监听
    editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
      @Override public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {

        } else {

        }
      }
    });
  }

  /**
   * 格式化手机号
   */
  private void formatMobile() {
    editText.addTextChangedListener(new TextWatcher() {
      @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s == null || s.length() == 0) return;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
          if (i != 3 && i != 8 && s.charAt(i) == ' ') {
            continue;
          } else {
            stringBuilder.append(s.charAt(i));
            if ((stringBuilder.length() == 4 || stringBuilder.length() == 9)
                && stringBuilder.charAt(stringBuilder.length() - 1) != ' ') {
              stringBuilder.insert(stringBuilder.length() - 1, ' ');
            }
          }
        }
        if (!stringBuilder.toString().equals(s.toString())) {
          int index = start + 1;
          if (stringBuilder.charAt(start) == ' ') {
            if (before == 0) {
              index++;
            } else {
              index--;
            }
          } else {
            if (before == 1) {
              index--;
            }
          }
          editText.setText(stringBuilder.toString());
          editText.setSelection(index);
        }
      }

      @Override public void afterTextChanged(Editable s) {

      }
    });
  }

  /**
   * 自定义光标
   */
  private void customCursor() {
    //设置光标颜色, R.drawable.cursor里自己定义颜色
    try {
      Field f = TextView.class.getDeclaredField("mCursorDrawableRes");
      f.setAccessible(true);
      f.set(editText, R.drawable.cursor);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
