package com.groundzero.giftexchange.features.interconnect.data;

import com.groundzero.giftexchange.features.interconnect.api.InterconnectRequest;
import com.groundzero.giftexchange.features.interconnect.entity.InterconnectEntity;

public class InterconnectDto {

  public static InterconnectEntity fromRequest(InterconnectEntity entity, InterconnectRequest request) {
    entity.setLookingToConnect(true);
    return entity;
  }
}
