package com.groundzero.giftexchange.jwt.utils;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public
class JwtUtils implements Serializable {

  private static final long serialVersionUID = -2550185165626007488L;

  public static final long JWT_ACCESS_TOKEN_EXPIRATION = 60*5;

  @Value("${jwt.secret}")
  private String secret;

  public String getUsernameFromToken(String token) {
    return getClaimFromToken(token, Claims::getSubject);
  }


  public Date getExpirationDateFromToken(String token) {
    return getClaimFromToken(token, Claims::getExpiration);
  }

  public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = getAllClaimsFromToken(token);
    return claimsResolver.apply(claims);
  }


  private Claims getAllClaimsFromToken(String token) {
    return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
  }


  private Boolean isTokenExpired(String token) {
    final Date expiration = getExpirationDateFromToken(token);
    return expiration.before(new Date());
  }


  public String generateToken(UserDetails userDetails) {
    Map<String, Object> claims = new HashMap<>();
    return doGenerateToken(claims, userDetails.getUsername());
  }


  private String doGenerateToken(Map<String, Object> claims, String subject) {
    return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + JWT_ACCESS_TOKEN_EXPIRATION * 1000))
        .signWith(SignatureAlgorithm.HS512, secret).compact();
  }


  public Boolean validateToken(String token, UserDetails userDetails) {
    final String username = getUsernameFromToken(token);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
  }

  public Map<Boolean, String> validateToken(String token) {
    Map<Boolean, String> validationResponse = new HashMap<>();
    try {
      Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
      validationResponse.put(true, "");
    } catch (SignatureException ex) {
      validationResponse.put(false, "Invalid JWT Signature");
    } catch (MalformedJwtException ex) {
      validationResponse.put(false, "Invalid JWT token");
    } catch (ExpiredJwtException ex) {
      validationResponse.put(false, "Expired JWT token");
    } catch (UnsupportedJwtException ex) {
      validationResponse.put(false, "Unsupported JWT exception");
    } catch (IllegalArgumentException ex) {
      validationResponse.put(false, "Jwt claims string is empty");
    }
    return validationResponse;
  }
}