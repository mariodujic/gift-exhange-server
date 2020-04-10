package com.groundzero.giftexchange.features.user.repository;

import com.groundzero.giftexchange.features.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
  boolean existsByUsername(String username);
  UserEntity findByUsername(String username);
}
