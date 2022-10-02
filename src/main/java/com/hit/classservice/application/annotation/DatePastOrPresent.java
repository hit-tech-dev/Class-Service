package com.hit.classservice.application.annotation;


import com.hit.classservice.application.annotation.validator.DatePastOrPresentValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = DatePastOrPresentValidator.class)
public @interface DatePastOrPresent {

  String message() default "invalid.date_past_or_present";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
