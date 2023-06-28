package ir.mapsa.maryamebrahimzadepayment.repositories;

import ir.mapsa.maryamebrahimzadepayment.models.BankInfo;
import ir.mapsa.maryamebrahimzadepayment.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankInfoRepository extends JpaRepository<BankInfo,Long> {
    BankInfo findByCardNumber(String cardNumber);
    BankInfo findByAccountNumber(String accountNumber);
    BankInfo findByBankInfoId(String bankInfoId);

}

