package com.groundzero.giftexchange.jwt.entity;

public class JwtResponse {

  private String token;

  public JwtResponse(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  public JwtResponse setToken(String token) {
    this.token = token;
    return this;
  }
}
