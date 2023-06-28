package com.trans.telepardaz.services.external;

import com.trans.telepardaz.dtos.transfer.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "${external.wallet.name}", url = "${external.wallet.url}")
public interface TransferToWalletService {
    @PostMapping("${external.wallet.path-deposit}")
    DepositResponse doTransferDeposit(DepositWalletRequest wallet);

    @PostMapping("${external.wallet.path-tracking}")
    DepositResponse doTransferTransaction(String trackingId);

    @PostMapping("${external.wallet.path-toWallet}")
    DepositResponse doTransferToWallet(DepositWalletTransferRequest wallet);
}
