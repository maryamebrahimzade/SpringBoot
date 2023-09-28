package com.example.config.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.user.models.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.AlgorithmConstraints;
import java.security.Key;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class  JwtUtil {
    @Value("${jwt.token.validity}")
    private long JWT_TOKEN_VALIDITY;

    @Value("${jwt.token.secret}")
    private String JWT_TOKEN_SECRET_KEY;

    @Value("${jwt.token.expire}")
    private long EXPIRE_TIME;
    @Value("${jwt.token.key:password}")
    private String tokenKey;

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(JWT_TOKEN_SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateAccessToken(User user) {
        List<String> claims = new ArrayList<>(); //user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return Jwts.builder()
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .claim("scopes", "auth_scope")
                .claim("authorities", claims)
                .setSubject(user.getUsername())
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Instant expiration() {
        return LocalDateTime.now().plus(EXPIRE_TIME, ChronoUnit.SECONDS).toInstant(ZoneOffset.UTC);
    }

    public DecodedJWT decode(String token) {
        return JWT.require(Algorithm.HMAC512(JWT_TOKEN_SECRET_KEY)).build().verify(token);
    }

}
