package com.groundzero.giftexchange.user.repository;

import com.groundzero.giftexchange.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserEntity, Integer> {
  boolean existsByUsername(String username);
  UserEntity findByUsername(String username);
}
