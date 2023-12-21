package com.example.validator.base;

import com.example.validator.enums.ErrorMessageType;
import java.util.HashMap;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {

  protected ErrorMessageType type;
  protected String title;
  protected Integer status;
  protected HashMap<String, List<Object>> messages;
}
