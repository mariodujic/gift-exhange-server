package com.groundzero.giftexchange.features.interconnect.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Interconnect {

  private boolean isLookingToConnect;

  public Interconnect(boolean isLookingToConnect) {
    this.isLookingToConnect = isLookingToConnect;
  }

  @JsonProperty("is_looking_to_connect")
  public boolean isLookingToConnect() {
    return isLookingToConnect;
  }

  public Interconnect setLookingToConnect(boolean lookingToConnect) {
    isLookingToConnect = lookingToConnect;
    return this;
  }
}
