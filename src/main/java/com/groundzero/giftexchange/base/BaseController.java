package com.groundzero.giftexchange.base;

import com.groundzero.giftexchange.features.user.repository.UserRepository;
import com.groundzero.giftexchange.utils.JwtUtils;

public abstract class BaseController {

  protected final JwtUtils jwtUtils;
  protected final UserRepository userRepository;

  protected BaseController(JwtUtils jwtUtils, UserRepository userRepository) {
    this.jwtUtils = jwtUtils;
    this.userRepository = userRepository;
  }
}
