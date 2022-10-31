package com.hit.classservice.application.utils;

import org.apache.commons.lang3.ObjectUtils;

public class SqlUtil {
  private SqlUtil() {
  }

  public static String escapeSQLLikeStatement(String value) {
    if (ObjectUtils.isEmpty(value)) {
      return null;
    }
    return value
        .replaceAll("%", "\\\\%")
        .replaceAll("_", "\\\\_");
  }

}
