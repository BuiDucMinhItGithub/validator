package com.example.validator.controller;

import com.example.validator.service.TransactionConfigService;
import com.example.validator.transactionconfig.TransactionConfigInsertRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/transaction-configuration")
public class TransactionConfigController {

  private final TransactionConfigService transactionConfigService;

  public TransactionConfigController(TransactionConfigService transactionConfigService) {
    this.transactionConfigService = transactionConfigService;
  }


  @PostMapping
  public void insertTransactionConfiguration(@Valid @RequestBody
  TransactionConfigInsertRequest transactionConfigInsertRequest) {
    log.info("Starting insert new transaction configuration");
    log.info(transactionConfigInsertRequest.getTransactionName());
    log.info(transactionConfigInsertRequest.getPrefix());
    transactionConfigService.retrieve(123);
  }
}
