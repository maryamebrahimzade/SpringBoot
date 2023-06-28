package com.trans.telepardaz.services;

import com.trans.telepardaz.dtos.transfer.DepositResponse;
import com.trans.telepardaz.services.external.TransferToBankService;
import com.trans.telepardaz.services.external.TransferToWalletService;
import com.trans.telepardaz.dtos.TransferDto;
import com.trans.telepardaz.dtos.transfer.*;
import com.trans.telepardaz.enums.TransactionStatus;
import com.trans.telepardaz.exceptions.ServiceException;
import com.trans.telepardaz.models.merchant.Merchant;
import com.trans.telepardaz.models.Transaction;
import com.trans.telepardaz.models.UserDetails;
import com.trans.telepardaz.repositories.TransactionRepository;
import com.trans.telepardaz.services.merchant.MerchantService;
import com.trans.telepardaz.utills.TransactionService;
import com.trans.telepardaz.utills.UuIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransferService extends BaseService<TransactionRepository, Transaction> {
    @Autowired
    private MerchantService merchantService;

    @Autowired
    private TransferToBankService transferToBankClient;

    @Autowired
    private TransferToWalletService transferToWalletClient;

    @Autowired
    private TransactionService transactionService;

    public DepositResponse transfer(TransferDto transferDto, UserDetails userDetails) throws ServiceException {
        Optional<Merchant> merchant = merchantService.findById(transferDto.getMerchantId());
        switch (transferDto.getTransferMethod()) {
            case TO_CARD -> {
                DepositCardRequest cardRequest = DepositCardRequest.builder()
                        .sourceCardNumber("5859831048450950")
                        .destinationCardNumber(merchant.get().getCardNumber())
                        .cvv2(4502)
                        .expireTime("06-07")
                        .otp(123456)
                        .amount(transferDto.getAmount()).build();
                DepositResponse depositResponse = transferToBankClient.doTransferCard(cardRequest);
                transactionService.saveTransaction(TransactionService.depositToCard(userDetails, cardRequest, depositResponse, transferDto));
                return depositResponse;
            }
            case TO_ACCOUNT -> {
                DepositAccountRequest accountRequest = DepositAccountRequest.builder()
                        .sourceAccountNumber("5859831093")
                        .destinationAccountNumber(merchant.get().getAccountNumber())
                        .amount(transferDto.getAmount()).build();
                DepositResponse depositResponse = transferToBankClient.doTransferAccount(accountRequest);
                transactionService.saveTransaction(TransactionService.depositToAccount(userDetails, accountRequest, depositResponse, transferDto));
                return depositResponse;
            }
            case TO_PAYMENT -> {
                DepositPaymentRequest paymentRequest = DepositPaymentRequest.builder()
                        .cardNumber(merchant.get().getCardNumber())
                        .cvv2(4502)
                        .expireTime("06-07")
                        .otp(123456)
                        .amount(transferDto.getAmount()).build();
                DepositResponse depositResponse = transferToBankClient.doTransferPayment(paymentRequest);
                transactionService.saveTransaction(TransactionService.depositToPayment(userDetails, paymentRequest, depositResponse, transferDto));
                return depositResponse;
            }
            case TO_WALLET -> {
                DepositWalletRequest walletRequest = DepositWalletRequest.builder()
                        .walletId("1")
                        .trackingId(UuIdGenerator.generateUuID())
                        .amount(transferDto.getAmount()).build();

                DepositResponse depositResponse = transferToWalletClient.doTransferDeposit(walletRequest);
                transactionService.saveTransaction(TransactionService.depositToWallet(userDetails, walletRequest, depositResponse, transferDto));
                return depositResponse;
            }
            case WALLET_TRANSFER -> {
                DepositWalletTransferRequest walletRequest = DepositWalletTransferRequest.builder()
                        .sourceWalletId("1")
                        .destinationWalletId("2")
                        .amount(transferDto.getAmount()).build();
                DepositResponse depositResponse = transferToWalletClient.doTransferToWallet(walletRequest);
                transactionService.saveTransaction(TransactionService.depositWalletToWallet(userDetails, walletRequest, depositResponse, transferDto));
                return depositResponse;
            }
            default -> throw new IllegalStateException("Unexpected value: " + transferDto.getTransferMethod());
        }
    }

    public void retryDeposit(DepositWalletRequest walletDto) throws Exception {
        for (int i = 0; i < 3; i++) {
            DepositResponse walletResponse = transferToWalletClient.doTransferDeposit(walletDto);
            if (walletResponse.getTransactionStatus().equals(TransactionStatus.SUCCESS)) {
                Transaction trans = repository.findByTrackingId(walletDto.getTrackingId());
                trans.setStatus(TransactionStatus.SUCCESS);
                super.update(trans);
                break;
            }
        }
    }
}
