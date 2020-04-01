package com.groundzero.giftexchange.jwt.entity;

public class JwtResponse {

  private boolean isSuccessful;
  private String token;

  public JwtResponse(boolean isSuccessful, String token) {
    this.isSuccessful = isSuccessful;
    this.token = token;
  }

  public boolean isSuccessful() {
    return isSuccessful;
  }

  public JwtResponse setSuccessful(boolean successful) {
    isSuccessful = successful;
    return this;
  }

  public String getToken() {
    return token;
  }

  public JwtResponse setToken(String token) {
    this.token = token;
    return this;
  }
}
