package com.groundzero.giftexchange.utils;

public enum JwtType {

  ACCESS(0),
  REFRESH(1);

  public Integer value;

  JwtType(Integer value) {
    this.value = value;
  }

  public static JwtType findByValue(Integer value) {
    for (JwtType v : values()) {
      if (v.value == value) {
        return v;
      }
    }
    return null;
  }
}
