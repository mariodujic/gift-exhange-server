package com.groundzero.giftexchange.trait.api;

import com.groundzero.giftexchange.common.ResponseData;
import com.groundzero.giftexchange.trait.entity.TraitEntity;

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
