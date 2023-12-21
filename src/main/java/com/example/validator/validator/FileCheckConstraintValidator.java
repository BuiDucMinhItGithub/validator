package com.example.validator.validator;

import com.example.validator.util.MessageTranslator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Objects;
import org.springframework.web.multipart.MultipartFile;

public class FileCheckConstraintValidator implements
    ConstraintValidator<FileCheck, MultipartFile> {

  private FileCheck validation;


  @Override
  public void initialize(FileCheck validation) {
    this.validation = validation;
  }

  @Override
  public boolean isValid(MultipartFile file, ConstraintValidatorContext cxt) {
    boolean isValid = true;
    boolean isRequired = validation.required();
    if (Objects.isNull(file) || file.isEmpty()) {
      isValid = !isRequired;
    } else {
      String fileType = Objects.requireNonNull(file.getContentType()).toLowerCase();
      if (!(fileType.equals("image/jpg")
          || fileType.equals("image/jpeg")
          || fileType.equals("image/png"))) {
        isValid = false;
      } else {
        long fileSize = file.getSize();
        if (fileSize > 10485760) { // 10MB
          isValid = false;
        }
      }
    }

    if (!isValid) {
      cxt.disableDefaultConstraintViolation();
      cxt.buildConstraintViolationWithTemplate(MessageTranslator.toLocale(validation.message()))
          .addConstraintViolation();
    }
    return isValid;
  }
}
