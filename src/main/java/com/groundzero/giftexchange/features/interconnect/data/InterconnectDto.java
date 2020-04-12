package com.groundzero.giftexchange.features.interconnect.data;

import com.groundzero.giftexchange.features.interconnect.api.InterconnectRequest;
import com.groundzero.giftexchange.features.interconnect.entity.InterconnectEntity;

public class InterconnectDto {

  public static InterconnectEntity fromRequest(InterconnectEntity entity, InterconnectRequest request) {
    entity.setLookingToConnect(!entity.isLookingToConnect());
    return entity;
  }

  public static Interconnect toResponse(InterconnectEntity entity) {
    return new Interconnect(entity.isLookingToConnect());
  }
}
