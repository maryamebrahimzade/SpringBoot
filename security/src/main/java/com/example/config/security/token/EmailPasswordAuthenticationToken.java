package com.example.config.security.token;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class EmailPasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {
    public EmailPasswordAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }
}
