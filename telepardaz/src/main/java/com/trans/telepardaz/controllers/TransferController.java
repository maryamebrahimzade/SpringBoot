package com.trans.telepardaz.controllers;

import com.trans.telepardaz.dtos.TransactionDto;
import com.trans.telepardaz.dtos.TransferDto;
import com.trans.telepardaz.exceptions.ServiceException;
import com.trans.telepardaz.utills.ConvertTokenToUserDetails;
import com.trans.telepardaz.models.Transaction;
import com.trans.telepardaz.models.UserDetails;
import com.trans.telepardaz.services.TransferService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transfer")
public class TransferController extends BaseController<Transaction, TransactionDto, TransferService> {
    @PostMapping("/")
    @Transactional
    public void transfer(@RequestBody TransferDto transferDto, @RequestHeader(name = "Authorization") String token) throws ServiceException, JsonProcessingException {
        UserDetails userDetails = ConvertTokenToUserDetails.convert(token);
        service.transfer(transferDto, userDetails);
    }
}
