package com.example.validator.transactionconfig;


import com.example.validator.validator.FieldRequired;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionConfigUpdateRequest {
  @FieldRequired(name = "field.id")
  private Integer id;
  @FieldRequired(name = "field.prefix")
  private String prefix;
  @FieldRequired(name = "field.transactionName")
  private String transactionName;
}
