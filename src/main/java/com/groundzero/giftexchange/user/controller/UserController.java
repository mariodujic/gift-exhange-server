package com.groundzero.giftexchange.user.controller;

import com.groundzero.giftexchange.jwt.service.JwtUserDetailsService;
import com.groundzero.giftexchange.jwt.utils.JwtUtils;
import com.groundzero.giftexchange.user.model.User;
import com.groundzero.giftexchange.user.model.UserEntity;
import com.groundzero.giftexchange.user.model.UserResponse;
import com.groundzero.giftexchange.user.repository.UserInfoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.ValidationException;

@RestController
public class UserController {

  private final UserInfoRepository userInfoRepository;
  private final JwtUserDetailsService jwtUserDetailsService;
  private final JwtUtils jwtUtils;

  public UserController(UserInfoRepository userInfoRepository, JwtUserDetailsService jwtUserDetailsService, JwtUtils jwtUtils) {
    this.userInfoRepository = userInfoRepository;
    this.jwtUserDetailsService = jwtUserDetailsService;
    this.jwtUtils = jwtUtils;
  }

  @PostMapping("/user")
  public UserResponse create(@RequestBody UserEntity userEntity) throws ValidationException {

    if (userInfoRepository.existsByUsername(userEntity.getUsername())) {
      throw new ValidationException("Username already exists");
    }
    userEntity.setPassword(new BCryptPasswordEncoder().encode(userEntity.getPassword()));
    userInfoRepository.save(userEntity);

    UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(userEntity.getUsername());

    String token = jwtUtils.generateToken(userDetails);

    /**
     * TODO better implementation required
     * @see com.groundzero.giftexchange.common.Response
     */
    return new UserResponse(
        200,
        "User successfully created",
        new UserResponse.Data(
            token,
            new User(
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getUsername()
            )
        )
    );
  }
}
