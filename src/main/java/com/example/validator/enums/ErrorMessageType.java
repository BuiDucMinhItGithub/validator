package com.example.validator.enums;

public enum ErrorMessageType {
  SHOW_IN_MESSAGE("ShowInMessage"),
  SHOW_IN_TITLE("ShowInTitle");

  private final String value;

  ErrorMessageType(String value) {
    this.value = value;
  }

  public final String getValue() {
    return this.value;
  }
}
