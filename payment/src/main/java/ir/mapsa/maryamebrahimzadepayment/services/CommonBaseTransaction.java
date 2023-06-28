package ir.mapsa.maryamebrahimzadepayment.services;

import ir.mapsa.maryamebrahimzadepayment.dto.TransactionDto;
import ir.mapsa.maryamebrahimzadepayment.exceptions.ServiceException;
import ir.mapsa.maryamebrahimzadepayment.models.*;
import ir.mapsa.maryamebrahimzadepayment.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public abstract class CommonBaseTransaction extends AbstractService<TransactionRepository, Transaction> implements BaseTransaction {
    @Autowired
    protected BankInfoService bankInfoService;

    protected Transaction saveTransaction(TransactionDto dto, BankInfo cSender, BankInfo cReceiver) {
        Transaction trxEntity = new Transaction();
        trxEntity.setReceiver(cReceiver);
        trxEntity.setSender(cSender);
        trxEntity.setDate(new Date());
        trxEntity.setAmount(dto.getAmount());
        trxEntity.setTransactionId(dto.getTransactionId());
        repository.save(trxEntity);
        return trxEntity;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected void resolveTransaction(BankInfo sender, BankInfo receiver, Long amount) throws ServiceException {
        bankInfoService.withdraw(sender, amount);
        bankInfoService.deposit(receiver, amount);
    }
}
