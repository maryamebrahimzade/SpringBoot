package com.trans.telepardaz.dtos;

import jakarta.validation.constraints.Pattern;
import lombok.*;
@Data
@EqualsAndHashCode(callSuper = true)
public class QRCodeDto extends BaseDto {
    private Long merchantId;
    @Pattern(regexp = "^\\d[0-9]+$",message = "Just enter the number")
    private String terminalId;
}
