package com.groundzero.giftexchange.features.interconnect.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "interconnect")
public class InterconnectEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  @JsonProperty("is_looking_to_connect")
  private boolean isLookingToConnect;

  public InterconnectEntity() {
  }

  public int getId() {
    return id;
  }

  public InterconnectEntity setId(int id) {
    this.id = id;
    return this;
  }

  public boolean isLookingToConnect() {
    return isLookingToConnect;
  }

  public InterconnectEntity setLookingToConnect(boolean lookingToConnect) {
    isLookingToConnect = lookingToConnect;
    return this;
  }
}
