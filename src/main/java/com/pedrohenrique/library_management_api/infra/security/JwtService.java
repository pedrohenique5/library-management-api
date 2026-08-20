package com.pedrohenrique.library_management_api.infra.security;

import com.pedrohenrique.library_management_api.core.domain.entities.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtService {

    private final SecretKey secretKey = Keys.hmacShaKeyFor(
            "f2A9xLm8Qw3N7vBc5YpR1tHs6ZjK4uEd9MnX2gVa8CfPw5TbL7kHy3DsQ1rUe6".getBytes()
    );
    private final long expirationMs = 86_400_000;

    public String generateToken(User user) {
        return Jwts.builder()
                .subject(user.getEmail())
                .claim("userId", user.getId())
                .claim("role", user.getRole().name())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(secretKey)
                .compact();
    }

    public String extractEmail(String token){
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean isTokenValid(String token){
        try {
            Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
