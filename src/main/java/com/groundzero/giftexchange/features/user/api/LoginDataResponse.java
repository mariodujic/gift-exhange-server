package com.groundzero.giftexchange.features.user.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groundzero.giftexchange.data.ResponseData;
import com.groundzero.giftexchange.features.jwt.data.JwtToken;

public class LoginDataResponse implements ResponseData {

  @JsonProperty("access_token")
  private JwtToken accessToken;
  @JsonProperty("refresh_token")
  private JwtToken refreshToken;

  public LoginDataResponse(JwtToken accessToken, JwtToken refreshToken) {
    this.accessToken = accessToken;
    this.refreshToken = refreshToken;
  }

  public JwtToken getAccessToken() {
    return accessToken;
  }

  public LoginDataResponse setAccessToken(JwtToken accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  public JwtToken getRefreshToken() {
    return refreshToken;
  }

  public LoginDataResponse setRefreshToken(JwtToken refreshToken) {
    this.refreshToken = refreshToken;
    return this;
  }
}
