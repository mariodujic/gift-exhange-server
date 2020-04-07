package com.groundzero.giftexchange.user.data;

import com.groundzero.giftexchange.user.api.RegistrationRequest;

public class UserDao {

  public static User fromRegistration(RegistrationRequest registrationRequest) {
    return new User(
        registrationRequest.getFirstName(),
        registrationRequest.getLastName(),
        registrationRequest.getUsername()
    );
  }
}
