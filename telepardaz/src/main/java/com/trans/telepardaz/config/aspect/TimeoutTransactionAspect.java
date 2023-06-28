package com.trans.telepardaz.config.aspect;

import com.trans.telepardaz.dtos.transfer.DepositWalletRequest;
import com.trans.telepardaz.services.TransferService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class TimeoutTransactionAspect {
    @Autowired
    private TransferService transferService;

    @AfterThrowing(value = "execution(* com.trans.telepardaz.services.TransferService.transfer(..))", throwing = "exception")
    public void checkTimedOutTransactions(JoinPoint jp, Exception exception) throws Exception {
        Signature signature = jp.getSignature();
        DepositWalletRequest[] objects = (DepositWalletRequest[]) jp.getArgs();
        transferService.retryDeposit(objects[0]);
    }
}
