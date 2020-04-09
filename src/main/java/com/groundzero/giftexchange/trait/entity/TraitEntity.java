package com.groundzero.giftexchange.trait.entity;

import javax.persistence.*;

@Entity
@Table(name = "trait")
public class TraitEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String description;
  private String joy;
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
  private int courageous;

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

  public String getJoy() {
    return joy;
  }

  public TraitEntity setJoy(String joy) {
    this.joy = joy;
    return this;
  }

  public String getAccomplishment() {
    return accomplishment;
  }

  public TraitEntity setAccomplishment(String accomplishment) {
    this.accomplishment = accomplishment;
    return this;
  }

  public String getDream() {
    return dream;
  }

  public TraitEntity setDream(String dream) {
    this.dream = dream;
    return this;
  }

  public String getFear() {
    return fear;
  }

  public TraitEntity setFear(String fear) {
    this.fear = fear;
    return this;
  }

  public int getHonest() {
    return honest;
  }

  public TraitEntity setHonest(int honest) {
    this.honest = honest;
    return this;
  }

  public int getSocialLife() {
    return socialLife;
  }

  public TraitEntity setSocialLife(int socialLife) {
    this.socialLife = socialLife;
    return this;
  }

  public int getEmpathy() {
    return empathy;
  }

  public TraitEntity setEmpathy(int empathy) {
    this.empathy = empathy;
    return this;
  }

  public int getCreative() {
    return creative;
  }

  public TraitEntity setCreative(int creative) {
    this.creative = creative;
    return this;
  }

  public int getPassionate() {
    return passionate;
  }

  public TraitEntity setPassionate(int passionate) {
    this.passionate = passionate;
    return this;
  }

  public int getLearner() {
    return learner;
  }

  public TraitEntity setLearner(int learner) {
    this.learner = learner;
    return this;
  }

  public int getListener() {
    return listener;
  }

  public TraitEntity setListener(int listener) {
    this.listener = listener;
    return this;
  }

  public int getLeader() {
    return leader;
  }

  public TraitEntity setLeader(int leader) {
    this.leader = leader;
    return this;
  }

  public int getCourageous() {
    return courageous;
  }

  public TraitEntity setCourageous(int courageous) {
    this.courageous = courageous;
    return this;
  }
}
