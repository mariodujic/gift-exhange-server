package com.groundzero.giftexchange.features.interconnect.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InterconnectRequest {

  @JsonProperty("user_id")
  private int userId;

  public InterconnectRequest() {
  }

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
