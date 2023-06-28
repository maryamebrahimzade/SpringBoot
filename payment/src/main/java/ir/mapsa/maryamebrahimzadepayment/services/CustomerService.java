package ir.mapsa.maryamebrahimzadepayment.services;

import ir.mapsa.maryamebrahimzadepayment.exceptions.ServiceException;
import ir.mapsa.maryamebrahimzadepayment.models.Customer;
import ir.mapsa.maryamebrahimzadepayment.repositories.CustomerRepository;
import org.springframework.stereotype.Service;


@Service
public class CustomerService extends AbstractService<CustomerRepository, Customer> {
    public Customer findByCustomerId(String customerId) throws ServiceException {
        Customer customer = repository.findByCustomerId(customerId);
        if (customer == null) {
            throw new ServiceException("customer_id_not_found");
        }
        return customer;
    }

//
//    public Long accountBalance(String cardNumber) throws ServiceException {
//        Customer customer = repository.findByCardNumber(cardNumber);
//        if (customer != null) {
//            return customer.getBalance();
//        } else {
//            throw new ServiceException("user_not_found");
//        }
//    }
//

//    public Customer findByAccountNumber(String cardNumber) {
//        return repository.findByAccountNumber(cardNumber);
//    }
//    public Customer getById(Long id) throws ServiceException {
//        Optional<Customer> customer = repository.findById(id);
//        try {
//            return customer.orElseThrow();
//        } catch (Exception e) {
//            throw new ServiceException(e.getMessage(), "user_not_Found");
//        }
//    }
//
//    @Transactional
//    public void update(CustomerDto customerDto) throws ServiceException {
//        Customer customer = repository.findById(customerDto.getId())
//                .orElseThrow(() -> new ServiceException("customer_not_found"));
//        change(customer, customerDto);
//        repository.save(customer);
//    }
//
//    private void change(Customer customer, CustomerDto customerDto) {
//        if (customerDto.getCardNumber() != null) customer.setCardNumber(customerDto.getCardNumber());
//        if (customerDto.getAge() != null) customer.setAge(customerDto.getAge());
//        if (customerDto.getBalance() != null) customer.setBalance(customerDto.getBalance());
//        if (customerDto.getFirstName() != null) customer.setFirstName(customerDto.getFirstName());
//        if (customerDto.getLastName() != null) customer.setLastName(customerDto.getLastName());
//    }
}
