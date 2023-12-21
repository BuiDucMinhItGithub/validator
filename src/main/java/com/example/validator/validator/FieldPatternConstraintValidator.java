package com.example.validator.validator;


import com.example.validator.util.MessageTranslator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldPatternConstraintValidator implements
    ConstraintValidator<FieldPattern, String> {

  private FieldPattern validation;
  private Pattern pattern;


  @Override
  public void initialize(FieldPattern validation) {
    this.validation = validation;
    this.pattern = Pattern.compile(validation.regexp());
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext cxt) {
    if (value == null || value.isEmpty()) {
      return true;
    }
    Matcher m = pattern.matcher(value);
    if (m.matches()) {
      return true;
    }
    cxt.disableDefaultConstraintViolation();
    cxt.buildConstraintViolationWithTemplate(
        String.format(MessageTranslator.toLocale(validation.message()),
            MessageTranslator.toLocale(validation.name()))).addConstraintViolation();
    return false;
  }
}
