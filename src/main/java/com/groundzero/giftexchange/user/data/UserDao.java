package com.groundzero.giftexchange.user.data;

import com.groundzero.giftexchange.user.entity.UserEntity;

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
