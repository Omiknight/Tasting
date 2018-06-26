package com.cins.tasting.utils;

import android.text.TextUtils;
import android.util.Patterns;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

public class StringUtil {
  public static final String RMB = "¥";
  private static final int MINUTES_OF_HOUR = 60;
  private static final int TEN = 10;
  private static final String CELL_PHONE_REGEX = "^1\\d{10}$";

  private StringUtil() {
  }

  public static String formatDouble(double value) {
    DecimalFormat decimalFormat = new DecimalFormat("0.##");
    decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
    return decimalFormat.format(value);
  }

  public static String formatDoubleShowAll(double value) {
    DecimalFormat decimalFormat = new DecimalFormat("0.00");
    decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
    return decimalFormat.format(value);
  }

  public static String formatMoney(double value) {
    return "¥" + formatDouble(value);
  }

  public static String formatPercent(double value) {
    return String.format("%d%%", (int) value);
  }

  public static String formatOne(double value) {
    DecimalFormat decimalFormat = new DecimalFormat("0.#");
    decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
    return decimalFormat.format(value);
  }

  public static boolean isEmail(String email) {
    return isBlank(email) ? false : Patterns.EMAIL_ADDRESS.matcher(email).matches();
  }

  public static boolean isCellPhone(CharSequence phone) {
    return isBlank(phone) ? false : Pattern.matches("^1\\d{10}$", phone);
  }

  public static CharSequence formatCellPhoneNumber(CharSequence cellPhoneNumber) {
    if (isCellPhone(cellPhoneNumber)) {
      StringBuilder stringBuilder = new StringBuilder(cellPhoneNumber);
      stringBuilder.insert(7, " ");
      stringBuilder.insert(3, " ");
      stringBuilder.insert(0, " ");
      return stringBuilder.toString();
    } else {
      return cellPhoneNumber;
    }
  }

  public static boolean isNotBlank(String str) {
    return !isBlank(str);
  }

  public static boolean isBlank(String str) {
    return str == null || str.length() == 0 || str.trim().length() == 0;
  }

  public static boolean isBlank(CharSequence charSequence) {
    return charSequence == null || isBlank(charSequence.toString());
  }

  public static boolean isNotBlank(CharSequence charSequence) {
    return !isBlank(charSequence);
  }

  public static String trim(String str) {
    if (str != null && str.length() != 0) {
      str = str.trim();
    }

    return str;
  }

  private static String formatTime(long value) {
    return value < 10L ? "0" + value : value + "";
  }

  public static String getTimeString(long hours, long minutes) {
    return formatTime(hours) + ":" + formatTime(minutes);
  }



  public static String charArray2String(char[] chars) {
    StringBuilder sb = new StringBuilder();
    char[] var2 = chars;
    int var3 = chars.length;

    for (int var4 = 0; var4 < var3; ++var4) {
      char c = var2[var4];
      sb.append(c);
    }

    return sb.toString();
  }

  public static String removeSpace(String candidate) {
    return !TextUtils.isEmpty(candidate) ? candidate.replaceAll("\\s+", "_") : candidate;
  }

  public static boolean notEquals(String one, String aother) {
    return !equals(one, aother);
  }

  public static boolean equals(String one, String aother) {
    return isBlank(one) ? isBlank(aother) : one.equals(aother);
  }

  public static String MD5(String str) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(str.getBytes());
      return toHex(messageDigest.digest());
    } catch (Exception var2) {
      var2.printStackTrace();
      return str;
    }
  }

  private static String toHex(byte[] buffer) {
    StringBuffer sb = new StringBuffer(buffer.length * 2);

    for (int i = 0; i < buffer.length; ++i) {
      sb.append(Character.forDigit((buffer[i] & 240) >> 4, 16));
      sb.append(Character.forDigit(buffer[i] & 15, 16));
    }

    return sb.toString();
  }

  public static String ensureNotNull(String s) {
    return s == null ? "" : s;
  }
}

