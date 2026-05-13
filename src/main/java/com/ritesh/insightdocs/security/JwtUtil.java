package com.ritesh.insightdocs.security;


import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String secretKey;
    @Value("${jwt.expiration}")
    private long expirationTime;

    public String buildToken(String email){
       String key =  Jwts.builder()
        .subject(email)           // store email inside the token
        .issuedAt(new Date())     // when it was created
        .expiration(new Date(System.currentTimeMillis() + expirationTime))  // when it expires
        .signWith(getSigningKey()) // sign with secret key
        .compact();  
        return key;
    }

    public boolean isTokenValid(String token) {
    try {
        // if this line runs without error → valid
        Jwts.parser()
            .verifyWith(getSigningKey())
            .build()
            .parseSignedClaims(token);
        return true;
    } catch (Exception e) {
        // signature mismatch, expired, malformed → invalid
        return false;
    }
}   



    private SecretKey getSigningKey() {
    byte[] keyBytes = secretKey.getBytes();
    return Keys.hmacShaKeyFor(keyBytes);
}
public String extractEmail(String token) {
    return Jwts.parser()
        .verifyWith( getSigningKey())
        .build()
        .parseSignedClaims(token)
        .getPayload()
        .getSubject();
}
    
    
}