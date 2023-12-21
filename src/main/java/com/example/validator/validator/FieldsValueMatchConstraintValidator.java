package com.example.validator.validator;

import com.example.validator.util.MessageTranslator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Objects;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.StringUtils;

public class FieldsValueMatchConstraintValidator implements
    ConstraintValidator<FieldsValueMatch, Object> {

  private String field;
  private String fieldMatch;
  private FieldsValueMatch validation;

  @Override
  public void initialize(FieldsValueMatch constraintAnnotation) {
    this.field = constraintAnnotation.field();
    this.fieldMatch = constraintAnnotation.fieldMatch();
    this.validation = constraintAnnotation;
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
    Object fieldValue = new BeanWrapperImpl(value)
        .getPropertyValue(field);
    Object fieldMatchValue = new BeanWrapperImpl(value)
        .getPropertyValue(fieldMatch);

    if (Objects.isNull(fieldValue) || Objects.isNull(fieldMatchValue)) {
      return true;
    }

    boolean valid = false;
    if (fieldValue instanceof String && fieldMatchValue instanceof String) {
      String stringValue = String.valueOf(fieldValue);
      String stringMatchValue = String.valueOf(fieldMatchValue);

      if (!StringUtils.hasText(stringValue) || !StringUtils.hasText(stringMatchValue)) {
        return true;
      }

      valid = stringValue.equals(stringMatchValue);
    }

    if (!valid) {
      constraintValidatorContext.disableDefaultConstraintViolation();
      constraintValidatorContext.buildConstraintViolationWithTemplate(
          MessageTranslator.toLocale(validation.message())).addConstraintViolation();
      return false;
    }
    return true;
  }
}
