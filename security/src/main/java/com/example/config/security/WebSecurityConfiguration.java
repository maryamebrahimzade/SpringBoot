package com.example.config.security;

import com.example.config.exception.FilterChainExceptionHandler;
import com.example.config.security.filter.JWTAuthenticationFilter;
import com.example.config.security.filter.JWTAuthorizationFilter;
import com.example.config.security.jwt.JwtUtil;
import com.example.config.security.token.EmailPasswordAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfiguration {
    private final EmailPasswordAuthenticationProvider emailPasswordAuthenticationProvider;
    private final FilterChainExceptionHandler filterChainExceptionHandler;
    private final ApplicationContext applicationContext;
    private final JwtUtil jwtUtil;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .cors().disable()
                .formLogin().disable()
                .httpBasic().disable()
                .authorizeHttpRequests()
                .requestMatchers(
                        "/v3/**",
                        "/swagger-ui/**",
                        "/api/users/register",
                        "/api/users/login")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(filterChainExceptionHandler, LogoutFilter.class)
                .addFilter(new JWTAuthenticationFilter(getAuthenticationManager(), jwtUtil))
                .addFilter(new JWTAuthorizationFilter(getAuthenticationManager(), jwtUtil));
        return http.build();
    }

    private AuthenticationManager getAuthenticationManager() {
        return applicationContext.getBean(AuthenticationManager.class);
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationManagerBuilder authenticationManagerBuilder) {
        return authenticationManagerBuilder
                .authenticationProvider(emailPasswordAuthenticationProvider)
                .getOrBuild();
    }
}
