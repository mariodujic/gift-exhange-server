package com.groundzero.giftexchange.features.user.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groundzero.giftexchange.data.ResponseData;
import com.groundzero.giftexchange.jwt.data.JwtAccessToken;
import com.groundzero.giftexchange.features.user.data.User;

public class RegistrationDataResponse implements ResponseData {

  @JsonProperty("access_token")
  private JwtAccessToken accessToken;
  private User user;

  public RegistrationDataResponse(JwtAccessToken accessToken, User user) {
    this.accessToken = accessToken;
    this.user = user;
  }

  public JwtAccessToken getAccessToken() {
    return accessToken;
  }

  public RegistrationDataResponse setAccessToken(JwtAccessToken accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  public User getUser() {
    return user;
  }

  public RegistrationDataResponse setUser(User user) {
    this.user = user;
    return this;
  }
}
