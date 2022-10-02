package com.hit.classservice.application.utils;

import com.hit.classservice.application.constant.CommonConstant;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.*;

public class DateTimeUtil {

  /**
   * @param minutes Long
   * @return Long
   */
  public static Long getEpochTime(Long minutes) {
    if (minutes == null) {
      return LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
    }
    return LocalDateTime.now().plusMinutes(minutes).toEpochSecond(ZoneOffset.UTC);
  }

  /**
   * @param epochTime Long
   * @return LocalDate
   */
  public static LocalDate epochTimeToLocalDate(Long epochTime) {
    return LocalDate.ofInstant(Instant.ofEpochSecond(epochTime), ZoneOffset.UTC);
  }

  /**
   * @param localDate LocalDate
   * @return Long
   */
  public static Long localDateToEpochTime(LocalDate localDate) {
    return localDate.toEpochSecond(LocalTime.MIN, ZoneOffset.UTC);
  }

  /**
   * @param date  LocalDate
   * @param month Integer
   * @return Long
   */
  public static Long getStartMonth(LocalDate date, Integer month) {
    return (date.minusMonths(month).withDayOfMonth(CommonConstant.ONE_INT_VALUE))
        .atStartOfDay(ZoneOffset.UTC).toEpochSecond();
  }

  /**
   * @param date LocalDate
   * @return Long
   */
  public static Long getEndMonth(LocalDate date) {
    return getStartMonth(date, -CommonConstant.ONE_INT_VALUE) - CommonConstant.ONE_INT_VALUE;
  }

  /**
   * @return Long
   */
  public static Long getEpochTimeNow() {
    return LocalDateTime.now(ZoneOffset.UTC).toEpochSecond(ZoneOffset.UTC);
  }

  /**
   * @param epochTime Double
   * @return double
   */
  public static double convertEpochToDay(Double epochTime) {
    BigDecimal bigDecimal = new BigDecimal(epochTime / CommonConstant.ONE_DAY_EPOCH_TIME_SECONDS.doubleValue());
    bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
    return bigDecimal.doubleValue();
  }

}
