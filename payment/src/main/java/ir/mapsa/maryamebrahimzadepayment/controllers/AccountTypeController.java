package ir.mapsa.maryamebrahimzadepayment.controllers;

import ir.mapsa.maryamebrahimzadepayment.dto.AccountTypeDto;
import ir.mapsa.maryamebrahimzadepayment.dto.BranchDto;
import ir.mapsa.maryamebrahimzadepayment.models.AccountType;
import ir.mapsa.maryamebrahimzadepayment.models.Branch;
import ir.mapsa.maryamebrahimzadepayment.services.AccountTypeService;
import ir.mapsa.maryamebrahimzadepayment.services.BranchService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountTypeController extends AbstractController<AccountType, AccountTypeDto, AccountTypeService> {

}
