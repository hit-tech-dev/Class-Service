package com.hit.classservice.application.annotation.validator;


import com.hit.classservice.application.annotation.DateFuture;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateFutureValidator implements ConstraintValidator<DateFuture, String> {

  @Override
  public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
    LocalDate date;
    try {
      date = LocalDate.parse(input);
    } catch (Exception e) {
      return false;
    }
    return date.isAfter(LocalDate.now());
  }

}
