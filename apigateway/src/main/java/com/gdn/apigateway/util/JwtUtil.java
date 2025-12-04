package com.gdn.apigateway.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Component
public class JwtUtil {

  @Value("${jwt.secret}")
  private String secret;

  private SecretKey getSigningKey() {
    return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
  }

  public Claims validateTokenAndGetClaims(String token) {
    return Jwts.parserBuilder()
        .setSigningKey(getSigningKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
  }

  public boolean isTokenValid(String token) {
    try {
      validateTokenAndGetClaims(token);
      return true;
    } catch (ExpiredJwtException | MalformedJwtException | 
             UnsupportedJwtException | SignatureException | IllegalArgumentException e) {
      return false;
    }
  }

  public String getUsernameFromToken(String token) {
    return validateTokenAndGetClaims(token).getSubject();
  }

  public String getMemberIdFromToken(String token) {
    return validateTokenAndGetClaims(token).getId();
  }
}



