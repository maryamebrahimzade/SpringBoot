package ir.mapsa.maryamebrahimzadepayment.dto;

import lombok.Data;

import java.util.Date;
@Data
public abstract class AbstractDto {
    private Long Id;
    private Integer version;
    private Date insertTimeStamp;
    private Date lastUpdateTimestamp;
}
