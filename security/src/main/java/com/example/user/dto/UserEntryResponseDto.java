package com.example.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEntryResponseDto {

    private String token;
    private String refreshToke;
    private long expiration;
}
