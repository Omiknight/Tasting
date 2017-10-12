package com.cins.tasting.utils;

/**
 * Created by jinjianping on 2017/10/12.
 */

public class StringUtil {
  public static boolean isNotBlank(String str) {
    return !isBlank(str);
  }
  public static boolean isBlank(String str) {
    return str == null || str.length() == 0 || str.trim().length() == 0;
  }
}
