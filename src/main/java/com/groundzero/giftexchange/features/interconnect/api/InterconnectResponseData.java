package com.groundzero.giftexchange.features.interconnect.api;

import com.groundzero.giftexchange.data.ResponseData;
import com.groundzero.giftexchange.features.interconnect.data.Interconnect;
import com.groundzero.giftexchange.features.interconnect.entity.InterconnectEntity;

public class InterconnectResponseData implements ResponseData {

  private Interconnect interconnect;

  public InterconnectResponseData(Interconnect interconnect) {
    this.interconnect = interconnect;
  }

  public Interconnect getInterconnect() {
    return interconnect;
  }

  public InterconnectResponseData setInterconnect(Interconnect interconnect) {
    this.interconnect = interconnect;
    return this;
  }
}
