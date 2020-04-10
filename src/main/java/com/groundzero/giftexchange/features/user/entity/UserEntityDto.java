package com.groundzero.giftexchange.features.user.entity;

import com.groundzero.giftexchange.features.user.api.RegistrationRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserEntityDto {

  public static UserEntity fromRegistrationRequest(UserEntity userEntity, RegistrationRequest request) {
    userEntity.setUsername(request.getUsername());
    userEntity.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
    userEntity.setFirstName(request.getFirstName());
    userEntity.setLastName(request.getLastName());
    return userEntity;
  }
}