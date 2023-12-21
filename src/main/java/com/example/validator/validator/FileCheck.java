package com.example.validator.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = FileCheckConstraintValidator.class)
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FileCheck {

  int index() default 0;

  boolean required() default true;

  String name() default "";

  String message() default "validation.multipart.invalid";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
