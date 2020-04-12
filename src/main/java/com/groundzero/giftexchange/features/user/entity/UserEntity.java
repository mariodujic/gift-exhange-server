package com.groundzero.giftexchange.features.user.entity;

import com.groundzero.giftexchange.features.interconnect.entity.InterconnectEntity;
import com.groundzero.giftexchange.features.trait.entity.TraitEntity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String firstName;
  private String lastName;
  private String username;
  private String password;
  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "trait_id")
  private TraitEntity trait;
  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "interconnect_id")
  private InterconnectEntity interconnect;

  public UserEntity() {
  }

  public TraitEntity getTrait() {
    return trait;
  }

  public UserEntity setTrait(TraitEntity trait) {
    this.trait = trait;
    return this;
  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public UserEntity setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public UserEntity setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public UserEntity setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public UserEntity setPassword(String password) {
    this.password = password;
    return this;
  }

  public InterconnectEntity getInterconnect() {
    return interconnect;
  }

  public UserEntity setInterconnect(InterconnectEntity interconnect) {
    this.interconnect = interconnect;
    return this;
  }
}
