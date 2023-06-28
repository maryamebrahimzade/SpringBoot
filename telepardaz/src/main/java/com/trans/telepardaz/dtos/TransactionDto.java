package com.trans.telepardaz.dtos;

import com.trans.telepardaz.enums.TransactionStatus;
import com.trans.telepardaz.enums.TransferMethod;
import lombok.*;
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class TransactionDto extends BaseDto {
    private String walletId;
    private  String user;
    private String trackingId;
    private Long amount;
    private TransactionStatus status;
    private TransferMethod transferMethod;
}
