package com.groundzero.giftexchange.jwt.entity;

public class JwtRefresherTokenRequest {

  private static final long serialVersionUID = 5926468583005150707L;

  private String refresherToken;

  public JwtRefresherTokenRequest() {
  }

  public JwtRefresherTokenRequest(String refresherToken) {
    this.refresherToken = refresherToken;
  }

  public String getRefresherToken() {
    return refresherToken;
  }

  public void setRefresherToken(String refresherToken) {
    this.refresherToken = refresherToken;
  }
}
