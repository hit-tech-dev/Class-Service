package com.hit.classservice.application.annotation;

import com.hit.classservice.application.annotation.validator.DatePastValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = DatePastValidator.class)
public @interface DatePast {

  String message() default "invalid.date_past";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
