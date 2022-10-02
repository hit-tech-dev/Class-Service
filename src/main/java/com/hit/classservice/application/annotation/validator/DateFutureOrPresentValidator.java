package com.hit.classservice.application.annotation.validator;


import com.hit.classservice.application.annotation.DateFutureOrPresent;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateFutureOrPresentValidator implements ConstraintValidator<DateFutureOrPresent, String> {

  @Override
  public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
    LocalDate now = LocalDate.now();
    LocalDate date;
    try {
      date = LocalDate.parse(input);
    } catch (Exception e) {
      return false;
    }
    return (date.isAfter(now) || date.isEqual(now));
  }

}
