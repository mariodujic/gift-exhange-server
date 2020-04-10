package com.groundzero.giftexchange.features.jwt.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groundzero.giftexchange.data.ResponseData;
import com.groundzero.giftexchange.features.jwt.data.JwtToken;

public class JwtRefreshTokenDataResponse implements ResponseData {

  @JsonProperty("refresh_token")
  private JwtToken refreshToken;

  public JwtRefreshTokenDataResponse(JwtToken refreshToken) {
    this.refreshToken = refreshToken;
  }

  public JwtToken getRefreshToken() {
    return refreshToken;
  }

  public JwtRefreshTokenDataResponse setRefreshToken(JwtToken refreshToken) {
    this.refreshToken = refreshToken;
    return this;
  }
}
