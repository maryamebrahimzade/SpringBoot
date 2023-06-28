package com.trans.telepardaz.config.filter;

import com.trans.telepardaz.services.external.AuthService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class AuthFilter implements Filter {
    @Autowired
    private AuthService authService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        if ((req.getHeader("Authorization") == null) || !authService.isTokenValid(req.getHeader("Authorization")).getIsValid()) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized - Please Log In");
        }
        chain.doFilter(request, response);
    }
}
