package com.groundzero.giftexchange.jwt.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JwtRefresherTokenRequest {

  private static final long serialVersionUID = 5926468583005150707L;

  @JsonProperty("refresher_token")
  private String refresherToken;

  public JwtRefresherTokenRequest() {
  }

  public JwtRefresherTokenRequest(String refresherToken) {
    this.refresherToken = refresherToken;
  }

  public String getRefresherToken() {
    return refresherToken;
  }

  public void setRefresherToken(String refresherToken) {
    this.refresherToken = refresherToken;
  }
}
