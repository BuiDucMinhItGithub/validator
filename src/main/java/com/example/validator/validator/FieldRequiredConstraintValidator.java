package com.example.validator.validator;


import com.example.validator.util.MessageTranslator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Map;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

public class FieldRequiredConstraintValidator implements
    ConstraintValidator<FieldRequired, Object> {

  private FieldRequired validation;

  @Override
  public void initialize(FieldRequired validation) {
    this.validation = validation;
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
    boolean valid = true;
    if (value == null) {
      valid = false;
    } else if (value instanceof String) {
      if (!StringUtils.hasText((String) value)) {
        valid = false;
      }
    } else if (value instanceof List) {
      if (CollectionUtils.isEmpty((List) value)) {
        valid = false;
      }
    } else if (value instanceof String[]) {
      String[] array = (String[]) value;
      if (array.length == 0) {
        valid = false;
      }
    } else if (value instanceof Integer) {
      if ((Integer) value < 0) {
        valid = false;
      }
    } else if (value instanceof Map) {
      if (CollectionUtils.isEmpty((Map) value)) {
        valid = false;
      }
    }

    if (!valid) {
      constraintValidatorContext.disableDefaultConstraintViolation();
      constraintValidatorContext.buildConstraintViolationWithTemplate(
          String.format(MessageTranslator.toLocale(validation.message()),
              MessageTranslator.toLocale(validation.name()))).addConstraintViolation();
      return false;
    }
    return true;
  }
}
