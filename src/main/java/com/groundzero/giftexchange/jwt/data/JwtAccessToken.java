package com.groundzero.giftexchange.jwt.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class JwtAccessToken {

  private String token;
  @JsonProperty("expiration_date")
  private Date expirationDate;

  public JwtAccessToken(String token, Date expirationDate) {
    this.token = token;
    this.expirationDate = expirationDate;
  }

  public String getToken() {
    return token;
  }

  public JwtAccessToken setToken(String token) {
    this.token = token;
    return this;
  }

  public Date getExpirationDate() {
    return expirationDate;
  }

  public JwtAccessToken setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
    return this;
  }
}
