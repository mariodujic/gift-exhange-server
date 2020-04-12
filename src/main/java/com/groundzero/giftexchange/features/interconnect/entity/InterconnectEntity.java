package com.groundzero.giftexchange.features.interconnect.entity;

import javax.persistence.*;

@Entity
@Table(name = "interconnect")
public class InterconnectEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private boolean isEligible;
  /*private int totalCount;
  private int successCount;
  private int failureCount;*/

  public InterconnectEntity() {
  }

  public int getId() {
    return id;
  }

  public InterconnectEntity setId(int id) {
    this.id = id;
    return this;
  }

  public boolean isEligible() {
    return isEligible;
  }

  public InterconnectEntity setEligible(boolean eligible) {
    isEligible = eligible;
    return this;
  }
}
