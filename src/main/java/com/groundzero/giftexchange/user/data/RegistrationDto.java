package com.groundzero.giftexchange.user.data;

import com.groundzero.giftexchange.trait.entity.TraitEntity;
import com.groundzero.giftexchange.user.api.RegistrationRequest;
import com.groundzero.giftexchange.user.entity.UserEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RegistrationDto {

  public static UserEntity toEntity(RegistrationRequest request) {
    UserEntity userEntity = new UserEntity();
    userEntity.setFirstName(request.getFirstName());
    userEntity.setLastName(request.getLastName());
    userEntity.setUsername(request.getUsername());
    userEntity.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
    userEntity.setTrait(new TraitEntity());
    return userEntity;
  }
}
