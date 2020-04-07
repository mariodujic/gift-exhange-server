package com.groundzero.giftexchange.jwt.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groundzero.giftexchange.common.ResponseData;

public class JwtAccessResponse implements ResponseData {

  @JsonProperty("access_token")
  private String accessToken;

  public JwtAccessResponse(String accessToken) {
    this.accessToken = accessToken;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public JwtAccessResponse setAccessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }
}
