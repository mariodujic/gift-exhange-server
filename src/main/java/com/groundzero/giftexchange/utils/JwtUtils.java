package com.groundzero.giftexchange.utils;

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

  public static final long JWT_ACCESS_TOKEN_EXPIRATION_SEC = 60 * 5;
  public static final long JWT_REFRESH_TOKEN_EXPIRATION_SEC = 60 * 60 * 24 * 365;

  private static final String CUSTOM_CLAIM_TYPE_KEY = "key_type";

  @Value("${jwt.secret}")
  private String secret;

  public String getUsernameFromToken(String token) {
    return getClaimFromToken(token, Claims::getSubject);
  }


  public Date getExpirationDateFromToken(String token) {
    return getClaimFromToken(token, Claims::getExpiration);
  }

  public JwtType getTokenType(String token) {
    return JwtType.findByValue((Integer) getAllClaimsFromToken(token).get(CUSTOM_CLAIM_TYPE_KEY));
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


  public String generateToken(UserDetails userDetails, JwtType tokenType) {
    Map<String, Object> claims = new HashMap<>();
    return doGenerateToken(claims, userDetails.getUsername(), tokenType);
  }


  private String doGenerateToken(Map<String, Object> claims, String subject, JwtType tokenType) {
    return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + getExpirationSeconds(tokenType) * 1000))
        .claim(CUSTOM_CLAIM_TYPE_KEY, tokenType.value)
        .signWith(SignatureAlgorithm.HS512, secret).compact();
  }

  private long getExpirationSeconds(JwtType tokenType) {
    return tokenType == JwtType.ACCESS ? JWT_ACCESS_TOKEN_EXPIRATION_SEC : JWT_REFRESH_TOKEN_EXPIRATION_SEC;
  }


  public Boolean validateToken(String token, UserDetails userDetails) {
    final String username = getUsernameFromToken(token);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
  }

  public String getTokenFromBearer(String bearer) {
    return bearer.substring(7);
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