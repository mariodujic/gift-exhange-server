package com.groundzero.giftexchange.jwt.entity;

public class JwtCredentialsRequest {

  private static final long serialVersionUID = 5926468583005150707L;

  private String username;
  private String password;

  public JwtCredentialsRequest(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public JwtCredentialsRequest setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public JwtCredentialsRequest setPassword(String password) {
    this.password = password;
    return this;
  }
}
