package com.hit.classservice.application.annotation;

import com.hit.classservice.application.annotation.validator.StringFormatDateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = StringFormatDateValidator.class)
public @interface StringFormatDate {

  String message() default "invalid.date_format";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
