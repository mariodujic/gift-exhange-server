package com.groundzero.giftexchange.trait.data;

import com.groundzero.giftexchange.trait.api.TraitRequest;
import com.groundzero.giftexchange.trait.entity.TraitEntity;

public class TraitDto {

  public static TraitEntity fromRequest(TraitRequest request) {
    TraitEntity traitEntity = new TraitEntity();
    traitEntity.setDescription(request.getDescription());
    return traitEntity;
  }
}
