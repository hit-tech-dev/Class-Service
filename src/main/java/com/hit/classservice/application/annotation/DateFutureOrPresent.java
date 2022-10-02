package com.hit.classservice.application.annotation;

import com.hit.classservice.application.annotation.validator.DateFutureOrPresentValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = DateFutureOrPresentValidator.class)
public @interface DateFutureOrPresent {

  String message() default "invalid.date_future_or_present";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
