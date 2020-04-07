package com.groundzero.giftexchange.jwt.controller;

import com.groundzero.giftexchange.common.EmptyDataResponse;
import com.groundzero.giftexchange.common.Response;
import com.groundzero.giftexchange.jwt.entity.JwtAccessResponse;
import com.groundzero.giftexchange.jwt.entity.JwtCredentialsRequest;
import com.groundzero.giftexchange.jwt.entity.JwtRefresherTokenRequest;
import com.groundzero.giftexchange.jwt.service.JwtUserDetailsService;
import com.groundzero.giftexchange.jwt.utils.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

  @RequestMapping(value = "/authenticate/credentials", method = RequestMethod.POST)
  public Response createAuthenticationTokenWithCredentials(@RequestBody JwtCredentialsRequest request) {
    try {
      authenticate(request.getUsername(), request.getPassword());
    } catch (Exception e) {
      return new Response(500, "Wrong username or password", new EmptyDataResponse());
    }

    UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(request.getUsername());
    String token = jwtUtils.generateToken(userDetails);
    return new Response(200, "Successfully fetched access token", new JwtAccessResponse(token));
  }

  @RequestMapping(value = "/authenticate/token", method = RequestMethod.POST)
  public Response createAuthenticationTokenWithToken(@RequestBody JwtRefresherTokenRequest request) {

    Map<Boolean, String> validRefresherToken = jwtUtils.validateToken(request.getRefresherToken());

    for (Map.Entry<Boolean, String> entry : validRefresherToken.entrySet()) {
      boolean isTokenValid = !entry.getKey();
      if (isTokenValid) {
        return new Response(500, entry.getValue(), new EmptyDataResponse());
      }
    }
    String username = jwtUtils.getUsernameFromToken(request.getRefresherToken());
    UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);
    String token = jwtUtils.generateToken(userDetails);
    return new Response(200, "Successfully fetched access token", new JwtAccessResponse(token));
  }

  private void authenticate(String username, String password) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
  }
}