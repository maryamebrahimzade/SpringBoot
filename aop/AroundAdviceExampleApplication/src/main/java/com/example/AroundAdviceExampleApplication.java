package com.example;

import com.example.service.BankService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AroundAdviceExampleApplication {

    public static void main(String[] args) {
//        SpringApplication.run(AroundAdviceExampleApplication.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(AroundAdviceExampleApplication.class, args);
// Fetching the employee object from the application context.
        BankService bank = context.getBean(BankService.class);
// Displaying balance in the account
        String accnumber = "12345";
        bank.displayBalance(accnumber);
// Closing the context object
        context.close();
    }
}
