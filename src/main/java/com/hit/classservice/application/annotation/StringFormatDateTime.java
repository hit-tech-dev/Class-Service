package com.hit.classservice.application.annotation;

import com.hit.classservice.application.annotation.validator.StringFormatDateTimeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = StringFormatDateTimeValidator.class)
public @interface StringFormatDateTime {

  String message() default "invalid.datetime_format";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
