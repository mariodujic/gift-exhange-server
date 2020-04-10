package com.groundzero.giftexchange.features.jwt.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JwtRefresherTokenRequest {

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
