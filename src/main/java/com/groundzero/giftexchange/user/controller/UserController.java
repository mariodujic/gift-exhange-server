package com.groundzero.giftexchange.user.controller;

import com.groundzero.giftexchange.user.model.UserEntity;
import com.groundzero.giftexchange.user.repository.UserInfoRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.ValidationException;

@RestController
public class UserController {

  private final UserInfoRepository userInfoRepository;

  public UserController(UserInfoRepository userInfoRepository) {
    this.userInfoRepository = userInfoRepository;
  }

  @PostMapping("/user")
  public Boolean create(@RequestBody UserEntity userEntity) throws ValidationException {

    if (userInfoRepository.existsByUsername(userEntity.getUsername())) {
      throw new ValidationException("Username already exists");
    }
    userEntity.setPassword(new BCryptPasswordEncoder().encode(userEntity.getPassword()));
    userInfoRepository.save(userEntity);
    return true;
  }
}
