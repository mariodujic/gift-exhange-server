package com.groundzero.giftexchange.features.trait.data;

import com.groundzero.giftexchange.features.trait.api.TraitsSurveyCompletedRequest;
import com.groundzero.giftexchange.features.trait.entity.TraitEntity;

public class TraitDto {

  public static TraitEntity fromRequest(TraitEntity entity, TraitsSurveyCompletedRequest request) {
    entity.setDescription(request.getDescription());
    return entity;
  }
}
