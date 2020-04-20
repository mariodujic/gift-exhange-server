package com.groundzero.giftexchange.features.trait.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groundzero.giftexchange.data.ResponseData;

public class TraitsSurveyCompletedResponseData implements ResponseData {

  private boolean isSurveyCompleted;

  public TraitsSurveyCompletedResponseData(boolean isSurveyCompleted) {
    this.isSurveyCompleted = isSurveyCompleted;
  }

  @JsonProperty("is_survey_completed")
  public boolean isSurveyCompleted() {
    return isSurveyCompleted;
  }
}
