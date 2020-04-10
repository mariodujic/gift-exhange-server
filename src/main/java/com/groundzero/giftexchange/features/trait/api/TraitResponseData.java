package com.groundzero.giftexchange.features.trait.api;

import com.groundzero.giftexchange.data.ResponseData;
import com.groundzero.giftexchange.features.trait.entity.TraitEntity;

public class TraitResponseData implements ResponseData {

  private TraitEntity trait;

  public TraitResponseData(TraitEntity trait) {
    this.trait = trait;
  }

  public TraitEntity getTrait() {
    return trait;
  }

  public TraitResponseData setTrait(TraitEntity trait) {
    this.trait = trait;
    return this;
  }
}
