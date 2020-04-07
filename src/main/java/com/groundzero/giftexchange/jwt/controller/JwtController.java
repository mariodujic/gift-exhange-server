package com.groundzero.giftexchange.jwt.controller;

import com.groundzero.giftexchange.common.EmptyDataResponse;
import com.groundzero.giftexchange.common.Response;
import com.groundzero.giftexchange.jwt.api.JwtRefresherTokenRequest;
import com.groundzero.giftexchange.jwt.data.JwtAccessToken;
import com.groundzero.giftexchange.jwt.api.JwtAccessTokenDataResponse;
import com.groundzero.giftexchange.jwt.service.JwtUserDetailsService;
import com.groundzero.giftexchange.jwt.utils.JwtUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@CrossOrigin
class JwtController {

  private final JwtUtils jwtUtils;
  private final JwtUserDetailsService jwtUserDetailsService;

  JwtController(JwtUtils jwtUtils, JwtUserDetailsService jwtUserDetailsService) {
    this.jwtUtils = jwtUtils;
    this.jwtUserDetailsService = jwtUserDetailsService;
  }

  @RequestMapping(value = "/authenticate/access-token", method = RequestMethod.POST)
  public Response createAuthenticationTokenWithToken(@RequestBody JwtRefresherTokenRequest request) {

    Map<Boolean, String> validRefresherToken = jwtUtils.validateToken(request.getRefresherToken());

    for (Map.Entry<Boolean, String> entry : validRefresherToken.entrySet()) {
      boolean isTokenValid = !entry.getKey();
      if (isTokenValid) {
        return new Response(500, entry.getValue(), new EmptyDataResponse());
      }
    }
    String username = jwtUtils.getUsernameFromToken(request.getRefresherToken());
    Date expirationDate = jwtUtils.getExpirationDateFromToken(request.getRefresherToken());
    UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);
    String token = jwtUtils.generateToken(userDetails);
    return new Response(
        200,
        "Successfully fetched access token",
        new JwtAccessTokenDataResponse(
            new JwtAccessToken(token, expirationDate)
        )
    );
  }
}