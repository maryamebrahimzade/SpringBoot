package com.example.user.dto;

import lombok.Data;

import java.util.Date;
@Data
public class BaseDto {
    private Long Id;
    private Integer version;
    private Date insertTimeStamp;
    private Date lastUpdateTimestamp;
}
