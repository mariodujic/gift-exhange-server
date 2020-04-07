package com.groundzero.giftexchange.jwt.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groundzero.giftexchange.common.ResponseData;
import com.groundzero.giftexchange.jwt.data.JwtAccessToken;

public class JwtAccessTokenDataResponse implements ResponseData {

  @JsonProperty("access_token")
  private JwtAccessToken accessToken;

  public JwtAccessTokenDataResponse(JwtAccessToken accessToken) {
    this.accessToken = accessToken;
  }

  public JwtAccessToken getAccessToken() {
    return accessToken;
  }

  public JwtAccessTokenDataResponse setAccessToken(JwtAccessToken accessToken) {
    this.accessToken = accessToken;
    return this;
  }
}
