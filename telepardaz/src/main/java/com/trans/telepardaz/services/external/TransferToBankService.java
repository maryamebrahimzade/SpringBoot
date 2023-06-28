package com.trans.telepardaz.services.external;

import com.trans.telepardaz.dtos.transfer.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "${external.bank.name}", url = "${external.bank.url}")
public interface TransferToBankService {
    @PostMapping("${external.bank.path-payment}")
    DepositResponse doTransferPayment(DepositPaymentRequest payment);

    @PostMapping("${external.bank.path-account}")
    DepositResponse doTransferAccount(DepositAccountRequest account);

    @PostMapping("${external.bank.path-card}")
    DepositResponse doTransferCard(DepositCardRequest card);
}
