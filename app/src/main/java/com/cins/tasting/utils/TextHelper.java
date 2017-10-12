package com.cins.tasting.utils;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

import static android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;

/**
 * Created by jinjianping on 2017/10/12.
 */

public class TextHelper {


    public static SpannableString highlight(String text, String highlight,
        int color) {
      SpannableString spannableString = new SpannableString(text);
      if (StringUtil.isNotBlank(highlight) && text.contains(highlight)) {
        spannableString.setSpan(
            new ForegroundColorSpan(color),
            text.indexOf(highlight),
            text.indexOf(highlight) + highlight.length(),
            SPAN_EXCLUSIVE_EXCLUSIVE);
      }
      return spannableString;
    }

}
