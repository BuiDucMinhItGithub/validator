package com.example.validator.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TransactionConfigService {

  public void retrieve(Integer transactionConfigurationId) {
    log.info("Start retrieve transaction configuration with id {}", transactionConfigurationId);
  }
}
