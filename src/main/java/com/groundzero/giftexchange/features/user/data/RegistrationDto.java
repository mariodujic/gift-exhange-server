package com.groundzero.giftexchange.features.user.data;

import com.groundzero.giftexchange.features.trait.entity.TraitEntity;
import com.groundzero.giftexchange.features.user.api.RegistrationRequest;
import com.groundzero.giftexchange.features.user.entity.UserEntity;
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
