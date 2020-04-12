package com.groundzero.giftexchange.features.interconnect.api;

import com.groundzero.giftexchange.data.ResponseData;
import com.groundzero.giftexchange.features.interconnect.entity.InterconnectEntity;

public class InterconnectResponseData implements ResponseData {

  private InterconnectEntity interconnect;

  public InterconnectResponseData(InterconnectEntity interconnect) {
    this.interconnect = interconnect;
  }

  public InterconnectEntity getInterconnect() {
    return interconnect;
  }

  public InterconnectResponseData setInterconnect(InterconnectEntity interconnect) {
    this.interconnect = interconnect;
    return this;
  }
}
