package com.groundzero.giftexchange.features.trait.data;

import com.groundzero.giftexchange.features.trait.api.TraitRequest;
import com.groundzero.giftexchange.features.trait.entity.TraitEntity;

public class TraitDto {

  public static TraitEntity fromRequest(TraitEntity entity, TraitRequest request) {
    entity.setDescription(request.getDescription());
    return entity;
  }
}
