package com.groundzero.giftexchange.features.interconnect.base;

import com.groundzero.giftexchange.utils.JwtUtils;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class BaseController {

  protected final JwtUtils jwtUtils;

  protected BaseController(JwtUtils jwtUtils) {
    this.jwtUtils = jwtUtils;
  }
}
