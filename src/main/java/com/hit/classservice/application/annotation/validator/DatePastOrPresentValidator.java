package com.hit.classservice.application.annotation.validator;


import com.hit.classservice.application.annotation.DatePastOrPresent;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DatePastOrPresentValidator implements ConstraintValidator<DatePastOrPresent, String> {

  @Override
  public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
    LocalDate now = LocalDate.now();
    LocalDate date;
    try {
      date = LocalDate.parse(input);
    } catch (Exception e) {
      return false;
    }
    return (date.isBefore(now) || date.isEqual(now));
  }

}
