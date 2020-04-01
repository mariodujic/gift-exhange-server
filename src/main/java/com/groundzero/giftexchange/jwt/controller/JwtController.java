package com.groundzero.giftexchange.jwt.controller;

import com.groundzero.giftexchange.jwt.entity.JwtRequest;
import com.groundzero.giftexchange.jwt.entity.JwtResponse;
import com.groundzero.giftexchange.jwt.service.JwtUserDetailsService;
import com.groundzero.giftexchange.jwt.utils.JwtUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;

@RestController
@CrossOrigin
class JwtController {

  private final AuthenticationManager authenticationManager;
  private final JwtUtils jwtUtils;
  private final JwtUserDetailsService jwtUserDetailsService;

  JwtController(AuthenticationManager authenticationManager, JwtUtils jwtUtils, JwtUserDetailsService jwtUserDetailsService) {
    this.authenticationManager = authenticationManager;
    this.jwtUtils = jwtUtils;
    this.jwtUserDetailsService = jwtUserDetailsService;
  }

  @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
  public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest jwtRequest) throws ValidationException {
    try {
      authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
    } catch (Exception e) {
      throw new ValidationException("Wrong username or password");
    }

    UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
    String token = jwtUtils.generateToken(userDetails);
    return ResponseEntity.ok(new JwtResponse(token));
  }

  private void authenticate(String username, String password) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
  }
}