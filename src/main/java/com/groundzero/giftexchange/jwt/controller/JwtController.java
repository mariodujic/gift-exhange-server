package com.groundzero.giftexchange.jwt.controller;

import com.groundzero.giftexchange.common.EmptyDataResponse;
import com.groundzero.giftexchange.common.Response;
import com.groundzero.giftexchange.jwt.entity.JwtAccessResponse;
import com.groundzero.giftexchange.jwt.entity.JwtRequest;
import com.groundzero.giftexchange.jwt.service.JwtUserDetailsService;
import com.groundzero.giftexchange.jwt.utils.JwtUtils;
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
  // TODO handle no bearer
  @RequestMapping(value = "/authenticate-with-credentials", method = RequestMethod.POST)
  public Response createAuthenticationTokenWithCredentials(@RequestBody JwtRequest jwtRequest) {
    try {
      authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
    } catch (Exception e) {
      return new Response(500, "Wrong username or password", new EmptyDataResponse());
    }

    UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
    String token = jwtUtils.generateToken(userDetails);
    return new Response(200, "Successfully fetched access token", new JwtAccessResponse(token));
  }

  @RequestMapping(value = "/authenticate-with-token", method = RequestMethod.POST)
  public Response createAuthenticationTokenWithToken(@RequestHeader(value = "Authorization") String authorization) {

    // TODO handle error
    String username = jwtUtils.getUsernameFromToken(authorization.substring(7));

    UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);
    String token = jwtUtils.generateToken(userDetails);
    return new Response(200, "Successfully fetched access token", new JwtAccessResponse(token));
  }

  private void authenticate(String username, String password) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
  }
}