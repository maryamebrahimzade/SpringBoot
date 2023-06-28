package com.trans.telepardaz.dtos.transfer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DepositWalletTransferRequest {
    private String sourceWalletId;
    private String destinationWalletId;
    private Long amount;
}
