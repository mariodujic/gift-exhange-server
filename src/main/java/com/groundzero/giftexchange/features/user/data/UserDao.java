package com.groundzero.giftexchange.features.user.data;

import com.groundzero.giftexchange.features.user.entity.UserEntity;

public class UserDao {

  public static User fromEntity(UserEntity entity) {
    return new User(
        entity.getId(),
        entity.getFirstName(),
        entity.getLastName(),
        entity.getUsername()
    );
  }
}