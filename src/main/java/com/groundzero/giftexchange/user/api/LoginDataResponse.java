package com.groundzero.giftexchange.user.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groundzero.giftexchange.common.ResponseData;
import com.groundzero.giftexchange.jwt.data.JwtAccessToken;

public class LoginDataResponse implements ResponseData {

  @JsonProperty("access_token")
  private JwtAccessToken accessToken;

  public LoginDataResponse(JwtAccessToken accessToken) {
    this.accessToken = accessToken;
  }

  public JwtAccessToken getAccessToken() {
    return accessToken;
  }

  public LoginDataResponse setAccessToken(JwtAccessToken accessToken) {
    this.accessToken = accessToken;
    return this;
  }
}
