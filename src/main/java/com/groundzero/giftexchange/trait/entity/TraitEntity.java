package com.groundzero.giftexchange.trait.entity;

import javax.persistence.*;

@Entity
@Table(name = "trait")
public class TraitEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String description;
  /*private String joy;
  private String accomplishment;
  private String dream;
  private String fear;
  // From scale to 1-5
  private int honest;
  private int socialLife;
  private int empathy;
  private int creative;
  private int passionate;
  private int learner;
  private int listener;
  private int leader;
  private int courageous;*/

  public TraitEntity() {
  }

  public int getId() {
    return id;
  }

  public TraitEntity setId(int id) {
    this.id = id;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public TraitEntity setDescription(String description) {
    this.description = description;
    return this;
  }
}
