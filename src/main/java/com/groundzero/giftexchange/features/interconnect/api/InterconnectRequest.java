package com.groundzero.giftexchange.features.interconnect.api;

public class InterconnectRequest {

  private int userId;

  public InterconnectRequest(int userId) {
    this.userId = userId;
  }

  public int getUserId() {
    return userId;
  }

  public InterconnectRequest setUserId(int userId) {
    this.userId = userId;
    return this;
  }
}
