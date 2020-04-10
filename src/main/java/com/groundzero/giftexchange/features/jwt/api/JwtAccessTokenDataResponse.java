package com.groundzero.giftexchange.features.jwt.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groundzero.giftexchange.data.ResponseData;
import com.groundzero.giftexchange.features.jwt.data.JwtToken;

public class JwtAccessTokenDataResponse implements ResponseData {

  @JsonProperty("access_token")
  private JwtToken accessToken;

  public JwtAccessTokenDataResponse(JwtToken accessToken) {
    this.accessToken = accessToken;
  }

  public JwtToken getAccessToken() {
    return accessToken;
  }

  public JwtAccessTokenDataResponse setAccessToken(JwtToken accessToken) {
    this.accessToken = accessToken;
    return this;
  }
}
