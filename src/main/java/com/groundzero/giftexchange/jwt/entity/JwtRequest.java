package com.groundzero.giftexchange.jwt.entity;

public class JwtRequest {

  private static final long serialVersionUID = 5926468583005150707L;

  private String username;
  private String password;

  public JwtRequest() {
  }

  public JwtRequest(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getUsername() {
    return username;
  }

  public JwtRequest setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public JwtRequest setPassword(String password) {
    this.password = password;
    return this;
  }
}
