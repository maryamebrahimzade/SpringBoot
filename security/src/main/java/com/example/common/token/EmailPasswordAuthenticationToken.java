package com.example.common.token;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class EmailPasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {
    public EmailPasswordAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }
}
