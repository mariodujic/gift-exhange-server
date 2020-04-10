package com.groundzero.giftexchange.features.jwt.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JwtAccessTokenRequest {

  @JsonProperty("refresh_token")
  private String refreshToken;

  public JwtAccessTokenRequest() {
  }

  public JwtAccessTokenRequest(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }
}
