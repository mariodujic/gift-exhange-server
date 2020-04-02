package com.groundzero.giftexchange.user.model;

import com.groundzero.giftexchange.common.ResponseData;

public class RegisterUserData implements ResponseData {
  private String token;
  private User user;

  public RegisterUserData(String token, User user) {
    this.token = token;
    this.user = user;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
