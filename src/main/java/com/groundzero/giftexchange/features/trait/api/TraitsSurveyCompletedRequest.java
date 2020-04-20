package com.groundzero.giftexchange.features.trait.api;

public class TraitsSurveyCompletedRequest {

  private String description;

  public TraitsSurveyCompletedRequest() {
  }

  public TraitsSurveyCompletedRequest(String dummyData) {
    this.description = dummyData;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
