package com.groundzero.giftexchange.user.model;

public class UserResponse {
  private int status;
  private String message;
  private Data data;

  public UserResponse(int status, String message, Data data) {
    this.status = status;
    this.message = message;
    this.data = data;
  }

  public int getStatus() {
    return status;
  }

  public UserResponse setStatus(int status) {
    this.status = status;
    return this;
  }

  public String getMessage() {
    return message;
  }

  public UserResponse setMessage(String message) {
    this.message = message;
    return this;
  }

  public Data getData() {
    return data;
  }

  public UserResponse setData(Data data) {
    this.data = data;
    return this;
  }

  public static class Data {
    private String token;
    private User user;

    public Data(String token, User user) {
      this.token = token;
      this.user = user;
    }

    public String getToken() {
      return token;
    }

    public Data setToken(String token) {
      this.token = token;
      return this;
    }

    public User getUser() {
      return user;
    }

    public Data setUser(User user) {
      this.user = user;
      return this;
    }
  }
}
