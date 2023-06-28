package com.trans.telepardaz.dtos.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class DepositWalletRequest {
    private String walletId;
    private String trackingId;
    private Long amount;
}
