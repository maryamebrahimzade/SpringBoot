package ir.mapsa.maryamebrahimzadepayment.controllers;

import ir.mapsa.maryamebrahimzadepayment.dto.CustomerDto;
import ir.mapsa.maryamebrahimzadepayment.exceptions.ServiceException;
import ir.mapsa.maryamebrahimzadepayment.models.Customer;
import ir.mapsa.maryamebrahimzadepayment.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController extends AbstractController<Customer,CustomerDto,CustomerService> {
    @Autowired
    private CustomerService service;
//    @GetMapping("/{cardNumber}")
//    public long getBalance(@PathVariable("cardNumber") String card) throws ServiceException {
//        return service.accountBalance(card);
//    }
}
