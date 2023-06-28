package com.trans.telepardaz.dtos;

import com.trans.telepardaz.enums.TransferMethod;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TransferDto extends BaseDto {
    private Long merchantId;
    private Long amount;
    private TransferMethod transferMethod;
}
