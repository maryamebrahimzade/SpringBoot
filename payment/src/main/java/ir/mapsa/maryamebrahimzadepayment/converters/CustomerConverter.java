package ir.mapsa.maryamebrahimzadepayment.converters;

import ir.mapsa.maryamebrahimzadepayment.dto.BankInfoDto;
import ir.mapsa.maryamebrahimzadepayment.models.BankInfo;
import ir.mapsa.maryamebrahimzadepayment.models.Customer;
import ir.mapsa.maryamebrahimzadepayment.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerConverter extends BaseConverter<CustomerDto, Customer> {
    @Mapping(source = "branch.branchCode",target = "branchCode")
    @Mapping(source = "accountType.name",target = "accountTypeName")
    @Mapping(source = "customer.customerId",target = "customerId")
    BankInfoDto bankInfoToBankInfoDto(BankInfo bankInfo);
    @Mapping(source = "bankInfoDto.branchCode",target = "branch.branchCode")
    @Mapping(source = "bankInfoDto.accountTypeName",target = "accountType.name")
    @Mapping(source = "bankInfoDto.customerId",target = "customer.customerId")
    BankInfo bankInfoDtoToBankInfo(BankInfoDto bankInfoDto);

}
