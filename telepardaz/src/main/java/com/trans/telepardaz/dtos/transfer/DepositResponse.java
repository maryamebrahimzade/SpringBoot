package com.trans.telepardaz.dtos.transfer;

import com.trans.telepardaz.enums.TransactionStatus;
import lombok.Data;

@Data
public class DepositResponse {
    private TransactionStatus transactionStatus;
}
