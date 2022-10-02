package com.hit.classservice.application.annotation.validator;


import com.hit.classservice.application.annotation.DatePast;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DatePastValidator implements ConstraintValidator<DatePast, String> {

  @Override
  public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
    LocalDate date;
    try {
      date = LocalDate.parse(input);
    } catch (Exception e) {
      return false;
    }
    return date.isBefore(LocalDate.now());
  }

}
