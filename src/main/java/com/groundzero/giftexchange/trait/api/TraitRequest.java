package com.groundzero.giftexchange.trait.api;

public class TraitRequest {
  private String description;

  public TraitRequest() {
  }

  public TraitRequest(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public TraitRequest setDescription(String description) {
    this.description = description;
    return this;
  }
}
