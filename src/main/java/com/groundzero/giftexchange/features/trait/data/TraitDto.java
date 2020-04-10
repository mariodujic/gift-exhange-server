package com.groundzero.giftexchange.features.trait.data;

import com.groundzero.giftexchange.features.trait.api.TraitRequest;
import com.groundzero.giftexchange.features.trait.entity.TraitEntity;

public class TraitDto {

  public static TraitEntity fromRequest(TraitRequest request) {
    TraitEntity traitEntity = new TraitEntity();
    traitEntity.setDescription(request.getDescription());
    return traitEntity;
  }
}
