package com.trans.telepardaz.utills;


import com.trans.telepardaz.dtos.TransactionDto;
import com.trans.telepardaz.dtos.TransferDto;
import com.trans.telepardaz.dtos.transfer.*;
import com.trans.telepardaz.models.Transaction;
import com.trans.telepardaz.models.UserDetails;
import com.trans.telepardaz.repositories.TransactionRepository;
import com.trans.telepardaz.services.BaseService;
import org.springframework.stereotype.Service;

@Service
public class TransactionService extends BaseService<TransactionRepository, Transaction> {
    private static TransactionDto.TransactionDtoBuilder getTransactionDtoBuilder(UserDetails userDetails, DepositResponse depositResponse, TransferDto transferDto) {
        return TransactionDto.builder()
                .user(userDetails.getSub())
                .trackingId(UuIdGenerator.generateUuID())
                .status(depositResponse.getTransactionStatus())
                .transferMethod(transferDto.getTransferMethod());
    }

    public static TransactionDto depositWalletToWallet(UserDetails userDetails, DepositWalletTransferRequest walletRequest, DepositResponse depositResponse, TransferDto transferDto) {
        return getTransactionDtoBuilder(userDetails, depositResponse, transferDto)
                .amount(walletRequest.getAmount())
                .walletId(walletRequest.getDestinationWalletId())
                .build();
    }


    public static TransactionDto depositToWallet(UserDetails userDetails, DepositWalletRequest walletRequest, DepositResponse depositResponse, TransferDto transferDto) {
        return getTransactionDtoBuilder(userDetails, depositResponse, transferDto)
                .amount(walletRequest.getAmount())
                .walletId(walletRequest.getWalletId())
                .build();
    }

    public static TransactionDto depositToCard(UserDetails userDetails, DepositCardRequest cardRequest, DepositResponse depositResponse, TransferDto transferDto) {
        return getTransactionDtoBuilder(userDetails, depositResponse, transferDto)
                .amount(cardRequest.getAmount())
                .build();
    }

    public static TransactionDto depositToAccount(UserDetails userDetails, DepositAccountRequest accountRequest, DepositResponse depositResponse, TransferDto transferDto) {
        return getTransactionDtoBuilder(userDetails, depositResponse, transferDto)
                .amount(accountRequest.getAmount())
                .build();
    }

    public static TransactionDto depositToPayment(UserDetails userDetails, DepositPaymentRequest paymentRequest, DepositResponse depositResponse, TransferDto transferDto) {
        return getTransactionDtoBuilder(userDetails, depositResponse, transferDto)
                .amount(paymentRequest.getAmount())
                .build();
    }

    public void saveTransaction(TransactionDto dto) {
        Transaction transaction = Transaction.builder()
                .trackingId(dto.getTrackingId())
                .walletId(dto.getWalletId())
                .amount(dto.getAmount())
                .user(dto.getUser())
                .status(dto.getStatus())
                .transferMethod(dto.getTransferMethod()).build();
        repository.save(transaction);
    }

}
