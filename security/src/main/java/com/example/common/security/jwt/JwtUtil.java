package com.example.common.security.jwt;

import com.example.user.models.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtil {
    @Value("${jwt.token.validity}")
    private long JWT_TOKEN_VALIDITY;

    @Value("${jwt.token.secret}")
    private String JWT_TOKEN_SECRET_KEY;

    @Value("${jwt.token.expire}")
    private long EXPIRE_TIME;

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(JWT_TOKEN_SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes); //
    }

    public String generateAccessToken(User user) {
        List<String> claims = new ArrayList<>(); //user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return Jwts.builder()
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .claim("scopes", "auth_scope")
                .claim("authorities", claims)
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Instant expiration() {
        return LocalDateTime.now().plus(EXPIRE_TIME, ChronoUnit.SECONDS).toInstant(ZoneOffset.UTC);
    }
}
