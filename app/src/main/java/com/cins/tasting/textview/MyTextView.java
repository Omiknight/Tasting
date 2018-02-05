package com.cins.tasting.textview;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.cins.tasting.R;
import com.cins.tasting.R2;
import java.util.List;

/**
 * Created by jinjianping on 2017/10/7.
 */

public class MyTextView extends AppCompatActivity {

  @BindView(R2.id.tv_another) public TextView textView;
  @BindView(R.id.ss) TextView sTextView;
  @BindView(R.id.ss2) public TextView textView2;

  @BindView(R2.id.text) public TextView text;
  @BindView(R2.id.edit) public EditText edit;
  @BindView(R2.id.container) public LinearLayout con;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.textview);
    ButterKnife.bind(this);

    textView.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_launcher, 0, 0, 0);

    //mode1();
    //mode2(sTextView);
    //mode8();
    mode9();

    con.setOnTouchListener(new View.OnTouchListener() {
      @Override public boolean onTouch(View v, MotionEvent event) {
        return true;
      }
    });
    //edit.setEnabled(false);

    String s = "15708488726";

    text.setText(PhoneFormat(s));
  }

  public static String PhoneFormat(String originPhoneStr) {
    String regex1 = "(.{3})";
    String regex2 = "(.{8})";

    return originPhoneStr
        .replaceFirst(regex1, "$1 ")
        .replaceFirst(regex2, "$1 ");
  }

  public void setTextViewStatus(boolean isChanged) {
    if (isChanged) {
      edit.setVisibility(View.VISIBLE);
    } else {
      edit.setVisibility(View.GONE);
    }
  }

  /**
   * 使用SpannableString设置样式——字体颜色
   */
  private void mode1() {
    SpannableString spannableString = new SpannableString("暗影IV已经开始暴走了");
    ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#009ad6"));
    spannableString.setSpan(colorSpan, 0, 8, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
    sTextView.setText(spannableString);
  }

  /**
   * 使用SpannableStringBuilder设置样式——字体颜色
   */
  private void mode2(TextView tv) {
    SpannableStringBuilder spannableString = new SpannableStringBuilder();
    spannableString.append("暗影IV");
    spannableString.append("已经开始暴走了");
    ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#009ad6"));
    spannableString.setSpan(colorSpan, 0, 8, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
    tv.setText(spannableString);
  }

  /**
   * 使用SpannableStringBuilder设置样式——背景颜色
   */
  private void mode3() {
    SpannableStringBuilder spannableString = new SpannableStringBuilder();
    spannableString.append("暗影IV已经开始暴走了");
    BackgroundColorSpan bgColorSpan = new BackgroundColorSpan(Color.parseColor("#009ad6"));
    spannableString.setSpan(bgColorSpan, 0, 8, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
    //((TextView)findViewById(R.id.mode3)).setText(spannableString);
  }

  /**
   * 使用SpannableStringBuilder设置样式——字体大小
   */
  private void mode4() {
    SpannableStringBuilder spannableString = new SpannableStringBuilder();
    spannableString.append("暗影IV已经开始暴走了");
    AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(20);
    spannableString.setSpan(absoluteSizeSpan, 0, 8, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
    //((TextView)findViewById(R.id.mode4)).setText(spannableString);
  }

  /**
   * 使用SpannableStringBuilder设置样式——粗体\斜体
   */
  private void mode5() {
    SpannableStringBuilder spannableString = new SpannableStringBuilder();
    spannableString.append("暗影IV已经开始暴走了");
    //setSpan可多次使用
    StyleSpan styleSpan = new StyleSpan(Typeface.BOLD);//粗体
    spannableString.setSpan(styleSpan, 0, 3, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
    StyleSpan styleSpan2 = new StyleSpan(Typeface.ITALIC);//斜体
    spannableString.setSpan(styleSpan2, 3, 6, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
    StyleSpan styleSpan3 = new StyleSpan(Typeface.BOLD_ITALIC);//粗斜体
    spannableString.setSpan(styleSpan3, 6, 9, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
    //((TextView)findViewById(R.id.mode5)).setText(spannableString);
  }

  /**
   * 使用SpannableStringBuilder设置样式——删除线
   */
  private void mode6() {
    SpannableStringBuilder spannableString = new SpannableStringBuilder();
    spannableString.append("暗影IV已经开始暴走了");
    StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
    spannableString.setSpan(strikethroughSpan, 0, 8, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
    //((TextView)findViewById(R.id.mode6)).setText(spannableString);
  }

  /**
   * 使用SpannableStringBuilder设置样式——下划线
   */
  private void mode7() {
    SpannableStringBuilder spannableString = new SpannableStringBuilder();
    spannableString.append("暗影IV已经开始暴走了");
    UnderlineSpan underlineSpan = new UnderlineSpan();
    spannableString.setSpan(underlineSpan, 0, 8, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
    //((TextView)findViewById(R.id.mode7)).setText(spannableString);
  }

  /**
   * 使用SpannableStringBuilder设置样式——图片
   */
  private void mode8() {
    String ss = "样式";
    SpannableStringBuilder spannableString = new SpannableStringBuilder(ss);
    //ImageSpan imageSpan = new ImageSpan(this, R.mipmap.ic_launcher);
    //也可以这样

    Drawable drawable = getResources().getDrawable(R.drawable.bk_icon_question_mark_regular);
    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    ImageSpan imageSpan1 = new ImageSpan(drawable, DynamicDrawableSpan.ALIGN_BASELINE);

    CenteredImageSpan imageSpan2 =
        new CenteredImageSpan(this, R.drawable.bk_icon_question_mark_regular);
    //CustomImageSpan imageSpan1 = new CustomImageSpan(this,R.mipmap.ic_launcher,2);
    //将index为6、7的字符用图片替代
    spannableString.setSpan(imageSpan1, 0, 1,
        Spannable.SPAN_INCLUSIVE_INCLUSIVE);
    spannableString.append(" ");

    Drawable drawable1 = getResources().getDrawable(R.drawable.bk_icon_question_mark_regular);
    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    ImageSpan imageSpan3 = new ImageSpan(drawable1, DynamicDrawableSpan.ALIGN_BASELINE);
    spannableString.setSpan(imageSpan3, 1, 2,
        Spannable.SPAN_INCLUSIVE_INCLUSIVE);

    //ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#009ad6"));
    //spannableString.setSpan(colorSpan, 1, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    //ClickableSpan clickableSpan = new ClickableSpan() {
    //  @Override public void onClick(View widget) {
    //    Toast.makeText(MyTextView.this, "请不要点我", Toast.LENGTH_SHORT).show();
    //  }
    //};
    //spannableString.setSpan(clickableSpan, ss.length() - 1, ss.length(),
    //    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    sTextView.setText(spannableString);
    //((TextView) findViewById(R.id.ss)).setMovementMethod(LinkMovementMethod.getInstance());

    //ForegroundColorSpan colorSpan1 = new ForegroundColorSpan(Color.parseColor("#009ad6"));
    //spannableString.setSpan(colorSpan, 5, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    //
    ////textView2.setText((CharSequence) sTextView.getText());
    //textView2.setText(spannableString);
  }

  public void mode9() {

    String ss = "我爱你一辈子哦";
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(ss);

    ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#009ad6"));
    spannableStringBuilder.setSpan(colorSpan, 1, 2, Spanned.SPAN_INCLUSIVE_INCLUSIVE);

    spannableStringBuilder.insert(1, "插");
    textView2.setText(spannableStringBuilder);

    //String ss = "样式";
    //SpannableStringBuilder spannableString = new SpannableStringBuilder(ss);
    ////ImageSpan imageSpan = new ImageSpan(this, R.mipmap.ic_launcher);
    ////也可以这样
    //
    //Drawable drawable = getResources().getDrawable(R.drawable.bk_icon_question_mark_regular);
    //drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    //ImageSpan imageSpan1 = new ImageSpan(drawable, DynamicDrawableSpan.ALIGN_BASELINE);
    //
    //spannableString.setSpan(imageSpan1, 0,1 ,
    //    Spannable.SPAN_INCLUSIVE_INCLUSIVE);
    ////spannableString.append("   ");
    //
    //Drawable drawable1 = getResources().getDrawable(R.drawable.bk_icon_question_mark_regular);
    //drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    //ImageSpan imageSpan3 = new ImageSpan(drawable1, DynamicDrawableSpan.ALIGN_BASELINE);
    //spannableString.setSpan(imageSpan3,1 ,2 ,
    //    Spannable.SPAN_INCLUSIVE_INCLUSIVE);
    //
    //textView2.setText(spannableString);

  }

  public void aVoid(List<Object> list) {

  }
}




