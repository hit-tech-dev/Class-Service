package com.hit.classservice.application.annotation.validator;

import com.hit.classservice.application.annotation.StringFormatDate;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringFormatDateValidator implements ConstraintValidator<StringFormatDate, String> {

  private static final String REGEX_FORMAT_DATE = "^([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))$";

  @Override
  public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
    if (StringUtils.isNotEmpty(input)) {
      return input.matches(REGEX_FORMAT_DATE);
    }

    return false;
  }

}
