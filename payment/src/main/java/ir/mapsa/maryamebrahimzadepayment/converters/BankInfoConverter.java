package ir.mapsa.maryamebrahimzadepayment.converters;

import ir.mapsa.maryamebrahimzadepayment.dto.BankInfoDto;
import ir.mapsa.maryamebrahimzadepayment.exceptions.ServiceException;
import ir.mapsa.maryamebrahimzadepayment.models.AccountType;
import ir.mapsa.maryamebrahimzadepayment.models.BankInfo;
import ir.mapsa.maryamebrahimzadepayment.models.Branch;
import ir.mapsa.maryamebrahimzadepayment.models.Customer;
import ir.mapsa.maryamebrahimzadepayment.services.AccountTypeService;
import ir.mapsa.maryamebrahimzadepayment.services.BankInfoService;
import ir.mapsa.maryamebrahimzadepayment.services.BranchService;
import ir.mapsa.maryamebrahimzadepayment.services.CustomerService;
import lombok.SneakyThrows;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class BankInfoConverter implements BaseConverter<BankInfoDto, BankInfo> {
    @Autowired
    private BankInfoService bankInfoService;
    @Autowired
    private BranchService branchService;
    @Autowired
    private AccountTypeService accountTypeService;
    @Autowired
    private CustomerService customerService;

    @AfterMapping
    public void afterSet(@MappingTarget BankInfoDto d,BankInfo e) {
        d.setBranchCode(e.getBranch().getBranchCode());
        d.setAccountTypeName(e.getAccountType().getAccountTypeId());
        d.setCustomerId(e.getCustomer().getCustomerId());
    }
    @AfterMapping
    public void afterSet(@MappingTarget BankInfo e,BankInfoDto d)throws ServiceException {
        e.setBranch(branchService.findByBranchCode(d.getBranchCode()));
        e.setAccountType(accountTypeService.findByName(d.getAccountTypeName()));
        e.setCustomer(customerService.findByCustomerId(d.getCustomerId()));
        e.setBankInfoId(bankInfoService.findByBankInfoId(d.getBankInfoId()));
    }
}
