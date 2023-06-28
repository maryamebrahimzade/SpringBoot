package com.trans.telepardaz.services.external;

import com.trans.telepardaz.utills.responses.AuthResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "${external.auth.name}", url = "${external.auth.url}")
public interface AuthService {
    @GetMapping(value = "${external.auth.path-token}")
    AuthResponse isTokenValid(@RequestHeader("Authorization") String token);
}