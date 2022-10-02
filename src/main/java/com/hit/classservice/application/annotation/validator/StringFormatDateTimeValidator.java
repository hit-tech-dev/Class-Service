package com.hit.classservice.application.annotation.validator;

import com.hit.classservice.application.annotation.StringFormatDateTime;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringFormatDateTimeValidator implements ConstraintValidator<StringFormatDateTime, String> {

  private static final String REGEX_FORMAT_DATETIME = "^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1]) " +
      "(2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9]$";

  @Override
  public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
    if (StringUtils.isNotEmpty(input)) {
      return input.matches(REGEX_FORMAT_DATETIME);
    }

    return false;
  }

}
