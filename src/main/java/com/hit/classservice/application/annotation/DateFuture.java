package com.hit.classservice.application.annotation;


import com.hit.classservice.application.annotation.validator.DateFutureValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = DateFutureValidator.class)
public @interface DateFuture {

  String message() default "invalid.date_future";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
