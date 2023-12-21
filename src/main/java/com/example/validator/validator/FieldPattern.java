package com.example.validator.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = FieldPatternConstraintValidator.class)
@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface FieldPattern {

  int index() default 0;

  String name() default "";

  String regexp();

  String message() default "validation.formula.invalid";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
