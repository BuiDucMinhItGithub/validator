package com.example.validator.transactionconfig;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionConfigResponse extends EntityBase {

  private Integer id;
  private String prefix;
  private String transaction_name;
  private boolean isDeleted;
}
