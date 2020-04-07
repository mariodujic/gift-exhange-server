package com.groundzero.giftexchange.user.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegistrationRequest {

  @JsonProperty("first_name")
  private String firstName;
  @JsonProperty("last_name")
  private String lastName;
  private String username;
  private String password;

  public RegistrationRequest() {
  }

  public RegistrationRequest(String firstName, String lastName, String username, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.password = password;
  }

  public String getFirstName() {
    return firstName;
  }

  public RegistrationRequest setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public RegistrationRequest setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public RegistrationRequest setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public RegistrationRequest setPassword(String password) {
    this.password = password;
    return this;
  }
}
