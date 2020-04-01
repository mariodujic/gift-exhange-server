package com.groundzero.giftexchange.user.model;

public class User {
  private String firstName;
  private String lastName;
  private String username;

  public User(String firstName, String lastName, String username) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
  }

  public String getFirstName() {
    return firstName;
  }

  public User setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public User setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public User setUsername(String username) {
    this.username = username;
    return this;
  }
}
