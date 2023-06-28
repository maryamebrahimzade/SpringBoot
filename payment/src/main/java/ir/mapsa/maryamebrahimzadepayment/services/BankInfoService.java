package ir.mapsa.maryamebrahimzadepayment.services;

import ir.mapsa.maryamebrahimzadepayment.exceptions.ServiceException;
import ir.mapsa.maryamebrahimzadepayment.models.BankInfo;
import ir.mapsa.maryamebrahimzadepayment.repositories.BankInfoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankInfoService extends AbstractService<BankInfoRepository, BankInfo> {

    public void withdraw(BankInfo customer, Long amount) throws ServiceException {
        if (amount > customer.getBalance()) {
            throw new ServiceException("your_balance_is_not_enough");
        }
        customer.setBalance(customer.getBalance() - amount);
        repository.save(customer);
    }

    public void deposit(BankInfo customer, Long amount) {
        customer.setBalance(customer.getBalance() + amount);
        repository.save(customer);
    }

    public BankInfo findByCardNumber(String cardNumber) {
        return repository.findByCardNumber(cardNumber);
    }

    public BankInfo findByAccountNumber(String cardNumber) {
        return repository.findByAccountNumber(cardNumber);
    }

    public String findByBankInfoId(String bankInfoId) throws ServiceException {
        BankInfo bankInfo = repository.findByBankInfoId(bankInfoId);
        if (bankInfo != null) {
            throw new ServiceException("bank_info_id_repetitious");
        }
        return bankInfoId;
    }

    public Long accountBalance(String cardNumber) throws ServiceException {
        BankInfo customer = repository.findByCardNumber(cardNumber);
        if (customer != null) {
            return customer.getBalance();
        } else {
            throw new ServiceException("user_not_found");
        }
    }


    public BankInfo getById(Long id) throws ServiceException {
        Optional<BankInfo> customer = repository.findById(id);
        try {
            return customer.orElseThrow();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), "user_not_Found");
        }
    }

//    @Transactional
//    public void update(CustomerDto customerDto) throws ServiceException {
//        BankInfo customer = repository.findById(customerDto.getId())
//                .orElseThrow(() -> new ServiceException("customer_not_found"));
//        change(BankInfo, customerDto);
//        repository.save(customer);
//    }
//
//    private void change(BankInfo customer, CustomerDto customerDto) {
//        if (customerDto.getCardNumber() != null) customer.setCardNumber(customerDto.getCardNumber());
//        if (customerDto.getAge() != null) customer.setAge(customerDto.getAge());
//        if (customerDto.getBalance() != null) customer.setBalance(customerDto.getBalance());
//        if (customerDto.getFirstName() != null) customer.setFirstName(customerDto.getFirstName());
//        if (customerDto.getLastName() != null) customer.setLastName(customerDto.getLastName());
//    }
}
