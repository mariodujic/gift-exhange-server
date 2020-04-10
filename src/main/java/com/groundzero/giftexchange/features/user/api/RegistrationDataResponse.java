package com.groundzero.giftexchange.features.user.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groundzero.giftexchange.data.ResponseData;
import com.groundzero.giftexchange.features.jwt.data.JwtToken;
import com.groundzero.giftexchange.features.user.data.User;

public class RegistrationDataResponse implements ResponseData {

  @JsonProperty("access_token")
  private JwtToken accessToken;
  @JsonProperty("refresh_token")
  private JwtToken refreshToken;
  private User user;

  public RegistrationDataResponse(JwtToken accessToken, JwtToken refreshToken, User user) {
    this.accessToken = accessToken;
    this.refreshToken = refreshToken;
    this.user = user;
  }

  public JwtToken getAccessToken() {
    return accessToken;
  }

  public RegistrationDataResponse setAccessToken(JwtToken accessToken) {
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

  public JwtToken getRefreshToken() {
    return refreshToken;
  }

  public RegistrationDataResponse setRefreshToken(JwtToken refreshToken) {
    this.refreshToken = refreshToken;
    return this;
  }
}
