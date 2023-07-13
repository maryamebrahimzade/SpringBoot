package com.example.logger.models;

import lombok.Data;

import java.util.Date;
@Data
public abstract class AbstractDto {
    private Long id;
    private Integer version;
    private Date insertTimestamp;
    private Date lastUpdateTimeStamp;
}
