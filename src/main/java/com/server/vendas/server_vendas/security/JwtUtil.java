package com.server.vendas.server_vendas.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Jwts.SIG;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

  @Value("${jwt.secret}")
  private String jwtSecret;

  @Value("${jwt.expiration}")
  private int jwtExpirationMs;

  private SecretKey key;

  @PostConstruct
  public void init() {
    this.key = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
  }

  public String generateToken(String email) {
    return Jwts.builder()
        .subject(email)
        .issuedAt(new Date())
        .expiration(new Date(new Date().getTime() + jwtExpirationMs))
        .signWith(key, SIG.HS256)
        .compact();
  }

  public String getEmailFromToken(String token) {
    return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject();
  }

  public boolean validateToken(String token) {
    try {
      Jwts.parser().verifyWith(key).build().parseSignedClaims(token);
      return true;
    } catch (SecurityException e) {
      System.out.println("Invalid JWT signature: " + e.getMessage());
    } catch (MalformedJwtException e) {
      System.out.println("Invalid JWT token: " + e.getMessage());
    } catch (ExpiredJwtException e) {
      System.out.println("JWT token is expired: " + e.getMessage());
    } catch (UnsupportedJwtException e) {
      System.out.println("JWT token is unsupported: " + e.getMessage());
    } catch (IllegalArgumentException e) {
      System.out.println("JWT claims string is empty" + e.getMessage());
    }
    return false;
  }
}
